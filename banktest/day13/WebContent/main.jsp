<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	
	<jsp:useBean id="b1" class="model.bank.Bank1VO"/>
	<jsp:useBean id="b2" class="model.bank.Bank2VO"/>
	
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	
	<table border="1">
		<tr>
			<td>이름</td>
			<td>총액</td>
		</tr>
		<tr>
		<td>${bank1.mname}</td>
		<td>${bank1.money}</td>
		</tr>
		<tr>
		<td>${bank2.mname2}</td>
		<td>${bank2.money2}</td>
		</tr>
	</table>
	
	<hr>

<form action="control.jsp" name="form1" method="post">	
	<input type="hidden" name="action" value="trans">
	<input type ="text" name="bal">
	<input type ="submit" value="이체하기">
</form>
<hr>
<form action="control.jsp" name="form1" method="post">	
	<input type="hidden" name="action" value="trans1">
	<input type ="text" name="bal">
	<input type ="submit" value="이체하기">
</form>
</body>
</html>