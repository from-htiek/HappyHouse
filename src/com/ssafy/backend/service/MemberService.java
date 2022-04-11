package com.ssafy.backend.service;

import com.ssafy.backend.dto.MemberDto;

public interface MemberService {
	int regist(MemberDto dto) throws Exception;
	MemberDto login(String id, String pw) throws Exception;
	MemberDto memberInfo(String id) throws Exception;
	int update(MemberDto dto) throws Exception;
	void delete(String id) throws Exception;
	String findpassword(MemberDto dto) throws Exception;
}
