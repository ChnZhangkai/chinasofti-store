package com.chinasofti.security.shiro;

import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authc.credential.SimpleCredentialsMatcher;

/** 
 * @Description 这个类进行秘密的校验 
 * @ClassName   CredentialsMatcher 
 * @Date        2017年8月30日 下午9:17:29 
 * @Author      动脑学院-jack
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
