<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<div id="detail">
		<div class="joinTop">
			<h2 class="text-center">수정정보</h2>
		</div>
			
		<div class="joinCenter row">
			<form>
				<fieldset class="joinField">
					<div class="form-group">
					 	<label for="input_id" class="col-sm-4 control-label">프로필 이미지 등록</label>
					 	<div class="col-sm-2">
							<img src="${img}/member/${member.profileImg}" alt="" style="width:200px;height:230px"/>
						</div>
					 	<div class="col-sm-2">
							<input type="file" id="profile_img" name="profile_img" />
						</div>
					</div>
					<div class="form-group">
					 	<label for="input_id" class="col-sm-4 control-label">아이디</label>
					 	<div class="col-sm-4">
							<input type="text" class="form-control" id="id" name="id" value="${member.id}" readonly="readonly"/>
						</div>
					</div>
					<div class="form-group">
						<label for="input_pw" class="col-sm-4 control-label">비밀번호</label>
					 	<div class="col-sm-4">
							<input type="password" class="form-control" id="password" name="password" value="${member.password}"/>
						</div>
					</div>
					<div class="form-group">
						<label for="input_name" class="col-sm-4 control-label">이름</label>
					 	<div class="col-sm-4">
							<input type="text" class="form-control" id="name" name="name" value="${member.name}" readonly="readonly"/>
						</div>
					</div>
					<div class="form-group">
						<label for="input_name" class="col-sm-4 control-label">주소</label>
					 	<div class="col-sm-4">
							<input type="text" class="form-control" id="addr" name="addr" value="${member.addr}"/>
						</div>
					</div>
					<div class="form-group">
						<label for="input_name" class="col-sm-4 control-label">생년월일</label>
					 	<div class="col-sm-4">
							<input type="text" class="form-control" id="birth" name="birth" value="${member.birth}" readonly="readonly"/>
						</div>
					</div>
					<div class="input_button text-center">
						<button id="updateBtn">수정</button>
						<button id="cancleBtn">취소</button>
					</div>
						
				</fieldset>
			</form>
		</div>
	</div>
	<script src="${js}/member.js"></script>
	<script>
	$(function() {
		$form = $('form');
		/*
		=== AJAX 적용 전 방식 ===
		$form.addClass('form-horizontal').attr('method','post')
			.attr('action','${context}/member/update.do');
		*/
		$form.addClass('form-horizontal');
		$('#updateBtn').addClass('btn btn-primary').click(function() {
			global.setContext('${context}');
			member.update();
		});
		$('#cancleBtn').addClass('btn btn-primary').click(function() {
			$form.reset();
		});
	});

	</script>