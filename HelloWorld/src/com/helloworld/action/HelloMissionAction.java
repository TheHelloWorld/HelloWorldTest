package com.helloworld.action;

import javax.annotation.Resource;

import org.apache.log4j.Logger;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


import com.helloworld.bean.Mission;
import com.helloworld.service.HelloMissionService;



@Controller 
public class HelloMissionAction {
	
	private static final Logger logger = Logger.getLogger(HelloMissionAction.class);
	
	@Resource
    private HelloMissionService helloMissionService;
	 
	
	/**
	 * 添加任务
	 * @param mission
	 */
	@RequestMapping(value = "addMission")
	public void addMission(Mission mission){
		try{
			helloMissionService.addMission(mission);
		}catch(Exception e){
			logger.error("HelloMission err Action addMission msg:"+e.getMessage());
		}	
	}
	
	
	/**
	 * 接受任务
	 * @param owner_id
	 * @param id
	 */
	@RequestMapping(value = "updateMissionOwnerById")
	public void updateMissionOwnerById(Long owner_id,Long id){
		try{
			helloMissionService.updateMissionOwnerById(owner_id, id);
		}catch(Exception e){
			logger.error("HelloMission err Action updateMissionOwnerById msg:"+e.getMessage());
		}		
	}
	
	
	/**
	 * 修改任务
	 * @param mission
	 */
	@RequestMapping(value = "updateMissionById")
	public void updateMissionById(Mission mission){
		try{
			helloMissionService.updateMissionById(mission);
		}catch(Exception e){
			logger.error("HelloMission err Action updateMissionById msg:"+e.getMessage());
		}		
	}
	
	
	/**
	 * 根据id修改任务状态
	 * @param status
	 * @param id
	 */
	@RequestMapping(value = "updateMissionStatusById")
	public void updateMissionStatusById(String status,Long id){
		try{
			helloMissionService.updateMissionStatusById(status, id);
		}catch(Exception e){
			logger.error("HelloMission err Action updateMissionStatusById msg:"+e.getMessage());
		}
	}
 	
}
