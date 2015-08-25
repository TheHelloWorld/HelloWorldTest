package com.helloworld.service;


import java.util.List;

import com.helloworld.bean.Friend;

public interface HelloFriendService {
	
	/**
	 * 添加好友
	 * @param friend
	 */
	public void addFriendRequest(Friend friend);
	
	
	/**
	 * 删除好友
	 * @param userid
	 * @param friendid
	 */
	public void removeFriendByIds(Long userid,Long friendid);
	
	/**
	 * 拉黑好友
	 * @param userid
	 * @param friendid
	 */
	public void updateFriendInBlack(Long userid,Long friendid);
	
	/**
	 * 根据用户id获得好友
	 * @param userid
	 * @return
	 */
	public List<Friend> getFriendById(Long userid);
}
