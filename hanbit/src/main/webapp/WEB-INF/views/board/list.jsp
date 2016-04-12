<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<div id="wrapper">
	<jsp:include page="list_table.jsp" />
</div>
<script src="${js}/article.js"></script>
<script type="text/javascript">
$(function() {
	var context = '${context}';
	
	$('#writeBtn').click(function() {
		article.writeForm(context);
	});
	$('#searchBtn').click(function() {
		var keyField = $('select[name=keyField] option:selected').val();
		var keyword = $('#keyword').val();
		$('#wrapper').empty();
		$('#wrapper').load(context+'/article/list?keyField='+keyField+'&keyword='+keyword);
	});
});

</script>