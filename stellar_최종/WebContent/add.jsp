<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="model.product.*,java.util.*,model.order.*"%>

<%
	request.setCharacterEncoding("UTF-8");
	String product=request.getParameter("product");
	int orderCnt=Integer.parseInt(request.getParameter("orderCnt"));
	
	int price=new ProductDAO().select(product);
	int totalPrice=orderCnt*price;
	
	ArrayList<OrderVO> list=(ArrayList)session.getAttribute("list");
	if(list==null){
		list=new ArrayList<OrderVO>();
		session.setAttribute("list", list);
	}
	list.add(new OrderVO((String)session.getAttribute("userID"),product,orderCnt));
%>

<script type="text/javascript">
	alert("<%=product%>(이)가 <%=orderCnt%>개 추가되었습니다. <%=totalPrice%>원이 누적됩니다.");
	history.go(-1);
</script>