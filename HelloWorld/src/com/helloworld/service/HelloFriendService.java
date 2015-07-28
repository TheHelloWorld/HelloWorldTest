package com.helloworld.service;

import org.apache.ibatis.annotations.Param;

import com.helloworld.bean.Friend;

public interface HelloFriendService {
	
	/**
	 * ��Ӻ���
	 * @param friend
	 */
	public void addFriendRequest(Friend friend);
	
	
	/**
	 * ɾ������
	 * @param userid
	 * @param friendid
	 */
	public void removeFriendByIds(@Param("userid")Long userid,@Param("friendid")Long friendid);
	
	/**
	 * ���ں���
	 * @param userid
	 * @param friendid
	 */
	public void updateFriendInBlack(@Param("userid")Long userid,@Param("friendid")Long friendid);
}
