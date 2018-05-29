package com.smart.config;

import java.util.List;

import com.smart.comm.interceptor.PermissionInterceptor;
import com.smart.comm.validator.MethodArgumentResovler;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * Created by 崔宗鲁 on 2018/5/28.
 *
 * @Description:
 */
@Configuration
public class SsoWebMvcConfigurerAdapter extends WebMvcConfigurerAdapter {

/*    public void addArgumentResolvers(List<HandlerMethodArgumentResolver> argumentResolvers) {
        super.addArgumentResolvers(argumentResolvers);
        argumentResolvers.add( new MethodArgumentResovler());
    }*/



/*    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new PermissionInterceptor()).addPathPatterns("*//**").excludePathPatterns("/toLogin","/login");
        super.addInterceptors(registry);
    }*/
}
