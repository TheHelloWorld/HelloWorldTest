package com.helloworld.action;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller 
public class FirstClassAction {
	
	 @RequestMapping(value = "testJsp")
	 public String getExport(HttpServletRequest request, String queryId){
		 System.out.println(1);
		 request.setAttribute("name", "Áõ×Óçû");
		 return "testJsp";
	 }
}
