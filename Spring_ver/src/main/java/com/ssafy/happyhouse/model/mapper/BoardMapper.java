package com.ssafy.happyhouse.model.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.ssafy.happyhouse.model.BoardDto;

@Mapper
public interface BoardMapper {
	List<BoardDto> list() throws Exception;
	void register(BoardDto dto) throws Exception;
	BoardDto getPost(int no) throws Exception;
	int update(BoardDto dto) throws Exception;
	void delete(int no) throws Exception;
}
