package com.ssafy.happyhouse.model.service;

import java.util.List;

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
	public List<HouseDto> searchByDong(String dongName, String memId) throws Exception {
		return houseMapper.searchByDong(dongName, memId);
	}

	@Override
	public List<HouseDto> searchByApt(String aptName, String memId) throws Exception {
		return houseMapper.searchByApt(aptName, memId);
	}

	@Override
	public int addFavoriteHouse(String aptNo, String aptCode, String memId) throws Exception {
		return houseMapper.addFavoriteHouse(aptNo, aptCode, memId);
	}

	@Override
	public List<HouseDto> inquireFavorite(String memId) throws Exception {
		return houseMapper.inquireFavorite(memId);
	}

	@Override
	public int deleteFavoriteHouse(String aptNo, String aptCode, String memId) throws Exception {
		return houseMapper.deleteFavoriteHouse(aptNo, aptCode, memId);
	}

}
