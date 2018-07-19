<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page pageEncoding="utf-8" session="false"%>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="utf-8">
<title>GA & Doo & CHUNG WEPPAGE</title>
<meta content="width=device-width, initial-scale=1.0" name="viewport">
<meta content="" name="keywords">
<meta content="" name="description">

<!-- Favicons -->
<link href="img/favicon.png" rel="icon">
<link href="img/apple-touch-icon.png" rel="apple-touch-icon">

<!-- Google Fonts -->
<link
	href="https://fonts.googleapis.com/css?family=Open+Sans:300,300i,400,400i,700,700i|Poppins:300,400,500,700"
	rel="stylesheet">

<!-- Bootstrap CSS File -->
<link href="lib/bootstrap/css/bootstrap.min.css" rel="stylesheet">

<!-- Libraries CSS Files -->
<link href="lib/font-awesome/css/font-awesome.min.css" rel="stylesheet">
<link href="lib/animate/animate.min.css" rel="stylesheet">

<!-- Main Stylesheet File -->
<link href="css/style.css" rel="stylesheet">

<!-- =======================================================
    Theme Name: Regna
    Theme URL: https://bootstrapmade.com/regna-bootstrap-onepage-template/
    Author: BootstrapMade.com
    License: https://bootstrapmade.com/license/
  ======================================================= -->
</head>

