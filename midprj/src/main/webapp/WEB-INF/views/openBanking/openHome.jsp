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
</script>
</head>
<body>
	<c:if test="${empty access_token}">
		<div>
			<button type="button" onclick="location.href ='bankOauth.do'">사용자
				인증 및 토큰 발급</button>

		</div>
	</c:if>

	<c:if test="${not empty access_token}">
		<div>
			<h1>사용자님의 access_token은 ${access_token }입니다.</h1>
			<h3>${message }</h3>
			<button type="button" onclick="location.href ='accountsList.do'">등록계좌조회</button>
		</div>
	</c:if>
</body>
</html>