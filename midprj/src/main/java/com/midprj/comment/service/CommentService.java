package com.midprj.comment.service;

import java.util.List;

public interface CommentService {
	List<CommentVO> commentSelectList(int noticeId);

	int commentInsert(CommentVO vo);
	int commentUpdate(CommentVO vo);
	int commentDelete(CommentVO vo);
}
