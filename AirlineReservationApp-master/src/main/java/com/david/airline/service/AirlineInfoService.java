package com.david.airline.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.david.airline.dao.AirlineInfoDao;
import com.david.airline.entity.AirlineInfo;

@Service
public class AirlineInfoService {
	
	@Autowired
	private AirlineInfoDao airlineInfoDao;
	

	public AirlineInfo findByNameOfAirline(String name) {
		return airlineInfoDao.findByNameOfAirline(name);
	}

}
