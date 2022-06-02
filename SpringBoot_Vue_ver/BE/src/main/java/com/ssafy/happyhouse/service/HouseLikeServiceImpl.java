package com.ssafy.happyhouse.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.happyhouse.dto.AreaLikeDto;
import com.ssafy.happyhouse.dto.HouseLikeDto;
import com.ssafy.happyhouse.mapper.HouseLikeMapper;

@Service
public class HouseLikeServiceImpl implements HouseLikeService {

	@Autowired
	private HouseLikeMapper houseLikeMapper;
	
	@Override
	public boolean insertLikeHouse(HouseLikeDto houseLikeDto) throws Exception {		
		return houseLikeMapper.insertLikeHouse(houseLikeDto) == 1;
	}

	@Override
	public boolean deleteLikeHouse(int no) throws Exception {		
		return houseLikeMapper.deleteLikeHouse(no) == 1;
	}

	@Override
	public List<HouseLikeDto> getLikeHouse(String memId) throws Exception {		
		return houseLikeMapper.getLikeHouse(memId);
	}

	@Override
	public boolean addBookmarkArea(AreaLikeDto areaLikeDto) throws Exception {
		return houseLikeMapper.addBookmarkArea(areaLikeDto) == 1;
	}

	@Override
	public List<AreaLikeDto> getBookmarkArea(String memId) throws Exception {
		return houseLikeMapper.getBookmarkArea(memId);
	}

}
