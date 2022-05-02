<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="root" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html>
<html lang="en">

<head>
  <meta charset="utf-8">
  <meta content="width=device-width, initial-scale=1.0" name="viewport">

  <title>HAPPY HOUSE</title>
  <meta content="" name="description">
  <meta content="" name="keywords">

  <!-- Favicons -->
  <!-- <link href="assets/img/favicon.png" rel="icon">
  <link href="assets/img/apple-touch-icon.png" rel="apple-touch-icon"> -->

  <!-- Google Fonts -->
  <link
    href="https://fonts.googleapis.com/css?family=Open+Sans:300,300i,400,400i,600,600i,700,700i|Raleway:300,300i,400,400i,500,500i,600,600i,700,700i|Poppins:300,300i,400,400i,500,500i,600,600i,700,700i"
    rel="stylesheet">

  <!-- Vendor CSS Files -->
  <link href="assets/vendor/aos/aos.css" rel="stylesheet">
  <link href="assets/vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">
  <link href="assets/vendor/bootstrap-icons/bootstrap-icons.css" rel="stylesheet">
  <link href="assets/vendor/boxicons/css/boxicons.min.css" rel="stylesheet">
  <link href="assets/vendor/glightbox/css/glightbox.min.css" rel="stylesheet">
  <link href="assets/vendor/remixicon/remixicon.css" rel="stylesheet">
  <link href="assets/vendor/swiper/swiper-bundle.min.css" rel="stylesheet">

  <!-- <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css"> -->
  <script src="https://cdn.jsdelivr.net/npm/jquery@3.6.0/dist/jquery.slim.min.js"></script>
  <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
  <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/js/bootstrap.bundle.min.js"></script>

  <!-- Template Main CSS File -->
  <link href="assets/css/style.css" rel="stylesheet">

  <!-- =======================================================
  * Template Name: Dewi - v4.7.0
  * Template URL: https://bootstrapmade.com/dewi-free-multi-purpose-html-template/
  * Author: BootstrapMade.com
  * License: https://bootstrapmade.com/license/
  ======================================================== -->
</head>

<body>

  <!-- ======= Header ======= -->
  <header id="header" class="fixed-top ">
    <div class="container d-flex align-items-center justify-content-between">

      <h1 class="logo"><a href="index.jsp">HAPPYHOUSE</a></h1>
      <!-- Uncomment below if you prefer to use an image logo -->
      <!-- <a href="index.html" class="logo"><img src="assets/img/logo.png" alt="" class="img-fluid"></a>-->

      <nav id="navbar" class="navbar">
        <ul>
          <li><a class="nav-link scrollto active" href="${root}/index.jsp">Home</a></li>
           <c:if test="${!empty userInfo}">
          <li><a class="nav-link scrollto" href="./admin/notice.jsp">NOTICE</a></li>
          <li class="dropdown"><a href="#"><span>SEARCH</span> <i class="bi bi-chevron-down"></i></a>
            <ul>
              <li><a href="search/searchMain.jsp">BY REGION</a></li>
              <li><a href="#">BY NAME</a></li>
            </ul>
          </li>
          <li><a class="nav-link scrollto" href="${root}/house?act=inquire&memId=${userInfo.memId}">FAVORITE</a></li>
          <li><a class="nav-link scrollto" href="${root}/board?act=list">BOARD</a></li>
          <li><a class="nav-link scrollto" href="${root}/member?act=memberinfo&id=${userInfo.memId}">INFO</a></li>
