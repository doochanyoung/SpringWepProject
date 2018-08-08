<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
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
<link href="../img/favicon.png" rel="icon">
<link href="../img/apple-touch-icon.png" rel="apple-touch-icon">

<!-- Google Fonts -->
<link
	href="https://fonts.googleapis.com/css?family=Open+Sans:300,300i,400,400i,700,700i|Poppins:300,400,500,700"
	rel="stylesheet">

<!-- Bootstrap CSS File -->
<link href="../lib/bootstrap/css/bootstrap.min.css" rel="stylesheet">

<!-- Libraries CSS Files -->
<link href="../lib/font-awesome/css/font-awesome.min.css"
	rel="stylesheet">
<link href="../lib/animate/animate.min.css" rel="stylesheet">

<!-- Main Stylesheet File -->
<link href="../css/style.css" rel="stylesheet">

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
	<header>
		<nav class="navbar navbar-expand-lg navbar-dark bg-dark">
			<a class="navbar-brand nav-menu" href="/board/boardList">Community&nbsp;</a>
			<button class="navbar-toggler" type="button" data-toggle="collapse"
				data-target="#navbarSupportedContent"
				aria-controls="navbarSupportedContent" aria-expanded="false"
				aria-label="Toggle navigation">
				<span class="navbar-toggler-icon"></span>
			</button>

			<div class="collapse navbar-collapse" id="navbarSupportedContent">
				<ul class="navbar-nav nav-menu">
					<li class="nav-item"><a href="<c:url value='/'/>">Home</a></li>
					<li class="nav-item"><a href="/board/boardList">Board</a></li>
					<li class="nav-item"><a href="/dataroom/dataroomList">Data Room</a></li>
					<li class="nav-item  menu-active"><a href="/gallery/galleryList">Gallery</a></li>
					<li class="nav-item menu-has-children"><a href="">로그인을 하세요</a>
						<ul class="navbar-nav">
							<li class="nav-item"><a href="<c:url value='/login'/>">로그인</a></li>
							<li class="nav-item"><a href="<c:url value='/register'/>">회원가입</a></li>
							<li class="menu-has-children"><a href="#">Drop Down 2</a>
								<ul class="navbar-nav">
									<li class="nav-item"><a href="#">Deep Drop Down 1</a></li>
									<li class="nav-item"><a href="#">Deep Drop Down 2</a></li>
									<li class="nav-item"><a href="#">Deep Drop Down 3</a></li>
									<li class="nav-item"><a href="#">Deep Drop Down 4</a></li>
									<li class="nav-item"><a href="#">Deep Drop Down 5</a></li>
								</ul></li>
						</ul></li>
					<!-- <li><a href="#contact">로그인버튼생성</a></li> -->
				</ul>
			</div>
		</nav>
	</header>
	<!-- #header -->


	<!--==========================
      Services Section
    ============================-->

	<section id="boards">
		<div class="container">
			<div class="section-header m-5">
				<h3 class="section-title">갤러리</h3>
				<p class="section-description">갤러리를 활용하여 많은 사진을 구경해 보세요.</p>
			</div>
			<div class="card m-4">
				<div class="card-header">Search</div>
				<div class="card-body">
					<div class="row">
						<div class="col-7">
							<div class="form-group">
								<input type="text" class="form-control"
									id="keyword" name="keyword" placeholder="search...." value="${pageHandler.keyword }">
							</div>
						</div>
						<div class="col-2">
							<select class="custom-select" id="searchType" name="searchType">
								<option value="none" id="select" <c:out value="${pageHandler.searchType == null ? 'selected':'' }" />>-------</option>
								<option value="title" id="select" <c:out value="${pageHandler.searchType eq 'title' ? 'selected':'' }" />>제목</option>
								<option value="writer" id="select" <c:out value="${pageHandler.searchType eq 'writer' ? 'selected':'' }" />>작성자</option>
							</select>
						</div>
						<div class="col-1">
							<div class="text-center">
								<button class="btn btn-default float-left" id="searchButton" type="button">검색</button>
							</div>
						</div>
					</div>
				</div>
			</div>
			<hr class="my-4">
			<div class="row">
				<table class="table table-striped table-sm"
					style="text-align: center; border: 1px solid #dddddd">
					<thead>
						<tr>
							<th class="mobile" scope="col">id</th>
							<th scope="col">제목</th>
							<th class="mobile" scope="col">작성자</th>
							<th class="mobile" scope="col">작성일</th>
							<th class="mobile" scope="col">조회수</th>
							<th class="mobile" scope="col">좋아요</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${list}" var="galleryVO">
							<tr>
								<th class="mobile" scope="row">${galleryVO.galleryId }</th>
								<td><a href='/gallery/galleryRead${pageMaker.makeSearch(pageMaker.pageHandler.page)}&galleryId=${galleryVO.galleryId}'>${galleryVO.galleryTitle }</a></td>
								<td class="mobile">${galleryVO.galleryUserId }</td>
								<td class="mobile"><fmt:formatDate pattern="yyyy-MM-dd HH:mm" value="${galleryVO.galleryRegdate }"/></td>
								<td class="mobile">${galleryVO.galleryHit }</td>
								<td class="mobile">${galleryVO.galleryLike }</td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
				<div class="text-center">
					<c:if test="${not empty loginId}">
					<button class="btn btn-default float-right m-2" type="button" id="galleryWrite">글 작성</button>
					</c:if>
				</div>
			</div>
		</div>
		<nav>
			<ul class="pagination pagination-info justify-content-center">
				<c:if test="${pageMaker.prev }">
				<li class="page-item"><a class="page-link" href="galleryList${pageMaker.makeSearch(pageMaker.startPage - 1) }" aria-label="Previous"> <span aria-hidden="true">&laquo;</span>
						<span class="sr-only">Previous</span></a></li>
				</c:if>
				<c:forEach begin="${pageMaker.startPage }" end="${pageMaker.endPage }" var="idx">
					<li class = "page-item <c:out value="${pageMaker.pageHandler.page == idx ? 'active' : ''}" />">
					<a class="page-link" href="galleryList${pageMaker.makeSearch(idx)}">${idx }</a>
					</li>
				</c:forEach>
				<c:if test="${pageMaker.next && pageMaker.endPage > 0 }">
				<li class="page-item"><a class="page-link" href="galleryList${pageMaker.makeSearch(pageMaker.endPage + 1) }" aria-label="Next"> <span aria-hidden="true">&raquo;</span> <span
						class="sr-only">Next</span></a></li>
				</c:if>
			</ul>
		</nav>
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
	<script src="../lib/jquery/jquery.min.js"></script>
	<script src="../lib/jquery/jquery-migrate.min.js"></script>
	<script src="../lib/bootstrap/js/bootstrap.bundle.min.js"></script>
	<script src="../lib/easing/easing.min.js"></script>
	<script src="../lib/wow/wow.min.js"></script>
	<script
		src="https://maps.googleapis.com/maps/api/js?key=AIzaSyD8HeI8o-c1NppZA-92oYlXakhDPYR7XMY"></script>

	<script src="../lib/waypoints/waypoints.min.js"></script>
	<script src="../lib/counterup/counterup.min.js"></script>
	<script src="../lib/superfish/hoverIntent.js"></script>
	<script src="../lib/superfish/superfish.min.js"></script>

	<!-- Contact Form JavaScript File -->
	<script src="../contactform/contactform.js"></script>

	<!-- Template Main Javascript File -->
	<script src="../js/main.js"></script>
	
	<script>
		$(document).ready(function() {
			$('#galleryWrite').on("click", function(ext) {
				self.location = "galleryWrite";
			});
			$("#searchButton").on("click", function(event){
				self.location = "galleryList" + '${pageMaker.makeQuery(1)}' + "&searchType=" + $("#searchType option:selected").val()
				+ "&keyword=" + encodeURIComponent($('#keyword').val());
			});
		});
	</script>
</body>
</html>
