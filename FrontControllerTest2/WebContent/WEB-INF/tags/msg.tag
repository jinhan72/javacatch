<%@ tag language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%@ attribute name="mid" %>
<%@ attribute name="uid" %>

<a href="control.jsp?action=updatemsg&mid=${mid}&mcnt=${mcnt}">♥</a>
<c:if test="${seUser == uid}">
	<a href="control.jsp?action=delmsg&mid=${mid}&mcnt=${mcnt}">삭제</a>
</c:if>