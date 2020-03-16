package com.liuhao.hgshop.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 首页的控制器
 * @author 刘浩
 *
 */
@Controller
public class IndexController {
   //111111111111111111
	@RequestMapping({"/","index"})
	public String index(Model model) {
		
		return "index";
	}
}
