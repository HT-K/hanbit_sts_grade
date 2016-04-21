/**
 * member
 */
var member = {
	init : function(context) {
		$.getJSON(context+'/member/list',function(data) {
			var member_list = '<div class="container" style="width:1000px;height:450px; margin:0 auto;">'
			+ '<table id="member_list" style="width:100%;margin-top: 30px">'
			+ '<tr style="background-color: yellow;">'
			+ '<th style="text-align: center;">아이디</th>'
			+'<th>이름</th>'
			+'<th>전공</th>'
			+'<th>수강과목</th> '
			+'<th>주소</th>'
			+'<th>생년월일</th></tr>';
			$.each(data, function(index,value) {
				member_list += '<tr><td>'+this.id+'</td>'
					+'<td><a class="memberProfile" href="'+context+'/admin/member/profile/'+this.id+'">'
						+this.name+'</a></td>'
					+'<td>'+this.major+'</td>'
					+'<td>'+this.subject+'</td> '
					+'<td>'+this.addr+'</td>'
					+'<td>'+this.birth+'</td></tr>';
			});
			member_list += '</table></div>'
			$('#content').html(member_list);
			$('#member_list').css('border','1px solid black');
			$('#member_list th').css('border','1px solid black').css('text-align','center');
			$('#member_list tr').css('border','1px solid black');
			$('#member_list tr td').css('border','1px solid black')
			.css('text-align','center');
			$('.memberProfile').click(function(e) {
				e.preventDefault();
				admin.memberProfile($(this).attr('href'));
			});
			
		});
	},
	updateForm : function(context) {
		alert('업데이트 폼으로 진입');
		$.getJSON(context+'/member/detail',function(data){
			
		});
	},
	update : function(context) {
		$.ajax({
			url : context+'/member/update',
			data : {
				"id" : $('#id').val(),
				"password" : $('#password').val(),
				"addr" : $('#addr').val(),
				"profileImg" : $('#profile_img').val()
			},
			dataType : 'json',
			type : 'post',
			contentType : 'application/json',
			mimeType : 'application/json',
			success : function(data) {
				alert('수정성공 '+data.profileImg);
			},
			error : function(xhr,status,msg) {
				alert('에러발생상태 :'+status+',내용 : '+msg);
			}
		});
	}
}










