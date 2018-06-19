//package com.gelin.shiro;
//
//import com.gelin.domain.Module;
//import com.gelin.domain.Role;
//import com.gelin.domain.User;
//import com.gelin.services.UserJurisdictionServices;
//import org.apache.shiro.authc.*;
//import org.apache.shiro.authz.AuthorizationInfo;
//import org.apache.shiro.authz.SimpleAuthorizationInfo;
//import org.apache.shiro.realm.AuthorizingRealm;
//import org.apache.shiro.subject.PrincipalCollection;
//
//import javax.annotation.Resource;
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Set;
//
///**
// * Created by 葛林 on 2017/7/3.
// */
//public class AuthRealm extends AuthorizingRealm {
//
//
//    @Resource
//    private UserJurisdictionServices userJurisdictionServices;
//
//    //认证，登录
//    @Override
//    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken tokens) throws AuthenticationException {
//        UsernamePasswordToken token = (UsernamePasswordToken) tokens;//获取用户输入的token
//        String username = token.getUsername();
//        User user = userJurisdictionServices.findByUserName(username);
//        return new SimpleAuthenticationInfo(user, user.getPassword(), this.getClass().getName());//放入shiro.调用CredentialsMatcher检验密码
//    }
//
//
//    //授权
//    @Override
//    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principal) {
//
//        User user = (User) principal.fromRealm(this.getClass().getName()).iterator().next();
//        List<String> permission = new ArrayList<>();
//        Set<Role> roles = user.getRoles();
//        if (roles.size() > 0) {
//            for (Role role : roles) {
//                Set<Module> modules = role.getModules();
//                if (modules.size() > 0) {
//                    for (Module module : modules) {
//                        permission.add(module.getMname());
//                    }
//                }
//            }
//        }
//        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
//        info.addStringPermissions(permission);
//        return info;
//    }
//
//
//}
