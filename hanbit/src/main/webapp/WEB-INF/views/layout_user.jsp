<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<html>
<head>
	<meta charset="UTF-8" />
	<title>사용자 페이지</title>
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.0/jquery.min.js"></script>
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap-theme.min.css">
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>
</head>
<body>
	<div id="header">
		  <tiles:insertAttribute name="header" />
	</div>
	<div id="content">
		<tiles:insertAttribute name="content" />
	</div>
	<div id="footer" style="text-align:center">
		<tiles:insertAttribute name="footer" />
	</div>
</body>
<script src="${js}/subject.js"></script>
<script src="${js}/Article.js"></script>
<script src="${js}/admin.js"></script>
<script src="${js}/member.js"></script>
<script src="${js}/record.js"></script>
<script src="${js}/Global.js"></script>
<script src="${js}/Hanbit.js"></script>
<script type="text/javascript">
	$(function() {
		var context = $.fn.global('${context}').getContext();
		var article = $.fn.article();
		$('#article_all').click(function(e) {
			e.preventDefault();
			article.articleAll(context);
		});
		$('#my_article').click(function(e) {
			e.preventDefault();
			article.myArticle(context);
		});
		$('#logout').click(function(e) {
			e.preventDefault();
			location.href='${context}/member/logout'; 
			
		});
		$('#mypage').click(function(e) {
			e.preventDefault();
			member.detail(context);
		});
		$('#updateBtn').click(function(e) {
			e.preventDefault();
			member.updateForm(context);
		});
	});
</script>
</html>
