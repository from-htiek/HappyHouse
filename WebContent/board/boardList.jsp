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
          <li><a class="nav-link scrollto active" href="${root}/board?act=list">BOARD</a></li>
          <li><a class="nav-link scrollto" href="${root}/member?act=memberinfo&id=${userInfo.memId}">INFO</a></li>
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
			<h2>BOARD</h2>
			<ol>
				<li><a href="${root}/index.jsp">Home</a></li>
				<li>BOARD</li>
			</ol>
		</div>

	</div>
</section>
<!-- End Breadcrumbs -->

<script>
	function viewContent(no){
		location.href = "${root}/board?act=view&postNo=" + no;
	}
</script>

<!-- start #main -->
<main id="main">

    <section class="inner-page">
      <div class="container">
      <div class="p-3">
      <div class="text-lg-end">
        <button class="mt-5 float-right text-center" id="writebtn" onclick="location.href='${root }/board?act=mvregister'">WRITING</button>
      </div>
<%--       	<a href="${root }/board?act=mvregister">글쓰기</a> --%>
       <table class="table mt-3 mb-5">
          <thead>
          </thead>
          <c:if test="${!empty posts}">
          <tbody>
          	<c:forEach var="post" items="${posts}">
            <tr>
              <td style="width: 10%;">${post.postNo}</td>
              <td style="width: 60%;"><a href="#" style="color:black" onclick="viewContent('${post.postNo}')">${post.title}</a></td>
              <td style="width: 15%;">${post.memId}</td>
              <td style="width: 15%;">${post.regDate}</td>
            </tr>
            </c:forEach>
          </tbody>
          </c:if>
        </table>
      </div>
      
      <div class="mb-4 row justify-content-center">
          <div class="col-md-4">
            <input type="text" class="form-control ">
          </div>
          <button class="col-md-1" id="postsearchbtn">SEARCH</button>
        </div>
      </div>

    </section>



</main>
<!-- End #main -->
<%@ include file="../inc/footer.jsp"%>
