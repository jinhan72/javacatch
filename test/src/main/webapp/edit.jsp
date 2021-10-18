<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="model.message2.*"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>글 수정/삭제</title>
<script type="text/javascript">
	function del() {
		result = confirm("정말로 삭제하시겠습니까?");
		if (result == true) {
			location.href = "mdelete.do?&mnum=${mdata.mnum}";
		} else {
			return;
		}
	}
</script>
</head>
<body>

<h2 style="color: pink;">게시글 수정 & 삭제</h2>
<hr>

	<form action="mupdate.do" method="post" name="form1">
	<input
				type="hidden" name="mnum" value="${mdata.mnum}"> <input
				type="hidden" name="userID" value="${seUser.userID}">
			<table>
				<tbody>
					<tr>
						<th>제목</th>
						<td><input type="text" name="title"
							value="${mdata.title}"></td>
					</tr>
					<tr>
						<th>내용</th>
						<td><input type="text" name="content"
							value="${mdata.content}"></td>
					</tr>
					
				</tbody>
				<tfoot>
					<tr>
						<td colspan="2" align="right"><input type="submit"
							value="내용 수정" class="button"> <input type="button"
							value="글 삭제" class="button" onclick="del()"> <input
							type="button" value="메인으로"
							onclick="location.href='list.do'"></td>
					</tr>
				</tfoot>
			</table>
		</form>

</body>
</html>