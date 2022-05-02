<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../inc/header.jsp" %>
 <%-- <head> --%>
	<script type="text/javascript" src="${root }/assets/js/search.js"></script>

    <nav id="navbar" class="navbar">
      <ul>
        <li><a class="nav-link scrollto" href="${root }/index.jsp">Home</a></li>
        <li><a class="nav-link scrollto" href="${root }/notice/notice.jsp">NOTICE</a></li>
        <li class="dropdown"><a href="#"><span>SEARCH</span> <i class="bi bi-chevron-down"></i></a>
          <ul>
            <li><a href="${root }/search/searchMain.jsp">BY REGION</a></li>
            <li><a href="#">BY NAME</a></li>
          </ul>
        </li>
        <li><a class="nav-link scrollto" href="${root}/house?act=inquire&memId=${userInfo.memId}">FAVORITE</a></li>
        <li><a class="nav-link scrollto" href="#contact">BOARD</a></li>
        <li><a class="nav-link scrollto" href="">INFO</a></li>
        <li><a class="nav-link scrollto" href="">LOGOUT</a></li>
        <!-- <li><a class="getstarted scrollto" href="#about">Get Started</a></li> -->
      </ul>
      <i class="bi bi-list mobile-nav-toggle"></i>
    </nav><!-- .navbar -->
  </div>

</header><!-- End Header -->

<!-- ======= Breadcrumbs ======= -->
<!-- <main> -->
        <section class="breadcrumbs">
            <div class="container">

                <div class="d-flex justify-content-between align-items-center">
                    <h2>SEARCH</h2>
                    <ol>
                        <li><a href="../index.jsp">Home</a></li>
                        <li>SEARCH</li>
                    </ol>
                </div>

            </div>
        </section><!-- End Breadcrumbs -->

        <div class="container">
            <div style="height: 50px;"></div>
            <div class="row">
                <div class="col-sm-5">
                    <h5 class="mt-2 mb-4"> Please select the region you want to search.</h5>
                    <div class="row mb-2">
                        <div class="col">
                                  <select id="sido" style="width: 100%; height: 30px;">
	          						<option value="">시도선택</option>
	          					  </select>
                        </div>
                        <div class="col">
                                <select id="gugun" style="width: 100%; height: 30px;">
                                    <option selected>구군선택</option>
                                </select>
                        </div>
                    </div>
                    <div class="row" style="margin-bottom: 10px;">
                        <div class="col">
                            <form id="search-form" action="${root }/house">
      							<input type="hidden" name="act" value="dongsearch">
      							<input type="hidden" name="memId" value="${userInfo.memId }">
                                <select onchange="javascript: this.form.submit()" name="dong" id="dong" style="width: 100%; height: 30px;">
                                    <option selected>동선택</option>
                                </select>
                            </form>
	  
                        </div>
                        <div class="col">
                            <form action="">
                                <select name="cars" style="width: 100%; height: 30px;">
                                    <option selected>*</option>
                                </select>
                            </form>
                        </div>
                    </div>
                    <div class="row" style="margin-bottom: 10px;">
	                    <form action="${root }/house">
						<input type="hidden" name="act" value="aptsearch">
							<label for="apt">아파트 검색</label>
							<input type="text" name="apt" id="apt" style="width: 100%; height: 30px;">
							<input type="submit" value="검색" id="sbm_btn">		
						</form>
                   </div>
                </div>

                <div class="col-sm-7">
                    <div id="map" style="width: 100%; height: 350px;">
                        <script type="text/javascript"
                            src="//dapi.kakao.com/v2/maps/sdk.js?appkey=fed99f2ec8be00245007859a6caf0270"></script>
                        <script>
                            var container = document.getElementById('map');
                            var options = {
                                center: new kakao.maps.LatLng(33.450701, 126.570667),
                                level: 3
                            };
                            var map = new kakao.maps.Map(container, options);
                        </script>
                    </div>
                </div>
            </div>
            <div style="height: 50px;"></div>
            <div class="container">
                <table class="table table-hover" style="margin:20px 0">
                    <thead>
                        <tr>
                            <th scope="col">#</th>
                            <th scope="col">NAME</th>
                            <th scope="col">BUILDYEAR</th>
                            <th scope="col">DEALAMOUNT</th>
                            <th scope="col">YEAR</th>
                            <th scope="col">MONTH</th>
                            <th scope="col">LIKE</th>
                        </tr>
                    </thead>
                    <tbody>
                    <!--  DB houseLike의 id를 autoIncrement로 설정할 것 -->
                      <c:if test="${list ne null}">
                			<c:forEach var="APT" items="${list }" varStatus="status">           
                		<form action="${root }/house" method="post">
                			<input type="hidden" name="act" value="favorite">
                			<input type="hidden" name="aptNo" value="${APT.aptNo }">
                			<input type="hidden" name="aptCode" value="${APT.aptCode }">
                			<input type="hidden" name="memId" value="${userInfo.memId }">
	                		<tr>
	                			<th scope="row">${status.count }</th>
	                            <td>${APT.aptName}</td>
	                            <td>${APT.buildYear}</td>
	                            <td>${APT.dealAmount}</td>
	                            <td>${APT.dealYear}</td>
	                            <td>${APT.dealMonth}</td>
	                            <c:choose >
		                            <c:when test="${APT.userLiked eq true}">
		                            	 <td>   🛒</td>
		                            </c:when>
		                           
		                           	<c:otherwise>
		                           		<td><input type="submit" value="☆"></td>
		                           		
		                           	</c:otherwise>
	                           	</c:choose>
							</tr>
						</form>
                			</c:forEach>
               		 </c:if>
               
                    </tbody>
                </table>
            </div>
        </div>





    </main><!-- End #main -->
<%@ include file="../inc/footer.jsp" %>