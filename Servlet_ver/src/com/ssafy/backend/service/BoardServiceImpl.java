package com.ssafy.backend.service;

import java.util.List;

import com.ssafy.backend.dao.BoardDaoImpl;
import com.ssafy.backend.dto.BoardDto;

public class BoardServiceImpl implements BoardService {
	
	static private BoardDaoImpl dao = BoardDaoImpl.getInstance();
	static private BoardServiceImpl instance = null;
	private BoardServiceImpl(){};
	
	static public BoardServiceImpl getInstance() {
		if(instance == null) {
			instance = new BoardServiceImpl();
		}
		return instance;
	}

	@Override
	public List<BoardDto> list() throws Exception {
		return dao.list();
	}

	@Override
	public void register(BoardDto dto) throws Exception {
		dao.register(dto);		
	}

	@Override
	public BoardDto getPost(int no) throws Exception {
		return dao.getPost(no);
	}

	@Override
	public int update(BoardDto dto) throws Exception {
		return dao.update(dto);
	}

	@Override
	public void delete(int no) throws Exception {
		dao.delete(no);
	}
}
