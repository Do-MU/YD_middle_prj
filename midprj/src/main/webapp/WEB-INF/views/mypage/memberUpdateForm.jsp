<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<script src="js/jquery.min.js"></script>
<script
	src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
<style>
#container {
	padding-bottom: 150px;
}

h1 {
	margin-bottom: 50px;
	font-size: 50px;
	text-align: center;
}

td {
	padding: 5px 10px 5px 60px;
}

th {
	font_size: 40px;
	height: 50px;
}

input {
	height: 30px;
}

#btn {
	margin-top: 40px;
	text-align: center;
	margin-right: 10px;
}

td.informs {
	font-weight: bold;
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
					<h2>회원 정보 수정</h2>
					<nav aria-label="breadcrumb mx-auto" role="navigation">
						<ol class="breadcrumb">
							<li class="breadcrumb-item"><a href="memberMyPage.do">MyPage</a></li>
							<li class="breadcrumb-item" aria-current="page">회원 정보 수정</li>
						</ol>
					</nav>
				</div>
			</div>
		</div>
	</section>
	<form id="frm" action="memberUpdate.do" method="post">
		<table align="center">
			<tr>
				<th>이름</th>
				<td><input type="hidden" id="fName" name="fName"
					value="${memberName }"> ${memberName }</td>
			</tr>
			<tr>
				<th>아이디</th>
				<td><input type="hidden" id="fId" name="fId"
					value="${memberId }">${memberId }</td>
			</tr>
			<tr>
				<th>비밀번호</th>
				<td><input type="password" id="password" name="password"
					value="${memberPw }"></td>
			</tr>
			<tr>
				<th>휴대폰 번호</th>
				<td><input type="tel" id="tel" name="tel" required="required"
					value=${memberTel }></td>
			</tr>
			<tr id="oldAddress">
				<th>주소</th>
				<td><input type="text" id="address" name="address"
					style="width: 300px;" value="${memberAddress }">
					<button type="button" onclick="addressUpdate()">주소 변경</button></td>
			</tr>


			<tr>
				<th>우편번호</th>
				<td id="member_address"><input type="text" name="zip"
					style="width: 80px;" />
					<button type="button" style="width: 60px;"
						onclick="openZipSearch()">검색</button></td>
			</tr>

			<tr>
				<th>주소</th>
				<td><input type="text" name="addr1" style="width: 330px;"
					readonly /></td>
			</tr>
			<tr>
				<th>상세주소</th>
				<td><input type="text" name="addr2" style="width: 330px;" /></td>
			</tr>


			<tr>
				<th>이메일 주소</th>
				<td><input type="email" id="email" name="email"
					value="${memberEmail }"></td>
			</tr>

		</table>
		<div id="btn">
			<button type="submit">변경하기</button>
			<button type="button" onclick="history.back()">취소</button>
		</div>
	</form>
</div>
<script>
	window.addEventListener('DOMContentLoaded', function() {
		document.querySelectorAll('tr')[5].style.display = "none";
		document.querySelectorAll('tr')[6].style.display = "none";
		document.querySelectorAll('tr')[7].style.display = "none";
	})

	function openZipSearch() {
		new daum.Postcode({
			oncomplete : function(data) {
				$('[name=zip]').val(data.zonecode); // 우편번호 (5자리)
				$('[name=addr1]').val(data.address);
				$('[name=addr2]').val(data.buildingName);
			}
		}).open();
	}
	function addressUpdate() {

		document.querySelectorAll('tr')[5].style.display = "";
		document.querySelectorAll('tr')[6].style.display = "";
		document.querySelectorAll('tr')[7].style.display = "";
		oldAddress.remove();

	}
</script>