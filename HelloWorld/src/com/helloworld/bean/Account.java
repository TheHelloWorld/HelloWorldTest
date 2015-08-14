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

}
