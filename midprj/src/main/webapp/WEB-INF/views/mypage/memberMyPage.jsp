<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<style>
#myPage_container {
	padding: 50px 0 150px;
	text-align: center;
}

#myPage_container div {
	width: 1000px;
	hieght: 200px;
	background-color: gray;
	color: white;
	font-size: 40px;
	padding: 20px;
	margin: 50px auto;
	text-align: center;
	cursor: pointer;
}

#page_header {
	margin-bottom: 100px;
}

#item_option{
	background-color:none;
}
</style>
<section id="page_header" class="single-page-header">
	<div class="container">
		<div class="row">
			<div class="col-md-12">
				<h2>MyPage</h2>
				<nav aria-label="breadcrumb mx-auto" role="navigation">
					<ol class="breadcrumb">
						<li class="breadcrumb-item"><a href="home.do">Home</a></li>
						<li class="breadcrumb-item" aria-current="page" id="item_option">MyPage</li>
					</ol>
				</nav>
			</div>
		</div>
	</div>
</section>
<div id="myPage_container">
	<div onclick="location.href='memberUpdateForm.do'">회원정보 수정</div>
	<div onclick="location.href='mapAtm.do'">가까운 지점 찾기</div>

</div>

<script>
	
</script>