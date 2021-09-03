<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isErrorPage="true"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>에러처리 페이지</title>
<style type="text/css">
   #er{
      color: red;
   }
</style>
</head>
<body>

<h2>발생에러: <span id="er"><%=exception%></span></h2>

</body>
</html>