<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<jsp:include page="../global/header.jsp" />
<style>
	table th{background: yellow;text-align: center;}
</style>
<div class="container">
<span class="glyphicon glyphicon-pencil" id="writeBtn" style="cursor:pointer; float: right;margin : 0 50px 30px 0">글쓰기</span>
<table class="table table-condensed table-bordered table-striped" >
	<c:if test="${command.totalPages > 0 }">
	<tr>
		<td colspan="5">
			${command.startRow} - ${command.endRow}
			[${command.pageNO}/${command.count}]
		</td>
	</tr>
	</c:if>
	<tr>
		
		<th>글 번호</th>
		<th>제목</th>
		<th>작성자</th>
		<th>작성일</th>
		<th>조회수</th>
	</tr>
	<c:choose>
	<c:when test="${command.count==0}">
	<tr>
		<td colspan="5" style="text-align: center;">
			게시글이 없습니다.
		</td>
	</tr>
	
	</c:when>
	<c:otherwise>
	<c:forEach var="article" items="${list}">
	<tr>
		<td>${article.articleId}</td>
		<td>
			<c:if test="${article.level}>0">
			<c:forEach begin="1" end="${article.level}">-</c:forEach>&gt;
			</c:if>
			<a href="${context}/article/page/${page}">${article.title}</a>
		</td>
		<td>${article.writerName}</td>
		<td>${article.postingDate}</td>
		<td>${article.readCount}</td>
	</tr>
	</c:forEach>
		</c:otherwise>
	</c:choose>
	</table>
	<nav>
	<ul class="pagination" style="margin-left: 40%">
		<c:if test="${command.startPage -command.pageSize gt 0}">
			<li class="disabled">
      <a href="${context}/article/page/${command.startPage-command.pageSize}" aria-label="Previous">
        <span aria-hidden="true">&laquo;</span>
      </a>
    </li>
		</c:if>
		
		<c:forEach begin="${command.startPage}" end="${command.endPage}" step="1" varStatus="i">
			<c:choose>
				<c:when test="${i.index == command.pageNO}">
					 <li class="active"><span>${i.index}<span class="sr-only">(current)</span></span></li>
				</c:when>
				<c:otherwise>
					<li><span><a href="${context}/article/page/${page}">${i.index}</a></span></li>
				</c:otherwise>
				
			</c:choose>
		</c:forEach>
		<c:if test="${command.startPage -command.pageSize gt 0}">
			<li class="disabled"><a href="${context}/article/page/${command.startPage+command.pageSize}" aria-label="Next">
       
        <span aria-hidden="true">&raquo;</span>
      </a> </li>
		</c:if>
 </ul>
	</nav>
	<div style="float:right;margin:0 50px 0 0">
		<form>
			<select name="keyField" id="keyField">
				<option value="title" selected="selected">제목</option>
				<option value="name" >이름</option>
			</select>
			<input type="text" name="keyword" id="keyword" />
			<input type="submit" value="검색" id="searchBtn"/>
		</form>
	</div>

</div>