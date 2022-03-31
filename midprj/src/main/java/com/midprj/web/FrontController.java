package com.midprj.web;

import java.io.IOException;
import java.util.HashMap;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.midprj.account.command.AccountInquiry;
import com.midprj.account.command.AccountList;
import com.midprj.accounts.command.accountsList;
import com.midprj.comm.Command;
import com.midprj.comment.command.CommentDelete;
import com.midprj.comment.command.CommentInsert;
import com.midprj.comment.command.CommentSearch;
import com.midprj.comment.command.CommentUpdate;
import com.midprj.home.command.HomeCommand;
import com.midprj.member.command.AjaxMemberIdCheck;
import com.midprj.member.command.AjaxMemberPwUpdate;
import com.midprj.member.command.MapAtm;
import com.midprj.member.command.MemberFindId;
import com.midprj.member.command.MemberFindIdForm;
import com.midprj.member.command.MemberFindPw;
import com.midprj.member.command.MemberFindPwForm;
import com.midprj.member.command.MemberJoin;
import com.midprj.member.command.MemberJoinForm;
import com.midprj.member.command.MemberLogin;
import com.midprj.member.command.MemberLoginForm;
import com.midprj.member.command.MemberMyPage;
import com.midprj.member.command.MemberUpdate;
import com.midprj.member.command.MemberUpdateForm;
import com.midprj.member.command.MemberUpdatePwForm;
import com.midprj.notice.command.AjaxNoticeSearch;
import com.midprj.notice.command.AjaxSortNotice;
import com.midprj.notice.command.NoticeDelete;
import com.midprj.notice.command.NoticeInsert;
import com.midprj.notice.command.NoticeInsertForm;
import com.midprj.notice.command.NoticeList;
import com.midprj.notice.command.NoticeUpdate;
import com.midprj.notice.command.NoticeUpdateForm;
import com.midprj.notice.command.NoticeView;
import com.midprj.oneaccount.command.OneAccount;
import com.midprj.openbanking.command.BankOauthCommand;
import com.midprj.openbanking.command.CallbackCommand;
import com.midprj.openbanking.command.OpenBanking;
import com.midprj.qna.command.QnaAnswerUpdate;
import com.midprj.qna.command.QnaInsert;
import com.midprj.qna.command.QnaInsertForm;
import com.midprj.qna.command.QnaList;
import com.midprj.qna.command.QnaView;



public class FrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private HashMap<String, Command> map = new HashMap<String, Command>();

	public FrontController() {
		super();
	}

	public void init(ServletConfig config) throws ServletException {

		map.put("/home.do", new HomeCommand()); 								// 메인 홈페이지
		
		map.put("/memberJoinForm.do", new MemberJoinForm());					// 회원가입 페이지
		map.put("/memberJoin.do", new MemberJoin());							// 회원가입 처리
		map.put("/ajaxMemberIdCheck.do", new AjaxMemberIdCheck());				// ID 중복 체크
		map.put("/memberLoginForm.do", new MemberLoginForm());					// 로그인 페이지
		map.put("/memberLogin.do", new MemberLogin());							// 로그인 처리
		map.put("/memberFindIdForm.do", new MemberFindIdForm());				// ID찾기 페이지
		map.put("/memberFindId.do", new MemberFindId());						// ID찾기 처리
		map.put("/memberFindPwForm.do", new MemberFindPwForm());				// 비밀번호찾기 페이지
		map.put("/memberFindPw.do", new MemberFindPw());						// 비밀번호찾기 처리
		map.put("/memberUpdatePwForm.do", new MemberUpdatePwForm());			// 비밀번호변경 페이지
		map.put("/ajaxMemberPwUpdate.do", new AjaxMemberPwUpdate());			// 비밀번호변경 처리
		
		map.put("/memberMyPage.do", new MemberMyPage());						// 마이페이지				
		map.put("/memberUpdateForm.do", new MemberUpdateForm());				// 회원정보수정 페이지
		map.put("/memberUpdate.do", new MemberUpdate());						// 회원정보수정 처리
		
		map.put("/noticeList.do", new NoticeList());							// 공지사항 목록 출력
		map.put("/noticeInsertForm.do", new NoticeInsertForm());				// 공지사항 등록 화면
		map.put("/noticeInsert.do", new NoticeInsert());						// 공지사항 등록 처리
		map.put("/noticeView.do", new NoticeView());							// 공지사항 상세 페이지
		map.put("/ajaxNoticeSearch.do", new AjaxNoticeSearch());				// 공지사항 검색기능
		map.put("/ajaxSortNotice.do", new AjaxSortNotice());					// 공지사항 오름/내림차순 재정렬
		map.put("/noticeUpdateForm.do", new NoticeUpdateForm());				// 공지사항 수정 화면
		map.put("/noticeUpdate.do", new NoticeUpdate());						// 공지사항 수정 처리
		map.put("/noticeDelete.do", new NoticeDelete());						// 공지사항 삭제 처리
		
		map.put("/commentInsert.do", new CommentInsert());                  	// 댓글 입력
		map.put("/commentSearch.do", new CommentSearch());                 	 	// 댓글 찾기
		map.put("/commentDelete.do", new CommentDelete());						// 댓글 삭제
		map.put("/commentUpdate.do", new CommentUpdate());						// 댓글 수정
		
		map.put("/qnaList.do", new QnaList());									// 고객센터 목록 출력
		map.put("/qnaView.do", new QnaView());									// 고객센터 상세 페이지
		map.put("/qnaInsertForm.do", new QnaInsertForm());						// 고객센터 작성 페이지
		map.put("/qnaInsert.do", new QnaInsert());								// 고객센터 작성 처리
		map.put("/qnaAnswerUpdate.do", new QnaAnswerUpdate());					// 고객센터 답변 등록
		
		map.put("/accountList.do", new AccountList());							// 계좌리스트 조회
		map.put("/accountInquiry.do", new AccountInquiry());					// 계좌
    
		map.put("/mapAtm.do", new MapAtm()); 									// 주변 은행 페이지
		
		map.put("/openBanking.do", new OpenBanking());
		map.put("/bankOauth.do", new BankOauthCommand());
		map.put("/callback.do", new CallbackCommand());
		map.put("/accountsList.do", new accountsList());
		map.put("/oneAccount.do", new OneAccount());
	}

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String uri = request.getRequestURI();
		String contextPath = request.getContextPath();
		String page = uri.substring(contextPath.length());

		Command comm = map.get(page);
		String viewPage = comm.exec(request, response);
		if (viewPage != null) {
		if (!viewPage.endsWith(".do")) {
			if (viewPage.startsWith("ajax:")) {
				// aJax 처리
				response.setContentType("text/html; charset=UTF-8");
				response.getWriter().append(viewPage.substring(5));

				return;
			} else {
				// viewPage = "WEB-INF/views/" + viewPage + ".jsp";
				viewPage = viewPage + ".tiles";
			}
		}

		RequestDispatcher dispatcher = request.getRequestDispatcher(viewPage);
		dispatcher.forward(request, response);
		}
	}
}
