<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<c:set var="now" value="<%=new java.util.Date()%>" />
<style>
 	.nav li a {color:gray}
 </style>
<header style="width:100%;margin: 0 auto">
   	<div style="text-align: center;">
   		<h3><a href="${context}/">사용자 페이지</a></h3>
   	</div>
 <nav class="navbar navbar-inverse " >
  <div class="container-fluid">           
<ul class="nav nav-pills">
     <li role="presentation" style="float:right;margin:0 100px 0 0">
  	<a href="${context}/member/login" id="logout">로그아웃</a>
  </li>
   <li role="presentation" style="float:right;margin:0 100px 0 0">
  	<a href="${context}/member/mypage" id="mypage">마이페이지</a>
  </li>
  	<li role="presentation" style="float:right;margin:0 100px 0 0">
  	<a href="${context}/article/list" id="article_list">게시판</a>
  </li>
 

</ul>
</div>
</nav>

</header>
<%-- <c:choose>
	<c:when test="empty sessionScope.user || empty sessionScope.admin">
		<jsp:include page="../global/default_header.jsp"/>
	</c:when>
	<c:otherwise>
		<c:choose>
			<c:when test="${user.level eq 'admin'}">
				<jsp:include page="../admin/admin_header.jsp"/>
			</c:when>
			<c:otherwise>
				<jsp:include page="../member/member_header.jsp"/>
			</c:otherwise>
		</c:choose>
	</c:otherwise>
</c:choose> --%>










