package com.ssafy.happyhouse.service;

import java.util.List;

import com.ssafy.happyhouse.dto.Comment;

public interface CommentService {
	public List<Comment> retrieveComment(int memboardId);
	public Comment detailComment(int no);
	public boolean writeComment(Comment Comment);
	public boolean updateComment(Comment Comment);
	public boolean deleteComment(int no);
}
