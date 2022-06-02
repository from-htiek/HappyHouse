package com.ssafy.happyhouse.service;

import java.sql.SQLException;
import java.util.List;

import com.ssafy.happyhouse.dto.AreaLikeDto;
import com.ssafy.happyhouse.dto.HouseLikeDto;

public interface HouseLikeService {

	public boolean insertLikeHouse(HouseLikeDto houseLikeDto) throws Exception;	
	public boolean deleteLikeHouse(int no) throws Exception;
	List<HouseLikeDto> getLikeHouse(String memId) throws Exception;
	
	public boolean addBookmarkArea(AreaLikeDto areaLikeDto) throws Exception;
	List<AreaLikeDto> getBookmarkArea(String memId) throws Exception;
}
