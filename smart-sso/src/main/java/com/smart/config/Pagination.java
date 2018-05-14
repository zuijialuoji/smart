package com.smart.config;

import java.io.Serializable;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by 崔宗鲁 on 2018/5/4.
 *
 * @Description:
 */
public class Pagination<T> extends LinkedHashMap<String, Object> implements Serializable {

    private static final long serialVersionUID = 7002501955628078021L;
    //从第几条开始
    private int offset;
    // 每页条数
    private int limit;

    /*----------------下面不同用法-----------------*/
    /** 默认显示页码数 */
    public static final int DEFAULT_OFFSET_SIZE = 3;
    /** 默认每页行数 */
    public static final int DEFAULT_PAGE_SIZE = 20;

    /** 显示页码数 */
    private int offsetSize = DEFAULT_OFFSET_SIZE;
    /** 每页行数 */
    private int pageSize = DEFAULT_PAGE_SIZE;
    /** 记录总数 */
    private long rowCount;
    /** 当前页码 */
    private int pageNo = 1;
    /** 当前页的数据 */
    private List<T> list;
    public Pagination() {
    }

    public Pagination(int pageNo, int pageSize) {
        this.pageNo = pageNo;
        this.pageSize = pageSize;
    }
    public Pagination(Map<String, Object> params) {
        this.putAll(params);
        // 分页参数
        this.offset = Integer.parseInt(params.get("offset").toString());
        this.limit = Integer.parseInt(params.get("limit").toString());
    }
    /**
     * 获得分页内容
     *
     * @return
     */
    public List<T> getList() {
        return list;
    }

    /**
     * 设置分页内容
     *
     * @param list
     */
    public void setList(List<T> list) {
        this.list = list;
    }


    public int getOffsetSize() {
        return offsetSize;
    }

    public void setOffsetSize(int offsetSize) {
        this.offsetSize = offsetSize;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public long getRowCount() {
        return rowCount;
    }

    public void setRowCount(long rowCount) {
        this.rowCount = rowCount;
    }

    public int getPageNo() {
        return pageNo;
    }

    public void setPageNo(int pageNo) {
        this.pageNo = pageNo;
    }

    /**
     * 第一条数据位置
     *
     * @return
     */
    public int getFirstResult() {
        return (pageNo - 1) * pageSize;
    }

    /**
     * 获取总页数
     */
    public long getPageCount() {
        if (rowCount % pageSize == 0)
            return rowCount / pageSize;
        else
            return (rowCount / pageSize) + 1;
    }

    public int getOffset() {
        return offset;
    }

    public void setOffset(int offset) {
        this.put("offset", offset);
    }

    public int getLimit() {
        return limit;
    }

    public void setLimit(int limit) {
        this.limit = limit;
    }
}
