<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
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
		<form action="${context}/article/option">
			<select name="keyField" id="keyField">
				<option value="title" selected="selected">제목</option>
				<option value="name" >이름</option>
			</select>
			<input type="text" name="keyword" id="keyword" value="" />
			<input type="hidden" name="pageNO" />
			<input type="hidden" name="command" value="main" />
			<input type="submit" value="검색" id="searchBtn"/>
		</form>
	</div>

</div>
<script src="${js}/article.js"></script>
<script type="text/javascript">
$(function() {
	var context = '${context}';
	$('#writeBtn').click(function() {
		article.writeForm(context);
	});
	$('#searchBtn').click(function() {
		$.ajax({
			url : context+'/article/search',
			data : {
				keyField : $('select[name=keyField] option:selected').val(),
				keyword : $('#keyword').val()
			},
			asynce : true,
			dataType : 'json',
			success : function(data) {
				var searchResult = '<form>'
					+'<div class="form-group">'
					+'<label for="exampleInputEmail1">제목</label>'
					+'<input type="text" class="form-control" id="title" name="title" value="'+data.title+'" readonly>'
					+'</div>'
					+'<div class="form-group">'
					+'<label for="exampleInputPassword1">작성자</label>'
					+'<input type="text" class="form-control" id="writerName" name="writerName" value="'+data.writerName+'"></div>'
					+'<div class="form-group">'
					+'<label for="exampleInputFile">비밀번호</label>'
					+'<input type="password" id="password" class="form-control" name="password" value="'+data.password+'"></div>'
					+'<div class="form-group">'
					+'<label for="exampleInputFile">글내용</label>'
					+'<textarea id="content" name="content" class="form-control"  rows="5" value="'+data.content+'"></textarea></div>'
					+'<button type="submit" id="writeSubmit" class="btn btn-primary btn-lg btn-block">전 송</button>'
					+'</form>';
					$('.container').append(writeForm);
			},
			error : function(xhr,status,msg) {
				alert('에러발생상태 :'+status+',내용 : '+msg);
			}
		});
	});
	
});

</script>