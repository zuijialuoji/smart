package com.smart.comm.validator;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 
 * @author 崔
 * @date: 2018年5月25日 上午10:17:32
 * @Description:自定义请求参数注解
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
