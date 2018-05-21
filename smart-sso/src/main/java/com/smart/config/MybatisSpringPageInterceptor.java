package com.smart.config;


import org.apache.ibatis.executor.Executor;
import org.apache.ibatis.executor.parameter.ParameterHandler;
import org.apache.ibatis.executor.resultset.ResultSetHandler;
import org.apache.ibatis.executor.statement.StatementHandler;
import org.apache.ibatis.mapping.BoundSql;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.plugin.*;
import org.apache.ibatis.reflection.MetaObject;
import org.apache.ibatis.reflection.SystemMetaObject;
import org.apache.ibatis.scripting.defaults.DefaultParameterHandler;
import org.apache.ibatis.session.ResultHandler;
import org.apache.ibatis.session.RowBounds;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;
import java.util.Properties;

/**
 * Created by 崔宗鲁 on 2018/5/4.
 *
 * @Description:
 */



@Component
@Intercepts({ @Signature(method = "prepare", type = StatementHandler.class, args = { Connection.class ,Integer.class }),
        @Signature(method = "query", type = Executor.class, args = { MappedStatement.class, Object.class, RowBounds.class, ResultHandler.class }) })
public class MybatisSpringPageInterceptor  implements Interceptor {

    private final ThreadLocal<Pagination<?>> localPagination = new ThreadLocal<Pagination<?>>();
    private final static Logger log = LoggerFactory.getLogger(MybatisSpringPageInterceptor.class);
    @Override
    public Object intercept(Invocation invocation) throws Throwable {
        if (invocation.getTarget() instanceof StatementHandler) {
            StatementHandler statementHandler = (StatementHandler) invocation.getTarget();
            Pagination<?> pagination = findPaginationParameter(statementHandler.getBoundSql().getParameterObject());
            if (pagination == null)
                return invocation.proceed();
            else {
                localPagination.set(pagination);
            }

            MetaObject metaStatementHandler = SystemMetaObject.forObject(statementHandler);
            // 分离代理对象链(由于目标类可能被多个拦截器拦截，从而形成多次代理，通过下面的两次循环
            // 可以分离出最原始的的目标类)
            while (metaStatementHandler.hasGetter("h")) {
                Object object = metaStatementHandler.getValue("h");
                metaStatementHandler = SystemMetaObject.forObject(object);
            }
            // 分离最后一个代理对象的目标类
            while (metaStatementHandler.hasGetter("target")) {
                Object object = metaStatementHandler.getValue("target");
                metaStatementHandler = SystemMetaObject.forObject(object);
            }
            MappedStatement mappedStatement = (MappedStatement) metaStatementHandler
                    .getValue("delegate.mappedStatement");
            // 分页信息if (localPage.get() != null) {
            BoundSql boundSql = (BoundSql) metaStatementHandler.getValue("delegate.boundSql");
            // 分页参数作为参数对象parameterObject的一个属性
            String sql = boundSql.getSql();
            // 重写sql
            String pageSql = buildPageSql(sql, pagination);
            // 重写分页sql
            metaStatementHandler.setValue("delegate.boundSql.sql", pageSql);
            Connection connection = (Connection) invocation.getArgs()[0];
            // 重设分页参数里的总页数等
            setPageParameter(sql, connection, mappedStatement, boundSql, pagination);
            // 将执行权交给下一个拦截器
            return invocation.proceed();
        }
        else if (invocation.getTarget() instanceof ResultSetHandler) {
            Pagination<?> pagination = localPagination.get();
            if (pagination == null)
                return invocation.proceed();
            try {
                Object result = invocation.proceed();
                pagination.setList((List) result);
                return result;
            }
            finally {
                localPagination.remove();
            }
        }
        return null;
    }
    private Pagination<?> findPaginationParameter(Object param) {
        if (param instanceof Pagination<?>) {
            return (Pagination<?>) param;
        }
        else if (param instanceof Map) {
            for (Object val : ((Map<?, ?>) param).values()) {
                if (val instanceof Pagination<?>) {
                    return (Pagination<?>) val;
                }
            }
        }
        return null;
    }
    /**
     * 只拦截这两种类型的 <br>
     * StatementHandler <br>
     * ResultSetHandler
     *
     * @param target
     * @return
     */
    @Override
    public Object plugin(Object target) {
        if (target instanceof StatementHandler || target instanceof ResultSetHandler) {
            return Plugin.wrap(target, this);
        }
        else {
            return target;
        }
    }

    @Override
    public void setProperties(Properties properties) {

    }
    public String buildPageSql(String sql, Pagination<?> pagination) {
        StringBuilder pageSql = new StringBuilder(sql);
       /* pageSql.append(" LIMIT " + (pagination.getPageNo() - 1) * pagination.getPageSize() + "," + pagination.getPageSize());*/
        pageSql.append(" LIMIT " + (pagination.getOffset() + ", " + pagination.getLimit()));
        return pageSql.toString();
    }
    /**
     * 获取总记录数
     *
     * @param sql
     * @param connection
     * @param mappedStatement
     * @param boundSql
     * @param   // page
     */
    private void setPageParameter(String sql, Connection connection, MappedStatement mappedStatement,
                                  BoundSql boundSql, Pagination<?> pagination) {
        // 记录总记录数
        String countSql = "SELECT COUNT(0) FROM (" + sql + ") a";
        PreparedStatement countStmt = null;
        ResultSet rs = null;
        try {
            countStmt = connection.prepareStatement(countSql);
            BoundSql countBS = new BoundSql(mappedStatement.getConfiguration(), countSql,
                    boundSql.getParameterMappings(), boundSql.getParameterObject());
            setParameters(countStmt, mappedStatement, countBS, boundSql.getParameterObject());
            rs = countStmt.executeQuery();
            int rowCount = 0;
            if (rs.next()) {
                rowCount = rs.getInt(1);
            }
            pagination.setRowCount(rowCount);
        }
        catch (SQLException e) {
            log.error("Ignore this exception", e);
        }
        finally {
            try {
                rs.close();
            }
            catch (SQLException e) {
                log.error("Ignore this exception", e);
            }
            try {
                countStmt.close();
            }
            catch (SQLException e) {
                log.error("Ignore this exception", e);
            }
        }
    }

    /**
     * 代入参数值
     *
     * @param ps
     * @param mappedStatement
     * @param boundSql
     * @param parameterObject
     * @throws SQLException
     */
    private void setParameters(PreparedStatement ps, MappedStatement mappedStatement, BoundSql boundSql,
                               Object parameterObject) throws SQLException {
        ParameterHandler parameterHandler = new DefaultParameterHandler(mappedStatement, parameterObject, boundSql);
        parameterHandler.setParameters(ps);
    }
}