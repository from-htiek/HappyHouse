package com.ssafy.backend.dao;

import java.sql.SQLException;
import java.util.List;

import com.ssafy.backend.dto.HouseDto;


public interface HouseDao{

	List<HouseDto> searchByApt(String aptCode, String memId) throws Exception;
	List<HouseDto> searchByDong(String dongCode, String memId) throws Exception;
	List<HouseDto> inquireFavorite(String memId) throws Exception;
	int addFavoriteHouse(String aptNo, String aptCode, String memId) throws Exception;
	int deleteFavoriteHouse(String aptNo, String aptCode, String memId) throws Exception;
}
