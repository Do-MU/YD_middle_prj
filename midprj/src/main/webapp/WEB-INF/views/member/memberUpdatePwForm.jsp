<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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

<script>
	function formCheck(){
		if(frm.password.value != frm.password1.value){
			alert("패스워드가 일치하지 않습니다.");
			frm.password.value="";
			frm.password1.value="";
			frm.password.focus();
			return false;
		}
		return true;
	}
</script>

<form id="frm" action="memberLoginForm.do"
	onsubmit="return formCheck();" method="post">
	<div>
		<h1>비밀번호 변경</h1>
	</div>
	<h1>${fid }</h1>
	<table align="center">

		<tr>
			<td>비밀번호</td>
			<td><input type="password" id="password" name="password"
				required="required" onchange="isSame()"></td>
		</tr>
		<tr>
			<td>비밀번호 확인</td>
			<td><input type="password" id="password1" name="password1"
				required="required" onchange="isSame()">&nbsp;&nbsp;<span
				id="pwSame"></span></td>
		</tr>

	</table>
	<div id="btn">
		<button type="button" onclick="isPwUpdate()">비밀번호 변경</button>
		&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		<button type="button" id="checkPw" value="No" onclick="history.back()">취소</button>
	</div>

	<script type="text/javascript">
    var passwordC; 
	function isSame() {
    		passwordC = $("#password").val();
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
				 $("#checkPw").val('Yes');
			 }else{
				 $("#pwSame").text('비밀번호가 불일치합니다.');
				 $("#pwSame").css("color", "red");
				 $("#checkPw").val('No'); 
			 }
		 }
	}
	function isPwUpdate() {
		var str = passwordC
		var params = {
				"mId" : "${fid }",
				"mPassword" : str
		}
		if($("#checkPw").val() == 'Yes'){
			$.ajax({
				url : "ajaxMemberPwUpdate.do",
				type : "post",
				data : params,
				dataType : "text",
				success : function(result){
					resultSplit = result.split("|")
					
					if(resultSplit[0] == '1'){
						alert("비밀번호가 변경되었습니다.");
						frm.submit();
					}
				}
			})
		}else{
			alert("패스워드가 일치하는지 확인하세요.")
		}
	}
	
    </script>
</form>