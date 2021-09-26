<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<form action="Upload" method="post" name="form1" enctype="multipart/form-data">
		<table>
			<tr>
				<td>제목 :</td>
				<td><input type="text" name="title" /></td>
			</tr>
			<tr>
				<td>글쓴이 :</td>
				<td><input type="file" value="파일 선택" name="file" /></td>
			</tr>
			<tr>
				<td colspan="2"><input type="submit" value="업로드" /></td>
			</tr>
		</table>
	</form>





</body>
</html>