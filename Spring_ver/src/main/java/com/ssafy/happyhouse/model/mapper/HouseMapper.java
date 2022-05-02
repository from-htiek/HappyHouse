package com.ssafy.happyhouse.model.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.ssafy.happyhouse.model.HouseDto;

@Mapper
public interface HouseMapper{

	List<HouseDto> searchByApt(String aptCode, String memId) throws Exception;
	List<HouseDto> searchByDong(String dongCode, String memId) throws Exception;
	List<HouseDto> inquireFavorite(String memId) throws Exception;
	int addFavoriteHouse(String aptNo, String aptCode, String memId) throws Exception;
	int deleteFavoriteHouse(String aptNo, String aptCode, String memId) throws Exception;
}
