package com.ssafy.backend.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.ssafy.backend.dto.MemberDto;
import com.ssafy.backend.service.MemberService;
import com.ssafy.backend.service.MemberServiceImpl;
import com.ssafy.backend.util.DBUtil;

public class MemberDaoImpl implements MemberService {
	private DBUtil dbUtil = DBUtil.getInstance();
	static private MemberDaoImpl instance = null;
	private MemberDaoImpl(){};
	
	static public MemberDaoImpl getInstance() {
		if(instance == null) {
			instance = new MemberDaoImpl();
		}
		return instance;
	}
	
	@Override
	public int regist(MemberDto dto) throws SQLException {
		int result = 0;
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			conn = dbUtil.getConnection();
			pstmt = conn.prepareStatement("insert into member (memId, memPw, memName, memEmail, memTel, signupDate)"
					+ "values (?, ?, ?, ?, ?, now())" );
			pstmt.setString(1, dto.getMemId());
			pstmt.setString(2, dto.getMemPw());
			pstmt.setString(3, dto.getMemName());
			pstmt.setString(4, dto.getMemEmail());
			pstmt.setString(5, dto.getMemTel());
			result = pstmt.executeUpdate();
		} finally {
			dbUtil.close(pstmt, conn);
		}
		
		return result;
	}

	@Override
	public MemberDto login(String id, String pw) throws SQLException {
		MemberDto dto = null;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = dbUtil.getConnection();
			pstmt = conn.prepareStatement("select memId, memPw from member where memId = ? and memPw = ?");
			pstmt.setString(1, id);
			pstmt.setString(2, pw);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				dto = new MemberDto();
				dto.setMemId(rs.getString("memId"));
				dto.setMemName(rs.getString("memPw"));
			}
		} finally {
			dbUtil.close(rs, pstmt, conn);
		}
		
		return dto;
	}

	@Override
	public MemberDto memberInfo(String id) throws SQLException {
		MemberDto dto = null;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			conn = dbUtil.getConnection();
			pstmt = conn.prepareStatement("select * from member where memId = ?");
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				dto = new MemberDto();
				dto.setMemId(rs.getString("memId"));
				dto.setMemPw(rs.getString("memPw"));
				dto.setMemName(rs.getString("memName"));
				dto.setMemEmail(rs.getString("memEmail"));
				dto.setMemTel(rs.getString("memTel"));
			}
		} finally {
			dbUtil.close(rs, pstmt, conn);
		}
		
		return dto;

	}

	@Override
	public int update(MemberDto dto) throws SQLException {
		int cnt = 0;
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			conn = dbUtil.getConnection();
			pstmt = conn.prepareStatement("update member set memPw = ?, memName = ?, memEmail= ?, memTel= ? where memId = ?;");
			pstmt.setString(1, dto.getMemPw());
			pstmt.setString(2, dto.getMemName());
			pstmt.setString(3, dto.getMemEmail());
			pstmt.setString(4, dto.getMemTel());
			pstmt.setString(5, dto.getMemId());
			
			cnt = pstmt.executeUpdate();
		} finally {
			dbUtil.close(pstmt, conn);
		}
		
		return cnt;
	}

	@Override
	public void delete(String id) throws SQLException {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			conn = dbUtil.getConnection();
			pstmt = conn.prepareStatement("delete from member where memId = ?;");
			pstmt.setString(1, id);

			pstmt.executeUpdate(); 
		} finally {
			dbUtil.close(rs, pstmt, conn);
		}
		
	}

	@Override
	public String findpassword(MemberDto dto) throws Exception {
		String result = "";
//		Connection conn = null;
//		PreparedStatement pstmt = null;
//		ResultSet rs = null;
//		
//		try {
//			conn = dbUtil.getConnection();
//			pstmt = conn.prepareStatement("select memPass from member where memId = ?");
//			pstmt.setString(1, id);
//			rs = pstmt.executeQuery();
//			if (rs.next()) {
//				dto = new MemberDto();
//				dto.setMemId(rs.getString("memId"));
//				dto.setMemPw(rs.getString("memPw"));
//				dto.setMemName(rs.getString("memName"));
//				dto.setMemEmail(rs.getString("memEmail"));
//				dto.setMemTel(rs.getString("memTel"));
//			}
//		} finally {
//			dbUtil.close(rs, pstmt, conn);
//		}
		return result;
	}

}
