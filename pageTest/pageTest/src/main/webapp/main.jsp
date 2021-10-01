<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<table>

		<c:forEach var="v" items="${datas}">
			<tr>
				<td>${v.tpk}</td>
				<td>${v.content}</td>
			</tr>
		</c:forEach>

		<tr>
			<td><a href="main.do?page=${page-1}">이전</a></td>

			<c:forEach begin="${paging.startPage}" end="${paging.endPage}" var="p">
				<td><a href="main.do?page=${p}">${p}</a></td>
			</c:forEach>
			<td><a href="main.do?page=${page+1}">다음</a></td>
		</tr>



	</table>

</body>
</html>

