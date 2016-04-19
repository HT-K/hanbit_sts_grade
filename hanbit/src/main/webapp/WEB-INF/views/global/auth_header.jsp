<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<c:set var="now" value="<%=new java.util.Date()%>" />
<header style="width:100%;margin: 0 auto">
 <h3 style="color: white; text-align: center;">
  		<a href="${context}/">한빛 교육 센터</a>
  	</h3>
  	<p style="float:right;margin-right: 50px;"><fmt:formatDate type="both" value="${now}" /></p>
            

<ul class="nav nav-pills">
  
  <li role="presentation" style="margin-left: 100px">
  	<a href="${context}/article/list">게시판</a>
  </li>
   <li role="presentation" style="margin-left: 100px">
  	<a href="${context}/member/login">로그아웃</a>
  </li>
  <li role="presentation" style="margin-left: 100px">
  	<a href="${context}/member/mypage">마이페이지</a>
  </li>
</ul>


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










