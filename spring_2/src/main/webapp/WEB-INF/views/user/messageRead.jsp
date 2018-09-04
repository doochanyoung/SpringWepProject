<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ page pageEncoding="utf-8" session="true"%>

<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="utf-8">
<title>Doo & GAE & CHUNG WEPPAGE</title>
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
									<h3 class="title">Read</h3>
								</div>
								<div class="card-body">
									<form class="form" role="form" method="post">
										<input type="hidden" name="messageId" id="messageId" value="${messageVO.messageId }"> 
										<input type="hidden" name="page" id="page" value="${pageHandler.page }">
										<input type="hidden" name="perPageNum" id="perPageNum" value="${pageHandler.perPageNum }">
										<input type="hidden" name="searchType" id="searchType"value="${pageHandler.searchType }">
										<input type="hidden" name="keyword" id="keyword" value="${pageHandler.keyword }">
									</form>
									<div class="form-group">
										<label for="title" class="text">Sender</label>
										<input type="text" class="form-control form-control-lg" name="messageSender" id="messageSender" placeholder="write Title" readonly="readonly" value="${messageVO.messageSender }">
									</div>
									<div class="form-group">
										<label for="writer" class="text">Receiver</label>
										<input type="text" class="form-control form-control-lg" name="messageReceiver" id="messageReceiver" readonly="readonly" value="${messageVO.messageReceiver }">
									</div>
									<div class="form-group">
										<label for="content" class="text">Content</label>
										<textarea class="form-control"
											placeholder="write content please......" id="messageContent"
											maxlength="40" name="messageContent" readonly="readonly">${messageVO.messageContent }</textarea>
									</div>
									<div class="row">
										<div class="col-4">
											<span><strong>보낸날짜</strong> : <fmt:formatDate pattern="yyyy-MM-dd HH:mm" value="${messageVO.messageSendDate }" /></span>
										</div>
										<div class="col-4">
											<span><strong>확인날짜</strong> : <fmt:formatDate pattern="yyyy-MM-dd HH:mm" value="${messageVO.messageOpendate }" /></span>
										</div>
									</div>
									<hr>
									<ul class="mailbox-attachments clearfix uploadedList">
										
									</ul>
									<hr>
									<div class="row">
									<c:if test="${messageId == messageVO.messageId}">
										<button class="btn btn-default btn-sm ml-3" id="messageRemove"
											type="button" style="background: #FF6C6C;">Remove</button>
									</c:if>
										<button class="btn btn-default btn-sm ml-3" id="messageList"
											type="button" style="background: #5AAEFF">List</button>
										<c:if test="${not empty messageId }">
										<button class="btn btn-default btn-sm ml-3"
											id="messageViewComment" type="button"
											style="background: #7536CF">ViewComment <strong id="commentCnt">[${messageVO.messageContent}]</strong></button>
										</c:if>
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
		<!--/container-->
		<!-- handlebars -->
		<div id="commentlists">
		
		</div>
		<nav>
			<ul class="pagination pagination-info justify-content-center">

			</ul>
		</nav>
		<div id="modifyModal" class="modal modal-primary fade" role="dialog">
			<div class="modal-dialog">
				<div class="modal-content">
					<div class="modal-header">
						<h4 class="modal-title">Modify</h4>
					</div>
					<div class="modal-body" data-rno>
						<textarea class="form-control" placeholder="write comment please......" id="modifyModalText"
							maxlength="1024" rows="5" name="modifyModalText"></textarea>
						<input type="hidden" name="modifyModalNum" id="modifyModalNum">
					</div>
					<div class="modal-footer">
						<button class="btn btn-default btn-sm" id="modifyModalModify" type="button">Modify</button>
						<button class="btn btn-default btn-sm" id="modifyModalDelete" style="background: #FF6C6C;" type="button">Delete</button>
						<button class="btn btn-default btn-sm" id="modifyModalClose" style="background: #5AAEFF" type="button" data-dismiss="modal">Close</button>
					</div>
				</div>
			</div>
		</div>
		<div id="replyModal" class="modal modal-primary fade" role="dialog">
			<div class="modal-dialog">
				<div class="modal-content">
					<div class="modal-header">
						<h4 class="modal-title">Reply</h4>
					</div>
					<div class="modal-body" data-rno>
						<input type="hidden" class="form-control form-control-lg" name="replyModalUserId" id="replyModalUserId" value="${loginId }">
						<textarea class="form-control" placeholder="write comment please......" id="replyModalText"
							maxlength="1024" rows="5" name="replyModalText"></textarea>
						<input type="hidden" name="replyModalNum" id="replyModalNum">
					</div>
					<div class="modal-footer">
						<button class="btn btn-default btn-sm" id="replyModalSubmit" type="button">Submit</button>
						<button class="btn btn-default btn-sm" id="replyModalClose" style="background: #5AAEFF" type="button" data-dismiss="modal">Close</button>
					</div>
				</div>
			</div>
		</div>
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

	<script>
		CKEDITOR.replace('boardContent', {
			height : '1000px',
			resize_enabled : false
		});
		$(document).ready(function() {
			var formObj = $("form[role='form']");
			var messageId = $('#messageId').val();
			$("#messageRemove").on("click", function() {
				var bool = confirm("정말 삭제 하시겠습니까?");
				if (bool) {
					var arr = [];
					$(boardContent).each(function (index, p) {
					    if ($(p).find('img').length > 0) {
					        $(p).find('img').each(function (index, img) {
					        	var at = $(img).attr('src');
					            at = ''+at;
					            var date = at.substring(22, 34);
					            at = at.substr(34);
					            at = date + "_s" + at;
					            arr.push(at);
					        });
					    }
					});
					if(arr.length > 0){
						$.post("/deleteAllFiles",{files:arr}, function(){});
					}
					formObj.attr("action", "/board/boardDelete");
					formObj.submit();
				}
			});
			$("#messageList").on("click", function() {
				formObj.attr("action", "/user/messageList");
				formObj.attr("method", "get");
				formObj.submit();
			});
		});
	</script>

	<script id="templateList" type="text/x-handlebars-template">
		{{#each .}}
		<div class="container py-3 commentCard">
			<div class="row">
				<div class="col-md-12">
					<div class="row">
						<div class="col-md-10 mx-auto">
							<!-- form card login -->
							<div class="card">
								<div class="card-body">
									<input type="hidden" id="cardNum" name="cardNum" value="{{boardCommentId}}">
									<h6 class="card-title">{{#fn_isIf}}<i class="fab fa-replyd"></i>{{/fn_isIf}} {{boardCommentUserId}} - {{commentDate boardCommentRegdate}}</h6>
									<div class="form-group">
										 <p class="card-text">{{boardCommentContent}}</p>
									</div>
									<hr>
									<div class="row">
										{{#fn_isIf2}}
										<button class="btn btn-default btn-sm ml-3" id="boardCommentReply"
											type="button" data-toggle="modal" data-target="#replyModal" style="background: #5AAEFF">Reply</button>
										{{/fn_isIf2}}
										{{#eqWriter}}
										<button class="btn btn-default btn-sm ml-3" id="boardCommentModify"
											type="button" data-toggle="modal" data-target="#modifyModal">Modify</button>
										{{/eqWriter}}
										<button class="btn btn-default btn-sm ml-3" id="boardCommentLike"
											type="button" style="background: #ABF200">Like</button>
									</div>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
		{{/each}}
	</script>
	
	<script id="templateAttach" type="text/x-handlebars-template">
	<li>
  		<span class="mailbox-attachment-icon has-img"><img src="{{imgsrc}}" alt="Attachment"></span>
  		<div class=	"mailbox-attachment-info">
			<a href="{{getLink}}" class="mailbox-attachment-name">{{fileName}}</a>
 	 	</div>
	</li>              
	</script>
	
</body>
</html>