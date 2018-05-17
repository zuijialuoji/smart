package com.smart.comm.validator;

import java.lang.annotation.*;

/**
 * Created by 崔宗鲁 on 2018/5/17.
 *
 * @Description:
 */
@Target(ElementType.PARAMETER)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface ValidateParam {

    /**
     * 验证器
     * @return
     */
    Validator[] value() default {};

    /**
     * 参数的描述名称
     * @return
     */
    String name() default "";
}
