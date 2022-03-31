<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div>
		<select id="nationOne" >
			<option value="" selected disabled>언어 선택</option>

			<c:forEach var="item" items="${eList}">
				<option value="${item.exchangeRate}">${item.nation }</option>

			</c:forEach>

		</select> <input type="text" id="money1" name="money1"
			onchange="money1Select()">
	</div>
	<div>
		<select id="nationTwo" >
			<c:forEach var="item" items="${eList}">
				<option value="${item.exchangeRate}">${item.nation }</option>
			</c:forEach>
		</select> <input type="text" id="money2" name="money2"
			onchange="money2Select()">
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

	// 다른나라돈 1원 = 한국 * 다른나라 value
</script>
</html>