package com.kanq.server.sso.config;


import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Author: Mr.huang
 * @Date: 2021/07/28/14:41
 * @Description:
 */

//@Configuration
/*
public class ShiroConfig {

    */
/**
     * 创建 Realm
     * @return realm
     *//*

    @Bean("myRealm")
    public MyRealm getMyRealm(){
        MyRealm myRealm=new MyRealm();
        return myRealm;
    }

    */
/**
     * 创建 SecurityManager
     * @param myRealm 注入自定义的Realm对象
     * @return
     *//*

    @Bean("securityManager")
    public DefaultWebSecurityManager getSecurityManager(@Qualifier("myRealm") MyRealm myRealm){
        DefaultWebSecurityManager securityManager=new DefaultWebSecurityManager();
        securityManager.setRealm(myRealm);
        return securityManager;
    }

    */
/**
     * 创建 shiroFilterFactory
     * @param defaultWebSecurityManager
     * @return
     *//*

    @Bean("shiroFilterFactory")
    public ShiroFilterFactoryBean getShiroFilterFactoryBean(@Qualifier("securityManager") DefaultWebSecurityManager defaultWebSecurityManager){
        ShiroFilterFactoryBean shiroFilterFactoryBean=new ShiroFilterFactoryBean();
        shiroFilterFactoryBean.setSecurityManager(defaultWebSecurityManager);
        return shiroFilterFactoryBean;
    }
}
*/
