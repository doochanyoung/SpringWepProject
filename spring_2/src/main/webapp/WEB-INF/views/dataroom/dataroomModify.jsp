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
<link href="../css/style.css?ver=1" rel="stylesheet">

<!-- Bootstrap Icon Library -->
<link rel="stylesheet"
	href="https://use.fontawesome.com/releases/v5.1.1/css/all.css"
	integrity="sha384-O8whS3fhG2OnA5Kas0Y9l3cfpmYjapjI0E4theH4iuMD+pLhbf6JI0jIMfYcK3yZ"
	crossorigin="anonymous">

<script src="../ckeditor/ckeditor.js"></script>

<script src="https://cdnjs.cloudflare.com/ajax/libs/handlebars.js/3.0.1/handlebars.js"></script>

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
					<li class="nav-item menu-active"><a href="/dataroom/dataroomList">Data
							Room</a></li>
					<li class="nav-item"><a href="/gallery/galleryList">Gallery</a></li>
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
      boards Section
    ============================-->

	<section id="boards">
		<div class="fluid-container py-5">
			<div class="row">
				<div class="col-md-12">
					<div class="row">
						<div class="col-md-10 mx-auto">
							<!-- form card login -->
							<div class="card">
								<div class="card-header">
									<h3 class="title">Modify</h3>
								</div>
								<div class="card-body">
									<form class="form" action="/dataroom/dataroomModify" role="form" method="post" id="formBoard">
										<input type="hidden" name="dataroomId" id="dataroomId" value="${dataroomVO.dataroomId }">
										<input type="hidden" name="page" id="page" value="${pageHandler.page }">
										<input type="hidden" name="perPageNum" id="perPageNum" value="${pageHandler.perPageNum }">
										<input type="hidden" name="searchType" id="searchType" value="${pageHandler.searchType }">
										<input type="hidden" name="keyword" id="keyword" value="${pageHandler.keyword }">
										<div class="form-group">
											<label for="title" class="text">Title</label> <input
												type="text" class="form-control form-control-lg"
												name="dataroomTitle" id="dataroomTitle" placeholder="write Title" value="${dataroomVO.dataroomTitle }">
										</div>
										<div class="form-group">
											<label for="writer" class="text">Writer</label> <input
												type="text" class="form-control form-control-lg"
												name="dataroomUserId" id="dataroomUserId" readonly="readonly" value="${dataroomVO.dataroomUserId }">
										</div>
										<div class="form-group">
											<label for="content" class="text">Content</label>
											<textarea class="form-control"
												placeholder="write content please......" id="dataroomContent"
												maxlength="40" name="dataroomContent">${dataroomVO.dataroomContent }</textarea>
										</div>
										<div class="fileDrop" style="border: 1px dotted blue; height:100px; text-align:center;">drag file</div>
										<ul class="mailbox-attachments clearfix uploadedList">
										
										</ul>
										<div class="row">
											<div class="col-4">
												<span><strong>조회수</strong> : ${dataroomVO.dataroomHit }</span>
											</div>
											<div class="col-4">
												<span><strong>좋아요</strong> : ${dataroomVO.dataroomLike }</span>
											</div>
											<div class="col-4">
												<span><strong>작성일</strong> : <fmt:formatDate pattern="yyyy-MM-dd HH:mm" value="${dataroomVO.dataroomRegdate }"/></span>
											</div>
										</div>
										<hr>
										<div class="row">									
											<button class="btn btn-default btn-sm ml-3" id="dataroomSave" type="button" style="background:#5AAEFF">Save</button>
											<button class="btn btn-default btn-sm ml-3" id="dataroomCancel" type="button" style="background:#FF6C6C;">Cancel</button>
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
	<!-- #boards -->

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
	<script src="../js/upload.js"></script>
	
	<script id="templateAttach" type="text/x-handlebars-template">
	<li>
  		<span class="mailbox-attachment-icon has-img"><img src="{{imgsrc}}" alt="Attachment"></span>
  		<div class=	"mailbox-attachment-info">
			<a href="{{getLink}}" class="mailbox-attachment-name">{{fileName}}</a>
			<a href="{{fullName}}" class="btn btn-default btn-xs pull-right delbtn"><i class="fa fa-fw fa-remove"></i></a>
 	 	</div>
	</li>                
	</script>

	<script>
		CKEDITOR.replace('dataroomContent', {
			 height: '600px',
			 resize_enabled: false
		});
		$(document).ready(function() {
			  $('#formBoard').submit(function(e) {
				e.preventDefault();
			    var dataroomTitle = $('#dataroomTitle').val();
			    var dataroomContent = CKEDITOR.instances.dataroomContent.getData();
			    var dataroomUserId = $('#dataroomUserId').val();
			    $(".error").remove();
			    var valid = true;
			    if (dataroomTitle.length < 1) {
			      $('#dataroomTitle').after('<span class="error" style="color:red;"><small>This field is required</small></span>');
			      valid = false;
			    } else if (dataroomTitle.length > 45) {
				      $('#dataroomTitle').after('<span class="error" style="color:red;"><small>please write less than 45 charactors...</small></span>');
				      valid = false;
				}
			    if (dataroomUserId.length < 1) {
			      $('#dataroomUserId').after('<span class="error" style="color:red;"><small>This field is required</small></span>');
			      valid = false;
			    } else if (dataroomUserId.length > 45) {
				      $('#dataroomUserId').after('<span class="error" style="color:red;"><small>please write less than 45 charactors...</small></span>');
				      valid = false;
				}
			    if (dataroomContent.length < 1) {
				      $('#dataroomContent').after('<span class="error" style="color:red;"><small>This field is required</small></span>');
				      valid = false;
			 	}  else if (dataroomContent.length > 4096) {
					   $('#dataroomContent').after('<span class="error" style="color:red;"><small>please write less than 4096 charactors...</small></span>');
					   valid = false;
				}
			    if(valid){
					var that = $(this);
					var str = "";
					var last = 0;
					var arr = [];
					$(".uploadedList .delbtn").each(function(index){
						str += "<input type='hidden' name='files["+index+"]' value='" + $(this).attr("href") + "'> ";
						arr.push($(this).attr("href"));
						last = index + 1;
					});
					$(dataroomContent).each(function (index, p) {
					    if ($(p).find('img').length > 0) {
					        $(p).find('img').each(function (index, img) {
					            var at = $(img).attr('src');
					            at = ''+at;
					            var date = at.substring(22, 34);
					            at = at.substr(34);
					            at = date + "_s" + at;
					            var isExist = false;
					            for(var i = 0; i < arr.length; i++){
					            	if(arr[i] == at){
					            		isExist = true;
					            		break;
					            	}
					            }
					            if(!isExist){
					            	 str += "<input type='hidden' name='files["+last+"]' value='" + at + "'> ";
					            }
					            last++;
					        });
					    }
					});
					that.append(str);
					that.get(0).submit();
			    }
			  });
		});
		var dataroomId = $('#dataroomId').val();
		var templateAttach = Handlebars.compile($("#templateAttach").html());
		$.getJSON("/dataroom/getAttach/"+dataroomId, function(list){
			$(list).each(function(){
				var fileInfo = getFileInfo(this);
				var html = templateAttach(fileInfo);
				$(".uploadedList").append(html);
			});
		});
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
					var fileInfo = getFileInfo(data);
					var html = templateAttach(fileInfo);
					$(".uploadedList").append(html);
				}
			});
		});
		$(document).ready(function(){
			var formObj = $("form[role='form']");
			var dataroomId = $('#dataroomId').val();
			var page = $('#page').val();
			var perPageNum = $('#perPageNum').val();
			var searchType = $('#searchType').val();
			var keyword = $('#keyword').val();
			$("#dataroomSave").on("click", function(){
				formObj.submit();
			});
			$("#dataroomCancel").on("click", function(){
				self.location = "/dataroom/dataroomRead?dataroomId=" + dataroomId +"&page=" + page + "&perPageNum=" + perPageNum
						+"&searchType=" + searchType + "&keyword=" + keyword;
			});
		});
		$(".uploadedList").on("click", ".delbtn", function(event) {
			event.preventDefault();
			var that = $(this);
			that.closest("li").remove();
		});
	</script>

</body>
</html>