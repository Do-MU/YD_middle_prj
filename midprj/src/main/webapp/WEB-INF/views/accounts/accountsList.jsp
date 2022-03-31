<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>

<script src="//code.jquery.com/jquery-1.11.1.min.js"></script>

<style>
#container {
	padding-bottom: 200px;
}
table {
	margin-top: 50px;
	width: 60%;
	font-size: 1.3em;
}
span:hover {
	cursor: pointer;
	color: red;
}
th {
	text-align: center;
	border-style: none none solid none;
}
.accounts:hover{
	cursor: pointer;
	background-color: #ffff99;
}
#insert_btn{
	width: 100px;
	height: 50px;
	margin-top: 50px;
	font-size: 1.2em;
}
  
.acnt{
	width:70%;
	height: 200px;
	margin-bottom: 30px;
	border-radius: 10px;
	background-color: blue;
}
.acnt:nth-child(2n){
	background-color: skyblue;
}
.acnt >h2{
	color: white;
	padding: 50px 0 0 30px;
	text-align: left;
}
.acnt >h3{
	color: white;
	padding: 50px 30px 0 0;
	text-align: right;
}
	#page_header{
	margin-bottom: 100px;
}
.col-md-12> h2{
	font-weight: lighter;
}
</style>

<div align="center" id="container">
	<section id="page_header" class="single-page-header">
		<div class="container">
			<div class="row">
				<div class="col-md-12">
					<h2>등 록 계 좌</h2>
					<nav aria-label="breadcrumb mx-auto" role="navigation">
						<ol class="breadcrumb">
							<li class="breadcrumb-item"><a href="home.do">오픈뱅킹</a></li>
							<li class="breadcrumb-item active" aria-current="page">계좌목록</li>
						</ol>
					</nav>
				</div>
			</div>
		</div>
	</section>

	<div>
		<c:if test="${not empty list }">
			<c:forEach items="${list }" var="l">
				<div id="account_${l.fintech_use_num}" class="acnt" onclick="location.href='accountContents.do?fin_num=${l.fintech_use_num}")>
					<h2>${l.bank_name }&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;${l.account_num_masked }</h2>
					<h3>${l.account_holder_name }</h3>
				</div>
			</c:forEach>
		</c:if>
	</div>
</div>
<script>
</script>