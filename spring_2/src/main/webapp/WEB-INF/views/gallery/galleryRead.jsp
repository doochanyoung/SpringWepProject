<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
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

<script src="../ckeditor/ckeditor.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/handlebars.js/3.0.1/handlebars.js"></script>

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
			<a class="navbar-brand nav-menu" href="/gallery/galleryList">Community&nbsp;</a>
			<button class="navbar-toggler" type="button" data-toggle="collapse"
				data-target="#navbarSupportedContent"
				aria-controls="navbarSupportedContent" aria-expanded="false"
				aria-label="Toggle navigation">
				<span class="navbar-toggler-icon"></span>
			</button>

			<div class="collapse navbar-collapse" id="navbarSupportedContent">
				<ul class="navbar-nav nav-menu">
					<li class="nav-item"><a href="<c:url value='/'/>">Home</a></li>
					<li class="nav-item"><a href="/gallery/galleryList">Board</a></li>
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
   ards Section
    ============================-->

	<section id="boards">
		<div class="container py-5">
			<div class="row">
				<div class="col-md-12">
					<div class="row">
						<div class="col-md-10 mx-auto">
							<!-- form card login -->
							<div class="card">
								<div class="card-header">
									<h3 class="title">Read</h3>
								</div>
								<div class="card-body">
									<form class="form" role="form" method="post">
										<input type="hidden" name="galleryId" id="galleryId"
											value="${galleryVO.galleryId }"> <input type="hidden"
											name="page" id="page" value="${pageHandler.page }"> <input
											type="hidden" name="perPageNum" id="perPageNum"
											value="${pageHandler.perPageNum }"> <input
											type="hidden" name="searchType" id="searchType"
											value="${pageHandler.searchType }"> <input
											type="hidden" name="keyword" id="keyword"
											value="${pageHandler.keyword }">
									</form>
									<div class="form-group">
										<label for="title" class="text">Title</label> <input
											type="text" class="form-control form-control-lg"
											name="galleryTitle" id="galleryTitle" placeholder="write Title"
											readonly="readonly" value="${galleryVO.galleryTitle }">
									</div>
									<div class="form-group">
										<label for="writer" class="text">Writer</label> <input
											type="text" class="form-control form-control-lg"
											name="galleryUserId" id="galleryUserId" readonly="readonly"
											value="${galleryVO.galleryUserId }">
									</div>
									<div class="row">
										<div class="col-4">
											<span><strong>조회수</strong> : ${galleryVO.galleryHit }</span>
										</div>
										<div class="col-4">
											<span><strong>좋아요</strong> : ${galleryVO.galleryLike }</span>
										</div>
										<div class="col-4">
											<span><strong>작성일</strong> : <fmt:formatDate
													pattern="yyyy-MM-dd HH:mm" value="${galleryVO.galleryRegdate }" /></span>
										</div>
									</div>
									<hr>
									<ul class="mailbox-attachments clearfix uploadedList" style="list-style:none;">
										
									</ul>
									<hr>
									<div class="row">
									<c:if test="${loginId == galleryVO.galleryUserId}">
										<button class="btn btn-default btn-sm ml-3" id="galleryModify"
											type="button">Modify</button>
										<button class="btn btn-default btn-sm ml-3" id="galleryRemove"
											type="button" style="background: #FF6C6C;">Remove</button>
									</c:if>
										<button class="btn btn-default btn-sm ml-3" id="galleryList"
											type="button" style="background: #5AAEFF">List</button>
											<button class="btn btn-default btn-sm ml-3" id="galleryLike"
											type="submit" style="background: #ABF200">Like</button>
									</div>
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
		
	</section>
	<!-- #gallerys -->

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

	<!-- Template Main Javascript File -->
	<script src="../js/main.js"></script>
	<script src="../js/upload.js"></script>

	<script>
		$(document).ready(function() {
			var formObj = $("form[role='form']");
			var galleryId = $('#galleryId').val();
			$("#galleryModify").on("click", function() {
				formObj.attr("action", "/gallery/galleryModify");
				formObj.attr("method", "get");
				formObj.submit();
			});
			$("#galleryRemove").on("click", function() {
				var bool = confirm("정말 삭제 하시겠습니까?");
				if (bool) {
					var arr = [];
					$(".uploadedList li").each(function(index){
						arr.push($(this).attr("data-src"));
					});
					if(arr.length > 0){
						$.post("/deleteAllFiles",{files:arr}, function(){});
					}
					formObj.attr("action", "/gallery/galleryDelete");
					formObj.submit();
				}
			});
			$("#galleryList").on("click", function() {
				formObj.attr("action", "/gallery/galleryList");
				formObj.attr("method", "get");
				formObj.submit();
			});
		});
	</script>
	
	<script id="templateAttach" type="text/x-handlebars-template">
	<li data-src='{{fullName}}'>
  		<span><img src="{{getLink}}" alt="Attachment"></span>
	</li>
	<hr>          
	</script>
	<script>
		$.ajaxSetup({cache : false});
		var galleryId = ${galleryVO.galleryId};
		var replyPage = 1;
		var templateAttach = Handlebars.compile($("#templateAttach").html());
		$.getJSON("/gallery/getAttach/"+galleryId, function(list){
			$(list).each(function(){
				var fileInfo = getFileInfo(this);
				var html = templateAttach(fileInfo);
				$(".uploadedList").append(html);
			});
		});
	</script>
</body>
</html>