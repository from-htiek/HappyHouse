package com.ssafy.happyhouse.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ssafy.happyhouse.dto.Comment;
import com.ssafy.happyhouse.mapper.CommentMapper;

@Service
public class CommentServiceImpl implements CommentService {
	
    @Autowired
	private CommentMapper CommentMapper;

    @Override
	public List<Comment> retrieveComment(int memboardId) {
		return CommentMapper.selectComment(memboardId);
	}
    
  	@Override
	public boolean writeComment(Comment Comment) {
		return CommentMapper.insertComment(Comment) == 1;
	}

	@Override
	public Comment detailComment(int no) {
		return CommentMapper.selectCommentByNo(no);
	}

	@Override
	@Transactional
	public boolean updateComment(Comment Comment) {
		return CommentMapper.updateComment(Comment) == 1;
	}

	@Override
	@Transactional
	public boolean deleteComment(int no) {
		return CommentMapper.deleteComment(no) == 1;
	}
}