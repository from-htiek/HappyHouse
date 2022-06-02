package com.ssafy.happyhouse.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ssafy.happyhouse.dto.Notice;
import com.ssafy.happyhouse.mapper.NoticeMapper;

@Service
public class NoticeServiceImpl implements NoticeService {
	
    @Autowired
	private NoticeMapper NoticeMapper;

    @Override
	public List<Notice> retrieveNotice() {
		return NoticeMapper.selectNotice();
	}
    
  	@Override
	public boolean writeNotice(Notice Notice) {
		return NoticeMapper.insertNotice(Notice) == 1;
	}

	@Override
	public Notice detailNotice(int no) {
		return NoticeMapper.selectNoticeByNo(no);
	}

	@Override
	@Transactional
	public boolean updateNotice(Notice Notice) {
		return NoticeMapper.updateNotice(Notice) == 1;
	}

	@Override
	@Transactional
	public boolean deleteNotice(int no) {
		return NoticeMapper.deleteNotice(no) == 1;
	}
}