<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta http-equiv="Content-Type" content="text/html;" charset="UTF-8">
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
					<li class="nav-item menu-active"><a href="/gallery/galleryList">Gallery</a></li>
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
      gallerys Section
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
									<h3 class="title">Write</h3>
								</div>
								<div class="card-body">
									<form class="form" action="/gallery/galleryWrite"
										autocomplete="off" id="formBoard" method="POST"
										class="contactForm" role="form">
										<div class="form-group">
											<label for="title" class="text">Title</label>
											<input type="text" class="form-control form-control-lg"
												name="galleryTitle" id="galleryTitle" placeholder="write Title">
											<div class="validation"></div>
										</div>
										<div class="form-group">
											<input type="hidden" class="form-control form-control-lg"
												name="galleryUserId" id="galleryUserId" value="${loginId }">
											<div class="validation"></div>
										</div>
										<div class="fileDrop" style="border: 1px dotted blue; height:100px; text-align:center;">drag file</div>
										<ul class="mailbox-attachments clearfix uploadedList">
										
										</ul>
										<div class="text-center mt-2">
											<button class="btn btn-default btn-sm btn-block"
												id="gallerySave" type="submit">Submit</button>
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
	
	<script id="templateAttach" type="text/x-handlebars-template">
	<li>
  		<span class="mailbox-attachment-icon has-img"><img src="{{imgsrc}}" alt="Attachment">
		<a href="{{fullName}}" class="btn btn-default btn-xs pull-right delbtn"><i class="fa fa-fw fa-remove"></i></a></span>
  		<div class=	"mailbox-attachment-info">
			<a href="{{getLink}}" class="mailbox-attachment-name">{{fileName}}</a>
 	 	</div>
	</li>              
	</script>

	<script>
		$(document).ready(function() {
			  $('#formBoard').submit(function(e) {
				e.preventDefault();
			    var galleryTitle = $('#galleryTitle').val();
			    var galleryUserId = $('#galleryUserId').val();
			    $(".error").remove();
			    var valid = true;
			    if (galleryTitle.length < 1) {
			      $('#galleryTitle').after('<span class="error" style="color:red;"><small>This field is required</small></span>');
			      valid = false;
			    } else if (galleryTitle.length > 45) {
				      $('#galleryTitle').after('<span class="error" style="color:red;"><small>please write less than 45 charactors...</small></span>');
				      valid = false;
				}
			    if (galleryUserId.length < 1) {
			      $('#galleryUserId').after('<span class="error" style="color:red;"><small>This field is required</small></span>');
			      valid = false;
			    } else if (galleryUserId.length > 45) {
				      $('#galleryUserId').after('<span class="error" style="color:red;"><small>please write less than 45 charactors...</small></span>');
				      valid = false;
				}
			    if(valid){
					var that = $(this);
					var str = "";
					$(".uploadedList .delbtn").each(function(index){
						str += "<input type='hidden' name='files["+index+"]' value='" + $(this).attr("href") + "'> ";
					});
					that.append(str);
					that.get(0).submit();
			    }
			  });
		});
	</script>
	<script>
		var template = Handlebars.compile($("#templateAttach").html());
		$(".fileDrop").on("dragenter dragover", function(event){ //파일을 드래그 했을때 화면에 사진 뜨는거  방지
			event.preventDefault();
		});
		$(".fileDrop").on("drop", function(event) {
			event.preventDefault();
			var files = event.originalEvent.dataTransfer.files;
			var file = files[0];
			var formData = new FormData();
			formData.append("file", file);
			$.ajax({
				url : '/uploadAjax',
				data : formData,
				dataType : 'text',
				processData : false,
				contentType : false,
				type : 'POST',
				success : function(data) {
					var fileInfo = getFileInfo2(data);
					var html = template(fileInfo);
					$(".uploadedList").append(html);
				}
			});
		});
		$(".uploadedList").on("click", ".delbtn", function(event) {
			event.preventDefault();
			var that = $(this);
			that.closest("li").remove();
		});
		function getOriginalName(fileName){
			if(checkImageType(fileName)){
				return;
			}
			var idx = fileName.indexOf("_") + 1;
			return fileName.substr(idx);
		}
		function getFileInfo2(fullName){
			var fileName, imgsrc, getLink;
			var fileLink;
			
			if(checkImageType(fullName)){
				imgsrc = "/displayFile2?fileName="+fullName;
				console.log(imgsrc);
				fileLink = fullName.substr(14);
				
				var front = fullName.substr(0, 12); // /2018/00/00
				var end = fullName.substr(14);
				getLink = "/displayFile2?fileName=" + front + end;
				console.log(getLink);
			}else{
				imgsrc = "/resources/img/file.png";
				fileLink = fullName.substr(12);
				getLink = "/displayFile2?fileName="+fullName;
			}
			fileName = fileLink.substr(fileLink.indexOf("_")+1);
			console.log(fileName);
			console.log(imgsrc);
			return {fileName: fileName, imgsrc:imgsrc, getLink:getLink, fullName:fullName};
		}
	</script>
</body>
</html>
