/**
 * Admin
 */
var admin = {
	memberProfile : function(url) {
		$.getJSON(url,function(data){
			var profile = '<table id="profile"><tr><td rowspan="9" id="td_profile"><img id="profile" src="'+member.getContext()+'/resources/img/member/song.PNG" /></td>'
			+'<th id="item" style="width:200px;text-align:center;background-color:yellow">항목</th><th style="width:200px;text-align:center;background-color:yellow">내용</th></tr><tr><td>아이디</td><td>'+data.id+'</td></tr><tr><td>비밀번호</td><td>'+data.password
			+'</td></tr><tr><td>이름</td><td>'+data.name+'</td></tr><tr><td>생일</td><td>'+data.birth+'</td></tr><tr>'
			+'<td>주소</td><td>'+data.addr+'</td></tr><tr><td>이메일</td><td>'+data.email+'</td>'
			+'</tr><tr><td>등록일</td><td>'+data.regdate+'</td></tr></table>'
			$('#content').html(profile);
			$('#profile').css('margin','0 auto').css('border','1px solid black');
			$('#profile tr').css('border','1px solid black');
			$('#profile tr th').css('border','1px solid black');
			$('#profile tr td').css('border','1px solid black');
		});
	}
}