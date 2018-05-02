package com.smart.core.domin;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author ：崔
 * @commons.core.model
 * @Description: 返回结果
 */
public class Result {

    /**
     * 结果体
     */
    protected Object data;

    /**
     * 状态码
     */
    protected Integer code;


    protected Map map;
    /**
     * 信息
     */
    protected String message;


    private Result(Integer code) {
        this.code = code;
    }

    public static Result create(Integer code) {
        return new Result(code);
    }
    /**
     * 成功之后返回 1
     * @return
     */
    public static Result createSuccessResult() {
        Result result = create(ResultCode.SUCCESS);
        result.setMap(new HashMap());
        return result;
    }

    public static Result createSuccessResult(Object data, String message) {
        return createSuccessResult().setData(data).setMessage(message);
    }

    public boolean isSuccess() {
        return code != null && code.equals(ResultCode.SUCCESS);
    }

    public Object getData() {
        return data;
    }

    public Result setData(Object data) {
        this.data = data;
        return this;
    }

    public Integer getCode() {
        return code;
    }

    public Result setCode(Integer code) {
        this.code = code;
        return this;
    }

    public Map getMap() {
        return map;
    }

    public Result setMap(Map map) {
        this.map = map;
        return this;
    }
    public String getMessage() {
        return message;
    }

    public Result setMessage(String message) {
        this.message = message;
        return this;
    }


    public Object  getValue(String key ){
        return  map.get("key");
    }

    public Result setValue(String key ,Object value){
        this.map.put(key,value);
        return this;
    }


}

