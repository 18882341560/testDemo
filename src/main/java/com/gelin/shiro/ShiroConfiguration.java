//package com.gelin.shiro;
//
//import at.pollux.thymeleaf.shiro.dialect.ShiroDialect;
//import org.apache.log4j.Logger;
//import org.apache.shiro.cache.ehcache.EhCacheManager;
//import org.apache.shiro.mgt.SecurityManager;
//import org.apache.shiro.spring.LifecycleBeanPostProcessor;
//import org.apache.shiro.spring.security.interceptor.AuthorizationAttributeSourceAdvisor;
//import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
//import org.apache.shiro.web.mgt.CookieRememberMeManager;
//import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
//import org.apache.shiro.web.servlet.SimpleCookie;
//import org.springframework.aop.framework.autoproxy.DefaultAdvisorAutoProxyCreator;
//import org.springframework.beans.factory.annotation.Qualifier;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//
//import java.util.LinkedHashMap;
//
///**
// * Created by 葛林 on 2017/7/3.
// */
//@Configuration
//public class ShiroConfiguration {
//
//    private final Logger logger = Logger.getLogger(ShiroConfiguration.class);
//
//    //权限过滤
//    @Bean(name = "shiroFilter")
//    public ShiroFilterFactoryBean shiroFilter(@Qualifier("securityManager") SecurityManager manager) {
//        ShiroFilterFactoryBean bean = new ShiroFilterFactoryBean();
//        bean.setSecurityManager(manager);
//        //配置登录的url和登录成功的url
////        bean.setLoginUrl("/login");
////        bean.setSuccessUrl("/loginUser");
////        //未授权界面;
////        bean.setUnauthorizedUrl("/403");
//        //配置访问权限的路劲
//        LinkedHashMap<String, String> filterChainDefinitionMap = new LinkedHashMap<>();
//        filterChainDefinitionMap.put("/html/login.html*", "anon"); //表示可以匿名访问
//        filterChainDefinitionMap.put("/loginUser", "anon");
//        filterChainDefinitionMap.put("/logout*", "anon");
//        filterChainDefinitionMap.put("/html/error.html*", "anon");
//        filterChainDefinitionMap.put("/html/index.html*", "authc");
//        filterChainDefinitionMap.put("/*", "authc");//表示需要认证才可以访问
//        filterChainDefinitionMap.put("/**", "authc");//表示需要认证才可以访问
//        filterChainDefinitionMap.put("/*.*", "authc");
//        bean.setFilterChainDefinitionMap(filterChainDefinitionMap);
//        return bean;
//    }
//
//    //配置核心安全事务管理器
//    @Bean(name = "securityManager")
//    public SecurityManager securityManager(@Qualifier("authRealm") AuthRealm authRealm) {
//        System.err.println("--------------shiro已经加载----------------");
//        DefaultWebSecurityManager manager = new DefaultWebSecurityManager();
//        manager.setRealm(authRealm);
//        ///注入缓存管理器
//        manager.setCacheManager(ehCacheManager());
//        //注入Cookie(记住我)管理器(remenberMeManager)
//        manager.setRememberMeManager(rememberMeManager());
//        return manager;
//    }
//
//    //配置自定义的权限登录器
//    @Bean(name = "authRealm")
//    public AuthRealm authRealm(@Qualifier("credentialsMatcher") CredentialsMatcher matcher) {
//        AuthRealm authRealm = new AuthRealm();
//        authRealm.setCredentialsMatcher(matcher);
//        return authRealm;
//    }
//
//    //配置自定义的密码比较器
//    @Bean(name = "credentialsMatcher")
//    public CredentialsMatcher credentialsMatcher() {
//        return new CredentialsMatcher();
//    }
//
//    /**
//     * 定义无法确定init（）或destory（）方法已经被调用
//     *
//     * @return
//     */
//    @Bean
//    public LifecycleBeanPostProcessor lifecycleBeanPostProcessor() {
//        return new LifecycleBeanPostProcessor();
//    }
//
//    /**
//     * 实现spring的自动代理
//     *
//     * @return
//     */
//    @Bean
//    public DefaultAdvisorAutoProxyCreator defaultAdvisorAutoProxyCreator() {
//        DefaultAdvisorAutoProxyCreator creator = new DefaultAdvisorAutoProxyCreator();
//        creator.setProxyTargetClass(true);
//        return creator;
//    }
//
//    //自定义权限注解
//    @Bean
//    public AuthorizationAttributeSourceAdvisor authorizationAttributeSourceAdvisor(@Qualifier("securityManager") SecurityManager manager) {
//        AuthorizationAttributeSourceAdvisor advisor = new AuthorizationAttributeSourceAdvisor();
//        advisor.setSecurityManager(manager);
//        return advisor;
//    }
//
//    /**
//     * 配置html页面能使用shiro标签
//     *
//     * @return
//     */
//    @Bean(name = "shiroDialect")
//    public ShiroDialect shiroDialect() {
//        return new ShiroDialect();
//    }
//
//    @Bean
//    public EhCacheManager ehCacheManager() {
//        EhCacheManager cacheManager = new EhCacheManager();
//        cacheManager.setCacheManagerConfigFile("classpath:config/ehcache-shiro.xml");
//        return cacheManager;
//
//    }
//
//    @Bean
//    public SimpleCookie rememberMeCookie() {
//        System.out.println("ShiroConfiguration.rememberMeCookie()");
//        //这个参数是cookie的名称，对应前端的checkbox的name = rememberMe
//        SimpleCookie simpleCookie = new SimpleCookie("rememberMe");
//        //<!-- 记住我cookie生效时间30天 ,单位秒;-->
//        simpleCookie.setMaxAge(259200);
//        return simpleCookie;
//    }
//
//    /**
//     * cookie管理对象;
//     *
//     * @return
//     */
//    @Bean
//    public CookieRememberMeManager rememberMeManager() {
//        System.out.println("ShiroConfiguration.rememberMeManager()");
//        CookieRememberMeManager cookieRememberMeManager = new CookieRememberMeManager();
//        cookieRememberMeManager.setCookie(rememberMeCookie());
//        return cookieRememberMeManager;
//    }
//
//}
