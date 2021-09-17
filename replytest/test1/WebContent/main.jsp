<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="mytag"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시물과 댓글</title>
<link rel="stylesheet" href="css/ad.css">
<script type="text/javascript">
	function signup() {
		window.open("insertUser.html", "회원가입 창", "width='500'", "height='300'");
	}
</script>
</head>
<body>

	<div class="content">

		<ol>
			<li><a href="control.jsp?action=main"> 전체 목록 보기</a></li>
		</ol>

		<hr>

		<h2>전체 목록</h2>
		<c:forEach var="v" items="${datas}">
			<c:set var="m" value="${v.m}" />
			<h3>
				[${m.uid} ${m.msg} &gt;&gt; [좋아요${m.favcount} | 댓글 ${m.replycount} |
				<!-- 게시물 나오는곳 -->
				${m.date}]]
				<c:if test="${mem!=null}">
				<a
						href="control.jsp?action=upfcnt&mid=${m.mid}&mcnt=${mcnt}&selUser=${selUser}">💖</a>
				</c:if>
				<c:if test="${mem.uid == m.uid}">
					<a
						href="control.jsp?action=mdelete&mid=${m.mid}&mcnt=${mcnt}&selUser=${selUser}">삭제</a>
				</c:if>
			</h3>
			<ol>
				<c:forEach var="r" items="${v.rlist}">

					<li>${r.uid}>>${r.rmsg}[${r.date}]<c:if
							test="${mem.uid == r.uid}">
							<a
								href="control.jsp?action=rdelete&rid=${r.rid}&mcnt=${mcnt}&selUser=${selUser}">삭제</a>
						</c:if></li>
				</c:forEach>
			</ol>
			<hr>
			<!-- 댓글 -->
			<form action="control.jsp" method="post">
				<input type="hidden" name="action" value="rinsert"> <input
					type="hidden" name="mid" value="${m.mid}"> <input
					type="hidden" name="uid" value="${mem.uid}"> <input
					type="hidden" name="mcnt" value="${mcnt}">
					
				<mytag:minsert type="rmsg"/>
			</form>
		</c:forEach>

		<a href="control.jsp?action=main&mcnt=${mcnt+1}&selUser=${selUser}">더보기&gt;&gt;</a>
		<hr>
		<!-- 게시물 추가 -->

		<form action="control.jsp" method="post">
			<input type="hidden" name="action" value="minsert"> <input
				type="hidden" name="uid" value="${mem.uid}"> <input
				type="hidden" name="mcnt" value="${mcnt}"> <input
				type="hidden" name="mem" value="${selUser}">
			<mytag:minsert type="msg"/>
		</form>
		<hr>
		<!-- 로그인/로그아웃 -->

		<mytag:login />

		<!-- 회원 목록 리스트 -->
		<h4>회원 목록</h4>

		<ol>
			<c:forEach var="u" items="${newUsers}">
				<li><a
					href="control.jsp?action=main&selUser=${u.uid}&mcnt=${mcnt}">${u.name}</a>님
				</li>
			</c:forEach>
		</ol>

	</div>


	<div class="ad">
		<ol>
			<li><a href="https://namu.wiki/w/PAKA" target="_blank"><img
					alt="광고_아기다람쥐PaKa" src="img/babysq.jpg"
					style="width: 200px; height: 200px;"></a></li>
			<li><a href="https://www.youtube.com/watch?v=Es3oxg9fDDY"
				target="_blank"><img alt="광고_유튜브" src="img/ad2.png"
					style="width: 200px; height: 200px;"></a></li>
			<li><a
				href="https://comic.naver.com/webtoon/list?titleId=570503&weekday=thu"
				target="_blank"><img alt="광고_웹툰" src="img/ad3.jpg"
					style="width: 200px; height: 200px;"></a></li>
		</ol>
	</div>
</body>
</html>