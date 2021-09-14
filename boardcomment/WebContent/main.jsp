<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title> 게시물과 댓글 </title>
</head>
<body>


<a href="control.jsp?action=main"> 전체 목록 보기</a>

<hr>

<h2>전체 목록</h2>
<table border="1">
<c:forEach var="v" items="${datas}">
	<c:set var="m" value="${v.m}"/>
	<tr>
		<td>${m.mid}</td>
		<td>${m.msg}</td>
		<td>좋아요 ${m.favcount}</td>
		<td>댓글${m.replycount}</td>
		<td>${m.date}</td>
	</tr>
<c:forEach var="a" items="${v.rlist}">
<tr>
	<td>${a.uid}</td>
	<td>${a.rmsg}</td>
	<td>${a.date}</td>
</tr>
</c:forEach>
</c:forEach>
</table>




</body>
</html>