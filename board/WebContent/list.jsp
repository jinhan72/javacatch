<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"
	import="model.message.*,model.member.* ,java.util.*"%>
<jsp:useBean id="datas" class="java.util.ArrayList" scope="request" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>글 목록 화면</title>
<script type="text/javascript">
	function check(mnum, mid) {
		console.log(mnum);
		console.log(mid);
		//document.location.href="control.jsp?action=edit&mnum="+mnum+"&writer="+mid;
	}
</script>
</head>
<body>

	<h2>게시글 목록</h2>
	<hr>
	<a href="form.jsp">글 등록</a>
	<hr>
	<table border="1">
		<tr>
			<th>글 번호</th>
			<th>제목</th>
			<th>작성자</th>
			<th>작성일</th>
		</tr>
		<%
			for (MessageVO vo : (ArrayList<MessageVO>) datas) {
				MemberVO member = (MemberVO) session.getAttribute("member");
				System.out.println("list for문 안에 memberID" + member.getMid());
		%>
		<tr>
			<!-- "control.jsp?action=edit&mnum=vo.getMnum()" 여기서 두개 보내거든요-->
			<td><a
				href="javascript:check(<%=vo.getMnum()%>, <%=member.getMid()%>)"><%=vo.getMnum()%></a></td>
			<td><%=vo.getTitle()%></td>
			<td><%=vo.getWriter()%></td>
			<td><%=vo.getWdate()%></td>
		</tr>
		<%
			}
		%>
	</table>
	<form action="control.jsp" method="post">
		<input type="hidden" name="action" value="search"> <select
			name="condition">
			<option selected value="title">제목</option>
			<option value="writer">작성자</option>
		</select> <input type="text" name="content"> <input type="submit"
			value="검색하기">
	</form>
	<hr>
	<form action="control.jsp" method="post">
		<input type="hidden" name="action" value="search">
		<div class="col-6 col-12-xsmall">
			<input type="text" name="content">
		</div>
		<select name="condition">
			<option selected value="title">제목</option>
			<option value="writer">작성자</option>
		</select> <input type="text" name="content"> <input type="submit"
			value="검색하기">
	</form>



	<form action="control.jsp" method="post" name="logoutForm">
		<input type="hidden" name="action" value="logout"> <input
			type="submit" value="로그아웃">
	</form>
	<form action="control.jsp" method="post" name="mylistForm">
		<input type="hidden" name="action" value="mylist"> <input
			type="submit" value="내가 작성한 글">
	</form>
</body>
</html>