<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

</head>
<body>

<form action="control.jsp" method="post" name="form1">
<input type="hidden" name="action" value="signup">
아이디<input type="text" name="uid">
<br>
이름<input type="text" name="name">
<br>
비밀번호<input type="password" name="passwd">
<br>
<input type="submit" value="회원가입" onclick="window.close();">

</form>
</body>
</html>