<body>

	<!--==========================
  Header
  ============================-->
	<header id="header">
    <div class="container">
      <div id="logo" class="pull-left">
        <a href="#hero"><img src="img/logo.png" alt="" title="" /></img></a>
        <!-- Uncomment below if you prefer to use a text logo -->
        <!--<h1><a href="#hero">Regna</a></h1>-->
      </div>

      <nav id="nav-menu-container">
        <ul class="nav-menu">
          <li class="menu-active"><a href="#hero">Home</a></li>
          <li><a href="#">Portfolio</a></li>
          <li><a href="#">Studies</a></li>
          <li><a href="#communities">Comuunity</a></li>
          <li class="menu-has-children"><a href="">로그인을 하세요</a>
            <ul>
              <li><a href="<c:url value='/login'/>">로그인</a></li>
              <li><a href="<c:url value='/register'/>">회원가입</a></li>
              <li class="menu-has-children"><a href="#">Drop Down 2</a>
                <ul>
                  <li><a href="#">Deep Drop Down 1</a></li>
                  <li><a href="#">Deep Drop Down 2</a></li>
                  <li><a href="#">Deep Drop Down 3</a></li>
                  <li><a href="#">Deep Drop Down 4</a></li>
                  <li><a href="#">Deep Drop Down 5</a></li>
                </ul>
              </li>
            </ul>
          </li>
          <!-- <li><a href="#contact">로그인버튼생성</a></li> -->
        </ul>
      </nav><!-- #nav-menu-container -->
    </div>
  </header>
	<!-- #header -->

	<!--==========================
    Hero Section
  ============================-->
	<section id="hero">
		<div class="hero-container">
			<div class="container py-5">
				<div class="row">
					<div class="col-md-12">
						<div class="row">
							<div class="col-md-6 mx-auto">
								<!-- form card login -->
								<div class="card">
									<div class="card-header">
										<h3 class="login-title">Register</h3>
									</div>
									<div class="card-body">
										<form class="form" role="form" autocomplete="off"
											id="formLogin" method="POST">
											<div class="form-group">
												<label for="ID" class="login-text">ID</label> <input
													type="text" class="form-control form-control-lg"
													name="userId" id="userId" placeholder="Write ID">
												<div class="validation"></div>
											</div>
											<div class="form-group">
												<label class="login-text">Password</label> <input
													type="password" class="form-control form-control-lg"
													name="userPassword" id="userPassword"
													placeholder="Write Password">
												<div class="invalid-feedback">Enter your password too!</div>
												<div class="validation"></div>
											</div>
											<div class="form-group">
												<label for="Nickname" class="login-text">Nickname</label> <input
													type="text" class="form-control form-control-lg"
													name="userNickname" id="userNickname"
													placeholder="Write Nickname">
												<div class="validation"></div>
											</div>
											<div class="form-group">
												<label for="Email" class="login-text">Email</label> <input
													type="email" class="form-control form-control-lg"
													name="userEmail" id="userEmail" placeholder="Write Email">
												<div class="validation"></div>
											</div>
											<div class="form-group">
												<label for="Email" class="login-text">Phone Number</label> <input
													type="text" class="form-control form-control-lg"
													name="userPhone" id="userPhone"
													placeholder="Write Phone Number">
												<div class="validation"></div>
											</div>
											<div class="form-group">
												<label for="Email" class="login-text">Introduction</label>
												<textarea class="form-control" name="userIntro" rows="5"
													data-rule="required"
													data-msg="Please write something for us"
													placeholder="introduce yourself...."></textarea>
												<div class="validation"></div>
											</div>
											<div class="text-center">
												<button class="btn btn-default btn-sm btn-block"
													type="submit">Submit</button>
											</div>
										</form>
									</div>
									<!--/card-block-->
								</div>
								<!-- /form card login -->
							</div>
						</div>
						<!--/row-->
					</div>
					<!--/col-->
				</div>
				<!--/row-->
			</div>
			<!--/container-->
		</div>
	</section>
	<!-- #login -->

	<!--==========================
    Footer
  ============================-->
	<footer id="footer">
		<div class="footer-top">
			<div class="container"></div>
		</div>

		<div class="container">
			<div class="row">
				<div class="col-6">
					<div class="copyright">
						&copy; Copyright <strong>Regna</strong>. All Rights Reserved
					</div>
					<div class="credits">
						<!--
          All the links in the footer should remain intact.
          You can delete the links only if you purchased the pro version.
          Licensing information: https://bootstrapmade.com/license/
          Purchase the pro version with working PHP/AJAX contact form: https://bootstrapmade.com/buy/?theme=Regna
        -->
						Designed by <a href="https://bootstrapmade.com/">BootstrapMade</a>
					</div>
				</div>
				<div class="col-6">
					<div class="credits">
						<div class="row">부산외국어대학교 I412 알고리즘 연구/개발실</div>
						<div class="row">
							두찬영 Doodoo 010-2436-xxxx&nbsp;<a href="">dcy93@naver.com</a>
						</div>
						<div class="row">
							김태훈 Gaetang 010-2436-xxxx&nbsp;<a href="">dcy93@naver.com</a>
						</div>
						<div class="row">
							이화섭 Chungma 010-2436-xxxx&nbsp;<a href="">dcy93@naver.com</a>
						</div>
					</div>
				</div>
			</div>
		</div>
	</footer>
	<!-- #footer -->

	<a href="#" class="back-to-top"><i class="fa fa-chevron-up"></i></a>

	<!-- JavaScript Libraries -->
	<script src="lib/jquery/jquery.min.js"></script>
	<script src="lib/jquery/jquery-migrate.min.js"></script>
	<script src="lib/bootstrap/js/bootstrap.bundle.min.js"></script>
	<script src="lib/easing/easing.min.js"></script>
	<script src="lib/wow/wow.min.js"></script>
	<script
		src="https://maps.googleapis.com/maps/api/js?key=AIzaSyD8HeI8o-c1NppZA-92oYlXakhDPYR7XMY"></script>

	<script src="lib/waypoints/waypoints.min.js"></script>
	<script src="lib/counterup/counterup.min.js"></script>
	<script src="lib/superfish/hoverIntent.js"></script>
	<script src="lib/superfish/superfish.min.js"></script>

	<!-- Contact Form JavaScript File -->
	<script src="contactform/contactform.js"></script>

	<!-- Template Main Javascript File -->
	<script src="js/main.js"></script>

</body>
</html>
