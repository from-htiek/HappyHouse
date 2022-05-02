package com.ssafy.happyhouse.model.service;

import java.util.Map;

import com.ssafy.happyhouse.model.MemberDto;

public interface MemberService {
	int regist(MemberDto dto) throws Exception;
	MemberDto login(Map<String, String> map) throws Exception;
	MemberDto memberInfo(String id) throws Exception;
	int update(MemberDto dto) throws Exception;
	void delete(String id) throws Exception;
	String findpassword(MemberDto dto) throws Exception;
}
