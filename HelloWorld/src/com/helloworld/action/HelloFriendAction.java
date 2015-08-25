package com.helloworld.action;

import java.util.List;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.helloworld.bean.Friend;
import com.helloworld.service.HelloFriendService;

@Controller 
public class HelloFriendAction {
	
	private static final Logger logger = Logger.getLogger(HelloFriendAction.class);
	
	@Resource
	private HelloFriendService helloFriendService;
	
	/**
	 * 添加好友
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "addFriend")
	public String addFriend(String username,Long userid,Long friendid,String friendname){
		try{
			Friend friend = new Friend();
			friend.setUserid(userid);
			friend.setFriendid(friendid);
			friend.setFriendname(friendname);
			friend.setUsername(username);
			helloFriendService.addFriendRequest(friend);		
			return "Y";
		}catch(Exception e){
			logger.error("HelloFriend err Action addFriend msg:"+e.getMessage());
			e.printStackTrace();
			return "N";
		}
	}
	
	
	/**
	 * 删除好友
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "removeFriend")
	public String removeFriend(Long myId,Long FriendId){
		try{
			helloFriendService.removeFriendByIds(myId, FriendId);
			return "Y";
		}catch(Exception e){
			logger.error("HelloFriend err Action removeFriend msg:"+e.getMessage());
			e.printStackTrace();
			return "N";
		}
	}
	
	
	/**
	 * 拉黑好友
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "blackFriend")
	public String blackFriend(Long userid,Long friendid){
		try{
			helloFriendService.updateFriendInBlack(userid, friendid);
			return "Y";
		}catch(Exception e){
			logger.error("HelloFriend err Action blackFriend msg:"+e.getMessage());
			e.printStackTrace();
			return "N";
		}
	}
	
	
	/**
	 * 根据用户id获得好友
	 * @return
	 */
	@RequestMapping(value = "getFirends")
	public String getFirendsById(Long userid,Model model){
		try{
			List<Friend> friendList = helloFriendService.getFriendById(userid);
			model.addAttribute("friendList", friendList);
			return "friendPage";
		}catch(Exception e){
			logger.error("HelloFriend err Action getFirendsById msg:"+e.getMessage());
			e.printStackTrace();
			return "500";
		}
	}
	
}
