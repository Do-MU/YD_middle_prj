<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<style>
form {
	padding: 200px;
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

input {
	height: 30px;
}
</style>

<form id="frm" action="memberLoginForm.do" method="post">
	<div>

		<h1>아이디 찾기</h1>
	</div>
	<table align="center">

		<tr>
			<td>이메일</td>
			<td><input type="email" id="femail" name="femail"
				required="required">
				<button type="button" id="checkId" value="No" onclick="isIdCheck()">체크</button>
			</td>

		</tr>
		<tr>
			<td>이름</td>
			<td><input type="text" id="fname" name="fname"
				required="required" onchange="isNameSame()">&nbsp;&nbsp;<span
				id="nameSame"></span></td>
		</tr>
	</table>
	<div id="btn">
		<button type="button" onclick="selectMemberId()">아이디찾기</button>
		&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		<button type="button" onclick="history.back()">취소</button>

	</div>
</form>
<script type="text/javascript">
	var mName;
	var mEmail;
	function selectMemberId() {

		var params = {
			"mEmail" : $("#femail").val(),
			"mName" : $("#fname").val()
		}
		if ($("#checkId").val() == 'Yes') {

			$.ajax({
				url : "memberFindId.do",
				type : "post",
				data : params,
				dataType : "text",
				success : function(result) {

					resultSplit = result.split("|")

					if (resultSplit[0] == '1') {
						alert("이메일로 ID를 보냈습니다.");
						frm.submit();

					} else {
						alert("등록되지않은 이메일입니다.");

					}
					;
				}
			});
		} else {
			alert("가입한 이메일의 성명을 적어주세요.")
			$("#femail").focus();
		}
	}

	function isIdCheck() {

		var str = $("#femail").val();
		if(str.search("@") != -1){
		$.ajax({
			url : "ajaxMemberIdCheck.do",
			type : "post",
			data : {"str" : str},
			dataType : "text",
			success : function(result) {
				resultSplit = result.split("|")

				if (resultSplit[0] == '1') {
					alert("이메일 조회 완료.");
					$("#checkId").attr("disabled", "disabled");
					
					
					mEmail = resultSplit[1];
					mName = resultSplit[2];

				} else {
					alert("등록되지 않은 이메일");
					$("#femail").val('');
					$("#femail").focus();
				}
				;

			}
		});
	
		}
		else{
			alert("이메일 형식으로 입력해주세요.");
			$("#femail").focus();
		}
	}
	function isNameSame() {
		if (mName == $("#fname").val()) {
			$("#nameSame").text("이름 일치")
			$("#nameSame").css("color", "blue");
			$("#checkId").val('Yes');
		} else {    
			$("#nameSame").text("이름 불일치")
			$("#nameSame").css("color", "red");
			$("#checkId").val('No');
		}
	}
</script>