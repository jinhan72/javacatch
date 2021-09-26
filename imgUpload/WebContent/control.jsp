<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    
    
    <%
    request.setCharacterEncoding("UTF-8");
    %>
    
    <%
    
    String action = request.getParameter("action");
    
    if(action.equals("form")){ 	
    	pageContext.forward("form.jsp");
    }
    
    else if(action.equals("upload")){
	request.setAttribute("file", request.getParameter("file"));
		pageContext.forward("main.jsp");
    }
    
    
    %>
    
    
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

</body>
</html>