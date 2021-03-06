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
					<li class="nav-item menu-active"><a href="/board/boardList">Board</a></li>
					<li class="nav-item"><a href="/dataroom/dataroomList">Data
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
									<h3 class="title">Read</h3>
								</div>
								<div class="card-body">
									<form class="form" role="form" method="post">
										<input type="hidden" name="boardId" id="boardId" value="${boardVO.boardId }"> 
										<input type="hidden" name="page" id="page" value="${pageHandler.page }">
										<input type="hidden" name="perPageNum" id="perPageNum" value="${pageHandler.perPageNum }">
										<input type="hidden" name="searchType" id="searchType"value="${pageHandler.searchType }">
										<input type="hidden" name="keyword" id="keyword" value="${pageHandler.keyword }">
									</form>
									<div class="form-group">
										<label for="title" class="text">Title</label> <input
											type="text" class="form-control form-control-lg"
											name="boardTitle" id="boardTitle" placeholder="write Title"
											readonly="readonly" value="${boardVO.boardTitle }">
									</div>
									<div class="form-group">
										<label for="writer" class="text">Writer</label> <input
											type="text" class="form-control form-control-lg"
											name="boardUserId" id="boardUserId" readonly="readonly"
											value="${boardVO.boardUserId }">
									</div>
									<div class="form-group">
										<label for="content" class="text">Content</label>
										<textarea class="form-control"
											placeholder="write content please......" id="boardContent"
											maxlength="40" name="boardContent" readonly="readonly">${boardVO.boardContent }</textarea>
									</div>
									<div class="row">
										<div class="col-4">
											<span><strong>조회수</strong> : ${boardVO.boardHit }</span>
										</div>
										<div class="col-4">
											<span><strong>좋아요</strong> : ${boardVO.boardLike }</span>
										</div>
										<div class="col-4">
											<span><strong>작성일</strong> : <fmt:formatDate
													pattern="yyyy-MM-dd HH:mm" value="${boardVO.boardRegdate }" /></span>
										</div>
									</div>
									<hr>
									<ul class="mailbox-attachments clearfix uploadedList">
										
									</ul>
									<hr>
									<div class="row">
									<c:if test="${loginId == boardVO.boardUserId}">
										<button class="btn btn-default btn-sm ml-3" id="boardModify"
											type="button">Modify</button>
										<button class="btn btn-default btn-sm ml-3" id="boardRemove"
											type="button" style="background: #FF6C6C;">Remove</button>
									</c:if>
										<button class="btn btn-default btn-sm ml-3" id="boardList"
											type="button" style="background: #5AAEFF">List</button>
											<button class="btn btn-default btn-sm ml-3" id="boardLike"
											type="submit" style="background: #ABF200">Like</button>
										<c:if test="${boardVO.boardIsReply == false}">
										<button class="btn btn-default btn-sm ml-3" id="boardReply"
											type="button" style="background: #FD65B0">Reply</button>
										</c:if>
										<c:if test="${not empty loginId }">
										<button class="btn btn-default btn-sm ml-3"
											id="boardViewComment" type="button"
											style="background: #7536CF">ViewComment <strong id="commentCnt">[${boardVO.boardCommCnt}]</strong></button>
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
		<c:if test="${not empty loginId }">
		<div class="container py-3">
			<div class="row">
				<div class="col-md-12">
					<div class="row">
						<div class="col-md-10 mx-auto">
							<!-- form card login -->
							<div class="card">
								<div class="card-header">
									<h3 class="title">comment</h3>
								</div>
								<div class="card-body">
										<input type="hidden" class="form-control form-control-lg"
											name="boardCommentUserId" id="boardCommentUserId"
											value="${loginId }">
									<div class="form-group">
										<label for="content" class="text">Content</label>
										<textarea class="form-control"
											placeholder="write comment please......"
											id="boardCommentContent" maxlength="1024"
											name="boardCommentContent" rows="5"></textarea>
									</div>
									<hr>
									<div class="row">
										<button class="btn btn-default btn-sm ml-3" id="commentSubmit"
											type="button">Submit</button>
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
		</c:if>
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
			var boardId = $('#boardId').val();
			$("#boardModify").on("click", function() {
				formObj.attr("action", "/board/boardModify");
				formObj.attr("method", "get");
				formObj.submit();
			});
			$("#boardRemove").on("click", function() {
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
			$("#boardList").on("click", function() {
				formObj.attr("action", "/board/boardList");
				formObj.attr("method", "get");
				formObj.submit();
			});
			$("#boardReply").on("click", function() {
				formObj.attr("action", "/board/boardReply");
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

	<script>
		$.ajaxSetup({cache : false});
		Handlebars.registerHelper("eqWriter", function(option) {
            if (this.boardCommentUserId == '${loginId}') {
                return option.fn(this);
            } else {
                return option.inverse(this); // 반대
            }
        });
		Handlebars.registerHelper("fn_isIf", function(option) {
            if (this.boardCommentIsReply == true) {
                return option.fn(this);
            } else {
                return option.inverse(this); // 반대
            }
        });
		Handlebars.registerHelper("fn_isIf2", function(option) {
            if (this.boardCommentIsReply == false) {
                return option.fn(this);
            } else {
                return option.inverse(this); // 반대
            }
        });
		Handlebars.registerHelper("commentDate", function(timeValue) { //handlers의 commentDate 처리 함수
			var dateObj = new Date(timeValue);
			var year = dateObj.getFullYear();
			var month = dateObj.getMonth() + 1;
			var date = dateObj.getDate();
			return year + "/" + month + "/" + date;
		});
		var printData = function(commentArr, target, templateObject) {
			console.log(commentArr);
			var template = Handlebars.compile(templateObject.html());
			var html = template(commentArr);
			$(".commentCard").remove();
			target.after(html);
		}
		var boardId = ${boardVO.boardId};
		var replyPage = 1;
		function getPage(pageInfo) {
			$.getJSON(pageInfo, function(data) {
				printData(data.list, $("#commentlists"), $("#templateList"));
				printPaging(data.pageMaker, $(".pagination"));
				$("#modifyModal").modal('hide');
				$("#replyModal").modal('hide');
				$("#commentCnt").html("["+data.pageMaker.totalCount+"]");
			});
		}
		var templateAttach = Handlebars.compile($("#templateAttach").html());
		$.getJSON("/board/getAttach/"+boardId, function(list){
			$(list).each(function(){
				var fileInfo = getFileInfo(this);
				var html = templateAttach(fileInfo);
				$(".uploadedList").append(html);
			});
		});
		var printPaging = function(pageMaker, target) {
			var str = "";
			if (pageMaker.prev) {
				str += "<li class='page-item'><a class='page-link' href='"
						+ (pageMaker.startPage - 1)
						+ "' aria-label='Previous'>"
						+ "<span aria-hidden='true'>&laquo;</span><span class='sr-only'>Previous</span></a></li>";
			}
			for (var i = pageMaker.startPage, len = pageMaker.endPage; i <= len; i++) {
				var strClass = pageMaker.pageHandler.page == i ? 'active' : '';
				str += "<li class = 'page-item "+ strClass +"'><a class='page-link' href='"+i+"'>"
						+ i + "</a></li>";
			}
			if (pageMaker.next) {
				str += "<li class='page-item'><a class='page-link' href='"
						+ (pageMaker.endPage + 1)
						+ "' aria-label='Previous'>"
						+ "<span aria-hidden='true'>&laquo;</span><span class='sr-only'>Pr evious</span></a></li>";
			}
			target.html(str);
		}
		$("#boardViewComment").on("click", function() { //버튼 누르면 /replies를 호출하여 restcontroller에서 댓글 목록을 출력해준다
			if ($(".commentCard .card").size() > 1) {
				return;
			}
			getPage("/replies/" + boardId + "/1");
		});
		$('.pagination').on("click", "li a", function(event) {
			event.preventDefault();
			replyPage = $(this).attr("href");
			getPage("/replies/" + boardId + "/" + replyPage);
		});
		$("#commentSubmit").on("click", function() {
			var boardCommentUserIdObj = $("#boardCommentUserId");
			var boardCommentContentObj = $("#boardCommentContent");
			var boardCommentUserId = boardCommentUserIdObj.val();
			var boardCommentContent = boardCommentContentObj.val();
			$(".error").remove();
			if (boardCommentContent.length < 1) {
			    $('#boardCommentContent').after('<span class="error" style="color:red;"><small>This field is required</small></span>');
			    return; 
			}
			$.ajax({
				type : 'post',
				url : '/replies/',
				headers : {
					"Content-Type" : "application/json",
					"X-HTTP-Method-Override" : "POST",
				},
				dataType : 'text',
				data : JSON.stringify({
					boardCommentBoardId : boardId,
					boardCommentUserId : boardCommentUserId,
					boardCommentContent : boardCommentContent
				}),
				success : function(result) {
					console.log("result: " + result);
					if (result == 'SUCCESS') {
						alert('등록 되었습니다.');
						replyPage = 1;
						getPage("/replies/" + boardId + "/" + replyPage);
						boardCommentContentObj.val("");
					}
				}
			});
		});
		$("#replyModalSubmit").on("click", function() {
			var replyModalUserIdObj = $("#replyModalUserId");
			var replyModalTextObj = $("#replyModalText");
			var replyModalTargetIdObj = $("#replyModalNum");
			var replyModalUserId = replyModalUserIdObj.val();
			var replyModalText = replyModalTextObj.val();
			var replyModalTargetId = replyModalTargetIdObj.val();
			$(".error").remove();
			if (replyModalText.length < 1) {
			    $('#replyModalText').after('<span class="error" style="color:red;"><small>This field is required</small></span>');
			    return; 
			}
			$.ajax({
				type : 'post',
				url : '/replies/reply',
				headers : {
					"Content-Type" : "application/json",
					"X-HTTP-Method-Override" : "post",
				},
				dataType : 'text',
				data : JSON.stringify({
					boardCommentId : replyModalTargetId,
					boardCommentContent : replyModalText,
					boardCommentBoardId : boardId,
					boardCommentUserId : replyModalUserId
				}),
				success : function(result) {
					console.log("result: " + result);
					if (result == 'SUCCESS') {
						alert('답글이 등록 되었습니다.');
						replyModalTextObj.val("");
						getPage("/replies/" + boardId + "/" + replyPage);
					}
				}
			});
		});
		$("#modifyModalModify").on("click", function() {
			var commentId = $("#modifyModalNum").val();
			var commentText = $("#modifyModalText").val();
			$(".error").remove();
			if (commentText.length < 1) {
			    $('#modifyModalText').after('<span class="error" style="color:red;"><small>This field is required</small></span>');
			    return; 
			}
			$.ajax({
				type : 'put',
				url : '/replies/'+commentId,
				headers : {
					"Content-Type" : "application/json",
					"X-HTTP-Method-Override" : "PUT",
				},
				dataType : 'text',
				data : JSON.stringify({
					boardCommentContent : commentText
				}),
				success : function(result) {
					console.log("result: " + result);
					if (result == 'SUCCESS') {
						alert('수정 되었습니다.');
						getPage("/replies/" + boardId + "/" + replyPage);
					}
				}
			});
		});
		$("#modifyModalDelete").on("click", function() {
			var commentId = $("#modifyModalNum").val();
			var commentText = $("#modifyModalText").val();
			var bool = confirm('정말 삭제하시겠습니까?');
			if (!bool) return;
			$.ajax({
				type : 'delete',
				url : '/replies/'+commentId,
				headers : {
					"Content-Type" : "application/json",
					"X-HTTP-Method-Override" : "delete",
				},
				dataType : 'text',
				success : function(result) {
					console.log("result: " + result);
					if (result == 'SUCCESS') {
						alert('삭제 되었습니다.');
						getPage("/replies/" + boardId + "/" + replyPage);
					}
				}
			});
		});
	</script>
	
	<script>
		$(document).on("click", ".commentCard", function(){
			var comm = $(this);
			$("#modifyModalText").val(comm.find('.card-text').text());
			$("#modifyModalNum").val(comm.find('#cardNum').val());
			$("#replyModalNum").val(comm.find('#cardNum').val());
		});
	</script>
</body>
</html>