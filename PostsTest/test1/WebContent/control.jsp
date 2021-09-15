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
	System.out.println(action);
	String url = "control.jsp?action=main";
	String mcntt=request.getParameter("mcnt");
	int mcnt =0; // 이놈이 페이지
	if(mcntt!=null){
		mcnt=Integer.parseInt(mcntt);
	}
	url = url+ "&mcnt="+mcnt; //위 url에 &mcnt값에 mcnt값을 넣어줌
	String selUser = request.getParameter("selUser"); 
	if(selUser!=null){
		url = url + "&selUser=" +selUser;
	}
	
	if(action.equals("main")){
		System.out.println(action);
		System.out.println("seluser =" +selUser);
		ArrayList<MsgSet> datas = mDAO.selectAll(selUser, mcnt);
		System.out.println("control, datas = " + datas);
	ArrayList<UserVO> newUsers=uDAO.selectAll();
		
		request.setAttribute("datas", datas);
		request.setAttribute("selUser", selUser);
		request.setAttribute("newUsers", newUsers);
		request.setAttribute("mcnt", mcnt);
		
		pageContext.forward("main.jsp");
	}
	// 로그인
	else if(action.equals("login")){
		//System.out.println(uVO.getUid());	
			uVO = uDAO.login(uVO);
		if(uVO != null){
			session.setAttribute("mem", uVO); // 회원 이름 보내주는 코드
			System.out.println(url);
			response.sendRedirect(url);
		}
		else{
			out.println("<script>alert('로그인 실패!');history.go(-1);</script>");
		}
	}
	else if(action.equals("logout")){
		session.invalidate();
		response.sendRedirect("control.jsp?action=main");
	}
	else if(action.equals("signup")){
		if(uDAO.insert(uVO)){
			response.sendRedirect("control.jsp?action=main");
		}
	}
	// 대댓글 인서트
	else if(action.equals("rinsert")){
		//UserVO vo = (UserVO)session.getAttribute("selUser"); // 어튜리뷰티를 get하면 오브젝 타입으로 넘어간다
		//System.out.println(mVO.getUid());
		rVO.setUid(request.getParameter("uid"));
		//System.out.println(rVO);
		if(rDAO.insert(rVO)){
			//System.out.println(action);
			response.sendRedirect(url);
		}
		else{
			throw new Exception("minsert에서 발생!");
		}
	}
	//댓글 인서트
	else if(action.equals("minsert")){
		System.out.println(mVO.getUid());
		mVO.setUid(request.getParameter("uid"));
		if(mDAO.insert(mVO)){
			response.sendRedirect(url);
		}
		else{
			throw new Exception("minsert에서 발생!");
		}
	}
	else if(action.equals("mdelete")){
		if(mDAO.delete(mVO)){
			response.sendRedirect(url);
		}
		else{
			throw new Exception("minsert에서 발생!");
		}
	}
	else if(action.equals("rdelete")){
		System.out.println(rVO.getRid());
		if(rDAO.delete(rVO)){
			response.sendRedirect(url);
		}
		else{
			throw new Exception("minsert에서 발생!");
		}
	}
	 %>