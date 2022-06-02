package com.ssafy.happyhouse.service;

import java.util.List;

import com.ssafy.happyhouse.dto.PopularAreaDto;
import com.ssafy.happyhouse.dto.PopularHouseDto;

public interface PopularService {
	
	List<PopularAreaDto> getPopularArea() throws Exception;
	List<PopularHouseDto> getPopularHouse() throws Exception;
}
