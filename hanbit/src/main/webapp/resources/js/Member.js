/**
 * Member
 */
function Member(){}
Member.prototype.joinForm = function(context) {
	var joinForm = '<div id="join">\
		<div class="joinTop">\
			<h2 class="text-center">회원가입</h2>\
		</div>\
		<div class="joinCenter row">\
			<form class="form-horizontal">\
				<fieldset class="joinField">\
					<div class="form-group">\
						<label for="input_cate" class="col-sm-4 control-label">회원등급</label>\
					 	<div class="col-sm-4">\
							<input type="radio" name="cate" id="cate" value="1" checked /> 관리자\
							<input type="radio" name="cate" id="cate" value="2" checked /> 교수\
							<input type="radio" name="cate" id="cate" value="3" checked /> 학생\
						</div>\
					</div>\
					<div class="form-group">\
					 	<label for="input_id" class="col-sm-4 control-label">아이디</label>\
					 	<div class="col-sm-4">\
							<input type="text" class="form-control" id="id" name="id" placeholder="아이디를 입력하세요"/>\
						</div>\
					</div>\
					<div class="form-group">\
						<label for="input_pw" class="col-sm-4 control-label">비밀번호</label>\
					 	<div class="col-sm-4">\
							<input type="password" class="form-control" id="password" name="password" placeholder="비밀번호를 입력하세요"/>\
						</div>\
					</div>\
					<div class="form-group">\
						<label for="input_pw_check" class="col-sm-4 control-label">비밀번호 확인</label>\
						<div class="col-sm-4">\
							<input type="password" class="form-control" name="passwordCheck" id="passwordCheck" placeholder="비밀번호를 확인하세요"/>\
						</div>\
					</div>\
					<div class="form-group">\
						<label for="input_name" class="col-sm-4 control-label">이름</label>\
					 	<div class="col-sm-4">\
							<input type="text" class="form-control" id="name" name="name" placeholder="이름을 입력하세요"/>\
						</div>\
					</div>\
					<div class="form-group">\
						<label for="input_name" class="col-sm-4 control-label">주소</label>\
					 	<div class="col-sm-4">\
							<input type="radio" name="addr" id="addr" value="서울" checked /> 서울\
							<input type="radio" name="addr" id="addr" value="인천" checked /> 인천\
							<input type="radio" name="addr" id="addr" value="경기" checked /> 경기\
							<input type="radio" name="addr" id="addr" value="부산" checked /> 부산\
							<input type="radio" name="addr" id="addr" value="대전" checked /> 대전\
						</div>\
					</div>\
					<div class="form-group">\
						<label for="input_name" class="col-sm-4 control-label">생년월일</label>\
					 	<div class="col-sm-4">\
							<input type="text" class="form-control" id="birth" name="birth" placeholder="생년월일을 입력하세요"/>\
						</div>\
					</div>\
					\
					<div class="input_button text-center">\
						<input type="button" id="joinBtn" value="회원가입"/>\
						<button id="cancleBtn">취소</button>\
					</div>\
						\
				</fieldset>\
			</form>\
		</div>\
	</div>';
	$('#content').html(joinForm);
	$('#joinBtn').click(function() {
		alert('회원가입 버튼 클릭');
		var member = {
			id : $('#id').val(),	
			password : $('#password').val(),	
			birth : $('#birth').val(),	
			addr : $('#addr').val(),	
			name : $('#name').val(),	
			cate : $('#cate').val()	
		};
		alert('멤버 데이터 JSON 처리됨'+context);
		$.ajax({
			url : context+'/member/join',
			data : JSON.stringify(member),
			dataType : 'json',
			type : 'POST',
			contentType: "application/json",
			mimeType : "application/json",
			async : false,
			success : function(data) {
				if (data != null) {
					alert(data.name+'님 회원으로 등록되었습니다');
					location.href = context+'/member/login';
				} else {
					alert('회원가입 중 오류가 발생했습니다');
					return false;
				}
			},
			error : function(request,status,error) {
				alert("code:"+request.status+"\n"+"message:"+request.responseText+"\n"+"error:"+error);
			}
		});
	});
}