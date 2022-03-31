package com.midprj.member.command;

import java.util.Properties;
import java.util.Random;

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

public class MemberFindPw implements Command {

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
		vo.setMemberId(request.getParameter("mId"));
		String result;
		vo = memberDao.selectMemberId(vo);
		if (vo == null) {
			result = "ajax:0";
			return result;
		}

		// 난수생성
		String mnumber = numberGen(6, 1);
		int min = 000001;
		int max = 999999;
		/*
		 * random.setSeed(System.currentTimeMillis()); int mnumber =
		 * random.nextInt(999999) ;
		 
		int mnumber = (int) (Math.random() * (max - min)) + min;
		 */
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
			message.setText("your Id = [" + mnumber + "]");

			Transport.send(message); // send message

		} catch (AddressException e) {
			e.printStackTrace();
		} catch (MessagingException e) {
			e.printStackTrace();
		}

		result = "ajax:1" + mnumber;
		return result;
	}

	public static String numberGen(int len, int dupCd) {

		Random rand = new Random();
		String numStr = ""; // 난수가 저장될 변수

		for (int i = 0; i < len; i++) {

			// 0~9 까지 난수 생성
			String ran = Integer.toString(rand.nextInt(10));

			if (dupCd == 1) {
				// 중복 허용시 numStr에 append
				numStr += ran;
			} else if (dupCd == 2) {
				// 중복을 허용하지 않을시 중복된 값이 있는지 검사한다
				if (!numStr.contains(ran)) {
					// 중복된 값이 없으면 numStr에 append
					numStr += ran;
				} else {
					// 생성된 난수가 중복되면 루틴을 다시 실행한다
					i -= 1;
				}
			}
		}
		return numStr;
	}
}
