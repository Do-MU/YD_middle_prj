<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<script src="js/jquery.min.js"></script>
<style>
#container {
	padding: 100px 0 300px;
}
th{
	padding: 10px;
}
</style>

<div align="center" id="container">
	<c:if test="${message eq 'insert'}">
		<form id="frmi" action="noticeInsert.do" method="post">
			<div>
				<h1>공 지 사 항 등 록</h1>
				<table border="1">
					<tr>
						<th>제목</th>
						<td colspan="3"><input type="text" size="80" class="noticeTitle"
							name="noticeTitle" required="required"></td>
					</tr>
					<tr>
						<th>내용</th>
						<td colspan="3"><textarea rows="10" cols="80"
								name="noticeContents"></textarea></td>
					</tr>
				</table>
			</div>
			<br>
			<div>
				<button type="submit">글등록</button>
				&nbsp;&nbsp;&nbsp;
				<button type="button" onclick="history.back()">취소</button>
			</div>
		</form>
	</c:if>

	<c:if test="${message eq 'update'}">
		<form id="frmu" action="noticeUpdate.do" method="post">
			<div>
				<h1>공 지 사 항 수 정</h1>
				<table border="1">
					<tr>
						<th>제목</th>
						<td colspan="3"><input type="text" size="80" class="noticeTitle" name="noticeTitle" required="required" value="${n.noticeTitle }"></td>
					</tr>
					<tr>
						<th>내용</th>
						<td colspan="3"><textarea rows="10" cols="80" name="noticeContents">${n.noticeContents }</textarea></td>
					</tr>
				</table>
			</div>
			<input type="hidden" name="noticeId" value="${n.noticeId }">
			<br>
			<div>
				<button type="submit">글수정</button>
				&nbsp;&nbsp;&nbsp;
				<button type="button" onclick="history.back()">취소</button>
			</div>
		</form>
	</c:if>
</div>