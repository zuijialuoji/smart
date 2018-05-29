package com.smart.comm.exception;


import com.smart.core.domin.Result;
import com.smart.core.domin.ResultCode;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *
 * @author 崔
 * @date: 2018年5月23日 下午2:57:31
 * @Description: 全局异常捕捉类
 */

public class GlobalExceptionProcessor {


    @ResponseBody
    @ExceptionHandler(value=ValidateException.class )
    public Result processException(Exception e) {
        return  Result.create(ResultCode.VALIDATE_ERROR).setMessage(e.getMessage());
    }


    @ResponseBody
    @ExceptionHandler(value=ServiceException.class )
    public Result serviceException(Exception e) {
        return  Result.create(ResultCode.SERVICE_ERROR).setMessage(e.getMessage());
    }
}
