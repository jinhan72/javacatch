<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="mytag"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="css/style.css">
<script type="text/javascript">
	function newUser(){
		window.open("insertUser.html","회원가입","width=500, height=200");
	}
</script>
</head>
<body>

<div class="content">

<ol>
	<li><a href="main.do"><img alt="로고" src="img/tmIcon.png" style="width:30px;height:30px;"></a></li>
	<li><a href="javascript:newUser()">회원가입</a></li>
</ol>

<hr>

<h2>전체목록</h2>
<c:forEach var="v" items="${datas}">
	<c:set var="m" value="${v.m}"/>
	<h3>[${m.uid}] ${m.msg} &gt;&gt; [좋아요 ${m.favcount} | 댓글 ${m.replycount} | ${m.date}] <mytag:msg mid="${m.mid}" uid="${m.uid}" /></h3>
		<form method="post" action="newrp.do">
			<input type="hidden" name="uid" value="${seUser}">
			<input type="hidden" name="mid" value="${m.mid}">
			<mytag:insert type="rmsg" />
			<input type="hidden" name="mcnt" value="${mcnt}">
			<input type="hidden" name="selUser" value="${selUser}">		
		</form>
	<ol><c:forEach  var="r" items="${v.rlist}">
		<li>${r.uid} >> ${r.rmsg} [${r.date}] <mytag:reply rid="${r.rid}" uid="${r.uid}" /> </li>
	</c:forEach></ol>
</c:forEach>

<hr>

<a href="main.do?mcnt=${mcnt+1}&selUser=${selUser}">더보기&gt;&gt;</a>

<hr>

<form method="post" action="control.jsp">
	<input type="hidden" name="action" value="newmsg">
	<input type="hidden" name="uid" value="${seUser}">
	<mytag:insert type="msg" />
	<input type="hidden" name="mcnt" value="${mcnt}">
	<input type="hidden" name="selUser" value="${selUser}">
</form>

<hr>

<mytag:login />

<hr>

<h4>신규 회원 목록</h4>
<ol>
	<c:forEach var="u" items="${newUsers}">
		<li><a href="main.do?mcnt=${mcnt}&selUser=${u.uid}">${u.name}</a>님 가입</li>
	</c:forEach>
</ol>

</div>
<div class="ad">
	<ul>
		<li><a href="https://www.dongwonmall.com/product/detail.do?productId=001080733&cate_id=&keyword=%EB%8F%99%EC%9B%90%20%EC%B0%B8%EC%B9%98"><img alt="광고_동원참치" src="img/ad1.png" style="width:200px;height:200px;"></a></li>
		<li><a href="https://www.youtube.com/watch?v=Es3oxg9fDDY"><img alt="광고_유튜브" src="img/ad2.png" style="width:200px;height:200px;"></a></li>
		<li><a href="https://comic.naver.com/webtoon/list?titleId=570503&weekday=thu"><img alt="광고_웹툰" src="img/ad3.jpg" style="width:200px;height:200px;"></a></li>
	</ul>
</div>

</body>
</html>