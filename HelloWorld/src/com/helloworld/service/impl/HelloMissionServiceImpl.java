package com.helloworld.service.impl;


import java.util.List;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import com.helloworld.bean.Mission;
import com.helloworld.dao.HelloMissionDao;
import com.helloworld.service.HelloMissionService;

@Service("helloMissionService")
public class HelloMissionServiceImpl implements HelloMissionService{
	
	private static final Logger logger = Logger.getLogger(HelloMissionServiceImpl.class);
	
	@Resource
    private HelloMissionDao helloMissionDao;
	

	/**
	 * �������
	 * @param mission
	 */
	public void addMission(Mission mission){
		try{
			helloMissionDao.addMission(mission);
		}catch(Exception e){
			logger.error("HelloMission err ServiceImple addMission msg:"+e.getMessage());
		}	
	}
	
	
	/**
	 * ��������
	 * @param owner_id
	 * @param id
	 */
	public void updateMissionById(Long owner_id,Long id){
		try{
			helloMissionDao.updateMissionById(owner_id, id);
		}catch(Exception e){
			logger.error("HelloMission err ServiceImple updateMissionById msg:"+e.getMessage());
		}	
	}
	
	/**
	 * ����id�޸�����״̬
	 * @param status
	 * @param id
	 */
	public void updateMissionStatusById(String status,Long id){
		try{
			helloMissionDao.updateMissionStatusById(status, id);
		}catch(Exception e){
			logger.error("HelloMission err ServiceImple updateMissionStatusById msg:"+e.getMessage());
		}	
	}
	
	/**
	 * ������п�������
	 * @return
	 */
	public List<Mission> getAlLAvailableMission(){
		try{
			List<Mission> list = helloMissionDao.getAlLAvailableMission();
			return list;
		}catch(Exception e){
			logger.error("HelloMission err ServiceImple getAlLAvailableMission msg:"+e.getMessage());
			return null;
		}
		
	}
	
	/**
	 * ����owner_id������и��˻�������
	 * @param owner_id
	 * @return
	 */
	public List<Mission> getMessionByOwnerId(Long owner_id){
		try{
			List<Mission> list = helloMissionDao.getMessionByOwnerId(owner_id);
			return list;
		}catch(Exception e){
			logger.error("HelloMission err ServiceImple getMessionByOwnerId msg:"+e.getMessage());
			return null;
		}	
	}
	
}
