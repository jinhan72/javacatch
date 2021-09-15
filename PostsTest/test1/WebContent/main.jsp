<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시물과 댓글</title>
<script type="text/javascript">
 function signup(){
	window.open("insertUser.jsp","회원가입 창","_blank");
 }
</script>
</head>
<body>

	<ol>
		<li><a href="control.jsp?action=main"> 전체 목록 보기</a></li>
	</ol>

	<hr>

	<h2>전체 목록</h2>
	<c:forEach var="v" items="${datas}">
		<c:set var="m" value="${v.m}" />
		<h3>[${m.uid} ${m.msg} &gt;&gt; [좋아요${m.favcount} | 댓글
			${m.replycount} | ${m.date}]]
			<c:if test="${mem.uid == m.uid}">
			<a href="control.jsp?action=mdelete&mid=${m.mid}&mcnt=${mcnt}">삭제</a>
			</c:if></h3>
		<ol>
			<c:forEach var="r" items="${v.rlist}">
				
				<li>${r.uid}>>${r.rmsg} [${r.date}]
				<c:if test="${mem.uid == r.uid}"><a href="control.jsp?action=rdelete&rid=${r.rid}&mcnt=${mcnt}">삭제</a></c:if></li>
				
			</c:forEach>
		</ol>
		<hr>
		<c:if test="${mem != null}">
				<form action="control.jsp" method="post">
					<input type="hidden" name="action" value="rinsert"> 
					<input type= "hidden" name="mid" value="${m.mid}">
					<input type= "hidden" name="uid" value="${mem.uid}">					
						<input type="text" name="rmsg">
						<input type="hidden" name="mcnt" value="${mcnt}">
						 <input type="submit" value="댓글 작성">
				</form>
		</c:if>
		<c:if test="${mem == null}">
			<input type="text" size="25" disabled value="로그인이 필요한 서비스">
		</c:if>
	</c:forEach>

	<a href="control.jsp?action=main&mcnt=${mcnt+1}&selUser=${selUser}">더보기&gt;&gt;</a>
	<hr>
	<c:if test="${mem!=null}">
		<form action="control.jsp" method="post">
			<input type="hidden" name="action" value="minsert">
			<input type="hidden" name="uid" value="${mem.uid}">
			<input type="hidden" name="mcnt" value="${mcnt}">
			<input type= "hidden" name="mem" value="${mem.uid}">
			<input type="text" name="msg">
			<input type="submit" value="게시물 작성">
		</form>
	</c:if>
	<c:if test="${mem==null}">
			<input type="text" size="25" disabled value="로그인이 필요한 서비스">
		
	</c:if>
	<hr>

	<form action="control.jsp" method="post" name="form1">
		<c:choose>
			<c:when test="${empty mem}">
				<input type="hidden" name="action" value="login">
				<input type="hidden" name ="mcnt" value="${mcnt}">
				<input type="text" name="uid" required>
				<input type="password" name="passwd" required>
				<input type="submit" value="로그인">
				<input type="button" value="회원가입" onclick="signup();">
				<br>
				
			</c:when>
				
			<c:otherwise>
	${mem.uid}님, 환영합니다!
	<input type="hidden" name="action" value="logout">
			<input type="submit" value="로그아웃">
				<a href="control.jsp?action=main&selUser=${mem.uid}&mcnt=${mcnt}">내글목록보기</a>
			</c:otherwise>
		</c:choose>
	</form>
</body>
</html>