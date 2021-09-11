<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%

	request.setCharacterEncoding("UTF-8");
	String userID=request.getParameter("userID");
	userID=userID.toLowerCase();
	
	session.setAttribute("userID", userID);
	if(userID.equals("관리자")||userID.equals("admin")){
		response.sendRedirect("admin.jsp");
	}
	else{
		response.sendRedirect("user.jsp");
	}

%>