package com.smart.comm.page;

import java.io.Serializable;

/**
 * Created by 崔宗鲁 on 2018/5/4.
 *
 * @Description:
 */
public class PaginationSupport implements Serializable {

    private static final long serialVersionUID = 2234283310680151858L;
    /** 默认显示页码数 */
    public static final int DEFAULT_OFFSET_SIZE = 3;
    /** 默认每页行数 */
    public static final int DEFAULT_PAGE_SIZE = 20;

    /** 显示页码数 */
    private int offsetSize = DEFAULT_OFFSET_SIZE;
    /** 每页行数 */
    private int pageSize = DEFAULT_PAGE_SIZE;
    /** 记录总数 */
    private long total;
    /** 当前页码 */
    private int pageNo = 1;

    public PaginationSupport() {
    }

    public PaginationSupport(int pageNo, int pageSize) {
        this.pageNo = pageNo;
        this.pageSize = pageSize;
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

    public long getTotal() {
        return total;
    }

    public void setTotal(long total) {
        this.total = total;
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
        if (total % pageSize == 0)
            return total / pageSize;
        else
            return (total / pageSize) + 1;
    }
}
