package com.ssafy.happyhouse.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "Comment (댓글정보)", description = "댓글번호, 글번호, 내용, 작성자아이디, 작성일을 가진   Domain Class")
public class Comment {
	@ApiModelProperty(value = "댓글번호")
	private int no;
	@ApiModelProperty(value = "글번호")
	private int memboardId;
	@ApiModelProperty(value = "작성자아이디")
	private String memId;
	@ApiModelProperty(value = "내용")
	private String content;
	@ApiModelProperty(value = "작성일")
	private String date;
	
	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}
	public int getMemboardId() {
		return memboardId;
	}
	public void setMemboardId(int memboardId) {
		this.memboardId = memboardId;
	}
	public String getMemId() {
		return memId;
	}
	public void setMemId(String memId) {
		this.memId = memId;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	
	@Override
	public String toString() {
		return "Comment [no=" + no + ", memboardId=" + memboardId + ", memId=" + memId + ", content=" + content
				+ ", date=" + date + "]";
	}
	
	


	
}