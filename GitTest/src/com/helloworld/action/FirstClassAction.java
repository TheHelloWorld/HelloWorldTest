package com.helloworld.action;

import java.io.PrintStream;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.mvel2.MVEL;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.helloworld.bean.Account;
import com.helloworld.service.FirstClassService;
import com.helloworld.util.MailUtil;


@Controller 
public class FirstClassAction {
	
	@Resource
    private FirstClassService firstClassService;
	 
	 /**
	  * 跳转到主页
	  * @param username
	  * @param password
	  * @return
	  */
	 @RequestMapping(value = "index")
	 public String goIndex(String username,String password){
		 
		 return "index";
	 }
	 
	 /**
	  * 检查用户名密码是否正确
	  * @param username
	  * @param password
	  * @return
	  */
	 @ResponseBody
	 @RequestMapping(value = "checkUser")
	 public String checkUser(String username,String password){
		return firstClassService.checkUser(username,password);
	 }
	 
	 /**
	  * 检查Email是否被占用
	  * @param email
	  * @return
	  */
	 @ResponseBody
	 @RequestMapping(value = "checkEmail")
	 public String checkEmail(String email){
		return firstClassService.checkEmail(email);		
	 }
	 
	 /**
	  * 添加用户
	  * @param username
	  * @param password
	  * @return
	  */
	 @ResponseBody
	 @RequestMapping(value = "addAccount")
	 public String addAccount(String username,String password){
		try{
			
			Account account = new Account();
			account.setUsername(username);
			account.setPassword(password);
			firstClassService.addUser(account);
			MailUtil mail = new MailUtil();
			mail.sendOne(username, "激活您的账号", "请点击下面链接激活您的账号<a href='localhost:8080/GitTest/updateStatusById.do?id="+account.getId()+"'>激活链接</a>");
			return  "Y";
		}catch(Exception e){
			return e.getMessage();
		}		
	 }
	 
	 /**
	  * 激活账户
	  * @param id
	  * @return
	  */
	 @RequestMapping(value = "updateStatusById")
	 public String updateStatusById(Long id){
		try{
			firstClassService.updateStatusById(id);
			return  "userIndex";
		}catch(Exception e){
			return e.getMessage();
		}		
	 }
	 
	 /**
	  * 检查HelloWorld Demo
	  * @param str
	  * @return
	  */
	 @ResponseBody
	 @RequestMapping(value = "checkHelloWorld")
	 public String  executeRedis(String str) {	
	    try{   		
	    	Serializable  r = MVEL.compileExpression(str);
	    	MVEL.executeExpression(r);
	    	str = str.toLowerCase();
	    	if(str.contains("helloworld")){
	    		return "Y";
	    	}else{
	    		return "请编写HelloWorld Demo!";
	    	}  	
	    }catch(Exception e){
	    	return "error:"+e.getMessage();
	    }
	}
	 	
}
