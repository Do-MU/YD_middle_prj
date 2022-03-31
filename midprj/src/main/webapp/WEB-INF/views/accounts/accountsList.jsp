<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>

<script src="//code.jquery.com/jquery-1.11.1.min.js"></script>

<style>
#container {
	padding: 200px 0;
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

#fun{
	display:none;
}
</style>

<div align="center" id="container">
	<div>
		<h1>등 록 계 좌</h1>
	</div>
	<div>
		<form id="frm" method="post">
			<div>
				<table id="contents">
					<thead>
						<tr>
							<th id="fun">은행대표코드</th>
							<th>은행대표코드</th>
							<th>은행명</th>
							<th>계좌번호(보안)</th>
							<th>예금주</th>
							<th>계좌상태</th>
						</tr>
					</thead>

					<tbody id="noticeBody">
						<c:if test="${empty list }">
							<tr>
								<td colspan="7">실패</td>
							</tr>
						</c:if>
						<c:if test="${not empty list }">
							<c:forEach items="${list }" var="l">
								<tr onclick="accountContents('${l.fintech_use_num}','${l.account_holder_name}')" class="accounts">
									<td align="center" id="fun">${l.fintech_use_num }</td>
									<td align="center">${l.bank_code_std }</td>
									<td align="center">${l.bank_name }</td>
									<td align="center">${l.account_num_masked }</td>
									<td align="center">${l.account_holder_name }</td>
									<td align="center">${l.account_state }</td>
								</tr>
							</c:forEach>
						</c:if>
					</tbody>
				</table>
			</div>
			<input type="hidden" id="finNum" name="finNum">
			<input type="hidden" id="holderName" name="holderName">
		</form>
	</div>

</div>
<script>
function accountContents(n, m){
	frm.finNum.value = n;
	frm.holderName.value = m;
	frm.action = "oneAccount.do";
	frm.submit();
}
</script>