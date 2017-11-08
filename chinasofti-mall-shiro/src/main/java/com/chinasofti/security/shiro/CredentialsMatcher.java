package com.chinasofti.security.shiro;

import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authc.credential.SimpleCredentialsMatcher;

/**
 * 
* @ClassName: CredentialsMatcher
* @Description: 密码校验
* @author xiaokunxiong
* @date 2017年11月6日 上午9:39:49 
*
 */
public class CredentialsMatcher extends SimpleCredentialsMatcher {
    
    @Override
    public boolean doCredentialsMatch(AuthenticationToken token,
            AuthenticationInfo info) {
        UsernamePasswordToken utoken = (UsernamePasswordToken)token;
        //获得用户输入的密码
        String inPassword = new String(utoken.getPassword());
        //获得数据库中的密码
        String dbPassword = (String)info.getCredentials();
        //进行密码的比对
        return this.equals(inPassword, dbPassword);
    }
}
