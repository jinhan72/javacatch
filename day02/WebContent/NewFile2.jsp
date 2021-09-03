<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" errorPage="error.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>include 지시어</title>
<style type="text/css">
#box1 {
	border: 1px solid blue;
}

#box2 {
	border: 1px solid pink;
}
</style>
</head>
<body>
	<%@include file="menu.jsp"%>
	<hr>
	<div id="box1"><%@include file="news.jsp"%></div>
	<div id="box2"><%@include file="shopping.jsp"%></div>
</body>
</html>