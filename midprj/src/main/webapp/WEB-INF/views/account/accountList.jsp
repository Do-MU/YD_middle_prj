<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<style>
#container{
	padding: 200px 0;
}
th{
	text-align: center;
}
.b09_electric {
    color: #000000;
    background-color: #ffffff;
    border:  #000000 solid 1px;
    padding : 3px;
    transition: all 0.1s ease;
    -webkit-transition: all 0.1s ease;
    -moz-transition: all 0.1s ease;
}

.b09_electric:hover {
    color: #ffffff;
    background-color: #000000;
    animation: b09_electric_blinkIn 0.1s step-end 0 2;
    -webkit-animation: b09_electric_blinkIn 0.1s step-end 0 2;
    -moz-animation: b09_electric_blinkIn 0.1s step-end 0 2;
    transition:  ease;
    -webkit-transition:  ease;
    -moz-transition:  ease ;
}

@-webkit-keyframes b09_electric_blinkIn {
    from,
    to {
        background-color: #f8f8f8;
        color: #080808;
    }
    50% {
        background-color: #ffffff;
        color: #000000;
    }
}

@-moz-keyframes b09_electric_blinkIn {
    from,
    to {
        background-color: #f8f8f8;
        color: #080808;
    }
    50% {
        background-color: #ffffff;
        color: #000000;
    }
}


</style>
<div align = "center" id = "container">
<c:if test = "${empty account }">
	<script type="text/javascript">
		alert("조회할 계좌가 없습니다.")
		location.href="home.do";
	</script>
	
</c:if>
<c:if test="${not empty account }">
<h1 align ="center"> ${account[0].member.memberName }님 환영합니다. </h1>
	<table border=1>
		<tr>
			<th width = "25%">상품명</th>
			<th width = "25%">계좌번호</th>
			<th width = "25%">현재잔액</th>
			<th width = "25%">비고</th>
		</tr>
		<c:forEach items="${account }" var="a">
		<tr>
			 <td align="center">${a.account.finproId }</td>	
			<td align="center">${a.account.accId }</td>	
			<td align="center">${a.account.accBalance }</td>	 
			<td align="center">
					<div class="back">
					    <div class="button_base b09_electric" id="button_base b09_electric"
					    onclick="remit(${a})"> 송금</div>
					</div>
			</td>	
		</tr>
		</c:forEach>
	</table>
	</c:if>
</div>


<script>
	function remit(info){
		frm.value = info;
		frm.action = "accountInquiry.do";
		frm.submit();
	}
	
</script>