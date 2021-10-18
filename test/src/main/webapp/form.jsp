<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="model.message2.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시글 작성</title>
</head>
<body>
	<h2 style="color: pink;">게시글 등록</h2>
	<hr>

	<form action="minsert.do" method="post" name="form1">
		<input type="hidden" name="userID" value="${seUser.userID}">
		<table>
			<thead>
				<tr>
					<th>제목</th>
					<td><input type="text" name="title" required></td>
				</tr>
			</thead>
			<tbody>
				<tr>
					<th>내용</th>
					<td><textarea name="content" required></textarea></td>
				</tr>
			</tbody>
			<tfoot>
				<tr>
					<td colspan="2" align="right"><input type="submit"
						value="글 등록" class="button"></td>
				</tr>
			</tfoot>
		</table>
	</form>

</body>
</html>