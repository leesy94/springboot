package com.study.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller //bean으로 만들어서 관리
public class MyController {
	@RequestMapping("/") //get,post 둘 다 받음
	public @ResponseBody String root() throws Exception { //string으로 반환 받고 싶을 때
		return "jsp 실행";
	}
	
	@RequestMapping("test1")
	public String test1_method() {
		return "test1";
	}
}
