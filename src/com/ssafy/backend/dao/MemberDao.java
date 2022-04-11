package com.ssafy.backend.dao;

import java.sql.SQLException;

import com.ssafy.backend.dto.MemberDto;

public interface MemberDao {
	int regist(MemberDto dto) throws SQLException;
	MemberDto login(String id, String pw) throws SQLException;
	MemberDto memberInfo(String id) throws SQLException;
	int update(MemberDto dto) throws SQLException;
	void delete(String id) throws SQLException;
	String findpassword(MemberDto dto) throws SQLException;
}
