package com.midprj.comment.service;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class CommentVO {
	private int commentId;
	private String commentContents;
	private String memberId;
	private int noticeId;
	private String commentDate;
}
