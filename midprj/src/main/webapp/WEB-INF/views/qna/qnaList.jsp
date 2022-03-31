<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<style>
#container>table {
	margin: 50px auto;
}

#container>table>thead>tr>td {
	border-style: none none solid none;
	padding-bottom: 20px;
}

#container>table>tbody>tr>td {
	padding: 15px 0;
}

.title {
	font-size: 3rem;
	font-weight: bold;
}

.conn {
	width: 15%;
	font-size: 1.2rem;
	font-weight: bold;
	text-align: center;
}

.cont {
	width: 55%;
	font-size: 1.2rem;
	font-weight: bold;
}

.conw {
	width: 10%;
	font-size: 1.2rem;
	font-weight: bold;
	text-align: center;
}

.cond {
	width: 150px;
	font-size: 1.2rem;
	font-weight: bold;
	text-align: center;
}

.cons {
	width: 100px;
	font-size: 1.2rem;
	font-weight: bold;
	text-align: center;
}

.pagelist {
	text-align: center;
}

.pagelist li {
	display: inline-block;
	list-style: none;
	padding: 10px;
}

.btn {
	width: 150px;
	display: block;
	margin: auto;
}

.titles:hover {
	cursor: pointer;
	text-decoration: underline;
}

#page_list {
	margin-top: 50px;
}

#page_list>ul>li>a {
	color: black;
}

thead {
	text-align: center;
}

#qna_ist_btn {
	width: 140px;
	height: 70px;
	font-size: 1.2em;
	margin: 30px auto;
}

#selectC {
	margin-left: 70px;
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
							<li class="breadcrumb-item"><a href="home.do">Home</a></li>
							<li class="breadcrumb-item active" aria-current="page">QnA</li>
						</ol>
					</nav>
				</div>
			</div>
		</div>
	</section>
	<div id="selectC">
		<select onchange="change(this)">
			<option value="10" ${pageVO.amount eq 10 ? 'selected' : '' }>10개씩
				보기</option>
			<option value="20" ${pageVO.amount eq 20 ? 'selected' : '' }>20개씩
				보기</option>
			<option value="50" ${pageVO.amount eq 50 ? 'selected' : '' }>50개씩
				보기</option>
			<option value="100" ${pageVO.amount eq 100 ? 'selected' : '' }>100개씩
				보기</option>
		</select>
	</div>
	
	<table align="center" class="table table-bordered">
		<thead>
			<tr>
				<td class="conn">번호</td>
				<td class="cont">제목</td>
				<td class="conw">작성자</td>
				<td class="cond">작성일자</td>
				<td class="cons">상태</td>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="vo" items="${list }">
				<tr class="titles">
					<td class="conn">${vo.qnaId }</td>
					<td class="cont" onclick="qnaContents('${vo.qnaId }')">${vo.qnaTitle }</td>
					<td class="conw">${vo.memberId }</td>
					<td class="cond">${vo.qnaDate }</td>
					<td class="cons"><c:if test="${vo.qnaIsAnswered eq 0}">미완료</c:if>
						<c:if test="${vo.qnaIsAnswered eq 1}">답변완료</c:if></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	<c:if test="${loginId ne 'admin' }">
		<div id="qna_ist_btn">
			<button type="button" onclick="location.href='qnaInsertForm.do'"
				id="btnsubmit" class="btn btn-dark">문의하기</button>
		</div>
	</c:if>
	<div id="page_list">
		<ul class="pagelist">
			<li class="first_page"><a
				href="qnaList.do??pageNum=${pageVO.startPage}&amount=${pageVO.amount}"><<</a></li>

			<c:if test="${pageVO.prev }">
				<li><a
					href="qnaList.do??pageNum=${num - 1 }&amount=${pageVO.amount}"><</a></li>
			</c:if>

			<c:forEach var="num" begin="${pageVO.startPage }"
				end="${pageVO.endPage }">
				<li class="${pageVO.pageNum eq num ? 'active' : '' }"><a
					href="qnaList.do?pageNum=${num }&amount=${pageVO.amount}">${num }</a></li>
			</c:forEach>
			<c:if test="${pageVO.next }">
				<li><a
					href="qnaList.do?pageNum=${num+1 }&amount=${pageVO.amount}">></a></li>
			</c:if>
			<li class="last_page"><a
				href="qnaList.do??pageNum=${pageVO.endPage}&amount=${pageVO.amount}">>></a></li>
		</ul>
	</div>
</div>
<script>
	if(${loginId == null}) {
	    alert("문의사항을 이용하시려면 로그인하셔야 합니다.");
	    location.href="memberLoginForm.do";
	}
	if('${message}' != ''){
		window.alert('${message}');
		window.location = 'qnaList.do';
	}
	function qnaContents(q){
		var url =  "qnaView.do?qna_id=" + q;
		window.location.href = url;
	}
	function change(a){
		//console.log(a);
		//console.log(a.value);
		location.href="qnaList.do?pageNum=1&amount=" + a.value;
	}
</script>