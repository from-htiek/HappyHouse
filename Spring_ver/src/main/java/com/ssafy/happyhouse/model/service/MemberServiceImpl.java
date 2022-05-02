package com.ssafy.happyhouse.model.service;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.happyhouse.model.MemberDto;
import com.ssafy.happyhouse.model.mapper.MemberMapper;

@Service
public class MemberServiceImpl implements MemberService {
	
	private MemberMapper memberMapper;
	
	@Autowired
	public MemberServiceImpl(MemberMapper memberMapper) {
		this.memberMapper = memberMapper;
	}
	
	
	@Override
	public int regist(MemberDto dto) throws Exception {
		return memberMapper.regist(dto);
	}

	@Override
	public MemberDto login(Map<String, String> map) throws Exception {
		return memberMapper.login(map);
	}

	@Override
	public MemberDto memberInfo(String id) throws Exception {
		return memberMapper.memberInfo(id);
	}

	@Override
	public int update(MemberDto dto) throws Exception {
		return memberMapper.update(dto);
	}

	@Override
	public void delete(String id) throws Exception {
		memberMapper.delete(id);
	}

	@Override
	public String findpassword(MemberDto dto) throws Exception {
		return memberMapper.findpassword(dto);
	}

}
