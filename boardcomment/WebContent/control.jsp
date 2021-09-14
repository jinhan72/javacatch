<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.*,model.msg.*,model.user.*"%>
    <jsp:useBean id="mDAO" class="model.msg.MessageDAO"/>
    <jsp:useBean id="mVO" class="model.msg.MessageVO"/>
    <jsp:useBean id="rDAO" class="model.msg.ReplyDAO"/>
    <jsp:useBean id="rVO" class="model.msg.ReplyVO"/>
    <jsp:useBean id="uDAO" class="model.user.UserDAO"/>
    <jsp:useBean id="uVO" class="model.user.UserVO"/>
	<jsp:setProperty property="*" name="mVO"/>
	<jsp:setProperty property="*" name="rVO"/>
	<jsp:setProperty property="*" name="uVO"/>
	
	<%

	String action = request.getParameter("action"); 
/*	String url = "control.jsp?action=main";
	String mcntt=request.getParameter("mcnt");
	int mcnt =2;
	if(mcntt!=null){
		mcnt=Integer.parseInt(mcntt);
	}
	url = url+ "&mcnt="+mcnt;
	String selUser = request.getParameter("selUser");
	if(selUser!=null){
		url = url + "&selUser=" +selUser;
	}*/
	
	if(action.equals("main")){
		System.out.println(action);
		ArrayList<MsgSet> datas = mDAO.selectAll();
		System.out.println(datas);
	//ArrayList<UserVO> newUsers=uDAO.selectAll();
		
		request.setAttribute("datas", datas);
		//request.setAttribute("selUser", selUser);
	//	request.setAttribute("newUsers", newUsers);
	//	request.setAttribute("mcnt", mcnt);
		
		pageContext.forward("main.jsp");
	}
	
	
	 %>