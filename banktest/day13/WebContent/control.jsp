
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="model.bank.*"%>
	<jsp:useBean id="b1" class="model.bank.Bank1VO"/>
	<jsp:useBean id="b2" class="model.bank.Bank2VO"/>
	<jsp:useBean id="bDAO" class="model.bank.BankDAO"/>
	
<%
	request.setCharacterEncoding("UTF-8");
%>

<%



 String action = request.getParameter("action");
 
 if(action.equals("main")){
	 Bank1VO bank1 = bDAO.getBank1();
	 Bank2VO bank2 = bDAO.getBank2();
		System.out.println("main1");
	 session.setAttribute("bank1", bank1);
	 session.setAttribute("bank2", bank2);
		System.out.println("main1");
	 response.sendRedirect("main.jsp");
 }
 
 if(action.equals("trans")){
	 	
		if(bDAO.trans1(Integer.parseInt(request.getParameter("bal")))){	
		System.out.println("trans1");
		
		session.getAttribute("bal");
		out.println("<script>alert('가능!');</script>");

		response.sendRedirect("control.jsp?action=main");
		System.out.println("trans2");	
		}
		else{
			out.println("<script>alert('불가능!');history.go(-1)</script>");
		}
	}
	
 if(action.equals("trans1")){
	 	
		if(bDAO.trans2(Integer.parseInt(request.getParameter("bal")))){	
		
		session.getAttribute("bal");
		out.println("<script>alert('가능!');</script>");
		response.sendRedirect("control.jsp?action=main");
		}
		else{
			out.println("<script>alert('불가능!');history.go(-1)</script>");
		}
	}
 	
 	
	
			

	
 %>