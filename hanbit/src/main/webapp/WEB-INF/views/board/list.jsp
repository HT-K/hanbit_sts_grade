<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<div id="wrapper">
	<jsp:include page="list_table.jsp" />
</div>
<script src="${js}/article.js"></script>
<script type="text/javascript">
$(function() {
	article.setContext('${context}');
	$('#writeBtn').click(function() {
		article.getContext();
		article.writeForm();
	});
	$('#searchBtn').click(function() {
		var keyField = $('select[name=keyField] option:selected').val();
		var keyword = $('#keyword').val();
		$('#wrapper').empty();
		$('#wrapper').load(context+'/article/list?keyField='+keyField+'&keyword='+keyword);
	});
	$('.searchId').click(function() {
		alert($(this).attr('href'));
		article.detail($(this).attr('href'));
		return false;
		
	});
});

</script>