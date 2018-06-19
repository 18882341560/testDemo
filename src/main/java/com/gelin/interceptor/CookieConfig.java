/*
package com.gelin.interceptor;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

*/
/**
 * Created by 葛林 on 2017/7/4.
 * <p>
 * 此方法把该拦截器实例化成一个bean,否则在拦截器里无法注入其它bean
 *
 * @return 配置拦截器
 * @param registry
 * ")
 * .excludePathPatterns("/login","/permission/userInsert",
 * "/error","/tUser/insert","/gif/getGifCode");
 * }
 * <p>
 * <p>
 * <p>
 * }
 *//*

@Configuration
public class CookieConfig extends WebMvcConfigurerAdapter {

    */
/**
 * 此方法把该拦截器实例化成一个bean,否则在拦截器里无法注入其它bean
 * @return
 *//*

    @Bean
    public SessionInterceptor sessionInterceptor() {
        return new SessionInterceptor();
    }
    */
/**
 * 配置拦截器
 * @param registry
 *//*

    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(sessionInterceptor())
                .addPathPatterns("*/
/**")
 .excludePathPatterns("/login","/permission/userInsert",
 "/error","/tUser/insert","/gif/getGifCode");
 }



 }
 */
