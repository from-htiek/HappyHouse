package com.ssafy.backend.dao;

import java.sql.SQLException;
import java.util.List;

import com.ssafy.backend.dto.BoardDto;

public interface BoardDao {
	List<BoardDto> list() throws SQLException;
	void register(BoardDto dto) throws SQLException;
	BoardDto getPost(int no) throws SQLException;
	int update(BoardDto dto) throws SQLException;
	void delete(int no) throws SQLException;
}
