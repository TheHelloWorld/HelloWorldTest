package com.helloworld.service.impl;


import java.util.List;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import com.helloworld.bean.Mission;
import com.helloworld.dao.HelloMissionDao;
import com.helloworld.dao.HelloWorldDao;
import com.helloworld.service.HelloMissionService;

@Service("helloMissionService")
public class HelloMissionServiceImpl implements HelloMissionService{
	
	private static final Logger logger = Logger.getLogger(HelloMissionServiceImpl.class);
	
	@Resource
    private HelloMissionDao helloMissionDao;
	
	@Resource
    private HelloWorldDao helloWorldDao;
	

	/**
	 * 发布任务
	 * @param mission
	 */
	public void addMission(Mission mission){
		try{
			helloMissionDao.addMission(mission);
		}catch(Exception e){
			logger.error("HelloMission err ServiceImple addMission msg:"+e.getMessage());
			e.printStackTrace();
		}	
	}
	
	
	/**
	 * 接任务
	 * @param owner_id
	 * @param id
	 */
	public void updateMissionOwnerById(Long owner_id,Long id){
		try{
			helloMissionDao.updateMissionOwnerById(owner_id, id);
		}catch(Exception e){
			logger.error("HelloMission err ServiceImple updateMissionOwnerById msg:"+e.getMessage());
			e.printStackTrace();
		}	
	}
	
	
	/**
	 * 修改任务
	 * @param mission
	 */
	public void updateMissionById(Mission mission){
		try{
			helloMissionDao.updateMissionById(mission);
		}catch(Exception e){
			logger.error("HelloMission err ServiceImple updateMissionById msg:"+e.getMessage());
			e.printStackTrace();
		}	
	}
	
	
	/**
	 * 修改任务状态̬
	 * @param status
	 * @param id
	 */
	public void updateMissionStatusById(String status,Long id){
		try{
			helloMissionDao.updateMissionStatusById(status, id);
		}catch(Exception e){
			logger.error("HelloMission err ServiceImple updateMissionStatusById msg:"+e.getMessage());
			e.printStackTrace();
		}	
	}
	
	
	/**
	 * 获得所有未接任务
	 * @return
	 */
	public List<Mission> getAllAvailableMission(){
		try{
			List<Mission> list = helloMissionDao.getAllAvailableMission();
			return list;
		}catch(Exception e){
			logger.error("HelloMission err ServiceImple getAlLAvailableMission msg:"+e.getMessage());
			e.printStackTrace();
			return null;
		}
		
	}
	
	
	/**
	 * 根据用户id获得所有以接任务
	 * @param owner_id
	 * @return
	 */
	public List<Mission> getMessionByOwnerId(Long owner_id){
		try{
			List<Mission> list = helloMissionDao.getMessionByOwnerId(owner_id);
			return list;
		}catch(Exception e){
			logger.error("HelloMission err ServiceImpl getMessionByOwnerId msg:"+e.getMessage());
			e.printStackTrace();
			return null;
		}	
	}
	
	
	/**
	 * 获得所有已经被接了的任务(status = 'IN')
	 * @return
	 */
	public List<Mission> getAllInMission(){
		try{
			List<Mission> list = helloMissionDao.getAllInMission();
			return list;
		}catch(Exception e){
			logger.error("HelloMission err ServiceImpl getAllInMission msg:"+e.getMessage());
			e.printStackTrace();
			return null;
		}
	}
	
	
	/**
	 * 获得任务经验
	 * @param experience
	 * @param id
	 * @return
	 */
	public void updateExperienceById(Integer experience,Long id){
		try{
			Integer oldExperience = helloWorldDao.getAccountById(id).getExperience();
			experience += oldExperience;
			helloMissionDao.updateExperienceById(experience, id);
		}catch(Exception e){
			logger.error("HelloMission err ServiceImpl updateExperienceById msg:"+e.getMessage());
			e.printStackTrace();
		}
	}
	
	/**
	 * 根据id获得Mission数据
	 * @param id
	 * @return
	 */
	@Override
	public Mission getMissionById(Long id){
		try{
			Mission mission = helloMissionDao.getMissionById(id);
			return mission;
		}catch(Exception e){
			logger.error("HelloMission err ServiceImpl getMissionById msg:"+e.getMessage());
			e.printStackTrace();
			return null;
		}
	}
	
}
