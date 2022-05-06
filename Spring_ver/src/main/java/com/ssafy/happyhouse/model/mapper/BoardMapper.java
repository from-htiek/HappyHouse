package com.ssafy.happyhouse.model.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.ssafy.happyhouse.model.BoardDto;

@Mapper
public interface BoardMapper {
	
	List<BoardDto> list(Map<String, Object> map) throws Exception;
	int getTotalCount(Map<String, String> map) throws Exception;
	void register(BoardDto dto) throws Exception;
	BoardDto getPost(int no) throws Exception;
	void update(BoardDto dto) throws Exception;
	void delete(int no) throws Exception;
}
