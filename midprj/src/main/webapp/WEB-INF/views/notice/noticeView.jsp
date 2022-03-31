<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<style>
#container {
	padding: 0 0 100px;
}
#page_header{
	margin-bottom: 100px;
}
#notice_tbl {
	margin: 50px 0;
	width: 50%;
}

.comment_tbl {
	margin: 50px 0;
}

th {
	text-align: center;
	height: 50px;
	font-size: 1.2em;
}
td{
	padding-left: 15px;
	font-size: 1.2em;
}

textarea {
	border: none;
}



#btns{
	margin-top: 50px;
}
#btns> button{
	width: 100px;
	height: 50px;
	font-size: 1.2em;
}

.btn-link{
	visibility: hidden;
	padding: 0;
}

.tr_comm:hover .btn-link {
	visibility: visible;
}
</style>

<script src="http://code.jquery.com/jquery-3.5.1.min.js"></script>

<div align="center" id="container">
	<div>
		<section id="page_header" class="single-page-header">
			<div class="container">
				<div class="row">
					<div class="col-md-12">
						<h2>공 지 사 항</h2>
						<nav aria-label="breadcrumb mx-auto" role="navigation">
							<ol class="breadcrumb">
								<li class="breadcrumb-item"><a href="noticeList.do">공지사항</a></li>
								<li class="breadcrumb-item active" aria-current="page">상세보기</li>
							</ol>
						</nav>
					</div>
				</div>
			</div>
		</section>
		<div>
			<table border="1" id="notice_tbl">
				<tr>
					<th width="10%">제목</th>
					<td>${notice.noticeTitle }</td>
					<th width="10%">작성일자</th>
					<td width="15%">&nbsp;&nbsp;${notice.noticeDate }</td>
				</tr>
				<tr>
					<th>내용</th>
					<td height="300" colspan="5" style="white-space:pre;">${notice.noticeContents }</td>
				</tr>
			</table>
		
			<form id="frm" method="post">
				<input id="noticeId" name="noticeId" type="hidden" value="${notice.noticeId }">
			</form>
		</div>
	</div>
	<div style="width:50%;">
		<div style="text-align:left;">
			<h1>댓 글</h1>
		</div>
		<c:forEach var="comment" items="${comment }">
			<table class="comment_tbl">
				<tr>
					<td class="comment_memId" width="20%" style="font-weight:bold;">┖> </td>
					<td width="20%" style="color:gray;">${comment.commentDate }</td>
					<td>
						<input name="commentId" type="hidden" value="${comment.commentId }">
					</td>
					<td></td>
				</tr>
				<tr class="tr_comm">
					<td colspan="3" style="padding: 0 0 20px 30px;">
						<pre id="comm_content_${comment.commentId}_before">${comment.commentContents}</pre>
						<textarea id="comm_content_${comment.commentId}_after" style="display: none;" cols="80" rows="2">${comment.commentContents}</textarea>
					</td>
					<td width="11%">
						<c:if test="${loginId eq comment.memberId}">
							<button id="comm_edit_btn_${comment.commentId}" class="btn btn-link" type="button" onClick="commentEdit(${comment.commentId })">수정</button>
						</c:if>
						<c:if test="${loginId eq comment.memberId || loginId eq 'admin'}">
							<button id="comm_del_btn" class="btn btn-link" type="button" onclick="commentDelete(${comment.commentId })">삭제</button>
						</c:if>
					</td>
				</tr>
			</table>
			<hr>
		</c:forEach>
	</div>
	<div class="input-comment" style="margin-top: 10px;">
		<div style="width: 50%">
			<textarea class="form-control" id="commentContent" placeholder="댓글을 입력하세요." rows="4"></textarea>
		</div>
		<div class="btn-group btn-group-sm">
			<input type="hidden" id="noticeId" value="${notice.noticeId }">
			<input type="hidden" id="memberId" value="${loginId }">
			<div style="margin-top: 7px;">
				<c:if test="${loginId == null}">
					<input type="button" class="btn btn-default" value="댓글 쓰기" disabled="disabled">
				</c:if>
				<c:if test="${loginId != null}">
					<input type="button" class="btn btn-default" value="댓글 쓰기" id="commentWrite">
				</c:if>
			</div>
		</div>
	</div>
	
	<div id="btns">
		<button type="button" onclick="location.href='noticeList.do'">목록가기</button>&nbsp;&nbsp;
		<c:if test="${loginId eq 'admin'}">
			<button type="submit" form="frm" id="updateBtn" formaction="noticeUpdateForm.do">수정</button>&nbsp;&nbsp;
			<button type="submit" form="frm" id="deleteBtn" formaction="noticeDelete.do">삭제</button>
		</c:if>
	</div>
</div>

<script>
	// 댓글 >> "작성자 이름 (작성자 ID)"로 출력
	var idtd = document.getElementsByClassName("comment_memId");
	var str = "${s}";
	var ary = str.slice(1,-1).split(", ");
	for(let i=0; i < idtd.length; i++){
		idtd[i].innerText += ary[i];
	}

	jQuery(document).ready(function() {
        if(${loginName == null}) {
            alert("공지사항을 확인하시려면 로그인하셔야 합니다.");
            location.href="memberLoginForm.do";
        }
    });

	 $.ajaxSetup({
	        type:"POST",
	        async:true,
	        dataType:"text",
	        error:function(xhr) {
	            console.log("error html = " + xhr.statusText);
	        }
	    });


	$(function() {
      	$("#commentWrite").on("click", function() {
            $.ajax({
            	  url:"commentInsert.do",
	               data:{
	                   commentContent:$("#commentContent").val(),
	                   noticeId :  $("#noticeId").val(),
	                   memberId : $("#memberId").val()
	               },
                beforeSend:function() {
                    console.log("시작 전...");
                },
                complete:function() {
                    console.log("완료 후...");
                },
                success:function(data) {            // 서버에 대한 정상응답이 오면 실행, callback
                    	 console.log("댓글이 정상적으로 입력되었습니다.");
	                        $("#commentContent").val("");
	                    	location.reload(); 
                }
            })
		});
	});
	
	function commentUpdate(n){
		var after_c = document.getElementById("comm_content_" + n + "_after").value;
		$.ajax({
      		url:"commentUpdate.do",
	        data:{
				commentId: n,
				commentContents: after_c
			},
			success:function(data) {            // 서버에 대한 정상응답이 오면 실행, callback
				console.log("댓글이 정상적으로 수정되었습니다.");
				location.reload(); 
			}
		});
	}
	
	function commentDelete(n){
		$.ajax({
      	  url:"commentDelete.do",
             data:{
                 commentId: n,
             },
          success:function(data) {            // 서버에 대한 정상응답이 오면 실행, callback
              	 console.log("댓글이 정상적으로 삭제되었습니다.");
                 location.reload(); 
          }
      });
	}
	
	function commentEdit(n){
		var before_c = document.getElementById("comm_content_" + n + "_before");
		var after_c = document.getElementById("comm_content_" + n + "_after");
		var edit_btn = document.getElementById("comm_edit_btn_" + n);
		before_c.style.display = "none";
		after_c.style.display = "block";
		after_c.focus();
		edit_btn.setAttribute("onClick", "commentUpdate("+n+")");
	}
</script>