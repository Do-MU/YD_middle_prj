<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>


<style>
#container {
	padding-bottom: 100px;
}

#page_header {
	margin-bottom: 100px;
}

.col-md-12>h2 {
	font-weight: lighter;
}

#acc_info {
	width: 70%;
	height: 200px;
	background-color: lightgray;
	padding: auto;
}

#acc_info>h2 {
	padding-top: 30px;
}

#acc_info>h3 {
	padding: 50px 30px;
	text-align: right;
}

#acc_trans {
	font-size: 1.5em;
	margin-top: 50px;
}

td {
	padding: 10px;
	border-style: solid none;
	border-color: lightgray;
}
</style>

<div id="container" align="center">
	<section id="page_header" class="single-page-header">
		<div class="container">
			<div class="row">
				<div class="col-md-12">
					<h2>오 픈 뱅 킹</h2>
					<nav aria-label="breadcrumb mx-auto" role="navigation">
						<ol class="breadcrumb">
							<li class="breadcrumb-item"><a href="openBanking.do">오픈뱅킹</a></li>
							<li class="breadcrumb-item active" aria-current="page">계좌상세</li>
						</ol>
					</nav>
				</div>
			</div>
		</div>
	</section>
	<div>
		<div id="acc_info">
			<h2>${ac.bank_name }&nbsp;${ac.account_num_masked }&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;[${ac.product_name }]</h2>
			<h3>${ac.balance_amt }원</h3>
		</div>
	</div>
	<div>
		<table id="acc_trans">
			<c:if test="${not empty list }">
				<tr>
					<td align="center">거래시간</td>
					<td align="center">입금/출금</td>
					<td align="center">거래구분</td>
					<td align="center">통장인자내용</td>
					<td align="center">거래금액</td>
					<td align="center">거래후잔액</td>
					<td align="center">거래점명</td>
				</tr>
				<c:forEach items="${list }" var="l">
					<tr class="notices">
						<td align="center">${l.tran_date }</td>
						<td align="center">${l.inout_type }</td>
						<td align="center">${l.tran_type }</td>
						<td align="center">${l.print_content }</td>
						<c:choose>
							<c:when test="${l.inout_type eq '입금' }">
								<td align="center" style="color: blue"><fmt:formatNumber
										value="${l.tran_amt}" type="number" var="currencyType" />
									${currencyType }</td>
							</c:when>
							<c:when test="${l.inout_type eq '출금' }">
								<td align="center" style="color: red"><fmt:formatNumber
										value="${l.tran_amt}" type="number" var="currencyType" />
									${currencyType }</td>
							</c:when>
						</c:choose>
						<td align="center"><fmt:formatNumber
								value="${l.after_balance_amt }" type="number" var="balance" />
							${balance }</td>
						<td align="center">${l.branch_name }</td>
					</tr>
				</c:forEach>
			</c:if>
		</table>
	</div>
</div>