<!-- 			<li><a class="nav-link scrollto" href="./member/memberInfo.jsp">INFO</a></li> -->
          <li><a class="nav-link scrollto" href="${root}/member?act=logout">LOGOUT</a></li>
          <!-- <li><a class="getstarted scrollto" href="#about">Get Started</a></li> -->
          </c:if>
        </ul>
        <i class="bi bi-list mobile-nav-toggle"></i>
      </nav><!-- .navbar -->

    </div>
  </header><!-- End Header -->

  <!-- ======= Hero Section ======= -->
  <section id="hero">
    <div class="hero-container" data-aos="fade-up" data-aos-delay="150">
      <h1>FIND. TOUR. OWN.</h1>
      <h2>Discover a place you'll love to live</h2>
      <div class="d-flex">
      <c:if test="${empty userInfo}">
        <a href="#about" class="btn-get-started scrollto" data-toggle="modal" data-target="#signupModal">SIGN UP</a>
        <a href="#about" class="btn-get-started scrollto ml-10" data-toggle="modal" data-target="#loginModal">LOGIN</a>
      </c:if>
      <c:if test="${!empty userInfo}">
      <div><h2> WELCOME ${userInfo.memId}!</h2></div>
      </c:if>
        <!-- <a href="https://www.youtube.com/watch?v=jDDaplaOz7Q" class="glightbox btn-watch-video"><i class="bi bi-play-circle"></i><span>Watch Video</span></a> -->
      </div>
    </div>
  </section><!-- End Hero -->

  <main id="main">

    <!-- signup Modal -->
    <div class="modal" id="signupModal">
      <div class="modal-dialog">
        <div class="modal-content">

          <div class="container">
            <div class="input-form-backgroud row">
              <div class="signupform col-md-12 mx-auto" id="signupform">
                <h4 class="mb-3">SIGN UP</h4>
                <form action="${root }/member" method="post">
                  <input type="hidden" name="act" value="signup">
                  <div class="row">
                    <div class="col-md-6 mb-3"> <label for="id">ID</label> 
                      <input type="text" class="form-control" id="id" name="id" required>
                    </div>
                    <div class="col-md-6 mb-3"> <label for="pw">PASSWORD</label> 
                      <input type="password" class="form-control" id="pw" name="pw" required>
                    </div>
                  </div>
                  <div class="mb-3"> <label for="name">NAME</label> 
                    <input type="text" class="form-control" id="email" name="name" required>
                  </div>
                  <div class="mb-3"> <label for="email">EMAIL</label> 
                    <input type="email" class="form-control" id="email" name="email" placeholder="you@example.com" required>
                  </div>
                  <div class="mb-3"> <label for="tel">PHONE</label> 
                    <input type="text" class="form-control" id="tel" name="tel" placeholder="010-XXXX-XXXX" required>
                  </div>
                  <div class="row">
                    <div class="col"></div>
                    <button class="col btn-get-started " type="submit">REGISTER</button>
                    <div class="col"></div>
                  </div>
                </form>
              </div>
            </div>
          </div>



        </div>
      </div>
    </div> <!-- end signup Modal -->

    <!-- login Modal -->
    <div class="modal" id="loginModal">
      <div class="modal-dialog">
        <div class="modal-content">

          <div class="container">
            <div class="input-form-backgroud row">
              <div class="loginform col-md-12 mx-auto" id="loginform">
                <h4 class="mb-3">LOGIN</h4>
                <form action="${root }/member" method="post">
                  <input type="hidden" name="act" value="login">
                  <div class="mb-3"> <label for="loginId">ID</label> 
                    <input type="text" class="form-control" id="loginId" name="loginId" required>
                  </div>
                  <div class="mb-3"> <label for="loginPw">PASSWORD</label> 
                    <input type="password" class="form-control" id="loginPw" name="loginPw" required>
                  </div>
                  <div class="row">
                    <button class="col btn-get-started m-3" type="submit">LOGIN</button>
                    <button class="col btn-get-started m-3" type="submit">FIND PASSWORD</button>
                  </div>
                </form>
              </div>
            </div>
          </div>

        </div>
      </div>
    </div> <!-- end login Modal -->

  </main><!-- End #main -->

  <!-- ======= Footer ======= -->
  <footer id="footer">
    <div class="footer-top">
      <div class="container">
        <div class="row">

          <div class="col-lg-3 col-md-6">
            <div class="footer-info">
              <h3>HAPPY HOUSE</h3>
              <p>
                (SSAFY) 서울시 강남구 테헤란로 멀티스퀘어 <br>

                <strong>Phone:</strong> 1544-9001<br>
                <strong>Email:</strong> admin@ssafy.com<br>
              </p>
              <div class="social-links mt-3">
                <a href="#" class="twitter"><i class="bx bxl-twitter"></i></a>
                <a href="#" class="facebook"><i class="bx bxl-facebook"></i></a>
                <a href="#" class="instagram"><i class="bx bxl-instagram"></i></a>
                <a href="#" class="google-plus"><i class="bx bxl-skype"></i></a>
                <a href="#" class="linkedin"><i class="bx bxl-linkedin"></i></a>
              </div>
            </div>
          </div>

        </div>
      </div>
    </div>

    <div class="container">
      <div class="copyright">
        &copy; Copyright <strong><span>Dewi</span></strong>. All Rights Reserved
      </div>
      <div class="credits">
        <!-- All the links in the footer should remain intact. -->
        <!-- You can delete the links only if you purchased the pro version. -->
        <!-- Licensing information: https://bootstrapmade.com/license/ -->
        <!-- Purchase the pro version with working PHP/AJAX contact form: https://bootstrapmade.com/dewi-free-multi-purpose-html-template/ -->
        Designed by <a href="https://bootstrapmade.com/">BootstrapMade</a>
      </div>
    </div>
  </footer><!-- End Footer -->

  <div id="preloader"></div>
  <a href="#" class="back-to-top d-flex align-items-center justify-content-center"><i
      class="bi bi-arrow-up-short"></i></a>

  <!-- Vendor JS Files -->
  <script src="assets/vendor/purecounter/purecounter.js"></script>
  <script src="assets/vendor/aos/aos.js"></script>
  <script src="assets/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>
  <script src="assets/vendor/glightbox/js/glightbox.min.js"></script>
  <script src="assets/vendor/isotope-layout/isotope.pkgd.min.js"></script>
  <script src="assets/vendor/swiper/swiper-bundle.min.js"></script>
  <script src="assets/vendor/php-email-form/validate.js"></script>

  <!-- Template Main JS File -->
  <script src="assets/js/main.js"></script>

</body>

</html>