<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<style>
	#subject_list{border : 1px solid black}
	#subject_list th	{border : 1px solid black;text-align: center}
	#subject_list tr td	{border : 1px solid black;text-align: center}
	#subject_list tr	{border : 1px solid black}
</style>
<div class="container" style="width:1000px;height:450px; margin:0 auto;">

	<table id="subject_list" style="width:100%;margin-top: 30px">
	<tr style="background-color: yellow;">
		<th style="text-align: center;">NO</th>
		<th>과목명</th>
		<th>담당교수</th>
	</tr>
		<c:forEach items="${list}"  var="subject" >
			<tr>
				<td>${subject.subjSeq}</td>
				<td><a href="${context}/subject/${subject.subjSeq}">${subject.subjName}</a></td>
				<td><a href="${context}/admin/${subject.profId}">${subject.profName}</a></td>
			</tr>	
		</c:forEach>
</table>
</div>
<script src="${context}/resources/js/admin.js"></script>	
<script type="text/javascript">
$(document).ready(function() {
	
});
</script>








