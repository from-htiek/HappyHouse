package com.ssafy.backend.service;

import java.sql.SQLException;
import java.util.List;

import com.ssafy.backend.dto.HouseDto;



public interface HouseService {
	List<HouseDto> searchByDong(String dongName, String memId) throws SQLException;
	List<HouseDto> searchByApt(String aptName, String memId) throws SQLException;
	List<HouseDto> inquireFavorite(String memId) throws SQLException;
	int addFavoriteHouse(String aptNo, String aptCode, String memId) throws SQLException;
	int deleteFavoriteHouse(String aptNo, String aptCode, String memId) throws SQLException;
}
