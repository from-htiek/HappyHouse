package com.ssafy.happyhouse.model.service;

import java.util.List;
import java.util.Map;

import com.ssafy.happyhouse.model.BoardDto;
import com.ssafy.util.PageNavigation;

public interface BoardService {
	List<BoardDto> list(Map<String, String> map) throws Exception;
	PageNavigation makePageNavigation(Map<String, String> map) throws Exception;
	void register(BoardDto dto) throws Exception;
	BoardDto getPost(int no) throws Exception;
	void update(BoardDto dto) throws Exception;
	void delete(int no) throws Exception;
}
