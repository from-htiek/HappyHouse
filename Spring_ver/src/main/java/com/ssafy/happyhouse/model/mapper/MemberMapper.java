package com.ssafy.happyhouse.model.mapper;

import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.ssafy.happyhouse.model.MemberDto;

@Mapper
public interface MemberMapper {
	int regist(MemberDto dto) throws Exception;
	MemberDto login(Map<String, String> map) throws Exception;
	MemberDto memberInfo(String id) throws Exception;
	int update(MemberDto dto) throws Exception;
	void delete(String id) throws Exception;
	String findpassword(MemberDto dto) throws Exception;
}
