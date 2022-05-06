package com.ssafy.happyhouse.model.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.web.bind.annotation.RequestParam;

import com.ssafy.happyhouse.model.HouseDto;

@Mapper
public interface HouseMapper{

	List<HouseDto> searchByApt(Map<String, String> map) throws Exception;
	List<HouseDto> searchByDong(Map<String, String> map) throws Exception;
	List<HouseDto> inquireFavorite(String memId) throws Exception;
	int addFavoriteHouse(Map<String, String> map) throws Exception;
	int deleteFavoriteHouse(Map<String, String> map) throws Exception;
}
