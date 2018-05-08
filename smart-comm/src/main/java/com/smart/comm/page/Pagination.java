package com.smart.comm.page;

import java.io.Serializable;
import java.util.List;

/**
 * Created by 崔宗鲁 on 2018/5/4.
 *
 * @Description:
 */
public class Pagination<T> extends PaginationSupport implements Serializable {

    private static final long serialVersionUID = 7002501955628078021L;
    /** 当前页的数据 */
    private List<T> rows;

    public Pagination() {
    }


    public Pagination(int pageNo, int pageSize) {
        super(pageNo, pageSize);
    }

    /**
     * 获得分页内容
     *
     * @return
     */
    public List<T> getRows() {
        return rows;
    }

    /**
     * 设置分页内容
     *
     * @param 
     */
    public void setRows(List<T> rows) {
        this.rows = rows;
    }
}
