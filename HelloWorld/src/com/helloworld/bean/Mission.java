package com.helloworld.bean;

public class Mission {
	
	/** 任务id*/
	private Long id;
	
	/** 任务内容*/
	private String content;
	
	/** 任务经验值*/
	private Integer experience;
	
	/** 任务发布id*/
	private Long publisher_id;
	
	/** 任务拥有者id*/
	private Long owner_id;
	
	/** 任务类型*/
	private String type;
	
	/** 任务人数*/
	private Integer num;
	
	/** 任务创建时间*/
	private String create_time;
	
	/** 任务最后期限*/
	private String dead_line;
	
	/** 任务状态*/
	private String status;
	
	

	public String getCreate_time() {
		return create_time;
	}

	public void setCreate_time(String create_time) {
		this.create_time = create_time;
	}

	public String getDead_line() {
		return dead_line;
	}

	public void setDead_line(String dead_line) {
		this.dead_line = dead_line;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Integer getNum() {
		return num;
	}

	public void setNum(Integer num) {
		this.num = num;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Integer getExperience() {
		return experience;
	}

	public void setExperience(Integer experience) {
		this.experience = experience;
	}

	public Long getPublisher_id() {
		return publisher_id;
	}

	public void setPublisher_id(Long publisher_id) {
		this.publisher_id = publisher_id;
	}

	public Long getOwner_id() {
		return owner_id;
	}

	public void setOwner_id(Long owner_id) {
		this.owner_id = owner_id;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	
	

}
