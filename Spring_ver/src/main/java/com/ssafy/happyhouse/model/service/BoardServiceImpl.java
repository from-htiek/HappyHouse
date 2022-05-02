package com.ssafy.happyhouse.model.service;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.happyhouse.model.BoardDto;
import com.ssafy.happyhouse.model.mapper.BoardMapper;

@Service
public class BoardServiceImpl implements BoardService {
	
	private BoardMapper boardMapper;
	
	@Autowired
	public BoardServiceImpl(BoardMapper boardMapper) {
		this.boardMapper = boardMapper;
	}

	@Override
	public List<BoardDto> list() throws Exception {
		return boardMapper.list();
	}

	@Override
	public void register(BoardDto dto) throws Exception {
		boardMapper.register(dto);		
	}

	@Override
	public BoardDto getPost(int no) throws Exception {
		return boardMapper.getPost(no);
	}

	@Override
	public int update(BoardDto dto) throws Exception {
		return boardMapper.update(dto);
	}

	@Override
	public void delete(int no) throws Exception {
		boardMapper.delete(no);
	}
}
