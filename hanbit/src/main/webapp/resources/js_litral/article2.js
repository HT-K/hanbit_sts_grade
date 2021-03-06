/**
 * 게시판 
 */
var article = {
	myArticle : function(context) {
		alert('내가 쓴 글 게시판 목록 진입');
	},
	articleAll : function(context) {
		alert('전체 게시판 목록 진입');
	},
	writeForm : function() {
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
				$('form').attr('method','post').attr('action',article.getContext()+'/article/write').submit();
			});
			
			
	},
	update : function() {
		$.ajax({
			url : '',
			data : {},
			async : true,
			dataType : 'json',
			success : function(data) {
				var searchResult = '<form>'
					+'<div class="form-group">'
					+'<label for="exampleInputEmail1">글번호</label>'
					+'<input type="text" class="form-control" id="articleId" name="articleId" value="'+data.article.articleId+'" readonly>'
					+'</div>'
					+'<div class="form-group">'
					+'<label for="exampleInputEmail1">제목</label>'
					+'<input type="text" class="form-control" id="title" name="title" value="'+data.article.title+'" >'
					+'</div>'
					+'<div class="form-group">'
					+'<label for="exampleInputPassword1">작성자</label>'
					+'<input type="text" class="form-control" id="writerName" name="writerName" value="'+data.article.writerName+'" readonly></div>'
					+'<div class="form-group">'
					+'<label for="exampleInputFile">비밀번호</label>'
					+'<input type="password" id="password" class="form-control" name="password" value="'+data.article.password+'"></div>'
					+'<div class="form-group">'
					+'<label for="exampleInputFile">글내용</label>'
					+'<textarea id="content" name="content" class="form-control"  rows="5" >'+data.article.content+'</textarea></div>'
					+'<button type="submit" id="updateSubmit" class="btn col-xs-6 btn-primary btn-lg" >수 정</button>'
					+'<button type="submit" id="deleteSubmit" class="btn col-xs-6 btn-danger btn-lg" >삭 제</button>'
					+'</form>';
				$('.container').html(searchResult);
			/*	$("textarea#content").text(data.article.content);*/
				$('#updateSubmit').click(function(e) {
					e.preventDefault(); /*기존에 submit 을 무력화 시켜라*/
					$.ajax(article.getContext()+'/article/update',{
						data : {
							articleId : $('#articleId').val(),
							title : $('#title').val(),
							writerName : $('#writerName').val(),
							password : $('#password').val(),
							content : $('#content').val()
						},
						type : 'post',
						success : function(data) {
							article.detail(article.getContext()+"/article/search/"+data.id);
						},
						error : function(xhr,status,msg) {
							alert('에러발생상태 :'+status+',내용 : '+msg);
						}
							
					});
				});
				$('#deleteSubmit').click(function(e) {
					e.preventDefault();
					$.ajax(article.getContext()+'/article/delete',{
						data : {articleId : $('#articleId').val()},
						success : function(data) {
							alert(data.message);
							location.href = article.getContext()+'/article/list';
						},
						error : function(xhr,status,msg) {
							alert('에러발생상태 :'+status+',내용 : '+msg);
						}
					});
				});
			},
			error : function(xhr,status,msg) {
				alert('에러발생상태 :'+status+',내용 : '+msg);
			}
		});
	},
	detail : function(url) {
		$.ajax({
			url : url,
			data : {},
			async : true,
			dataType : 'json',
			success : function(data) {
				var searchResult = '<form>'
					+'<div class="form-group">'
					+'<label for="exampleInputEmail1">글번호</label>'
					+'<input type="text" class="form-control" id="articleId" name="articleId" value="'+data.article.articleId+'" readonly>'
					+'</div>'
					+'<div class="form-group">'
					+'<label for="exampleInputEmail1">제목</label>'
					+'<input type="text" class="form-control" id="title" name="title" value="'+data.article.title+'" >'
					+'</div>'
					+'<div class="form-group">'
					+'<label for="exampleInputPassword1">작성자</label>'
					+'<input type="text" class="form-control" id="writerName" name="writerName" value="'+data.article.writerName+'" readonly></div>'
					+'<div class="form-group">'
					+'<label for="exampleInputFile">비밀번호</label>'
					+'<input type="password" id="password" class="form-control" name="password" value="'+data.article.password+'"></div>'
					+'<div class="form-group">'
					+'<label for="exampleInputFile">글내용</label>'
					+'<textarea id="content" name="content" class="form-control"  rows="5" >'+data.article.content+'</textarea></div>'
					+'<button type="submit" id="updateForm" class="btn col-xs-6 btn-primary btn-lg" >수 정</button>'
					+'<button type="submit" id="replySubmit" class="btn col-xs-6 btn-danger btn-lg" >댓 글 감 추 기</button>'
					+'</form>';
				searchResult+=article.replyForm;
				$('.container').html(searchResult);
				$('#updateForm').click(function() {
					
				});
				$('#replySubmit').click(function() {
					article.reply();
				});
			},
			error : function(xhr,status,msg) {
				alert('에러발생상태 :'+status+',내용 : '+msg);
			}
		});
	},
	replyForm : '<form>'
			+'<div class="form-group">'
			+'<label for="exampleInputFile">댓 글</label>'
			+'<form><textarea name="reply" id="reply" class="form-control"  rows="10"></textarea></form>'
			+'<button type="submit" id="updateForm" class="btn col-xs-6 btn-success btn-lg" >확 인</button>'
			+'<button type="submit" id="replySubmit" class="btn col-xs-6 btn-warning btn-lg" >취 소</button>'
			+'</form>'
	
};