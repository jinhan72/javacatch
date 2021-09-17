<%@ tag language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%@ attribute name="type"%>

<c:choose>
	<c:when test="${type =='rmsg'}">
		<c:if test="${mem != null}">

			<input type="text" name="rmsg">
			<input type="submit" value="댓글 작성">

		</c:if>

		<c:if test="${mem == null}">
			<input type="text" size="25" disabled value="로그인이 필요한 서비스">
		</c:if>
	</c:when>
	<c:when test="${type=='msg'}">
		<c:if test="${mem!=null}">

			<input type="text" name="msg">
			<input type="submit" value="게시물 작성">

		</c:if>
		<c:if test="${mem==null}">
			<input type="text" size="25" disabled value="로그인이 필요한 서비스">
		</c:if>

	</c:when>
</c:choose>