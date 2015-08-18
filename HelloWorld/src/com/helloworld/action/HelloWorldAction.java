package com.helloworld.action;

import java.io.Serializable;


import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.mvel2.MVEL;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.helloworld.bean.Account;
import com.helloworld.service.HelloWorldService;
import com.helloworld.util.MailUtil;


@Controller 
public class HelloWorldAction {
	
	private static final Logger logger = Logger.getLogger(HelloWorldAction.class);
	
	@Resource
    private HelloWorldService helloWorldService;
	 
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
		return helloWorldService.checkUser(username,password);
	 }
	 
	 
	 /**
	  * 检查Email是否被占用
	  * @param email
	  * @return
	  */
	 @ResponseBody
	 @RequestMapping(value = "checkEmail")
	 public String checkEmail(String email){
		return helloWorldService.checkEmail(email);		
	 }
	 
	 
	 /**
	  * 添加用户
	  * @param username
	  * @param password
	  * @return
	  */
	 @ResponseBody
	 @RequestMapping(value="addAccount", method = RequestMethod.POST, produces = "plain/text; charset=UTF-8")
	 public String addAccount(String username,String password){
		try{		
			Account account = new Account();
			account.setUsername(username);
			account.setPassword(password);
			helloWorldService.addUser(account);
			MailUtil mail = new MailUtil();
			mail.sendOne(username, "激活您的账号", "请点击下面链接激活您的账号<a href='localhost:8080/GitTest/updateStatusById.do?id="+account.getId()+"'>激活链接</a><br/>如果链接不能点击请复制以下链接到您的浏览器地址栏：localhost:8080/GitTest/updateStatusById.do?id="+account.getId()+"");
			return  "Y";
		}catch(Exception e){
			logger.error("HelloWorld err Action addAccount msg:"+e.getMessage());
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
			int count = helloWorldService.getNumById(id);
			String status = helloWorldService.getStatusById(id);
			if("FALSE".equals(status) && count == 1){
				helloWorldService.updateStatusById(id);
				return "successPage";
			}else{
				if("TRUE".equals(status)){
					logger.info("updateStatusById msg: already activity");
					return "statusTrue";
				}else if(count != 0){
					logger.info("updateStatusById msg: account dosent exists");
					return "countErr";
				}
				return "404";
			}	
		}catch(Exception e){
			logger.error("HelloWorld err Action updateStatusById msg:"+e.getMessage());
			return "500";
		}		
	 }
	 
	 
	 /**
	  * 检查HelloWorld Demo
	  * @param str
	  * @return
	  */
	 @ResponseBody
	 @RequestMapping(value="checkHelloWorld", method = RequestMethod.POST, produces = "plain/text; charset=UTF-8")
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
	    	logger.error("HelloWorld err Action executeRedis msg:"+e.getMessage());
	    	return "error:"+e.getMessage();
	    }
	}
 	
}
