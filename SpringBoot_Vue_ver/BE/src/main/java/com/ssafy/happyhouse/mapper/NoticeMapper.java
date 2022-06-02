package com.ssafy.happyhouse.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.ssafy.happyhouse.dto.Notice;
@Mapper
public interface NoticeMapper {
	public List<Notice> selectNotice();
	public Notice selectNoticeByNo(int no);
	public int insertNotice(Notice Notice);
	public int updateNotice(Notice Notice);
	public int deleteNotice(int no);
}