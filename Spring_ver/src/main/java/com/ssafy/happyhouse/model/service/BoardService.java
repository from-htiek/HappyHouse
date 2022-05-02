package com.ssafy.happyhouse.model.service;

import java.util.List;

import com.ssafy.happyhouse.model.BoardDto;

public interface BoardService {
	List<BoardDto> list() throws Exception;
	void register(BoardDto dto) throws Exception;
	BoardDto getPost(int no) throws Exception;
	int update(BoardDto dto) throws Exception;
	void delete(int no) throws Exception;
}
