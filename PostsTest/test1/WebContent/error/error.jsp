<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isErrorPage="true"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>오류 처리 페이지</title>
</head>
<body>

예외의 유형: ${pageContext.errorData.throwable} <br>
상태 코드: ${pageContext.errorData.statusCode} <br>
실패된 URI: ${pageContext.errorData.requestURI} <br>

</body>
</html>