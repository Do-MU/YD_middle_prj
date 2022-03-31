<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<style>
#container {
	padding: 0 0 100px;
	text-align: center;
}

#contents_tbl {
	margin: auto auto 100px;
	width: 60%;
}

#answer_tbl {
	margin: 0 auto;
	width: 60%;
}

th {
	height: 50px;
	text-align: center;
}

.titles {
	background-color: lightgray;
}

td {
	padding: 0 15px;
	text-align: left;
}

#content_td {
	height: 300px;
}

textarea {
	resize: none;
	width: 60%;
}

.btns {
	margin: 50px auto;
	height: 50px;
	width: 100px;
}

#page_header {
	margin-bottom: 100px;
}
</style>

<div id="container">
	<section id="page_header" class="single-page-header">
		<div class="container">
			<div class="row">
				<div class="col-md-12">
					<h2>QnA</h2>
					<nav aria-label="breadcrumb mx-auto" role="navigation">
						<ol class="breadcrumb">
							<li class="breadcrumb-item"><a href="qnaList.do">QnA</a></li>
							<li class="breadcrumb-item active" aria-current="page">상세보기</li>
						</ol>
					</nav>
				</div>
			</div>
		</div>
	</section>

	<table border="1" id="contents_tbl">
		<tr>
			<th width="10%" class="titles">작성자</th>
			<td width="40%">${q.memberId }</td>
			<th width="10%" class="titles">작성일자</th>
			<td width="15%">${q.qnaDate }</td>
			<th width="10%" class="titles">답변완료</th>
			<td width="15%"><c:if test="${q.qnaIsAnswered eq 0}">미완료</c:if>
				<c:if test="${q.qnaIsAnswered eq 1}">완료</c:if></td>
		</tr>
		<tr>
			<th class="titles">제목</th>
			<td colspan="5">${q.qnaTitle }</td>
		</tr>
		<tr>
			<th class="titles">내용</th>
			<td colspan="5" id="content_td" style="white-space: pre;">${q.qnaContents }</td>
		</tr>
	</table>

	<c:if test="${q.qnaIsAnswered eq 1}">
		<table id="answer_tbl">
			<tr>
				<th width="10%">답변일시</th>
				<td>${q.qnaAnswerDate }</td>
			</tr>
			<tr>
				<th>답변내용</th>
				<td id="answer_td" style="white-space: pre;">${q.qnaAnswerContents }</td>
			</tr>
		</table>
		<button class="btns" onclick="history.back()">돌아가기</button>
	</c:if>
	<c:if test="${authority eq 'admin'}">
		<c:if test="${q.qnaIsAnswered eq 0}">
			<form name="frm" action="qnaAnswerUpdate.do?qnaId=${q.qnaId }"
				method="post">
				<input type="hidden" name="qnaId" value="${q.qnaId }">
				<textarea name="answer" id="answer" rows="10" cols="120"></textarea>
				<br>
				<div>
					<input class="btns" type="submit" value="답변">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					<input class="btns" type="button" onclick="history.back()"
						value="돌아가기">
				</div>
			</form>
		</c:if>
	</c:if>
</div>