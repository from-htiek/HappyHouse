package com.ssafy.happyhouse.mapper;

import java.sql.SQLException;
import java.util.List;

import com.ssafy.happyhouse.dto.AreaLikeDto;
import com.ssafy.happyhouse.dto.HouseLikeDto;

public interface HouseLikeMapper {
	
	// 좋아요 매물 추가
	public int insertLikeHouse(HouseLikeDto houseLikeDto) throws SQLException;
	
	// 좋아요 매물 삭제 
	public int deleteLikeHouse(int no) throws SQLException;
	
	// 관심 매물 리스트 얻어오기
	List<HouseLikeDto> getLikeHouse(String memId) throws SQLException;
	
	public int addBookmarkArea(AreaLikeDto areaLikeDto) throws SQLException;
	List<AreaLikeDto> getBookmarkArea(String memId) throws SQLException;
}
