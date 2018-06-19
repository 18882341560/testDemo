//package com.gelin.shiro;
//
//import org.apache.shiro.authc.AuthenticationInfo;
//import org.apache.shiro.authc.AuthenticationToken;
//import org.apache.shiro.authc.UsernamePasswordToken;
//import org.apache.shiro.authc.credential.SimpleCredentialsMatcher;
//
///**
// * Created by 葛林 on 2017/7/3.
// */
//public class CredentialsMatcher extends SimpleCredentialsMatcher {
//
//    //密码的校验
//    public boolean doCredentialsMatch(AuthenticationToken authToken, AuthenticationInfo info) {
//        UsernamePasswordToken token = (UsernamePasswordToken) authToken;
//        String password = new String(token.getPassword());//获取用户输入密码
//        String dbPassword = (String) info.getCredentials();//获取数据库密码
//        return this.equals(password, dbPassword);
//    }
//
//
//}
