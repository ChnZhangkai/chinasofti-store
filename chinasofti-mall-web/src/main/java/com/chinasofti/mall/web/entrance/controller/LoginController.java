package com.chinasofti.mall.web.entrance.controller;

import javax.servlet.http.HttpSession;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.DisabledAccountException;
import org.apache.shiro.authc.ExcessiveAttemptsException;
import org.apache.shiro.authc.ExpiredCredentialsException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.UnauthorizedException;
import org.apache.shiro.session.UnknownSessionException;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.chinasofti.mall.common.entity.PtUser;

@Controller
public class LoginController {
	@RequestMapping("/login")
	public String login() {
		return "login";
	}

	@RequestMapping("/index")
	public String index() {
		return "index";
	}

	@RequestMapping("/main")
	public String main() {
		return "main";
	}

	/**
	 * @Description
	 * 我们和shiro框架的交互完全通过Subject这个类去交互,用它完成登录,注销,获取当前的用户对象等操作: @return String
	 * 返回类型 @throws
	 */
	@RequestMapping(value = "/loginUser")
	public String loginUser(String username, String password, HttpSession session, Model model) {
		String msg = "";
		UsernamePasswordToken token = new UsernamePasswordToken(username, password);
		Subject subject = SecurityUtils.getSubject();
		try {
			// 在这里掉到了shiro中进行登录校验,如果权限校验没有通过就不会往下走
			subject.login(token); // 完成登录
			PtUser user = (PtUser) subject.getPrincipal();
			session.setAttribute("user", user);
			return "main";
		} catch (UnknownSessionException use) {
			subject = new Subject.Builder().buildSubject();
			subject.login(token);
			session = (HttpSession) subject.getSession(true);
			return "main";
		} catch (IncorrectCredentialsException e) {
			msg = "登录密码错误,请核对密码后重试";
			model.addAttribute("message", msg);
			System.out.println(msg);
		} catch (ExcessiveAttemptsException e) {
			msg = "登录失败次数过多";
			model.addAttribute("message", msg);
			System.out.println(msg);
		} catch (LockedAccountException e) {
			msg = "帐号已被锁定. The account for username " + token.getPrincipal() + " was locked.";
			model.addAttribute("message", msg);
			System.out.println(msg);
		} catch (DisabledAccountException e) {
			msg = "帐号已被禁用,请联系管理员.";
			model.addAttribute("message", msg);
			System.out.println(msg);
		} catch (ExpiredCredentialsException e) {
			msg = "帐号已过期. the account for username " + token.getPrincipal() + "  was expired.";
			model.addAttribute("message", msg);
			System.out.println(msg);
		} catch (UnknownAccountException e) {
			msg = "该帐号不存在,请核对账号或联系管理员.";
			model.addAttribute("message", msg);
			System.out.println(msg);
		} catch (UnauthorizedException e) {
			msg = "您没有得到相应的授权！" + e.getMessage();
			model.addAttribute("message", msg);
			System.out.println(msg);
		}catch (Exception e) {
			
			return "login";// 返回登录页面
		}
		return "login";

	}

	@RequestMapping("/logOut")
	public String logOut(HttpSession session) {
		Subject subject = SecurityUtils.getSubject();
		subject.logout();
		return "redirect:login";
	}
}
