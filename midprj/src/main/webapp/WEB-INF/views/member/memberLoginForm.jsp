<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<style>

#login {
	margin: 10px 0 10px 0;
	padding: 300px 0;
	text-align: center;
}

#login h1 {
	font-size: 50px;
	font-family: "Arial";
	text-align: center;
}

#id_pass, #login_btn {
	display: inline-block;
	vertical-align: top;
}

#id_pass input {
	height: 50px;
	width: 350px;
}

#id {
	margin-top: 50px;
}

#password {
	margin-top: 10px;
}

#login button {
	margin-top: 50px;
	margin-left: 5px;
	padding: 12px;
	border-radius: 5px;
}

ul {
	list-style-type: none;
}

#btns {
	margin: 40px 0 0 0;
}

#btns li {
	margin-right: 20px;
	display: inline;
	font-size: 20px;
	text-align: center;
}

a {
	color: black;
	text-decoration-line: none;
}

a:hover {
	color: red;
}
</style>

<script type="text/javascript">
	if ('${message}' != '') {
		alert('${message}');
		window.location="memberLoginForm.do";
	}

	function formCheck() {
		if (frm.id.value == "") {
			alert("아이디를 입력하세요.");
			frm.memberId.focus();
			return false;
		}

		if (frm.password.value == "") {
			alert("패스워드를 입력하세요.");
			frm.memberPassword.focus();
			return false;
		}
		frm.submit();
	}
</script>

<form id="frm" name="frm" action="memberLogin.do" method="post">
	<div id="login">
		<h1>로 그 인</h1>
		<div id="id_pass">
			<div>
				<input type="text" id="id" name="id" placeholder="아이디를 입력하세요.">
			</div>
			<div>
				<input type="password" id="password" name="password"
					placeholder="비밀번호를 입력하세요.">
			</div>
		</div>

		<div id="login_btn">
			<button style="height: 110px;" onclick="formCheck()">로그인</button>
		</div>

		<ul id="btns">
			<li><a href='memberFindIdForm.do'>아이디 찾기</a></li>
			<li><a href='memberFindPwForm.do'>비밀번호 찾기</a></li>
			<li><a href='memberJoinForm.do'>회원 가입</a></li>
		</ul>
	</div>
</form>