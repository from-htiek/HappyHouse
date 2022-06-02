package com.ssafy.happyhouse.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.happyhouse.dto.PopularAreaDto;
import com.ssafy.happyhouse.dto.PopularHouseDto;
import com.ssafy.happyhouse.mapper.PopularMapper;

@Service
public class PopularServiceImpl implements PopularService {

	@Autowired
	private PopularMapper popularMapper;

	@Override
	public List<PopularAreaDto> getPopularArea() throws Exception {
		return popularMapper.getPopularArea();
	}

	@Override
	public List<PopularHouseDto> getPopularHouse() throws Exception {
		return popularMapper.getPopularHouse();
	}
}
