<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
	if (!'${loginId}') {
		alert('로그인이 필요합니다.');
		window.location = "memberLoginForm.do";
	}
	
	if('${access_token}' != ''){
		window.location = "accountsList.do";
	}
</script>
<style>
#container {
	margin: 100px auto;
}
.btn{
	padding: 10px;
	margin: 50px;
}
h3{
	text-align: center;
}
</style>
</head>
<body>
	<div id="container" align="center">
		<c:if test="${empty access_token}">
			<div>
				<div>
					<h3>등록된 계좌가 없습니다...<br>계좌등록을 위해 아래 버튼을 눌러 인증해주시기 바랍니다.</h3>
				</div>
				<button type="button" class="btn btn-primary" onclick="location.href ='bankOauth.do'">인증하기</button>
			</div>
		</c:if>
	</div>
</body>
</html>