<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	
	<%
	request.setCharacterEncoding("UTF-8");
	%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div>


		<table>
		
		<c:forEach items = "${datas}" var = "vo">
		
			<tr>
				<td>제목 :</td>
				<td>${vo.title} </td>
			</tr>
			<tr>
				<td>이미지 :</td>
				<td><img src = "images/${vo.filename}"> </td>
			</tr>
			</c:forEach>
		</table>


	</div>

</body>
</html>