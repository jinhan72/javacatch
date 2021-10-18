<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="model.message2.*"%>
<jsp:useBean id="memData" class="model.client2.Client2VO"
	scope="session"></jsp:useBean>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원정보 수정/삭제</title>
<script type="text/javascript">
	function  memDel() {
		result = confirm("정말 탈퇴하시겠습니까?");
		if(result == true){
			location.href = "cdelete.do?&userID=${seUser.userID}";
		} else{
			return;
		}
		
	}
</script>
</head>
<body>

	<h2 style="color: lightgreen;">My Page</h2>
	<hr>

	<form action="cupdate.do" method="post" name="form1">
		<table>
			<tbody>
				<tr>
					<th>ID</th>
					<td><input type="text" name="userID" value="${seUser.userID}"
						readonly="readonly"></td>
				</tr>
				<tr>
					<th>PW</th>
					<td><input type="text" name="userPW" value="${seUser.userPW}"></td>
				</tr>
				<tr>
					<th>NAME</th>
					<td><input type="text" name="name" value="${seUser.name}"></td>
				</tr>
			</tbody>
			<tfoot>
				<tr>
					<td colspan="2" align="right"><input type="submit"
						value="회원정보 수정" class="button"> <input type="button"
						value="회원탈퇴" class="button" onclick="memDel()"> <input
						type="button" value="메인으로" onclick="location.href='list.do'"></td>
				</tr>
			</tfoot>
		</table>
	</form>

</body>
</html>