package com.ssafy.backend.service;

import com.ssafy.backend.dao.MemberDaoImpl;
import com.ssafy.backend.dto.MemberDto;

public class MemberServiceImpl implements MemberService {
	
	static private MemberDaoImpl dao = MemberDaoImpl.getInstance();
	static private MemberServiceImpl instance = null;
	private MemberServiceImpl(){};
	
	static public MemberServiceImpl getInstance() {
		if(instance == null) {
			instance = new MemberServiceImpl();
		}
		return instance;
	}
	
	@Override
	public int regist(MemberDto dto) throws Exception {
		return dao.regist(dto);
	}

	@Override
	public MemberDto login(String id, String pw) throws Exception {
		return dao.login(id, pw);
	}

	@Override
	public MemberDto memberInfo(String id) throws Exception {
		return dao.memberInfo(id);
	}

	@Override
	public int update(MemberDto dto) throws Exception {
		return dao.update(dto);
	}

	@Override
	public void delete(String id) throws Exception {
		dao.delete(id);
	}

	@Override
	public String findpassword(MemberDto dto) throws Exception {
		return dao.findpassword(dto);
	}

}
