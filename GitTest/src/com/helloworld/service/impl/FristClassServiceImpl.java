package com.helloworld.service.impl;

import javax.annotation.Resource;

import com.helloworld.dao.FirstClassDao;
import com.helloworld.service.FirstClassService;
import org.springframework.stereotype.Service;

@Service("firstClassService")
public class FristClassServiceImpl implements FirstClassService{
	
	@Resource
    private FirstClassDao firstClassDao;
	
	@Override
	public int test(){
		firstClassDao.getIdByName("123");
		return  0;
	}

}
