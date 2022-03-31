package com.midprj.member.command;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.midprj.comm.Command;
import com.midprj.member.service.MemberService;
import com.midprj.member.service.MemberVO;
import com.midprj.member.serviceImpl.MemberServiceImpl;

public class MemberFindId implements Command {

	@Override
	public String exec(HttpServletRequest request, HttpServletResponse response) {

		String recipient = request.getParameter("mEmail");
		
		// 1. 발신자의 메일 계정과 비밀번호 설정
		final String user = "wlsdud0302a@naver.com";
		final String password = "qkrwlsdud";

		// 2. Property에 SMTP 서버 정보 설정
		Properties prop = new Properties();
		prop.put("mail.smtp.host", "smtp.naver.com");
		prop.put("mail.smtp.port", 465);
		prop.put("mail.smtp.auth", "true");
		prop.put("mail.smtp.ssl.enable", "true");
		prop.put("mail.smtp.ssl.trust", "smtp.naver.com");

		// id 찾기
		MemberService memberDao = new MemberServiceImpl();
		MemberVO vo = new MemberVO();
		vo.setMemberEmail(recipient);
		vo.setMemberName(request.getParameter("mName"));
		String result;
		vo = memberDao.selectMemberId(vo);
		if (vo == null) {
			result = "ajax:0";
			return result;
		}
		// 3. SMTP 서버정보와 사용자 정보를 기반으로 Session 클래스의 인스턴스 생성
		Session session = Session.getDefaultInstance(prop, new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(user, password);
			}
		});

		// 4. Message 클래스의 객체를 사용하여 수신자와 내용, 제목의 메시지를 작성한다.
		// 5. Transport 클래스를 사용하여 작성한 메세지를 전달한다.

		MimeMessage message = new MimeMessage(session);
		try {
			message.setFrom(new InternetAddress(user));

			// 수신자 메일 주소
			message.addRecipient(Message.RecipientType.TO, new InternetAddress(recipient));

			// Subject
			message.setSubject("PLAYDDIT verification code");

			// Text
			message.setText("your Id = [" + vo.getMemberId() + "]");

			Transport.send(message); // send message

		} catch (AddressException e) {
			e.printStackTrace();
		} catch (MessagingException e) {
			e.printStackTrace();
		}

		result = "ajax:1" + "|" +vo.getMemberEmail() + "|" +vo.getMemberName() + "|"; 
		return result;
	}
}
