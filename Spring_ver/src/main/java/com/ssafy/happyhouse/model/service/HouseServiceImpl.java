package com.ssafy.happyhouse.model.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.happyhouse.model.HouseDto;
import com.ssafy.happyhouse.model.mapper.HouseMapper;

@Service
public class HouseServiceImpl implements HouseService {

	private HouseMapper houseMapper;
	
	@Autowired
	public HouseServiceImpl(HouseMapper houseMapper) {
		this.houseMapper = houseMapper;
	}
	
	@Override
	public List<HouseDto> searchByDong(Map<String, String> map) throws Exception {
		return houseMapper.searchByDong(map);
	}

	@Override
	public List<HouseDto> searchByApt(Map<String, String> map) throws Exception {
		return houseMapper.searchByApt(map);
	}

	@Override
	public int addFavoriteHouse(Map<String, String> map) throws Exception {
		return houseMapper.addFavoriteHouse(map);
	}

	@Override
	public List<HouseDto> inquireFavorite(String memId) throws Exception {
		return houseMapper.inquireFavorite(memId);
	}

	@Override
	public int deleteFavoriteHouse(Map<String, String> map) throws Exception {
		return houseMapper.deleteFavoriteHouse(map);
	}

}
