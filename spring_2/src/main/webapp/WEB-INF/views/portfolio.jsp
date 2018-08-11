<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page pageEncoding="utf-8" session="true"%>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="utf-8">
<title>GAE & Doo & CHUNG WEPPAGE</title>
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
<link href="css/style.css?ver=20180807-14" rel="stylesheet">

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
					<li>
					<a href="<c:url value='/'/>">Home</a>
					</li>
					<li class="menu-active"><a href="#">Portfolio</a></li>
					<li><a href="#studies">Study</a></li>
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
								</ul></li>
						</ul></li>
					<!-- <li><a href="#contact">로그인버튼생성</a></li> -->
				</ul>
			</nav>
			<!-- #nav-menu-container -->
		</div>
	</header>
	<script>
	function DooOver() {
		bodycheck = 1;
		bodyValue = "두찬영";
	}
	function GaeOver() {
		bodycheck = 2; 
		bodyValue = "김태훈";
	}
	function ChungOver() {
		bodycheck = 3;
		bodyValue = "이화섭";
	}
	function PortfolioOn() {

		document.getElementById("Doo").innerHTML="두찬영 (DooDoo)";
		document.getElementById("Gae").innerHTML="김태훈 (GaeTaeng)";
		document.getElementById("Chung").innerHTML="이화섭 (ChungMa)";
			document.getElementById("Doo").style.fontSize = "16px";
			document.getElementById("Gae").style.fontSize = "16px";
			document.getElementById("Chung").style.fontSize = "16px";
			
	}
	function PortfolioOut() { 
		document.getElementById("Doo").innerHTML="";
		document.getElementById("Gae").innerHTML="";
		document.getElementById("Chung").innerHTML="";
			document.getElementById("Doo").style.fontsize = "0px";
			document.getElementById("Gae").style.fontSize = "0px";
			document.getElementById("Chung").style.fontSize = "0px";

	}
	</script>
	
	<aside id="aside" onmouseover="PortfolioOn()" onmouseout="PortfolioOut()">
		<div class="container">
			<nav>
				<ul class="anside-nav-menu">
					<li onclick="DooOver()"><a id = "Doo" href="#" ></a></li>
					<li onclick="GaeOver()"><a id = "Gae" href="#"></a></li>
					<li onclick="ChungOver()"><a id = "Chung" href="#"></a></li>
				</ul>
			</nav>
		</div>
	</aside>
	
	<div id="div-body">
	</div>
	
	
	<section id="hero">
		
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
