<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<script src="js/jquery.min.js"></script>
<style>
#container {
	padding: 0 0 100px;
}

#page_header {
	margin-bottom: 100px;
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

#noticeBody>tr>td {
	padding-top: 10px;
}

th {
	text-align: center;
	border-style: none none solid none;
}

.notices:hover {
	cursor: pointer;
	background-color: #ffff99;
}

#insert_btn {
	width: 100px;
	height: 50px;
	margin-top: 50px;
	font-size: 1.2em;
}

.pagelist {
	text-align: center;
}

.pagelist li {
	display: inline-block;
	list-style: none;
	padding: 10px;
}

#page_list {
	margin-top: 50px;
}

#page_list>ul>li>a {
	color: black;
}

#selectC {
	display: inline-block;
}
</style>


<div align="center" id="container">
	<section id="page_header" class="single-page-header">
		<div class="container">
			<div class="row">
				<div class="col-md-12">
					<h2>거 래 내 역</h2>
				</div>
			</div>
		</div>
	</section>

	<div>
		<table id="contents">
			<c:if test="${not empty list }">
				<c:forEach items="${list }" var="l">
					<tr class="notices">
						<td align="center">${l.tran_date }</td>
						<td align="center">${l.inout_type }</td>
						<td align="center">${l.tran_type }</td>
						<td align="center">${l.print_content }</td>
						<td align="center">${l.tran_amt }</td>
						<td align="center">${l.after_balance_amt }</td>
						<td align="center">${l.branch_name }</td>
					</tr>
				</c:forEach>
			</c:if>
		</table>
	</div>
</div>
