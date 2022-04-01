<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<style>
#container {
	padding: 150px 0;
}

#btn {
	margin-top: 30px;
	text-align: center;
}

h1 {
	margin-bottom: 50px;
	font-size: 50px;
	text-align: center;
}

td {
	font-size: 20px;
	padding: 5px 10px 5px 60px;
}

#btn>button {
	width: 100px;
	height: 50px;
	text-size: 1.2em;
}

input {
	height: 40px;
	width: 300px;
}

#Nbtn {
	margin-top: 30px;
	text-align: center;
	display: none;
}

#page_header {
	margin-bottom: 100px;
}
</style>
<section id="page_header" class="single-page-header">
	<div class="container">
		<div class="row">
			<div class="col-md-12">
				<h2>비밀번호 찾기</h2>
				<nav aria-label="breadcrumb mx-auto" role="navigation">
					<ol class="breadcrumb">
						<li class="breadcrumb-item"><a href="home.do">Home</a></li>
						<li class="breadcrumb-item active" aria-current="page">비밀번호
							찾기</li>
					</ol>
				</nav>
			</div>
		</div>
	</div>
</section>
<div id="container">
	<form id="frm" action="memberUpdatePwForm.do" method="post">
		<table align="center">
			<tr>
				<td>이메일</td>
				<td><input type="email" id="femail" name="femail"
					required="required">
					<button type="button" id="checkId" value="No" onclick="isIdCheck()"
						style="height: 40px;">체크</button></td>

			</tr>
			<tr>
				<td>아이디</td>
				<td><input type="text" id="fid" name="fid" required="required"
					onchange="isIdSame()">&nbsp;&nbsp;<span id="idSame"></span></td>

			</tr>
			<tr>
				<td>이름</td>
				<td><input type="text" id="fname" name="fname"
					required="required" onchange="isNameSame()">&nbsp;&nbsp;<span
					id="nameSame"></span></td>

			</tr>

			<tr id=Nbtn>

				<td><input type="text" id="fnumber" name="fnumber"
					placeholder="인증번호"></td>
				<td><button type="button" onclick="mnumberCheck()">확인</button></td>
			</tr>
		</table>

		<div id="btn">
			<button type="submit">확인</button>
			&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			<button type="button" onclick="selectMemberPw()"
				style="width: 130px;">비밀번호 찾기</button>
			&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			<button type="button" onclick="history.back()">취소</button>

		</div>

		<script type="text/javascript">
			var mnumber;
			var resultNum;
			var idSameCk;
			var nameSameCk;
			function selectMemberPw() {
				var params = {
					"mEmail" : $("#femail").val(),
					"mName" : $("#fname").val(),
					"mid" : $("#fid").val()
				}

				if (($("#idSame").text() == "아이디 일치")
						&& ($("#nameSame").text() == "이름 일치")) {
					$
							.ajax({
								url : "memberFindPw.do",
								type : "post",
								data : params,
								dataType : "text",
								success : function(result) {
									resultNum = result.charAt(0);
									mnumber = result.substring(1);
									console.log(mnumber);
									if (resultNum == '1') {
										alert("이메일로 인증번호를 보냈습니다.");
										document.getElementById("Nbtn").style.display = "block";

									} else {
										alert("등록되지않은 이메일입니다.");

									}
									;
								}
							});
				} else {
					alert("가입한 이메일의 아이디와 성명을 확인해주세요.")
				}
			}
			function isIdCheck() {

				var str = document.getElementById('femail').value;
				if (str.search("@") != -1) {
					$.ajax({
						url : "ajaxMemberIdCheck.do",
						type : "post",
						data : {
							"str" : $("#femail").val()
						},
						dataType : "text",
						success : function(result) {
							resultSplit = result.split("|")

							if (resultSplit[0] == '1') {
								alert("이메일 조회 완료.");
								$("#checkId").attr("disabled", "disabled");

								mEmail = resultSplit[1];
								mName = resultSplit[2];
								mId = resultSplit[3];
							} else {
								alert("등록되지 않은 이메일");
								$("#femail").val('');
								$("#femail").focus();

							}
							;

						}
					});
				} else {
					alert("이메일 형식으로 입력해주세요.");
					$("#femail").focus();
				}
			}
			function mnumberCheck() {
				if (mnumber == fnumber.value) {
					alert("인증완료");
					frm.submit();
				}
			}
			function isIdSame() {
				if (mId == $("#fid").val()) {
					$("#idSame").text("아이디 일치")
					$("#idSame").css("color", "blue");

				} else {
					$("#idSame").text("아이디 불일치")
					$("#idSame").css("color", "red");

				}
			}
			function isNameSame() {
				if (mName == $("#fname").val()) {
					$("#nameSame").text("이름 일치")
					$("#nameSame").css("color", "blue");

				} else {
					$("#nameSame").text("이름 불일치")
					$("#nameSame").css("color", "red");

				}
			}
		</script>
	</form>
</div>