package com.helloworld.bean;

public class Account {
	
	/** 账户id*/
	private Long id;
	
	/** 账户名*/
	private String username;
	
	/** 账户密码*/
	private String password;
	
	/** 账户状态*/
	private String status;
	
	/** 经验值*/
	private Integer experience;
	
	/** 当前等级*/
	private Integer nowlevel;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Integer getExperience() {
		return experience;
	}

	public void setExperience(Integer experience) {
		this.experience = experience;
	}

	public Integer getNowlevel() {
		return nowlevel;
	}

	public void setNowlevel(Integer nowlevel) {
		this.nowlevel = nowlevel;
	}

}
