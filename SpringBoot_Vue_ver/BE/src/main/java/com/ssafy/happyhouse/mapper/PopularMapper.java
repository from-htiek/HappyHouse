package com.ssafy.happyhouse.mapper;

import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.ssafy.happyhouse.dto.PopularAreaDto;
import com.ssafy.happyhouse.dto.PopularHouseDto;

@Mapper
public interface PopularMapper {
	
	List<PopularAreaDto> getPopularArea() throws SQLException;
	List<PopularHouseDto> getPopularHouse() throws SQLException;
}
