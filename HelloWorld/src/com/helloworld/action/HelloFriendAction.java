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
	 * ��Ӻ���
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "addFriend")
	public String addFriend(){
		return "N";
		
	}
	
	/**
	 * ɾ������
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "removeFriend")
	public String removeFriend(){
		return "N";
	}
	
	/**
	 * ���ں���
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "blackFriend")
	public String blackFriend(){
		return "N";
	}
	
}
