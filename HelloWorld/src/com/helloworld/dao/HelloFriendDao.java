package com.helloworld.dao;


import org.apache.ibatis.annotations.Param;

import com.helloworld.bean.Friend;

public interface HelloFriendDao {
	
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
