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
#page_header{
	margin-bottom: 100px;
}
.col-md-12> h2{
	font-weight: lighter;
}
.acnt{
	width:70%;
	height: 200px;
	margin-bottom: 30px;
	border-radius: 10px;
	background-color: blue;
}
.acnt:hover{
	cursor:pointer;
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
	padding: 10px 30px 0 0;
	text-align: right;
}
</style>

<div align="center" id="container">
	<section id="page_header" class="single-page-header">
		<div class="container">
			<div class="row">
				<div class="col-md-12">
					<h2>오 픈 뱅 킹</h2>
					<nav aria-label="breadcrumb mx-auto" role="navigation">
						<ol class="breadcrumb">
							<li class="breadcrumb-item"><a href="openBanking.do">오픈뱅킹</a></li>
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
				<div id="account_${l.fintech_use_num}" class="acnt" onclick="location.href='accountsView.do?fin_num=${l.fintech_use_num}'">
					<h2>${l.bank_name }&nbsp; [${l.product_name}]&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<br>${l.account_num_masked }</h2>
					<h3>예금주 : ${l.account_holder_name }&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;${l.balance_amt}원</h3>
				</div>
			</c:forEach>
		</c:if>
	</div>
</div>
<script>
	
</script>