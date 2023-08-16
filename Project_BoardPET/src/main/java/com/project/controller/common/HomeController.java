package com.project.controller.common;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
	
	public HomeController() {
		System.out.println("HomeController빈이 생성되었습니다 :)");
	}
	
	@GetMapping("/")
	public String home() {
		return "home";
	}
	
}
