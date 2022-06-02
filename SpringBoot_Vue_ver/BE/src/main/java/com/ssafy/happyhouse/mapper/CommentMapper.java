package com.ssafy.happyhouse.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.ssafy.happyhouse.dto.Comment;
@Mapper
public interface CommentMapper {
	public List<Comment> selectComment(int memboardId);
	public Comment selectCommentByNo(int no);
	public int insertComment(Comment comment);
	public int updateComment(Comment comment);
	public int deleteComment(int no);
}