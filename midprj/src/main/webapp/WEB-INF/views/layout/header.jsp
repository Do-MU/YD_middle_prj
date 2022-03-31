<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="description"
	content="Bingo One page parallax responsive HTML Template ">

<meta name="author" content="Themefisher.com">

<title>Navigator | Responsive Multipurpose Bootstrap HTML5
	Template</title>

<!-- Mobile Specific Meta
  ================================================== -->
<meta name="viewport" content="width=device-width, initial-scale=1">

<!-- Favicon -->
<link rel="shortcut icon" type="image/x-icon" href="images/favicon.png" />

<!-- CSS
  ================================================== -->
<!-- Themefisher Icon font -->
<link rel="stylesheet" href="plugins/themefisher-font/style.css">
<!-- bootstrap.min css -->
<link rel="stylesheet"
	href="plugins/bootstrap/dist/css/bootstrap.min.css">
<!-- Lightbox.min css -->
<link rel="stylesheet"
	href="plugins/lightbox2/dist/css/lightbox.min.css">
<!-- Slick Carousel -->
<link rel="stylesheet" href="plugins/slick-carousel/slick/slick.css">
<link rel="stylesheet"
	href="plugins/slick-carousel/slick/slick-theme.css">
<!-- Main Stylesheet -->
<link rel="stylesheet" href="css/style.css">


<!-- Colors -->
<!-- <link rel="stylesheet" type="text/css" href="css/colors/green.css" title="green">
  <link rel="stylesheet" type="text/css" href="css/colors/red.css" title="light-red">
  <link rel="stylesheet" type="text/css" href="css/colors/light-blue.css" title="light-blue">
  <link rel="stylesheet" type="text/css" href="css/colors/yellow.css" title="yellow">
  <link rel="stylesheet" type="text/css" href="css/colors/light-green.css" title="light-green">
  <link rel="stylesheet" type="text/css" href="css/colors/blue.css" title="blue"> -->

<style>
.log_btns {
	color: white;
}

.log_btns:hover {
	color: yellow;
}
</style>
<script>
	var tid;
	var cnt = ${loginTime};
	
	function counter_init() {
		tid = setInterval("counter_run()", 1000);
	}

	function counter_reset() {
		clearInterval(tid);
		cnt = ${loginTime};
		counter_init();
	}

	function counter_run() {
		if (cnt == 0) {
			clearInterval(tid);
			alert("로그인 시간이 만료되었습니다.");
			location.href = "memberLoginForm.do";
		}
		document.all.counter.innerText = time_format(cnt);
		cnt--;
	}

	function time_format(s) {
		var nHour = 0;
		var nMin = 0;
		var nSec = 0;
		if (s > 0) {
			nMin = parseInt(s / 60);
			nSec = s % 60;

			if (nMin > 60) {
				nHour = parseInt(nMin / 60);
				nMin = nMin % 60;
			}
		}
		if (nSec < 10)
			nSec = "0" + nSec;
		if (nMin < 10)
			nMin = "0" + nMin;

		return "" + nHour + ":" + nMin + ":" + nSec;
	}	
</script>
</head>
<body>
	<section class="header  navigation">
		<div class="container">
			<div class="row">
				<div class="col-md-12">
					<nav class="navbar navbar-expand-md">
						<a class="navbar-brand" href="home.do"> <img
							src="images/OBANGSY.png" alt="logo">
						</a>
						<button class="navbar-toggler" type="button"
							data-toggle="collapse" data-target="#navbarSupportedContent"
							aria-controls="navbarSupportedContent" aria-expanded="false"
							aria-label="Toggle navigation">
							<span class="tf-ion-android-menu"></span>
						</button>
						<div class="collapse navbar-collapse" id="navbarSupportedContent">
							<ul class="navbar-nav ml-auto">
								<li class="nav-item"><a class="nav-link" href="openBanking.do">오픈뱅킹</a></li>
								<li class="nav-item"><a class="nav-link"
									href="accountList.do">계좌조회</a></li>
								<li class="nav-item"><a class="nav-link" href="#">이체하기</a></li>
								<li class="nav-item"><a class="nav-link"
									href="noticeList.do">공지사항</a></li>
								<li class="nav-item"><a class="nav-link" href="qnaList.do">QnA</a></li>
								<li class="nav-item dropdown"><a
									class="nav-link dropdown-toggle" href="#" id="navbarDropdown"
									role="button" data-toggle="dropdown" aria-haspopup="true"
									aria-expanded="false"> Pages </a>
									<div class="dropdown-menu" aria-labelledby="navbarDropdown">
										<a class="dropdown-item" href="404.html">404 Page</a>
									</div></li>
							</ul>
						</div>
						&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						<c:if test="${not empty loginName}">
							<div>
								<a class='log_btns' href='memberMyPage.do'>${loginName}님</a>&nbsp;&nbsp;&nbsp;
								<div id="demo" style="color: white;"></div>
								<div id = "counter" style="color: white;"></div>
							</div>
							<div><input type="button" value = "연장" onclick = "counter_reset()" ></div>
							&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
							<div>
								<a class='log_btns' href='memberLoginForm.do'>로그아웃</a>
							</div>
						</c:if>

						<c:if test="${empty loginName}">
							<div>
								<a class='log_btns' href='memberLoginForm.do'>로그인</a>&nbsp;&nbsp;&nbsp;
								<a class='log_btns' href='memberJoinForm.do'>회원가입</a>
							</div>
						</c:if>
					</nav>
				</div>
			</div>
		</div>
	</section>
	<!-- Main jQuery -->
	<script src="plugins/jquery/dist/jquery.min.js"></script>
	<!-- Bootstrap 3.7 -->
	<script src="plugins/bootstrap/dist/js/popper.min.js"></script>
	<script src="plugins/bootstrap/dist/js/bootstrap.min.js"></script>
	<!-- Parallax -->
	<script src="plugins/parallax/jquery.parallax-1.1.3.js"></script>
	<!-- lightbox -->
	<script src="plugins/lightbox2/dist/js/lightbox.min.js"></script>
	<!-- Owl Carousel -->
	<script src="plugins/slick-carousel/slick/slick.min.js"></script>
	<!-- Portfolio Filtering -->
	<script src="plugins/mixitup/dist/mixitup.min.js"></script>
	<!-- Smooth Scroll js -->
	<script src="plugins/smooth-scroll/dist/js/smooth-scroll.min.js"></script>
	

	<!-- Custom js -->
	<script src="js/script.js"></script>
	<script>
		counter_init();
	</script>
</body>
</html>