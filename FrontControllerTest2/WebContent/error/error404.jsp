<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isErrorPage="true"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>오류 처리 페이지2</title>
</head>
<body>

<h2>요청 처리 실패! 해당 페이지를 찾을 수 없습니다!</h2>
실패된 URI: ${pageContext.errorData.requestURI} <br>

</body>
</html>