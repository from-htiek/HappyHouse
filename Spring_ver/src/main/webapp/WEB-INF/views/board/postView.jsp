<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../inc/header.jsp"%>
<nav id="navbar" class="navbar">
	<ul>
		<li><a class="nav-link scrollto" href="${root}/">Home</a></li>
		<li><a class="nav-link scrollto" href="">NOTICE</a></li>
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

<script>
	function editContent(no){
		location.href = "${root}/board?act=mvedit&postNo=" + no;
	}
</script>

<!-- start #main -->
<main id="main">
<div>${post.title}</div>
<div>${post.content}</div>
<a onclick="editContent('${post.postNo}')">EDIT</a>
<a href="${root}/board?act=delete&postNo=${post.postNo}">DELETE</a>
</main>

<!-- End #main -->
<%@ include file="../inc/footer.jsp"%>