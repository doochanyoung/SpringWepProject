<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" session="true"%>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta http-equiv="Content-Type" content="text/html;" charset="UTF-8">
<title> Doo & GAE & CHUNG WEPPAGE</title>
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
			<a class="navbar-brand nav-menu" href="/dataroom/dataroomList">User&nbsp;</a>
			<button class="navbar-toggler" type="button" data-toggle="collapse"
				data-target="#navbarSupportedContent"
				aria-controls="navbarSupportedContent" aria-expanded="false"
				aria-label="Toggle navigation">
				<span class="navbar-toggler-icon"></span>
			</button>

			<div class="collapse navbar-collapse" id="navbarSupportedContent">
				<ul class="navbar-nav nav-menu">
					<li class="nav-item"><a href="<c:url value='/'/>">Home</a></li>
					<li class="nav-item"><a href="/user/userModify">modify</a></li>
					<li class="nav-item"><a href="/user/userProfile">profile</a></li>
					<li class="nav-item menu-active"><a href="/user/userProfile">message</a></li>
				</ul>
			</div>
		</nav>
	</header>
	<!-- #header -->


	<!--==========================
      datarooms Section
    ============================-->

	<section id="messages">
		<div class="container">
			<div class="section-header m-5">
				<h3 class="section-title">메세지 보관함</h3>
				<p class="section-description">메시지를 확인하세요!</p>
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
								<option value="sender" id="select" <c:out value="${pageHandler.searchType eq 'sender' ? 'selected':'' }" />>보낸자</option>
								<option value="content" id="select" <c:out value="${pageHandler.searchType eq 'content' ? 'selected':'' }" />>내용</option>
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
							<th class="mobile" scope="col">메세지번호</th>
							<th class="mobile" scope="col">내용</th>
							<th class="mobile" scope="col">보낸사람</th>
							<th class="mobile" scope="col">보낸날짜</th>
							<th class="mobile" scope="col">읽은날짜</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${list}" var="messageVO">
							<tr>
								<th class="mobile" scope="row">${messageVO.messageId}</th>
								<td><a href='/user/messageRead${pageMaker.makeSearch(pageMaker.pageHandler.page)}&messageId=${messageVO.messageId}'>${messageVO.messageContent}</a></td>
								<td class="mobile">${messageVO.messageSender }</td>
								<td class="mobile"><fmt:formatDate pattern="yyyy-MM-dd HH:mm" value="${messageVO.messageSendDate }"/></td>
								<td class="mobile"><fmt:formatDate pattern="yyyy-MM-dd HH:mm" value="${messageVO.messageOpendate }"/></td>			
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
		</div>
		<nav>
			<ul class="pagination pagination-info justify-content-center">
				<c:if test="${pageMaker.prev }">
				<li class="page-item"><a class="page-link" href="messageList${pageMaker.makeSearch(pageMaker.startPage - 1) }" aria-label="Previous"> <span aria-hidden="true">&laquo;</span>
						<span class="sr-only">Previous</span></a></li>
				</c:if>
				<c:forEach begin="${pageMaker.startPage }" end="${pageMaker.endPage }" var="idx">
					<li class = "page-item <c:out value="${pageMaker.pageHandler.page == idx ? 'active' : ''}" />">
					<a class="page-link" href="messageList${pageMaker.makeSearch(idx)}">${idx }</a>
					</li>
				</c:forEach>
				<c:if test="${pageMaker.next && pageMaker.endPage > 0 }">
				<li class="page-item"><a class="page-link" href="messageList${pageMaker.makeSearch(pageMaker.endPage + 1) }" aria-label="Next"> <span aria-hidden="true">&raquo;</span> <span
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
	
	<!-- Template Main Javascript File -->
	<script src="../js/main.js"></script>
	<script src="../js/upload.js"></script>
	
	<script>
		$(document).ready(function() {
			  $('#formRegister').submit(function(e) {
				e.preventDefault();
			    $(".error").remove();
			    var valid = true;
			    if ($('#userName').val().length < 1) {
				      $('#userName').after('<span class="error" style="color:red;"><small>This field is required</small></span>');
				      valid = false;
				    } else if ($('#userName').val().length > 45) {
					      $('#userName').after('<span class="error" style="color:red;"><small>please write less than 45 charactors...</small></span>');
					      valid = false;
					}
			    if ($('#userNickname').val().length < 1) {
				      $('#userNickname').after('<span class="error" style="color:red;"><small>This field is required</small></span>');
				      valid = false;
				    } else if ($('#userNickname').val().length > 45) {
					      $('#userNickname').after('<span class="error" style="color:red;"><small>please write less than 45 charactors...</small></span>');
					      valid = false;
					}
			    if ($('#userPassword').val().length < 1) {
				      $('#userPassword').after('<span class="error" style="color:red;"><small>This field is required</small></span>');
				      valid = false;
				    } else if ($('#userPassword').val().length > 45) {
					      $('#userPassword').after('<span class="error" style="color:red;"><small>please write less than 45 charactors...</small></span>');
					      valid = false;
					}
			    if($('#userPassword').val() != $('#userPasswordCheck').val()){
			    	 $('#userPassword').after('<span class="error" style="color:red;"><small>Password and PasswordCheck have to same.</small></span>');
			    	 valid = false;
			    }
			    if ($('#userEmail').val().length < 1) {
			      $('#userEmail').after('<span class="error" style="color:red;"><small>This field is required</small></span>');
			      valid = false;
			    } else if ($('#userEmail').val().length > 45) {
				      $('#userEmail').after('<span class="error" style="color:red;"><small>please write less than 45 charactors...</small></span>');
				      valid = false;
				}
			    if ($('#userPhone').val().length < 1) {
				      $('#userPhone').after('<span class="error" style="color:red;"><small>This field is required</small></span>');
				      valid = false;
			 	}  else if ($('#userPhone').val().length > 45) {
					   $('#userPhone').after('<span class="error" style="color:red;"><small>please write less than 45 charactors...</small></span>');
					   valid = false;
				}
			    if ($('#userIntro').val().length < 1) {
				      $('#userIntro').after('<span class="error" style="color:red;"><small>This field is required</small></span>');
				      valid = false;
			 	}  else if ($('#userIntro').val().length > 1024) {
					   $('#userIntro').after('<span class="error" style="color:red;"><small>please write less than 1024 charactors...</small></span>');
					   valid = false;
				}
			    if(valid){
			    	document.getElementById("formRegister").submit();
			    }
			  });
		});
	</script>
</body>
</html>
