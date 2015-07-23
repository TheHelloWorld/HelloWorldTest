package com.helloworld.action;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.helloworld.service.HelloFriendService;

@Controller 
public class HelloFriendAction {
	
	@Resource
	private HelloFriendService helloFriendService;
	
	/**
	 * 添加好友
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "addFriend")
	public String addFriend(){
		return "N";
		
	}
	
	/**
	 * 删除好友
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "removeFriend")
	public String removeFriend(){
		return "N";
	}
	
	/**
	 * 拉黑好友
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "blackFriend")
	public String blackFriend(){
		return "N";
	}
	
}
