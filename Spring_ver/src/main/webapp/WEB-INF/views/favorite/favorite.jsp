<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../inc/header.jsp" %>

    <nav id="navbar" class="navbar">
      <ul>
        <li><a class="nav-link scrollto" href="${root }/index.jsp">Home</a></li>
        <li><a class="nav-link scrollto" href="${root }/notice/notice.jsp">NOTICE</a></li>
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
    </nav><!-- .navbar -->
  </div>
  
</header><!-- End Header -->

	<!--  외부에서 들어왔을 때 로그인된 상태라면 JS submit을 통해 리로드  -->
  <!-- ======= Breadcrumbs ======= -->
  <section class="breadcrumbs">
    <div class="container">

      <div class="d-flex justify-content-between align-items-center">
      <form id="inquire-favorite" action="${root }/house?act=inquire&memId=${userInfo.memId}" method="post">
        <h2 id="temp-button">FAVORITE</h2>
      </form>
        <ol>
          <li><a href="index.html">Home</a></li>
          <li>FAVORITE</li>
        </ol>
      </div>

    </div>
  </section><!-- End Breadcrumbs -->

<!-- start #main -->
<main id="main">

  <section class="inner-page">
    <div class="container">
      <table class="table table-hover" style="margin:20px 0">
        <thead>
          <tr>
            <th scope="col">#</th>
            <th scope="col">APARTMENT</th>
            <th scope="col">REGION</th>
            <th scope="col">COST</th>
            <th scope="col"></th>
          </tr>
        </thead>
        
      <c:if test="${userInfo ne null}">
      	  <c:forEach var="APT" items="${list }" varStatus="status">
      	  <form action="${root }/favorite/delete" method="post">
              <!-- <input type="hidden" name="act" value="delete"> -->
              <input type="hidden" name="aptNo" value="${APT.aptNo }">
              <input type="hidden" name="aptCode" value="${APT.aptCode }">
              <input type="hidden" name="memId" value="${userInfo.memId }">
          <tr>
            <th scope="row">${status.count }</th>
            <td>${APT.aptName }</td>
            <td>${APT.dongName }</td>
            <td>${APT.dealAmount }</td>
            <td><input type="submit" value="★"></td>
          </tr>
          </form>
	  	  </c:forEach>
	  </c:if>
		
      </tbody>
      </table>
    </div>

<!--     <ul class="pagination justify-content-center" style="margin:20px 0">
      <li class="page-item"><a class="page-link" href="#">Previous</a></li>
      <li class="page-item"><a class="page-link" href="#">1</a></li>
      <li class="page-item"><a class="page-link" href="#">2</a></li>
      <li class="page-item"><a class="page-link" href="#">3</a></li>
      <li class="page-item"><a class="page-link" href="#">Next</a></li>
    </ul> -->
  </section>

  



  </main><!-- End #main -->
<%@ include file="../inc/footer.jsp" %>