package com.ssafy.happyhouse.service;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.happyhouse.dto.MemberDto;
import com.ssafy.happyhouse.mapper.MemberMapper;

@Service
public class MemberServiceImpl implements MemberService {

	private MemberMapper memberMapper;
	
	@Autowired
	public MemberServiceImpl(MemberMapper memberMapper) {
		this.memberMapper = memberMapper;
	}
	
	@Override
	public boolean regist(MemberDto dto) throws Exception {
		return memberMapper.regist(dto) == 1;
	}

//	@Override
//	public MemberDto login(Map<String, String> map) throws Exception {
//		return memberMapper.login(map);
//	}

	@Override
	public MemberDto memberInfo(String id) throws Exception {
		return memberMapper.memberInfo(id);
	}

	@Override
	public boolean update(MemberDto dto) throws Exception {
		return memberMapper.update(dto) == 1;
	}

	@Override
	public boolean delete(String id) throws Exception {
		return memberMapper.delete(id) == 1;
	}
	
	@Override
	public MemberDto login(MemberDto memberDto) throws Exception {
		if(memberDto.getMemId() == null || memberDto.getMemPw() == null)
			return null;
		return memberMapper.login(memberDto);
	}

	@Override
	public MemberDto userInfo(String userid) throws Exception {
		return memberMapper.userInfo(userid);
	}

}
