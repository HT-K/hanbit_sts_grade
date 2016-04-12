<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<style>
	/* table{border: 1px solid black;width: 80%;margin-left: 10%}
	table tr{border: 1px solid black}
	table tr th{border: 1px solid black;text-align: center;background: yellow}
	table tr td{border: 1px solid black} */
</style>
<jsp:include page="../global/header.jsp" />
<div class="container">
<div style="margin-right: 100px">
	<img src="${context}/resources/img/write.png" id="writeBtn" style="cursor:pointer; width: 50px;height: 50px;float: right;margin-right: 50px" alt="" />
</div>
<table class="table table-condensed" >
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
		<td>${article.writeName}</td>
		<td>${article.postingDate}</td>
		<td>${article.readCount}</td>
	</tr>
	</c:forEach>
	<tr>
		<td colspan="5">
			<a href="#">
			<img src="${context}/resources/img/write.png" style="width: 50px;height: 50px;float: right;margin-right: 50px" alt="" />
			</a>
		</td>
		
	</tr>
	<tr>
		<td colspan="5">
		<c:if test="${command.startPage -command.pageSize gt 0}">
			<a href="${context}/article/page/${command.startPage-command.pageSize}">◀ 이전</a>
		</c:if>
		<c:forEach begin="${command.startPage}" end="${command.endPage}" step="1" varStatus="1">
			<c:choose>
				<c:when test="${i.index == command.pageNO}">
					<font color="red">${i.index}</font>
				</c:when>
				<c:otherwise>
					<a href="${context}/article/page/${page}">${i.index}</a>
				</c:otherwise>
				
			</c:choose>
		</c:forEach>
		<c:if test="${command.startPage -command.pageSize gt 0}">
			<a href="${context}/article/page/${command.startPage+command.pageSize}">다음 ▶</a>
		</c:if>
		</td>
	</tr>
	</c:otherwise>
	</c:choose>
	<tr>
		<td colspan="5">
		<form action="${context}/article/option">
			<select name="keyField" id="">
				<option value="id" selected="selected">아이디</option>
				<option value="name" selected="selected">이름</option>
			</select>
			<input type="text" name="keyword" value="" />
			<input type="hidden" name="pageNO" />
			<input type="hidden" name="command" value="main" />
			<input type="submit" value="검색" />
		</form>
		</td>
	</tr>
</table>
</div>
<script type="text/javascript">
$(function() {
	$('#writeBtn').click(function() {
		$('.container').empty();
		var writeForm = '<form>'
		+'<div class="form-group">'
		+'<label for="exampleInputEmail1">제목</label>'
		+'<input type="text" class="form-control" id="title" name="title" placeholder="Email">'
		+'</div>'
		+'<div class="form-group">'
		+'<label for="exampleInputPassword1">작성자</label>'
		+'<input type="text" class="form-control" id="writerName" name="writerName" placeholder="작성자"></div>'
		+'<div class="form-group">'
		+'<label for="exampleInputFile">글암호</label>'
		+'<input type="password" id="password" class="form-control" name="password"></div>'
		+'<div class="form-group">'
		+'<label for="exampleInputFile">글내용</label>'
		+'<textarea id="content" name="content" class="form-control"  rows="5"></textarea></div>'
		+'<button type="submit" id="writeSubmit" class="btn btn-primary btn-lg btn-block">전송</button>'
		+'</form>';
		$('.container').html(writeForm);
	});
});
</script>