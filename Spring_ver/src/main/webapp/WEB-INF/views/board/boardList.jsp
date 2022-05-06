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
				<li><a href="${root}/index">Home</a></li>
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

<script type="text/javascript">
        $(document).ready(function () {
        	
/*         	if("${key}")
        		$("#skey").val("${key}").prop("selected", true); */

        	
/*         	$("#searchBtn").click(function () {
                var word = $("#sword").val();
                if(word == "") {
                	alert("모든 목록 조회!!!");
                }
                $("#searchform").attr("action", "${root}/guestbook/list").submit();
            }); */
        	
        	$(".page-item").click(function() {
				$("#pg").val(($(this).attr("data-pg")));
				$("#pageform").attr("action", "${root}/board/list").submit();
			});
        	
        	//file download
/*             $('.filedown').click(function() {
        		// alert("원본 :  " + $(this).attr('ofile') + "      실제 :  " + $(this).attr('sfile'));
        		$(document).find('[name="sfolder"]').val($(this).attr('sfolder'));
        		$(document).find('[name="ofile"]').val($(this).attr('ofile'));
        		$(document).find('[name="sfile"]').val($(this).attr('sfile'));
        		$('#downform').attr('action', '${root}/guestbook/download').attr('method', 'get').submit();
        	}); */
        });
</script>

<form name="pageform" id="pageform" method="GET" action="">
	<input type="hidden" name="pg" id="pg" value="">
	<input type="hidden" name="key" id="key" value="${key}">
	<input type="hidden" name="word" id="word" value="${word}">
</form>

<!-- start #main -->
<main id="main">

    <section class="inner-page">
      <div class="container">
      <div class="p-3">
      <div class="text-lg-end">
        <button class="mt-5 float-right text-center" id="writebtn" onclick="location.href='${root }/board/register'">WRITING</button>
      </div>
       <table class="table mt-3 mb-5">
          <thead>
          </thead>
          <c:if test="${!empty posts}">
          <tbody>
          	<c:forEach var="post" items="${posts}">
            <tr>
              <td style="width: 10%;">${post.postNo}</td>
              <td style="width: 55%;"><a href="${root }/board/getPost?postNo=${post.postNo}" style="color:black">${post.title}</a></td>
              <td style="width: 15%;">${post.memId}</td>
              <td style="width: 15%;">${post.regDate}</td>
              <td style="width: 5%;">
              	<a href="${root}/board/delete?postNo=${post.postNo}">
              	<i class="fa-solid fa-trash-can"></i></a>
              </td>
            </tr>
            </c:forEach>
          </tbody>
          </c:if>
        </table>
        <div class="mb-4 row justify-content-center">
        	<div class="col-md-4">${navigation.navigator}</div>
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
