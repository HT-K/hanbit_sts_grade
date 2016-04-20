/**
 * member
 */
var member = {
	context : '',
	setContext : function(context) {
		this.context = context;
	},
	getContext : function() {
		return this.context;
	},
	init : function(context) {
		this.setContext(context);
		$.getJSON(member.getContext()+'/member/list',function(data) {
			var member_list = '<div class="container" style="width:1000px;height:450px; margin:0 auto;">'
			+ '<table id="member_list" style="width:100%;margin-top: 30px">'
			+ '<tr style="background-color: yellow;">'
			+ '<th style="text-align: center;">아이디</th>'
			+'<th>이름</th>'
			+'<th>전공</th>'
			+'<th>수강과목</th> '
			+'<th>주소</th>'
			+'<th>생년월일</th></tr>';
			
			$.each(data.list, function(index,member) {
				member_list += '<tr><td>'+member.id+'</td>'
					+'<td><a href="'+member.getContext()+'/grade/add/'+member.id+'">'
						+member.name+'</a></td>'
					+'<td>'+member.major+'</td>'
					+'<td>'+member.subject+'</td> '
					+'<td>'+member.addr+'</td>'
					+'<td>'+member.birth+'</td></tr>';
			});
			member_list += '</table></div>'
			$('#content').html(member_list);
			$('#member_list').css('border','1px solid black');
			$('#member_list th').css('border','1px solid black').css('text-align','center');
			$('#member_list tr').css('border','1px solid black');
			$('#member_list tr td').css('border','1px solid black')
			.css('text-align','center');
		});
	}		
}