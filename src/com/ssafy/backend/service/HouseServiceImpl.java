package com.ssafy.backend.service;

import java.sql.SQLException;
import java.util.List;

import com.ssafy.backend.dao.HouseDaoImpl;
import com.ssafy.backend.dao.MemberDaoImpl;
import com.ssafy.backend.dto.HouseDto;

public class HouseServiceImpl implements HouseService {
	static private HouseDaoImpl dao = HouseDaoImpl.getInstance();
	static private HouseServiceImpl instance = null;
	private HouseServiceImpl(){};
	
	static public HouseServiceImpl getInstance() {
		if(instance == null) {
			instance = new HouseServiceImpl();
		}
		return instance;
	}

	@Override
	public List<HouseDto> searchByDong(String dongName, String memId) throws SQLException {
		return dao.searchByDong(dongName, memId);
	}

	@Override
	public List<HouseDto> searchByApt(String aptName, String memId) throws SQLException {
		return dao.searchByApt(aptName, memId);
	}

	@Override
	public int addFavoriteHouse(String aptNo, String aptCode, String memId) throws SQLException {
		return dao.addFavoriteHouse(aptNo, aptCode, memId);
	}

	@Override
	public List<HouseDto> inquireFavorite(String memId) throws SQLException {
		return dao.inquireFavorite(memId);
	}

	@Override
	public int deleteFavoriteHouse(String aptNo, String aptCode, String memId) throws SQLException {
		return dao.deleteFavoriteHouse(aptNo, aptCode, memId);
	}

}
