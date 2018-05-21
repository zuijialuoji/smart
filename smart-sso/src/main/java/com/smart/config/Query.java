package com.smart.config;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Created by 崔宗鲁 on 2018/5/14.
 *
 * @Description:
 */
public class Query<T> extends LinkedHashMap<String, Object> {
    private static final long serialVersionUID = 1L;
    //
    private int offset;
    // 每页条数
    private int limit;

    private Pagination<T> page;

    public Query(Map<String, Object> params) {
        this.putAll(params);
        // 分页参数
        this.offset = Integer.parseInt(params.get("offset").toString());
        this.limit = Integer.parseInt(params.get("limit").toString());
         page =new Pagination<T>(offset,limit);
        this.put("page", page);
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

    public Pagination<T> getPage(){
        return this.page;
    }

    public Pagination<T> setPage(Pagination<T> page ){
        return this.page =page;
    }
}
