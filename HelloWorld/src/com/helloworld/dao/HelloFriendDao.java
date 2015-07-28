package com.helloworld.dao;


import org.apache.ibatis.annotations.Param;

import com.helloworld.bean.Friend;

public interface HelloFriendDao {
	
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
	public void removeFriendByIds(@Param("userid")Long userid,@Param("friendid")Long friendid);
	
	/**
	 * 拉黑好友
	 * @param userid
	 * @param friendid
	 */
	public void updateFriendInBlack(@Param("userid")Long userid,@Param("friendid")Long friendid);
	
}
