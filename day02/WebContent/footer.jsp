<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<footer>
<h2> 출력문임</h2>
<%= request.getParameter("email") %>
<br>
<% out.println(request.getParameter("tel"));%>
</footer>
</body>
</html>