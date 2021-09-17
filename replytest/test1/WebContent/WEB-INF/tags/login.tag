<%@ tag language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<form action="control.jsp" method="post" name="form1">
			<c:choose>
				<c:when test="${empty mem}">
					<input type="hidden" name="action" value="login">
					<input type="hidden" name="mcnt" value="${mcnt}">
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