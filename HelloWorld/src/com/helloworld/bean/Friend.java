package com.helloworld.bean;

public class Friend {
	
	/** id*/
	private Long id;
	
	/** 创建时间*/
	private String create_time;
	
	/** 本人名称*/
	private String username;
	
	/** 好友名称*/
	private String friendname;
	
	/** 本人id*/
	private Long userid;
	
	/** 好友id*/
	private Long friendid;
	
	/** 好友状态*/
	private String status;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	public String getCreate_time() {
		return create_time;
	}

	public void setCreate_time(String create_time) {
		this.create_time = create_time;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getFriendname() {
		return friendname;
	}

	public void setFriendname(String friendname) {
		this.friendname = friendname;
	}

	public Long getUserid() {
		return userid;
	}

	public void setUserid(Long userid) {
		this.userid = userid;
	}

	
	public Long getFriendid() {
		return friendid;
	}

	public void setFriendid(Long friendid) {
		this.friendid = friendid;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	
}
