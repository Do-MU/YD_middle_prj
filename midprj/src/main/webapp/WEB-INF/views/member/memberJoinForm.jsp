<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="js/jquery.min.js"></script>
<script
	src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
<style>
#Join{
	padding: 200px 0;
}
#Join> h1{
	margin-bottom: 50px;
}
#btns{
	margin-top: 50px;
}
th {
	width: 200px;
	padding-left: 80px;
	font-size: 1.2em;
}

td {
	padding-bottom: 10px;
	width: 430px;
}
input{
	height: 40px;
	width: 250px;
}
button{
	height: 40px;
}
</style>
</head>
<body>
	<form id="frm" name="frm" action="memberJoin.do" method="post">
		<div id="Join" align="center">
			<h1>회 원 가 입</h1>
			<div id="id_pass">
				<table>
					<tr>
						<th>ID</th>
						<td id="member_id"><input type="text" id="id" name="id"
							required="required" placeholder="아이디를 입력하세요.">
							<button type="button" id="checkId" value="No"
								onclick="isIdCheck()">중복체크</button></td>
					</tr>
					<tr>
						<th>비밀번호</th>
						<td id="member_password"><input type="password" id="password"
							name="password" onchange="isSame()" required="required"
							placeholder="비밀번호를 입력하세요."></td>
					</tr>
					<tr>
						<th></th>
						<td id="member_passwordCheck"><input type="password"
							id="password1" name="password1" onchange="isSame()"
							required="required" placeholder="비밀번호를 확인하세요.">&nbsp;&nbsp;<span
							id="pwSame"></span></td>
					</tr>

					<tr>
						<th>이름</th>
						<td id="member_name"><input type="text" id="name" name="name"
							required="required" placeholder="이름을 입력하세요."></td>
					</tr>

					<tr>
						<th>이메일</th>
						<td id="member_email"><input type="email" id="email"
							name="email" required="required" placeholder="이메일을 입력하세요."></td>
					</tr>
					<tr>
						<th>전화번호</th>
						<td id="member_tel"><input type="tel" id="tel" name="tel"
							required="required" placeholder="전화번호를 입력하세요."></td>
					</tr>

					<tr>
						<th>생년월일</th>
						<td id="member_birth"><input type="date" id="birth"
							name="birth" required="required">
						</td>
					</tr>

					<tr>
						<th>우편번호</th>
						<td id="member_address"><input type="text" name="zip"
							style="width: 80px;" />
							<button type="button" style="width: 60px;"
								onclick="openZipSearch()">검색</button></td>
					</tr>
					<tr>
						<th>주소</th>
						<td><input type="text" name="addr1"
							style="width: 300px;" readonly /></td>
					</tr>
					<tr>
						<th>상세주소</th>
						<td><input type="text" name="addr2"
							style="width: 300px;" /></td>
					</tr>

				</table>
			</div>

			<div id="btns">
				<button type="submit" value="회원가입">회원가입</button>&nbsp;&nbsp;&nbsp;&nbsp;
				<button type="button" onclick="history.back()">취소</button>
			</div>
		</div>
	</form>
	
	
	<script>
		function isIdCheck() {
			var str = document.getElementById('id').value;
			$.ajax({
				url : "ajaxMemberIdCheck.do",
				type : "post",
				data : {
					"str" : $("#id").val()
				},
				dataType : "text",
				success : function(result) {
					if (result == '1') {
						alert("사용가능한 아이디 입니다.");
						if (!confirm("아이디를 사용하시겠습니까?")) {
		
				        } else {
				    
							$("#checkId").attr("disabled", "disabled");
							$("#checkId").val('Yes');
							$("#password").focus();
				        }

					} else {
						alert("이미 사용중인 아이디 입니다.");
						$("#checkId").val('');
						$("#id").focus();
					}
					;
					
				}
			});
		}
		
		
		function formCheck() {
			if ($("#checkId").val() != 'Yes') {
				alert("아이디 중복체크를 해주세요..");
				return false;
			}

			if ($("#password").val() != $("#password1").val()) {
				alert("패스워드가 일치 하지 않습니다.");
				$("#password").val("");
				$("#password1").val("");
				$("#password").focus();
				return false;
			}

			return true;
		}
		
		function openZipSearch() {
			new daum.Postcode({
				oncomplete : function(data) {
					$('[name=zip]').val(data.zonecode); // 우편번호 (5자리)
					$('[name=addr1]').val(data.address);
					$('[name=addr2]').val(data.buildingName);
				}
			}).open();
		}
		
		function isSame() {
			 var passwordC = $("#password").val()
			 if (passwordC.length < 6 || passwordC.length > 16) {
		        window.alert('비밀번호는 6글자 이상, 16글자 이하만 이용 가능합니다.');
		        $("#password").val('');
		        $("#password1").val('');
		        $("#pwSame").text('');
		        $("#password").focus();	        
			 }
			 if (($("#password").val().length > 0) && ($("#password1").val().length > 0)){
				 if($("#password").val() == $("#password1").val()){
					 $("#pwSame").text('비밀번호가 일치합니다.');
					 $("#pwSame").css("color", "blue");
					 $("#checkId").val('Yes');
				 }else{
					 $("#pwSame").text('비밀번호가 불일치합니다.');
					 $("#pwSame").css("color", "red");
					 $("#checkId").val('No'); 
				 }
			 }
		}
	</script>

</body>
</html>