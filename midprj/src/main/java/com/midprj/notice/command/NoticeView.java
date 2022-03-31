package com.midprj.notice.command;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.midprj.comm.Command;
import com.midprj.comment.service.CommentService;
import com.midprj.comment.service.CommentVO;
import com.midprj.comment.serviceImpl.CommentServiceImpl;
import com.midprj.member.service.MemberService;
import com.midprj.member.service.MemberVO;
import com.midprj.member.serviceImpl.MemberServiceImpl;
import com.midprj.notice.service.NoticeService;
import com.midprj.notice.service.NoticeVO;
import com.midprj.notice.serviceImpl.NoticeServiceImpl;

public class NoticeView implements Command {

	@Override
	public String exec(HttpServletRequest request, HttpServletResponse response) {
		//request 값 : loginName(로그인유저네임),notice(게시글 정보), comment(게시글 댓글정보), commentQuery(게시글 댓글 개수) 
		//vo에 게시판저장
		NoticeService nDAO = new NoticeServiceImpl();
		NoticeVO vo = new NoticeVO();
		int noticeId = Integer.parseInt(request.getParameter("noticeId"));
		vo.setNoticeId(noticeId);
		
		// 로그인 유저 확인
		HttpSession session = request.getSession();
		String loginName =  (String)session.getAttribute("loginName");
		request.setAttribute("loginName" , loginName);
		
		// 조회수 증가 
		request.setAttribute("notice",nDAO.noticeSelect(vo));
		nDAO.noticeUpdateHit(vo.getNoticeId());
		
		// 댓글 불러오기
		CommentService cDAO = new CommentServiceImpl();
		MemberService mDAO = new MemberServiceImpl();
		MemberVO mVO = new MemberVO();
		List<String> sList = new ArrayList<String>();
		List<CommentVO> cList = cDAO.commentSelectList(Integer.parseInt(request.getParameter("noticeId")));
		
		// 댓글작성자 > 이름(ID**) 형식으로 출력
		for(CommentVO c : cList) {
			mVO.setMemberId(c.getMemberId());
			String mId = c.getMemberId();
			String mId_a = mId.substring(0,3);
			for(int i=3;i<mId.length();i++) {
				mId_a += "*";
			}
			String str = mDAO.selectMember(mVO).getMemberName() + " (" +  mId_a + ")";
			sList.add(str);
		}
		request.setAttribute("comment", cList);
		request.setAttribute("s", sList);
		 
		return "notice/noticeView";
	}
}
