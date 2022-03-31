<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<style>
#container {
	height: 1000px;
}

#contact_us{
	padding: 0 auto;
}
</style>


	<section class="hero-area">
		<div class="container">
			<div class="row">
				<div class="col-md-6">
					<div class="block">
						<h2>오뱅시</h2>
						<h3> : 오픈 뱅킹계의 명품</h3>
						<p>오뱅시 팀은 바꾸고 싶은 세상의 모습이 있고 생각만 해도 가슴 뛰는 목표가 있는 조직입니다.
							어렵고, 불편하고, 멀게 느껴지는 금융이 아닌 누구에게나 쉽고 상식적인 금융을 만드는 것이 오뱅시팀의 존재 이유입니다.</p>
						<c:if test="${loginId == null}">
							<a href="memberLoginForm.do" class="btn btn-main">Join with Us</a>
						</c:if>
						<c:if test="${loginId != null}">
							<a href="accountList.do" class="btn btn-main">Join with Us</a>
						</c:if>
					</div>
				</div>
			</div>
		</div>
	</section>


	<section class="contact-us section bg-gray" id="contact">
		<div class="container">
			
			<div class="row" id="contact_us">
				<div class="col-12 col-md-4">
					<div class="address-block contact-meta-block">
						<i class="tf-ion-android-pin"></i>
						<h4>Our Location</h4>
						<p>
							 대한민국 대구광역시 중구<br>중앙대로 403 (남일동 135-1, 5층)<br>

						</p>

					</div>
				</div>
				<div class="col-12 col-md-4">
					<div class="phone-block contact-meta-block">
						<i class="tf-ion-ios-telephone"></i>
						<h4>Call Us</h4>
						<p>
							Office) 053-421-2460 <br> Fax)  053-356-3939
						</p>
					</div>
				</div>
				<div class="col-12 col-md-4">
					<div class="social-icons-block contact-meta-block">
						<i class="tf-ion-ios-contact"></i>
						<h4>Our social</h4>
						<ul class="list-inline social-icon">
							<li class="list-inline-item"><a href=""><i class="tf-ion-social-facebook"></i></a></li>
							<li class="list-inline-item"><a href=""><i class="tf-ion-social-twitter"></i></a></li>
							<li class="list-inline-item"><a href=""><i class="tf-ion-social-linkedin"></i></a></li>
							<li class="list-inline-item"><a href=""><i class="tf-ion-social-dribbble"></i></a></li>
							<li class="list-inline-item"><a href=""><i class="tf-ion-social-instagram"></i></a></li>
						</ul>
					</div>
				</div>
			</div>
		</div>
	</section>

<script>
	if ('${message}' != '') {
		window.alert('${message}');
		window.location = 'home.do';
	}
</script>