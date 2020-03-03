package com.liuhao.hgshop.controller;

import org.apache.dubbo.config.annotation.Reference;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.liuhao.hgshop.service.UserService;

/**
 * 用户操作控制器
 * @author 刘浩
 *
 */
@Controller
public class UserController {

	@Reference(timeout=2000,version="1.0.0")
	private UserService userService;
	
	/**
	 * 跳转到登录页面
	 * @return
	 */
	@RequestMapping("tologin")
	public String toLogin() {
		return "login";
	}
	/**
	 * 实现登录功能
	 * @param name
	 * @param password
	 * @return
	 */
	@RequestMapping("login")
	public String login(String name,String password ) {
		
		System.err.println("name " + name + " password " + password);
		
		//登录成功返回首页,登录失败停留在登录页面
		if(userService.login(name, password))
			return "redirect:/";
		else {
			return "login";
		}
	}
}
