<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../inc/header.jsp"%>


<nav id="navbar" class="navbar">
	<ul>
		<li><a class="nav-link scrollto" href="${root}/index.jsp">Home</a></li>
		<li><a class="nav-link scrollto" href="">NOTICE</a></li>
		<li class="dropdown"><a href="#"><span>SEARCH</span> <i
				class="bi bi-chevron-down"></i></a>
			<ul>
				<li><a href="#">BY REGION</a></li>
				<li><a href="#">BY NAME</a></li>
			</ul></li>
		<li><a class="nav-link scrollto" href="#contact">FAVORITE</a></li>
          <li><a class="nav-link scrollto" href="${root}/board?act=list">BOARD</a></li>
          <li><a class="nav-link scrollto active" href="${root}/member?act=memberinfo&id=${userInfo.memId}">INFO</a></li>
          <li><a class="nav-link scrollto" href="${root}/member?act=logout">LOGOUT</a></li>
		<!-- <li><a class="getstarted scrollto" href="#about">Get Started</a></li> -->
	</ul>
	<i class="bi bi-list mobile-nav-toggle"></i>
</nav>
<!-- .navbar -->

</div>
</header>
<!-- End Header -->

<!-- ======= Breadcrumbs ======= -->
<section class="breadcrumbs">
	<div class="container">

		<div class="d-flex justify-content-between align-items-center">
			<h2></h2>
			<ol>
				<li><a href="${root}/index.jsp">Home</a></li>
				<li>MY INFO</li>
			</ol>
		</div>

	</div>
</section>
<!-- End Breadcrumbs -->


<main id="main">
<div class="container rounded bg-white m-auto p-5">
	<div class="row" id="memberinfoform">
		<div class="col-md-4 border-right">
			<div
				class="d-flex flex-column align-items-center text-center p-3 py-5">
				<img class="rounded-circle mt-5"
					src="${root }/assets/img/background3.jpg" width="90"> <span
					class="font-weight-bold">SSAFY</span> <span>SSAFY@ssafy.com</span>
			</div>
		</div>
		<div class="col-md-8">
			<div class="p-3 py-5">
				<div class="d-flex justify-content-between align-items-center mb-3">
					<!-- <h6 class="text-right">Edit your profile</h6> -->
				</div>
				<form action="${root }/member" method="post">
					<input type="hidden" name="act" value="update" />
					<div class="row">
						<div class="col-md-6 mb-3">
							<label for="id">ID</label> <input type="text"
								class="form-control" id="id" name="id"
								value="${userDetailInfo.memId}" readonly>
						</div>
						<div class="col-md-6 mb-3">
							<label for="pw">PASSWORD</label> <input type="password"
								class="form-control" id="pw" name="pw"
								value="${userDetailInfo.memPw}">
						</div>
					</div>
					<div class="mb-3">
						<label for="name">NAME</label> <input type="text"
							class="form-control" id="email" name="name"
							value="${userDetailInfo.memName}">
					</div>
					<div class="mb-3">
						<label for="email">EMAIL</label> <input type="email"
							class="form-control" id="email" name="email"
							value="${userDetailInfo.memEmail}">
					</div>
					<div class="mb-3">
						<label for="tel">PHONE</label> <input type="text"
							class="form-control" id="tel" name="tel"
							value="${userDetailInfo.memTel}">
					</div>
					<div class="row">
						<div class=col></div>
						<button class="col btn-get-started m-4" type="submit">CONFIRM</button>
						<div class=col></div>
					</div>
				</form>
<%-- 				<button class="col btn-get-started m-4" type="submit" onclick="location.href='${root}/member?act=memberinfo&id=${userInfo.memId}'">CANCLE</button> --%>
			</div>
		</div>

	</div>
</div>


</main>
<!-- End #main -->


</html>
<%@ include file="../inc/footer.jsp"%>