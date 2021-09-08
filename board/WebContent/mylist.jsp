<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="model.message.*,model.member.*, java.util.*"%>
<jsp:useBean id="datas" class="java.util.ArrayList" scope="request" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>내 리스트</title>
</head>
<body>
<table border="1">
	<tr>
		<th>글 번호</th><th>제목</th><th>작성자</th><th>작성일</th>
	</tr>
	<%
		for(MessageVO vo:(ArrayList<MessageVO>)datas){
			
			MemberVO member = (MemberVO)session.getAttribute("member");
			System.out.println(member.getMid());
			System.out.println(vo.getWriter());

			if(member.getMid().equals(vo.getWriter())){
			System.out.println(member.getMid());
			System.out.println(vo.getWriter());
	%>
		<tr>
			<td><a href="javascript:check(<%=vo.getMnum()%>)"><%=vo.getMnum()%></a></td><!-- 글 변경을 위한 비밀번호 등의 인증작업처리 필요! -->
			<td><%=vo.getTitle()%></td>
			<td><%=vo.getWriter()%></td>
			<td><%=vo.getWdate()%></td>
		</tr>
	<%
			}
		}
	%>
</table>
</body>
</html>