<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h2> jsp </h2>
<jsp:include page="footer.jsp">
	<jsp:param value="abc@naver.com" name="email"/>
	<jsp:param value="010-6272-2019" name="tel"/>
</jsp:include>
<!-- 태그 바디 -->
</body>
</html>