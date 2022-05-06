<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="root" value="${pageContext.request.contextPath}" />

<head>
<meta charset="utf-8">
<meta content="width=device-width, initial-scale=1.0" name="viewport">

<title>HAPPY HOUSE</title>
<meta content="" name="description">
<meta content="" name="keywords">

<!-- Favicons -->
<!--   <link href="../assets/img/favicon.png" rel="icon">
  <link href="../assets/img/apple-touch-icon.png" rel="apple-touch-icon"> -->

<!-- Google Fonts -->
<link
	href="https://fonts.googleapis.com/css?family=Open+Sans:300,300i,400,400i,600,600i,700,700i|Raleway:300,300i,400,400i,500,500i,600,600i,700,700i|Poppins:300,300i,400,400i,500,500i,600,600i,700,700i"
	rel="stylesheet">

<!-- Vendor CSS Files -->
<link href="${root }/assets/vendor/aos/aos.css" rel="stylesheet">
<link href="${root }/assets/vendor/bootstrap/css/bootstrap.min.css"
	rel="stylesheet">
<link href="${root }/assets/vendor/bootstrap-icons/bootstrap-icons.css"
	rel="stylesheet">
<link href="${root }/assets/vendor/boxicons/css/boxicons.min.css"
	rel="stylesheet">
<link href="${root }/assets/vendor/glightbox/css/glightbox.min.css"
	rel="stylesheet">
<link href="${root }/assets/vendor/remixicon/remixicon.css"
	rel="stylesheet">
<link href="${root }/assets/vendor/swiper/swiper-bundle.min.css"
	rel="stylesheet">

<!-- <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css"> -->
<script
	src="https://cdn.jsdelivr.net/npm/jquery@3.6.0/dist/jquery.slim.min.js"></script>
<script
	src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/js/bootstrap.bundle.min.js"></script>

<!-- Template Main CSS File -->
<link href="${root }/assets/css/style.css" rel="stylesheet">


<!-- summernote -->
<script
	src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js"
	integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6"
	crossorigin="anonymous"></script>

<link
	href="https://cdn.jsdelivr.net/npm/summernote@0.8.18/dist/summernote-bs4.min.css"
	rel="stylesheet">
<script
	src="https://cdn.jsdelivr.net/npm/summernote@0.8.18/dist/summernote-bs4.min.js"></script>

<!-- =======================================================
  * Template Name: Dewi - v4.7.0
  * Template URL: https://bootstrapmade.com/dewi-free-multi-purpose-html-template/
  * Author: BootstrapMade.com
  * License: https://bootstrapmade.com/license/
  ======================================================== -->
</head>
<body>
	<!-- ======= Header ======= -->
	<header id="header" class="fixed-top header-inner-pages">
		<div
			class="container d-flex align-items-center justify-content-between">

			<h1 class="logo">
				<a href="${root}/index.jsp"">HAPPY HOUSE</a>
			</h1>
			<!-- Uncomment below if you prefer to use an image logo -->
			<!-- <a href="index.html" class="logo"><img src="assets/img/logo.png" alt="" class="img-fluid"></a>-->


			<nav id="navbar" class="navbar">
				<ul>
					<li><a class="nav-link scrollto" href="${root}/">Home</a></li>
					<li><a class="nav-link scrollto" href="${root}/notice/list">NOTICE</a></li>
          <li class="dropdown"><a href="#"><span>SEARCH</span> <i class="bi bi-chevron-down"></i></a>
            <ul>
              <li><a href="/house/search">BY REGION</a></li>
              <li><a href="#">BY NAME</a></li>
            </ul>
          </li>
          <li><a class="nav-link scrollto" href="${root}/favorite/list/${userInfo.memId}">FAVORITE</a></li>
           <li><a class="nav-link scrollto" href="${root}/board/list?pg=1&key=&word=">BOARD</a></li>
          <li><a class="nav-link scrollto" href="${root}/member/info/${userInfo.memId}">INFO</a></li>
          <li><a class="nav-link scrollto" href="${root}/member/logout">LOGOUT</a></li>
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
				<h2>BOARD</h2>
				<ol>
					<li><a href="${root}/">Home</a></li>
					<li>BOARD</li>
				</ol>
			</div>

		</div>
	</section>
	<!-- End Breadcrumbs -->
	
	<script type="text/javascript">
        $(document).ready(function () {
            $("#registerBtn").click(function () {
                if (!$("#title").val()) {
                    alert("제목을 입력해주세요");
                    return;
                } else if (!$("#content").val()) {
                    alert("내용을 입력해주세요");
                    return;
                } else {
                    $("#writeform").attr("action", "${root}/board/register").submit();
                }
            });
        });
    </script>

	<main id="main">
	<div class="container m-auto p-5">
		<div class="row" id="boardwriteform">
			<form id="writeform" method="post" action="">
				<div class="mb-3">
					<input type="text" class="form-control" placeholder="Please enter your title." id="title" name="title">
				</div>

				<textarea id="content" name="content"></textarea>
				<script>
         			$('#content').summernote({
            		placeholder: 'Please enter your content.',
            		tabsize: 2,
            		height: 500
          			});
        		</script>
				<div class="row">
					<div class="col-md-5"></div>
					<button type ="button" id="registerBtn" class="btn-get-started col-md-2 m-4">CONFIRM</button>
					<div class="col-md-5"></div>
				</div>
			</form>
		</div>
	</div>



	</main>
	<!-- End #main -->
</html>
<%@ include file="../inc/footer.jsp"%>