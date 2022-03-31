<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<script src="js/jquery.min.js"></script>
<style>
#container {
	padding: 0 0 100px;
}

#page_header{
	margin-bottom: 100px;
}

table {
	margin-top: 50px;
	width: 60%;
	font-size: 1.3em;
}

span:hover {
	cursor: pointer;
	color: red;
}

#noticeBody>tr>td {
	padding-top: 10px;
}

th {
	text-align: center;
	border-style: none none solid none;
}

.notices:hover {
	cursor: pointer;
	background-color: #ffff99;
}

#insert_btn {
	width: 100px;
	height: 50px;
	margin-top: 50px;
	font-size: 1.2em;
}

.pagelist {
	text-align: center;
}

.pagelist li {
	display: inline-block;
	list-style: none;
	padding: 10px;
}

#page_list {
	margin-top: 50px;
}

#page_list>ul>li>a {
	color: black;
}

#selectC {
	display: inline-block;
}
</style>

<div align="center" id="container">
	<section id="page_header" class="single-page-header">
		<div class="container">
			<div class="row">
				<div class="col-md-12">
					<h2>공 지 사 항</h2>
					<nav aria-label="breadcrumb mx-auto" role="navigation">
						<ol class="breadcrumb">
							<li class="breadcrumb-item"><a href="home.do">Home</a></li>
							<li class="breadcrumb-item active" aria-current="page">공지사항</li>
						</ol>
					</nav>
				</div>
			</div>
		</div>
	</section>

	<div>
		<form id="frm" method="post">
			<div>
				<span> <select id="searchKey" name="searchKey"
					onchange="allSelected()">
						<option value="1">전체</option>
						<option value="2">제목</option>
						<option value="3">내용</option>
				</select> <input type="text" id="searchVal" name="searchVal" size="40">&nbsp;
					<input type="button" onclick="searchList()" value="검색">&nbsp;
				</span>
				<div id="selectC">
					<select onchange="change(this)">
						<option value="5" ${pageVO.amount eq 5 ? 'selected' : '' }>5개씩
							보기</option>
						<option value="10" ${pageVO.amount eq 10 ? 'selected' : '' }>10개씩
							보기</option>
						<option value="20" ${pageVO.amount eq 20 ? 'selected' : '' }>20개씩
							보기</option>
						<option value="50" ${pageVO.amount eq 50 ? 'selected' : '' }>50개씩
							보기</option>
					</select>
				</div>
				<table id="contents">

					<thead>

						<tr>
							<th width="15%"><span onclick="sortNotice('A')"> ▲ </span>
								NO <span onclick="sortNotice('D')"> ▼ </span></th>
							<th width="55%">제 목</th>
							<th width="20%">작성일자</th>
							<th width="10%">조회수</th>
						</tr>
					</thead>

					<tbody id="noticeBody">
						<c:if test="${empty list }">
							<tr>
								<td colspan="5">게시글이 존재하지 않습니다.</td>
							</tr>
						</c:if>
						<c:if test="${not empty list }">
							<c:forEach items="${list }" var="n">
								<tr onclick="noticeContents('${n.noticeId}')" class="notices">
									<td align="center">${n.noticeId }</td>
									<td>${n.noticeTitle }</td>
									<td align="center">${n.noticeDate }</td>
									<td align="center">${n.noticeHit }</td>
								</tr>
							</c:forEach>
						</c:if>
					</tbody>
				</table>
			</div>
			<br>
			<div>
				<c:if test="${loginId eq 'admin'}">
					<button type="button" id="insert_btn"
						onclick="location.href='noticeInsertForm.do'">글쓰기</button>
				</c:if>
			</div>
			<input type="hidden" id="noticeId" name="noticeId">
		</form>
	</div>
	<div id="page_list">
		<ul class="pagelist">
			<li class="first_page"><a
				href="noticeList.do??pageNum=${pageVO.startPage}&amount=${pageVO.amount}"><<</a></li>

			<c:if test="${pageVO.prev }">
				<li><a
					href="noticeList.do??pageNum=${num - 1 }&amount=${pageVO.amount}"><</a></li>
			</c:if>

			<c:forEach var="num" begin="${pageVO.startPage }"
				end="${pageVO.endPage }">
				<li class="${pageVO.pageNum eq num ? 'active' : '' }"><a
					href="noticeList.do?pageNum=${num }&amount=${pageVO.amount}">${num }</a></li>
			</c:forEach>
			<c:if test="${pageVO.next }">
				<li><a
					href="noticeList.do?pageNum=${num+1 }&amount=${pageVO.amount}">></a></li>
			</c:if>
			<li class="last_page"><a
				href="noticeList.do??pageNum=${pageVO.endPage}&amount=${pageVO.amount}">>></a></li>
		</ul>
	</div>
</div>
<script type="text/javascript">
	if ('${message}' != '') {
		window.alert('${message}');
		window.location = 'noticeList.do';
	}

	// 검색[전체] 선택 시 검색창 비우기
	function allSelected() {
		var selected = document.getElementById("searchKey");
		if (selected.options[selected.selectedIndex].value == 1) {
			document.getElementById("searchVal").value = '';
		}

	}

	// 공지사항 클릭시 공지사항 번호를 넘겨줌
	function noticeContents(n) {
		frm.noticeId.value = n;
		frm.action = "noticeView.do";
		frm.submit();
	}

	// 검색
	function searchList() {
		$.ajax({
			url : "ajaxNoticeSearch.do",
			type : "post",
			data : {
				"key" : $("#searchKey").val(),
				"val" : $("#searchVal").val()
			},
			dataType : "json",
			success : function(result) {
				if (result.length > 0) {
					searchResult(result); //json data>> html
				} else {
					alert("검색 결과가 존재하지 않습니다.");
				}
			}
		});
	}

	// key: 'A' > 오름차순 / 'D' > 내림차순
	function sortNotice(key) {
		$.ajax({
			url : "ajaxSortNotice.do",
			type : "post",
			data : {
				"key" : key
			},
			dataType : "json",
			success : function(result) {
				searchResult(result);
			}
		})
	}

	// 검색 혹은 재정렬시 공지사항 목록 재출력
	function searchResult(data) {
		var tb = $("#noticeBody");
		$("#noticeBody").empty();

		$.each(data, function(index, item) {
			var html = $("<tr />").attr({
				'onclick' : 'noticeContents(' + item.noticeId + ')',
				'class' : 'notices'
			}).append($("<td align='center'/>").text(item.noticeId),
					$("<td />").text(item.noticeTitle),
					$("<td align='center'/>").text(item.noticeDate),
					$("<td align='center'/>").text(item.noticeHit));
			tb.append(html);

		});

		$("#contents").append(tb);
	}
	function change(a) {
		location.href = "noticeList.do?pageNum=1&amount=" + a.value;
	}
</script>
