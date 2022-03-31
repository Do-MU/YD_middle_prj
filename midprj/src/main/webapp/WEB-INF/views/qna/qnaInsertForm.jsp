<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<style>
#container {
	padding-bottom: 100px;
	text-align: center;
}

#contents_tbl {
	margin: auto auto 100px;
	width: 60%;
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

#page_header {
	margin-bottom: 100px;
}

#qnaTitle:focus, textarea:focus{
	outline: none;
}
</style>

<body>
<div id="container">
	<section id="page_header" class="single-page-header">
		<div class="container">
			<div class="row">
				<div class="col-md-12">
					<h2>QnA</h2>
					<nav aria-label="breadcrumb mx-auto" role="navigation">
						<ol class="breadcrumb">
							<li class="breadcrumb-item"><a href="qnaList.do">QnA</a></li>
							<li class="breadcrumb-item active" aria-current="page">등록하기</li>
						</ol>
					</nav>
				</div>
			</div>
		</div>
	</section>
	<form id="frm" action="qnaInsert.do" method="post">
		<input type = "hidden" value = "${memberId }" name = "memberId">
		<table border="1" id="contents_tbl">
			<tr>
				<th width="10%" class="titles" height="50px">작성자</th>
				<td width="40%">${memberId }</td>
				<th width="10%" class="titles">작성일자</th>
				<td width="15%">${Date }</td>
				<th width="10%" class="titles">답변완료</th>
				<td width="15%">미완료</td>
			</tr>
			<tr>
				<th class="titles" height="50px">제목</th>
				<td colspan="5">
				<input type="text" id="qnaTitle" name="qnaTitle" required="required" 
				 style = " border:none; width : 100%;" placeholder ="제목을 입력하세요 "></td>
			</tr>
			<tr>
				<th class="titles">내용</th>
				<td colspan="5" id="content_td">
				<textarea style = " border:none; height : 90%;  width : 100%;"
				 name="qnaContents" placeholder ="내용을 입력하세요 "></textarea></td>
			
			</tr>
		</table>
		<br>
		<div>
			<button type="submit">글등록</button>
			&nbsp;&nbsp;&nbsp;
			<button type="button" onclick="history.back()">뒤로가기</button>
		</div>
	</form>
</div>
