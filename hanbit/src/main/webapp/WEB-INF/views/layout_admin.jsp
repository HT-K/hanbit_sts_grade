<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<html>
<head>
	<meta charset="UTF-8" />
	<title>관리자 페이지</title>
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
<script src="${js}/admin.js"></script>
<script src="${js}/member.js"></script>
<script src="${js}/record.js"></script>
<script type="text/javascript">
	$(function() {
		var context = '${context}';
		$('#subjectMgmt').click(function(e) {
			e.preventDefault();
			subject.init(context);
		});
		$('#adminMgmt').click(function(e) {
			e.preventDefault();
			admin.init(context);
		});
		$('#memberMgmt').click(function(e) {
			e.preventDefault();
			member.init(context);
		});
		$('#recordMgmt').click(function(e) {
			e.preventDefault();
			record.init(context);
		});
	});
</script>
</html>
