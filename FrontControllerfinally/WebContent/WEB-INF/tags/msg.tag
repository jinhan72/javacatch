<%@ tag language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%@ attribute name="mid" %>
<%@ attribute name="uid" %>

<a href="fav.do?mid=${mid}&mcnt=${mcnt}&selUser=${selUser}">♥</a>
<c:if test="${seUser == uid}">
	<a href="delm.do?mid=${mid}&mcnt=${mcnt}&selUser=${selUser}">삭제</a>
</c:if>