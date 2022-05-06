package com.ssafy.happyhouse.model.service;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import com.ssafy.happyhouse.model.HouseDto;

public interface HouseService {
	List<HouseDto> searchByDong(Map<String, String> map) throws Exception;
	List<HouseDto> searchByApt(Map<String, String> map) throws Exception;
	List<HouseDto> inquireFavorite(String memId) throws Exception;
	int addFavoriteHouse(Map<String, String> map) throws Exception;
	int deleteFavoriteHouse(Map<String, String> map) throws Exception;
}
