<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
select {
	width: 150px; /* 원하는 너비설정 */
	height: 60px;
	margin: 10px; padding : .8em .5em; /* 여백으로 높이 설정 */
	font-family: inherit; /* 폰트 상속 */
	background:
		url(https://farm1.staticflickr.com/379/19928272501_4ef877c265_t.jpg)
		no-repeat 95% 50%; /* 네이티브 화살표 대체 */
	border: 1px solid #999;
	border-radius: 0px; /* iOS 둥근모서리 제거 */
	-webkit-appearance: none; /* 네이티브 외형 감추기 */
	-moz-appearance: none;
	appearance: none;
	padding: .8em .5em;
}

input {
	width: 100px;
	height: 50px;
	border-top: none;
	border-left: none;
	border-right: none;
	border-bottom: 3px solid black;
}

#pre1, #pre2 {
	border-top: none;
	border-left: none;
	border-right: none;
	border-bottom: none;
}

table.eTable {
	border-collapse: separate;
	border-spacing: 1px;
	text-align: center;
	line-height: 1.5;
	margin: 20px 10px;
}

table.eTable th {
	width: 155px;
	padding: 10px;
	font-weight: bold;
	vertical-align: top;
	color: #fff;
	background: #ce4869;
}

table.eTable td {
	width: 155px;
	padding: 10px;
	vertical-align: top;
	border-bottom: 1px solid #ccc;
	background: #eee;
}
</style>

</head>
<body>
	<div align="center">
		<span> <select id="nationOne" onchange="f1()">
				<option value="" selected disabled>언어 선택</option>

				<c:forEach var="item" items="${eList}">
					<option value="${item.exchangeRate}" id="${item.currency }">${item.nation }</option>

				</c:forEach>

		</select> <input type="text" id="money1" name="money1"
			onchange="money1Select()"> <input type="text" id="pre1"
			readonly></input>
		</span> 
		<span> <select id="nationTwo" onchange="f2()">
				<c:forEach var="item" items="${eList}">
					<option value="${item.exchangeRate}" id="${item.currency }">${item.nation }</option>
				</c:forEach>
		</select> <input type="text" id="money2" name="money2"
			onchange="money2Select()"> <input type="text" id="pre2"
			readonly></input>
		</span>

		<div></div>
		<table class="eTable">
			<thead>
				<tr>
					<th scope="cols">국가</th>
					<th scope="cols">환율</th>
					<th scope="cols">통화</th>
				</tr>
			</thead>
			<tbody>

				<c:forEach var="item" items="${eList}">
					<tr>
						<td>${item.nation }</td>
						<td>${item.exchangeRate }</td>
						<td>${item.currency }</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
</body>

<script type="text/javascript">
	function money1Select() {
		if (nationTwo.options[nationTwo.selectedIndex].text == '일본' || nationTwo.options[nationTwo.selectedIndex].text == '인도네시아') {
			
			var sum1 = money1.value / (nationTwo.value/100) * nationOne.value;
			money2.value = sum1.toFixed(2);
		} else {
			var sum1 = money1.value / nationTwo.value * nationOne.value;
			console.log(sum1);
			money2.value = sum1.toFixed(2);
		}
		

	}
	function money2Select() {
if (nationOne.options[nationOne.selectedIndex].text == '일본' || nationOne.options[nationOne.selectedIndex].text == '인도네시아') {
			
			var sum2 = money2.value / (nationOne.value/100) * nationTwo.value;
			money1.value = sum2.toFixed(2);
		} else {
		var sum2 = money2.value / nationOne.value * nationTwo.value;
		money1.value = sum2.toFixed(2);
		}
	
	}

	
	function f1(){
		const selectVal = nationOne.value;
		const optionId = document.querySelector('option[value="'+selectVal+'"]').id;
		pre1.value = optionId;
	}
	function f2(){
		const selectVal = nationTwo.value;
		const optionId = document.querySelector('#nationTwo option[value="'+selectVal+'"]').id;
		pre2.value = optionId;
		
	}
</script>
</html>