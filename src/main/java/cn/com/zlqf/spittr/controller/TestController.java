package cn.com.zlqf.spittr.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.com.zlqf.spittr.entity.Spitter;
import cn.com.zlqf.spittr.service.SpitterService;

@Controller
public class TestController {
	
	@Autowired
	private SpitterService spitterService;
	
	@RequestMapping("/test")
	public String test() {
		System.out.println(spitterService);
		Spitter spitter = spitterService.findOne("2");
		System.out.println(spitter);
		return "test";
	}
}
