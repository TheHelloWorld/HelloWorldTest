package com.helloworld.action;

import java.io.Serializable;
import java.util.List;


import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.mvel2.MVEL;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.helloworld.bean.Account;
import com.helloworld.bean.Mission;
import com.helloworld.service.HelloMissionService;
import com.helloworld.service.HelloWorldService;
import com.helloworld.util.MailUtil;


@Controller 
public class HelloWorldAction {
	
	private static final Logger logger = Logger.getLogger(HelloWorldAction.class);
	
	@Resource
    private HelloWorldService helloWorldService;
	
	@Resource
    private HelloMissionService helloMissionService;
	 
	
	/**
	  * 主页
	  * @param username
	  * @param password
	  * @return
	  */
	 @RequestMapping(value = "index")
	 public String index(){	 
		 return "index";
	 }
	 
	
	 /**
	  * 跳转到用户主页
	  * @param username
	  * @param password
	  * @return
	  */
	 @RequestMapping(value = "userIndex")
	 public String goIndex(Long id,Model model){ 
		 Account account = helloWorldService.getAccountById(id);	
		 List<Mission> listAMission = helloMissionService.getAllAvailableMission();
		 model.addAttribute("account",account);
		 model.addAttribute("listAMission",listAMission);
		 if(account.getType().equals("NORMAL")){
			 List<Mission> listIMission = helloMissionService.getAllInMission();
			 model.addAttribute("listIMission",listIMission);
			 return "backStageManagement";
		 }
		 List<Mission> listOMission = helloMissionService.getMessionByOwnerId(id);		 
		 model.addAttribute("listOMission",listOMission);
		 return "userIndex";
	 }
	 
	 
	 /**
	  * 检查用户名密码
	  * @param username
	  * @param password
	  * @return
	  */
	 @ResponseBody
	 @RequestMapping(value = "checkUser")
	 public String checkUser(String username,String password){
		 Long id = helloWorldService.checkUser(username,password);
		 if(id == null){
			 return "N";
		 }else{
			 return String.valueOf(id);
		 }
		
	 }
	 
	 
	 /**
	  * 邮件激活
	  * @param email
	  * @return
	  */
	 @ResponseBody
	 @RequestMapping(value = "checkEmail")
	 public String checkEmail(String email){
		return helloWorldService.checkEmail(email);		
	 }
	 
	 
	 /**
	  * 注册
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
			mail.sendOne(username, "激活邮件", "请点击以下链接<a href='localhost:8080/GitTest/updateStatusById.do?id="+account.getId()+"'>激活</a><br/>如果不能点击请复制链接到地址栏localhost:8080/GitTest/updateStatusById.do?id="+account.getId()+"");
			return  "Y";
		}catch(Exception e){
			logger.error("HelloWorld err Action addAccount msg:"+e.getMessage());
			e.printStackTrace();
			return e.getMessage();
		}		
	 }
	 
	 
	 /**
	  * 将账户状态置为激活
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
			e.printStackTrace();
			return "500";
		}		
	 }
	 
	 
	 /**
	  * 检查用户名密码
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
	    	e.printStackTrace();
	    	return "error:"+e.getMessage();
	    }
	}
	 
	
}
