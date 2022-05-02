package com.ssafy.backend.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import com.ssafy.backend.dto.BoardDto;
import com.ssafy.backend.util.DBUtil;

public class BoardDaoImpl implements BoardDao{

	private DBUtil dbUtil = DBUtil.getInstance();
	static private BoardDaoImpl instance = null;
	private BoardDaoImpl(){};

	static public BoardDaoImpl getInstance() {
		if(instance == null) {
			instance = new BoardDaoImpl();
		}
		return instance;
	}

	@Override
	public List<BoardDto> list() throws SQLException {
		List<BoardDto> list = new ArrayList<>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			
			conn = dbUtil.getConnection();
			pstmt = conn.prepareStatement("select no, memId, title, date from memboard order by no desc;");
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				BoardDto dto = new BoardDto();
				dto.setPostNo(rs.getInt("no"));
				dto.setMemId(rs.getString("memId"));
				dto.setTitle(rs.getString("title"));
//				dto.setContent(rs.getString("content"));
				dto.setRegDate(rs.getString("date"));
//				System.out.println(dto);
				list.add(dto);
			}
			
		} finally {
			dbUtil.close(rs, pstmt, conn);
		}
		return list;
	}

	@Override
	public void register(BoardDto dto) throws SQLException {
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			conn = dbUtil.getConnection();
			pstmt = conn.prepareStatement("insert into memboard(memId, title, content, date) values(?, ?, ?, now());");
			pstmt.setString(1, dto.getMemId());
			pstmt.setString(2, dto.getTitle());
			pstmt.setString(3, dto.getContent());
			pstmt.executeUpdate();
			
		} finally {
			dbUtil.close(pstmt, conn);
		}
		
	}

	@Override
	public BoardDto getPost(int no) throws SQLException {
		BoardDto dto = null;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			conn = dbUtil.getConnection();
			pstmt = conn.prepareStatement("select* from memboard where no = ?;");
			pstmt.setInt(1, no);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				dto = new BoardDto();
				dto.setPostNo(rs.getInt("no"));
				dto.setMemId(rs.getString("memId"));
				dto.setTitle(rs.getString("title"));
				dto.setContent(rs.getString("content"));
				dto.setRegDate(rs.getString("date"));
			}
			
		} finally {
			dbUtil.close(rs, pstmt, conn);
		}
		
		return dto;
	}

	@Override
	public int update(BoardDto dto) throws SQLException {
		int cnt = 0;
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = dbUtil.getConnection();
			pstmt = conn.prepareStatement("update memboard set title = ?, content = ? where no = ?;");
			pstmt.setString(1, dto.getTitle());
			pstmt.setString(2, dto.getContent());
			pstmt.setInt(3, dto.getPostNo());
			
			cnt = pstmt.executeUpdate();
		} finally {
			dbUtil.close(pstmt, conn);
		}
		return cnt;
	}

	@Override
	public void delete(int no) throws SQLException {
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = dbUtil.getConnection();
			pstmt = conn.prepareStatement("delete from memboard where no = ?;");
			pstmt.setInt(1, no);
			pstmt.executeUpdate();
		} finally {
			dbUtil.close(pstmt, conn);
		}
	}
	
	
}
