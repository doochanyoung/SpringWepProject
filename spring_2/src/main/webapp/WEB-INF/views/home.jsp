<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page pageEncoding="utf-8" session="true"%>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="utf-8">
<title>Doo & Gae & CHUNG WEPPAGE</title>
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

<!-- Bootstrap Icon Library -->
<link rel="stylesheet"
	href="https://use.fontawesome.com/releases/v5.1.1/css/all.css"
	integrity="sha384-O8whS3fhG2OnA5Kas0Y9l3cfpmYjapjI0E4theH4iuMD+pLhbf6JI0jIMfYcK3yZ"
	crossorigin="anonymous">

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
				<a href="<c:url value='/'/>"><img src="img/LOGO2-TEST.png" alt=""
					title="" /></img></a>
				<!-- Uncomment below if you prefer to use a text logo -->
				<!--<h1><a href="#hero">Regna</a></h1>-->
			</div>

			<nav id="nav-menu-container">
				<ul class="nav-menu">
					<li class="menu-active"><a href="<c:url value='/'/>">Home</a></li>
					<li><a href="<c:url value='/portfolio'/>">Portfolio</a></li>
					<li><a href="#studies">Study</a></li>
					<li><a href="#communities">Comuunity</a></li>
					<c:choose>
						<c:when test="${not empty sessionScope.loginId}">
							<li>${sessionScope.loginId}님 반갑습니다.</li>
							<li class="menu-has-children"><a href="#">회원 정보</a>
								<ul>
									<li><a href="/login/logout">로그아웃</a></li>
									<li><a href="/user/userModify">정보 수정</a></li>
									<li><a href="/user/userProfile">프로필</a></li>
									<li><a href="/user/messageList">메세지함</a></li>
								</ul>
							</li>
						</c:when>
							
						<c:otherwise>
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
									</ul></li>
							</ul></li>
						</c:otherwise>
					</c:choose>
				</ul>
			</nav>
			<!-- #nav-menu-container -->
		</div>
	</header>
	<!-- #header -->
	
	
	<!--==========================
    Hero Section
  ============================-->
	<section id="hero">
		<div class="hero-container">
			<h1>Welcome to DGC</h1>
			<h3>DGC의 Spring 개발 프로젝트 페이지입니다.</h3>
			<a href="#about" class="btn-get-started">Get Started</a>
		</div>
	</section>
	<!-- #hero -->

	<!--==========================
    About Section
  ============================-->
	<section id="about">
		<div class="container">
			<div class="row about-container">

				<div class="col-lg-6 content order-lg-1 order-2">
					<h2 class="title" align="center">D & G & C</h2>
					<p>위 페이지는 컴퓨터공학과의 전공 지식과 여러 IT에 관한 지식들을 공유하고 알려주기 위한 목적을 가진
						커뮤니티 사이트입니다.</p>

					<div class="icon-box wow fadeInUp">
						<div class="icon">
							<i class="fa fa-shopping-bag"></i>
						</div>
						<h4 class="title">
							<a href="">두찬영</a>
						</h4>
						<p class="description">부산외국어대학교 컴퓨터공학과 13학번</p>
					</div>

					<div class="icon-box wow fadeInUp" data-wow-delay="0.2s">
						<div class="icon">
							<i class="fa fa-photo"></i>
						</div>
						<h4 class="title">
							<a href="">김태훈</a>
						</h4>
						<p class="description">부산외국어대학교 컴퓨터공학과 13학번</p>
					</div>

					<div class="icon-box wow fadeInUp" data-wow-delay="0.4s">
						<div class="icon">
							<i class="fa fa-bar-chart"></i>
						</div>
						<h4 class="title">
							<a href="">이화섭</a>
						</h4>
						<p class="description">부산외국어대학교 컴퓨터공학과 13학번</p>
					</div>

				</div>

				<div class="col-lg-6 background order-lg-2 order-1 wow fadeInRight"></div>
			</div>

		</div>
	</section>
	<!-- #about -->

	<!--==========================
      Studies Section
    ============================-->

	<section id="studies">
		<div class="container wow fadeIn">
			<div class="section-header">
				<h3 class="section-title">Study</h3>
				<p class="section-description"></p>
			</div>
			<div class="row">
				<div class="col-lg-4 col-md-6 wow fadeInUp" data-wow-delay="0.2s">
					<div class="card">
						<div class="card-header">
							<div class="row">
								<div class="icon">
									<a href=""><i class="fa fa-comments"></i></a>
								</div>
								<h4 class="title">
									<a href="<c:url value='/board/boardList'/>">&nbsp;Free</a>
								</h4>
							</div>
						</div>
						<p class="description">Voluptatum deleniti atque corrupti quos
							dolores et quas molestias excepturi sint occaecati cupiditate non
							provident</p>
					</div>
				</div>
				<div class="col-lg-4 col-md-6 wow fadeInUp" data-wow-delay="0.4s">
					<div class="card">
						<div class="icon">
							<a href=""><i class="fab fa-chrome"></i>
						</div>
						<h4 class="title">
							<a href="">WEB</a>
						</h4>
						<p class="description">Minim veniam, quis nostrud exercitation
							ullamco laboris nisi ut aliquip ex ea commodo consequat tarad
							limino ata</p>
					</div>
				</div>
				<div class="col-lg-4 col-md-6 wow fadeInUp" data-wow-delay="0.6s">
					<div class="card">
						<div class="icon">
							<a href=""><i class="fab fa-cuttlefish"></i></a>
						</div>
						<h4 class="title">
							<a href="">C</a>
						</h4>
						<p class="description">Duis aute irure dolor in reprehenderit
							in voluptate velit esse cillum dolore eu fugiat nulla pariatur</p>
					</div>
				</div>

				<div class="col-lg-4 col-md-6 wow fadeInUp" data-wow-delay="0.2s">
					<div class="card">
						<div class="icon">
							<a href=""><i class="fab fa-android"></i></a>
						</div>
						<h4 class="title">
							<a href="">Android</a>
						</h4>
						<p class="description">Excepteur sint occaecat cupidatat non
							proident, sunt in culpa qui officia deserunt mollit anim id est
							laborum</p>
					</div>
				</div>
				<div class="col-lg-4 col-md-6 wow fadeInUp" data-wow-delay="0.4s">
					<div class="card">
						<div class="icon">
							<a href=""><i class="fab fa-java"></i></a>
						</div>
						<h4 class="title">
							<a href="">JAVA</a>
						</h4>
						<p class="description">At vero eos et accusamus et iusto odio
							dignissimos ducimus qui blanditiis praesentium voluptatum
							deleniti atque</p>
					</div>
				</div>
				<div class="col-lg-4 col-md-6 wow fadeInUp" data-wow-delay="0.6s">
					<div class="card">
						<div class="icon">
							<a href=""><i class="fab fa-python"></i></a>
						</div>
						<h4 class="title">
							<a href="">Python</a>
						</h4>
						<p class="description">Et harum quidem rerum facilis est et
							expedita distinctio. Nam libero tempore, cum soluta nobis est
							eligendi</p>
					</div>
				</div>
			</div>

			<div class="row">
				<div class="col-lg-4 col-md-6 wow fadeInUp" data-wow-delay="0.2s">
					<div class="card">
						<div class="icon">
							<a href=""><i class="fa fa-database"></i></a>
						</div>
						<h4 class="title">
							<a href="">Database</a>
						</h4>
						<p class="description">Excepteur sint occaecat cupidatat non
							proident, sunt in culpa qui officia deserunt mollit anim id est
							laborum</p>
					</div>
				</div>
				<div class="col-lg-4 col-md-6 wow fadeInUp" data-wow-delay="0.4s">
					<div class="card">
						<div class="icon">
							<a href=""><i class="fas fa-server"></i></a>
						</div>
						<h4 class="title">
							<a href="">server</a>
						</h4>
						<p class="description">At vero eos et accusamus et iusto odio
							dignissimos ducimus qui blanditiis praesentium voluptatum
							deleniti atque</p>
					</div>
				</div>
				<div class="col-lg-4 col-md-6 wow fadeInUp" data-wow-delay="0.6s">
					<div class="card">
						<div class="icon">
							<a href=""><i class="fas fa-lock"></i></a>
						</div>
						<h4 class="title">
							<a href="">security</a>
						</h4>
						<p class="description">Et harum quidem rerum facilis est et
							expedita distinctio. Nam libero tempore, cum soluta nobis est
							eligendi</p>
					</div>
				</div>
			</div>
		</div>
	</section>


	<!--==========================
      Services Section
    ============================-->

	<section id="communities">
		<div class="container wow fadeIn">
			<div class="section-header">
				<h3 class="section-title">Community</h3>
				<p class="section-description">각 분야별 게시판을 활용하여 소통해보세요.</p>
			</div>
			<div class="row">
				<div class="col-lg-4 col-md-6 wow fadeInUp" data-wow-delay="0.2s">
					<div class="box">
						<div class="icon">
							<a href=""><i class="fa fa-desktop"></i></a>
						</div>
						<h4 class="title">
							<a href="/board/boardList">자유게시판</a>
						</h4>
						<p class="description">자유게시판</p>
					</div>
				</div>
				<div class="col-lg-4 col-md-6 wow fadeInUp" data-wow-delay="0.4s">
					<div class="box">
						<div class="icon">
							<a href=""><i class="fa fa-bar-chart"></i></a>
						</div>
						<h4 class="title">
							<a href="/board/dataroomList">자료실</a>
						</h4>
						<p class="description">자료실</p>
					</div>
				</div>
				<div class="col-lg-4 col-md-6 wow fadeInUp" data-wow-delay="0.6s">
					<div class="box">
						<div class="icon">
							<a href=""><i class="fa fa-paper-plane"></i></a>
						</div>
						<h4 class="title">
							<a href="">사진첩</a>
						</h4>
						<p class="description">사진첩</p>
					</div>
				</div>
			</div>
	</section>








	<!--==========================
      Team Section
    ============================-->

	<section id="team">
		<div class="container wow fadeInUp">
			<div class="section-header">
				<h3 class="section-title">Team</h3>
				<p class="section-description">D & G & C의 개발자 소개</p>
			</div>
			<div class="row" align="center">
				<div class="col-lg-4 col-md-6">
					<div class="member">
						<div class="pic">
							<img src="img/doo.jpg" alt="">
						</div>
						<h4>두찬영</h4>
						<span>Programming Web Developer</span>
						<div class="social">
							<a href=""><i class="fab fa-twitter"></i></a> <a href=""><i
								class="fab fa-facebook"></i></a> <a href=""><i
								class="fab fa-google-plus"></i></a> <a href=""><i
								class="fab fa-linkedin"></i></a>
						</div>
					</div>
				</div>

				<div class="col-lg-4 col-md-6">
					<div class="member">
						<div class="pic">
							<img src="img/gaetaeng.jpg" alt="">
						</div>
						<h4>김태훈</h4>
						<span>Programming Web Developer</span>
						<div class="social">
							<a href=""><i class="fab fa-twitter"></i></a> <a href=""><i
								class="fab fa-facebook"></i></a> <a href=""><i
								class="fab fa-google-plus"></i></a> <a href=""><i
								class="fab fa-linkedin"></i></a>
						</div>
					</div>
				</div>

				<div class="col-lg-4 col-md-6">
					<div class="member">
						<div class="pic">
							<img src="img/chungma.jpg" alt="">
						</div>
						<h4>이화섭</h4>
						<span>Programming Web Developer</span>
						<div class="social">
							<a href=""><i class="fab fa-twitter"></i></a> <a href=""><i
								class="fab fa-facebook"></i></a> <a href=""><i
								class="fab fa-google-plus"></i></a> <a href=""><i
								class="fab fa-linkedin"></i></a>
						</div>
					</div>
				</div>
			</div>
	</section>

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
					<div class="copyright">
						<div class="row">부산외국어대학교 I412 알고리즘 연구/개발실</div>
						<div class="row">
							두찬영 Doodoo 010-2436-xxxx&nbsp;<a href="">dcy93@naver.com</a>
						</div>
						<div class="row">
							김태훈 Gaetang 010-7576-xxxx&nbsp;<a href="">nuckly60@gmail.com</a>
						</div>
						<div class="row">
							이화섭 Chungma 010-5650-xxxx&nbsp;<a href="">hwasub1115@naver.com</a>
						</div>
					</div>
				</div>
			</div>
		</div>
	</footer>
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
