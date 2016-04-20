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
	<div id="test"></div>
</body>
<script src="${js}/subject.js"></script>
<script src="${js}/admin.js"></script>
<script src="${js}/member.js"></script>
<script src="${js}/record.js"></script>
<script type="text/javascript">
	$(function() {
		var context = '${context}';
		$('#subjectMgmt').click(function() {
			subject.init(context);
		});
		$('#adminMgmt').click(function() {
			admin.init(context);
		});
		$('#memberMgmt').click(function() {
			alert('멤버관리 클릭');
			$.ajax({
				url :'${context}/member/list',
				dataType : 'json',
				success : function(data) {
					if (data != null) {
						alert('성공 !!!'+data.name);
					}else{
						alert('실패 !!!');
					}
					var member_list = '<div class="container" style="width:1000px;height:450px; margin:0 auto;">'
						+ '<table id="member_list" style="width:100%;margin-top: 30px">'
						+ '<tr style="background-color: yellow;">'
						+ '<th style="text-align: center;">아이디</th>'
						+'<th>이름</th>'
						+'<th>전공</th>'
						+'<th>수강과목</th> '
						+'<th>주소</th>'
						+'<th>생년월일</th></tr>';
						
						/*  $.each(data, function(index,v) { */
							member_list += '<tr><td>'+data.id+'</td>'
								+'<td>'
									+data.name+'</a></td>'
								+'<td>'+data.major+'</td>'
								+'<td>'+data.subject+'</td> '
								+'<td>'+data.addr+'</td>'
								+'<td>'+data.birth+'</td></tr>';
						/* });  */
						member_list += '</table></div>'
						$('#content').html(member_list);
						$('#member_list').css('border','1px solid black');
						$('#member_list th').css('border','1px solid black').css('text-align','center');
						$('#member_list tr').css('border','1px solid black');
						$('#member_list tr td').css('border','1px solid black')
						.css('text-align','center');
				},
				error : function(xhr,status,msg) {
					alert('에러발생상태 :'+status+',내용 : '+msg);
				}
			});
		});
		$('#recordMgmt').click(function() {
			record.init(context);
		});
	});
</script>
</html>
