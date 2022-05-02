package com.ssafy.happyhouse.model.service;

import java.sql.SQLException;
import java.util.List;

import com.ssafy.happyhouse.model.HouseDto;

public interface HouseService {
	List<HouseDto> searchByDong(String dongName, String memId) throws Exception;
	List<HouseDto> searchByApt(String aptName, String memId) throws Exception;
	List<HouseDto> inquireFavorite(String memId) throws Exception;
	int addFavoriteHouse(String aptNo, String aptCode, String memId) throws Exception;
	int deleteFavoriteHouse(String aptNo, String aptCode, String memId) throws Exception;
}
