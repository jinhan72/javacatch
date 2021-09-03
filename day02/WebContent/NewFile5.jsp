<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
#a{
color: blue;
}
#b{
color: red;
}
</style>
</head>
<body>



	<%
		for (int i = 1; i < 11; i++) {
	%>
	
	<%if(i%2==0){
	%>
	<span id="a"><%=i %> </span> <br>	
	<%} %>
	<%if(i%2==1){
		%>
		<span id ="b"> <%= i %>  </span><br>
	<% }%>

	<%
		}
	%>
	
	
	
</body>
</html>