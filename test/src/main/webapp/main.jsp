<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="model.message2.*,java.util.*"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>     


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>메인페이지 로그인 후 이용가능</title>
</head>
<body>

<c:if test="${seUser==null}">
	<form action="login.do" method="post" name="form1">
		<input type="hidden" name="action" value="login">
		<table border="1">
			<tr>
				<td>아이디</td>
				<td><input type="text" name="userID"></td>
			</tr>
			<tr>
				<td>비밀번호</td>
				<td><input type="password" name="userPW"></td>
			</tr>
			<tr>
				<td colspan="2" align="right"><input type="submit" value="로그인"></td>
			</tr>
			<tr>
					<td colspan="2" align="right"><input type="button" value="회원가입하기"  onclick="location.href='signup.jsp'"></td>
			</tr>
		</table>
	</form>
</c:if>	

<br><br>

<h2 style="color: skyblue;">게시글</h2>
<hr style="color: yellow; font-size: large;">

<table border="1">
	<tr>
		<th>글 번호</th>
		<th>작성자</th>
		<th>제목</th>
		<th>작성일</th>
	</tr>

<c:if test="${mdatas==null}">
	<tr>
		<td colspan="5" align="center">등록된 게시글이 없습니다.</td>
	</tr>
</c:if>	

<c:if test="${mdatas!=null}">
	<c:forEach var="v" items="${mdatas}">
		<tr>
			<td>${v.mnum}</td>
			<td>${v.userID}</td>
			<td>${v.title}</td>
			<td>${v.wdate}</td>
		</tr>
	</c:forEach>
</c:if>
</table>


</body>
</html>