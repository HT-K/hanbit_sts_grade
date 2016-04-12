/**
 * 게시판 
 */
var article = {
	writeForm : function(context) {
		var writeForm = '<form>'
			+'<div class="form-group">'
			+'<label for="exampleInputEmail1">제목</label>'
			+'<input type="text" class="form-control" id="title" name="title" placeholder="제 목">'
			+'</div>'
			+'<div class="form-group">'
			+'<label for="exampleInputPassword1">작성자</label>'
			+'<input type="text" class="form-control" id="writerName" name="writerName" placeholder="작 성 자"></div>'
			+'<div class="form-group">'
			+'<label for="exampleInputFile">비밀번호</label>'
			+'<input type="password" id="password" class="form-control" name="password" placeholder="비 밀 번 호"></div>'
			+'<div class="form-group">'
			+'<label for="exampleInputFile">글내용</label>'
			+'<textarea id="content" name="content" class="form-control"  rows="5" placeholder="글 내 용"></textarea></div>'
			+'<button type="submit" id="writeSubmit" class="btn btn-primary btn-lg btn-block">전 송</button>'
			+'</form>';
			$('.container').html(writeForm);
			$('#writeSubmit').click(function() {
				$('form').attr('method','post').attr('action',context+'/article/write').submit();
			});
			
	},
	detail : function(context) {
		$.ajax({
			url : context+'/article/detail',
			data : {
				keyField : $('select[name=keyField] option:selected').val(),
				keyword : $('#keyword').val()
			},
			async : true,
			dataType : 'json',
			success : function(data) {
				var searchResult = '<form>'
					+'<div class="form-group">'
					+'<label for="exampleInputEmail1">제목</label>'
					+'<input type="text" class="form-control" id="title" name="title" value="'+data.title+'" readonly>'
					+'</div>'
					+'<div class="form-group">'
					+'<label for="exampleInputPassword1">작성자</label>'
					+'<input type="text" class="form-control" id="writerName" name="writerName" value="'+data.writerName+'"></div>'
					+'<div class="form-group">'
					+'<label for="exampleInputFile">비밀번호</label>'
					+'<input type="password" id="password" class="form-control" name="password" value="'+data.password+'"></div>'
					+'<div class="form-group">'
					+'<label for="exampleInputFile">글내용</label>'
					+'<textarea id="content" name="content" class="form-control"  rows="5" value="'+data.content+'"></textarea></div>'
					+'<button type="submit" id="writeSubmit" class="btn btn-primary btn-lg btn-block">전 송</button>'
					+'</form>';
					$('.container').append(writeForm);
			},
			error : function(xhr,status,msg) {
				alert('에러발생상태 :'+status+',내용 : '+msg);
			}
		});
	}
};