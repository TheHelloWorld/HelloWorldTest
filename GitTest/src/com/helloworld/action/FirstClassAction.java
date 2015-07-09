package com.helloworld.action;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.helloworld.service.FirstClassService;


@Controller 
public class FirstClassAction {
	
	@Resource
    private FirstClassService firstClassService;
	
	 @RequestMapping(value = "testJsp")
	 public String getExport(HttpServletRequest request, String queryId){
		 System.out.println(1);
		 System.out.println(firstClassService.test());
		 request.setAttribute("name", "Áõ×Óçû");
		 return "testJsp";
	 }
}
