<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<header style="width:100%;margin: 0 auto">
 <h3 style="color: white; text-align: center;">
  		<a href="${context}/">관리자 페이지</a>
  	</h3>
  	<p style="float:right;margin-right: 50px;"><fmt:formatDate type="both" value="${now}" /></p>
            

<ul class="nav nav-pills">
  <li role="presentation" style="float:right;margin:0 100px 0 0">
  	<a href="${context}/admin/logout" >로그아웃</a>
  </li>
</ul>


</header>