<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입</title>
</head>
<body>
	<form action="control.jsp" method="post" name="regForm">
	<input type="hidden" name="action" value="reg">
		<table border="1">
			<tr>
				<td>ID</td>
				<td><input type="text" name="mid"></td>
			</tr>
			<tr>
				<td>PW</td>
				<td><input type="password" name="mpw"></td>
			</tr>
			<tr>
				<td colspan="2" align="right">
				<input type="submit" value="회원가입"></td>
			</tr>
		</table>
	</form>
	<hr>
</body>
</html>