package com.ssafy.happyhouse.mapper;

import java.sql.SQLException;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.ssafy.happyhouse.dto.MemberDto;

@Mapper
public interface MemberMapper {
	public int regist(MemberDto dto) throws SQLException;
	//public MemberDto login(Map<String, String> map) throws SQLException;
	public MemberDto memberInfo(String id) throws SQLException;
	public int update(MemberDto dto) throws SQLException;
	public int delete(String id) throws SQLException;
	
	public MemberDto login(MemberDto memberDto) throws SQLException;
	public MemberDto userInfo(String userid) throws SQLException;
}
