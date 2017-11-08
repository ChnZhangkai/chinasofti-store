package com.chinasofti.security.shiro;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

import com.chinasofti.security.entity.Module;
import com.chinasofti.security.entity.Role;
import com.chinasofti.security.entity.User;
import com.chinasofti.security.service.UserService;
/**
 * 
* @ClassName: AuthRealm
* @Description: AuthRealm完成根据用户名去数据库的查询,并且将用户信息放入shiro中,供第二个类调用.CredentialsMatcher,
* 								完成对于密码的校验.其中用户的信息来自shiro 
* @author xiaokunxiong
* @date 2017年11月3日 下午4:44:14 
*
 */
public class AuthRealm extends AuthorizingRealm {
    @Autowired
    private UserService service;
    
    //认证.登录
    /* 
     *这个方法主要是做登录验证，说白了就是去数据库里面校验用户是否存在，注意这里不需要进行密码校验，shiro会帮我们做密码校验
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(
            AuthenticationToken token) throws AuthenticationException {
        try {
            UsernamePasswordToken utoken = (UsernamePasswordToken)token;//获取用户输入的token
            String username = utoken.getUsername();
            User user = service.findUserByName(username);
            if (user != null) {
                // 若存在，将此用户存放到登录认证info中，无需自己做密码对比，Shiro会为我们进行密码对比校验
                return new SimpleAuthenticationInfo(user, user.getPassword(),
                        this.getClass().getName());//放入shiro.调用CredentialsMatcher检验密码
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    
    //授权
    /* 
     * 授权的方法是在碰到<shiro:hasPermission>标签的时候调用的,它会去检测shiro框架中的权限(这里的permissions)是否包含有该标签的name值,如果有,里面的内容显示,如果没有,里面的内容不予显示(这就完成了对于权限的认证.)
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(
            PrincipalCollection principal) {
        User user = (User)principal.fromRealm(this.getClass().getName())
                .iterator()
                .next();//获取session中的用户
        List<String> permissions = new ArrayList<String>();
        Set<Role> roles = user.getRoles();
        if (roles.size() > 0) {
            for (Role role : roles) {
                Set<Module> modules = role.getModules();
                if (modules.size() > 0) {
                    for (Module module : modules) {
                        permissions.add(module.getMname());
                    }
                }
            }
        }
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
        info.addStringPermissions(permissions);//将权限放入shiro中.
        return info;
    }
}
