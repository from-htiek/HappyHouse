package com.ssafy.happyhouse.service;

import java.util.Map;

import com.ssafy.happyhouse.dto.MemberDto;

public interface MemberService {
	public boolean regist(MemberDto dto) throws Exception;
	//public MemberDto login(Map<String, String> map) throws Exception;
	public MemberDto memberInfo(String id) throws Exception;
	public boolean update(MemberDto dto) throws Exception;
	public boolean delete(String id) throws Exception;
	
	public MemberDto login(MemberDto memberDto) throws Exception;
	public MemberDto userInfo(String userid) throws Exception;
}
