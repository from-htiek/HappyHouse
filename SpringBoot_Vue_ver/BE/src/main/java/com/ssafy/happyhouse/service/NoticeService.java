package com.ssafy.happyhouse.service;

import java.util.List;

import com.ssafy.happyhouse.dto.Notice;

public interface NoticeService {
	public List<Notice> retrieveNotice();
	public Notice detailNotice(int no);
	public boolean writeNotice(Notice Notice);
	public boolean updateNotice(Notice Notice);
	public boolean deleteNotice(int no);
}
