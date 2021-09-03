<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>포워딩 vs 리다이렉팅</title>
</head>
<body>

<form action="forward.jsp" method="post">
   <input type="text" name="username">
   <input type="submit" value="페이지 이동">
</form>

<hr>

<form action="response_sendRedirect.jsp" method="post">
   <input type="text" name="username">
   <input type="submit" value="페이지 이동">
</form>
<!-- response객체를 주체로한 리다이렉팅 방식은 jsp 액션태그(포워딩)와 다르게, 
	페이지를 전환/이동 할때에 request,response 객체를 새로 생성함
 -->

</body>
</html>