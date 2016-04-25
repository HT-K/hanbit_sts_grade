/**
 * Article.JS
 */
function Article(){}
Article.prototype.myarticle=function(){
	alert('내가 쓴 글 진입');
}
Article.prototype.articleAll=function(context,page){
	alert("모든 게시글 보기 진입");
	$.getJSON(context+'/article/list/'+page,function(data) {
		var totalPages = data.command.totalPages;
		var startRow = data.command.startRow;
		var endRow = data.command.endRow;
		var pageNO = data.command.pageNO;
		var count = data.command.count;
		var startPage = data.command.startPage;
		var endPage = data.command.endPage;
		var pageSize = data.command.pageSize;
		var groupSize = data.command.groupSize; 
		
		
		var articleAllTable = 
			'		<style>\
				table th{background: yellow;text-align: center;}\
			</style>\
			<div class="container">\
			<span class="glyphicon glyphicon-pencil" id="writeBtn" style="cursor:pointer; float: right;margin : 0 50px 30px 0">글쓰기</span>\
			<table class="table table-condensed table-bordered table-striped" >';
			if(totalPages > 0){	
			
				articleAllTable +='<tr>\
					<td colspan="5"> 총게시글\
						['+(count)+']\
					</td>\
				</tr>';
			}
				articleAllTable +='<tr>\
					<th>글 번호</th>\
					<th>제목</th>\
					<th>작성자</th>\
					<th>작성일</th>\
					<th>조회수</th>\
				</tr>';
			if (count==0) {
				articleAllTable += '<tr>\
				<td colspan="5" style="text-align: center;">\
					게시글이 없습니다.\
				</td>\
			</tr>';
			} else {
				$.each(data.list, function(index,article) {
					articleAllTable+=
						'<tr>\
							<td>'+article.articleId+'</td>\
							<td>\
							<a class="searchId" href="'+context+'/article/detail/'+article.articleId+'">'+article.title+'</a>\
							</td>\
							<td>'+article.writerName+'</td>\
							<td>'+article.postingDate+'</td>\
							<td>'+article.readCount+'</td>\
						</tr>';
						
				});
			}
			
					
			articleAllTable+='</table>';
			
			var pagination = '<nav><ul class="pagination" style="margin-left: 40%">';
				
			if (startPage != 1) {
				pagination += '<a href="'+context+'/article/list/1">\
					<img src = "left.png"></a>'
			}	
			if (startPage -groupSize > 0) {
					pagination += '<li class="disabled">\
				      <a href="'+context+'/article/page/'+startPage-groupSize+'" aria-label="Previous">\
				        <span aria-hidden="true">&laquo;</span>\
				      </a>\
				    </li>';
				}
			for (var i = startPage; i <= endPage; i++) {
				if (i == pageNO) {
					pagination += '<li class="active"><span>'+i+'</span></li>';
				} else {
					pagination += '<li><a href="#"><span>'+i+'</span></a></li>';
				}
			}
			if ((startPage + groupSize) <= totalPages) {
				pagination += '<a href="'+context+'/article/list/'+(startPage+groupSize)+'"></a>';
			}
			 '</ul>\
				</nav>';
				articleAllTable +=pagination;
				articleAllTable +='<br/>';
				var searchOption = 
					'<div style="float:right;margin:50px 50px 0 0">\
						<form>\
							<select name="keyField" id="keyField">\
								<option value="title" selected="selected">제목</option>\
								<option value="name" >이름</option>\
							</select>\
							<input type="text" name="keyword" id="keyword" />\
							<input type="submit" value="검색" id="searchBtn"/>\
						</form>\
					</div>';
			articleAllTable += searchOption;
			+'\
			</div>';
		$('#content').html(articleAllTable);
		$('.searchId').click(function() {
			alert('디테일 버튼 클릭');
			Article.prototype.detail($(this).attr('href'));
		});
	});
		
}
Article.prototype.writeForm=function(){
	var writeForm = 
		'<div class="container">'
		+	'<form>'
		+		'<div class="form-group">'
		+			'<label for="title">제목</label>'
		+			'<input type="text" class="form-control" id="title" name="title" placeholder="제 목">'
		+		'</div>'
		+		'<div class="form-group">'
		+			'<label for="writerName">작성자</label>'
		+			'<input type="text" class="form-control" id="writerName" name="writerName" placeholder="작 성 자">'
		+		'</div>'
		+		'<div class="form-group">'
		+			'<label for="password">글암호</label>'
		+			'<input type="password" id="password" class="form-control" name="password" placeholder="비 밀 번 호">'
		+		'</div>'
		+		'<div class="form-group">'
		+			'<label for="content">글내용</label>'
		+			'<textarea id="content" name="content" class="form-control" rows="5" placeholder="글 내 용"></textarea>'
		+		'</div>'
		+		'<button type="submit" id="writeSubmit" class="col-xs-6 btn btn-success btn-lg">등 록</button>'
		+		'<button type="reset" id="writeReset" class="col-xs-6 btn btn-warning btn-lg">취 소</button>'
		+	'</form>'
		+'</div>';
	$('#wrapper').html(writeForm);

	$('#writeSubmit').click(function(e) { // '등 록' 버튼 클릭 시 호출되는 메소드
		e.preventDefault();
		article.write();
	}); // writeForm 변수 End
}
Article.prototype.write=function(){
	$.ajax({
		url : article.getContext() + '/article/write', 
		data : { // 위 URL로 호출되는 컨트롤러에 보낼 데이터들이다.
			title : $('#title').val(),
			writerName : $('#writerName').val(),
			password : $('#password').val(),
			content : $('#content').val()
		},
		type : 'post', // 이곳에 type을 쓰지 않으면 디폴트로 get이 된다.
		async : true, // 당연히 true여야한다. 생략가능하다
		dataType : 'json', // 생략이 가능하다, 왜냐하면 view-context.xml에서 설정해놨다.
		success : function() {
			location.href = article.getContext() + "/article/article_home";
		},
		/*error : function(xhr, status, msg) { // 실패하면 이곳으로, 왼쪽 매개변수는 정해져 있다.
			alert('에러 발생 상태 : '+status+' 내용 : '+msg);
		}*/
	}); // write, .ajax() End
}
Article.prototype.detail=function(url){
	alert('디테일 url :'+url);
	$.getJSON(url,function(data){ // $.ajax({}) , 이런식으로 객체{}를 매개변수로 써야한다.
			var detailForm =
				'<div class="container">'
				+	'<form>'
				+		'<div class="form-group">'
				+			'<label for="articleId">게시글 번호</label>'
				+			'<input type="text" class="form-control" id="articleId" name="articleId" placeholder="글 번호" value="' + data.article.articleId + '" readonly/>'
				+		'</div>'
				+		'<div class="form-group">'
				+			'<label for="title">제목</label>'
				+			'<input type="text" class="form-control" id="title" name="title" placeholder="제 목" value="' + data.article.title + '" readonly />' // value 값은 ''싱글 커터를 살리기 위해 ""더블커터 사이에 싱글커터안에 넣어준다!
				+		'</div>'
				+		'<div class="form-group">'
				+			'<label for="writerName">작성자</label>'
				+			'<input type="text" class="form-control" id="writerName" name="writerName" value="' + data.article.writerName + '" placeholder="작 성 자" readonly />'
				+		'</div>'
				+		'<div class="form-group">'
				+			'<label for="password">글암호</label>'
				+			'<input type="password" id="password" class="form-control" name="password" value="' + data.article.password + '" placeholder="비 밀 번 호" readonly />'
				+		'</div>'
				+		'<div class="form-group">'
				+			'<label for="content">글내용</label>'
				+			'<textarea class="form-control" id="content" name="content" rows="5" placeholder="글 내 용" readonly>' + data.article.content + '</textarea>'
				+		'</div>'
				+		'<div class="form-group">'
				+			'<button type="submit" id="updateFormBtn" name="updateFormBtn" class="btn col-xs-4 btn-primary btn-lg">글 수 정 폼으로</button>'   
				+			'<button type="submit" id="deleteBtn" name="deleteBtn" class="btn col-xs-4 btn-danger btn-lg">글 삭 제</button>'
				+			'<button type="submit" id="replyFormBtn" name="replyFormBtn" class="btn col-xs-4 btn-info btn-lg">댓글 등록 폼</button>'
				+		'</div>'
				+	'</form>'
				+'</div>'
				+'<div class="container" style="margin-top:20px;">'
				+	'<div id="replyDiv">'
				+		'<form id="replyForm" style="display:none;">'
				+			'<div class="form-group">'
				+				'<label for="exampleInputFile">댓 글</label>'
				+				'<textarea class="form-control" row="5" id="reply_content" name="reply_content" placeholder="댓글을 입력해주세요..." style="height : 100px"></textarea>'
				+			'</div>'
				+			'<div class="form-group">'
				+				'<button type="submit" id="replyOkBtn" class="btn col-xs-6 btn-success btn-lg" >댓 글 등 록</button>'
				+				'<button type="reset" id="replyCancle" class="btn col-xs-6 btn-warning btn-lg" >취 소</button>'
				+			'</div>'
				+		'</form>'
				+	'</div>'
				+'</div>'
				+'<div class="container" style="margin-top:20px;" id="replyRes">' // 이 부분을 .html로해서 계속 댓글들을 최신화 시킨다.
				+'</div>';
			$('#wrapper').html(detailForm); // article.detail() 호출 시 article_home.jsp의 wrapper(div) 사이에 있던 내용을 삭제(.empty())하고 detailForm을 붙인다(.append())
			
			// detail로 들어오는 즉시 댓글들을 보여주기 위한 $.ajax()
			$.ajax({
				url : article.getContext() + '/article/reply', 
				data : { // 위 URL로 호출되는 컨트롤러에 보낼 데이터들이다.
					articleId : data.article.articleId
				},
				async : true, // 당연히 true여야한다. 생략가능하다
				dataType : 'json', // 생략이 가능하다, 왜냐하면 view-context.xml에서 설정해놨다.
				success : function(data) { // 해당 URL로 호출된 컨트롤러의 메소드에서 model의 값을 가져오는 것을 성공하면 success가 실행된다 (해당 값(JSON형태)은 파라미터인 data에 들어있다!)
					//alert("댓글 가져오기 성공!");
					$.each(data.reply, function(index, value) {  // 제이쿼리의 for - each문
						// controller에서 보내온 "reply" 접근법, data.reply는 데이터베이스에서 가져온 List<ReplyDTO>를 뜻한다 
						// index는 그안에 있는 하나하나의 ReplyDTO 객체 자체를 뜻한다.
						// value는 그 객체(ReplyDTO)에 들어있는 하나하나의 값(reply_seq, articleId, writerName, reply_content)에 접근할 때 쓴다.
						var replyRes =
							'<form class="form-inline">'
						  	+	'<div class="form-group">'
						    +		'<label for="writerName">댓글 작성자 : '+ value.writerName +'</label>'
						    +	'</div>'
						    +	'<div class="form-group">'
						    +		'<label for="regTime" style="margin-left:20px;">댓글 작성시간 : '+ value.regTime +'</label>'
						    +	'</div>'
						    +	'<button type="submit" class="btn btn-success" style="margin-left:20px;">댓글 수정</button>'
						    +	'<button type="submit" class="btn btn-warning" style="margin-left:5px;">댓글 삭제</button>'
						    +'</form>'
						    +'<div class="form-group">'
							+	'<input type="text" class="form-control" id="replyRes" name="replyRes" value="' + value.reply_content + '"  placeholder="댓글 내용" style="margin-top:10px;" readonly>' // value 값은 ''싱글 커터를 살리기 위해 ""더블커터 사이에 싱글커터안에 넣어준다!
							+'</div>';
						$('#replyRes').append(replyRes);
					  });
				},
				error : function(xhr, status, msg) { // 실패하면 이곳으로, 왼쪽 매개변수는 정해져 있다.
					alert('에러 발생 상태 : '+status+' 내용 : '+msg);
				}
			}); // $.ajax() End
			
			$('#updateFormBtn').click(function(e) { // '수정 폼으로' 클릭 시 호출되는 메소드
				e.preventDefault(); // 기존의 submit를 무력화 시켜라!! (이걸 써주지 않으면 /article/home (이전에 호출되던 URL)로 가버리게된다)
				article.update(updateParam);
			}); // updateFormBtn() End
			
			$('#deleteBtn').click(function(e) { // '글 삭 제' 클릭 시 호출되는 메소드
				e.preventDefault();
				article.deleteArticle(data.article.articleId); // 삭제 할 해당 게시글의 글번호를 매개변수로 보내준다.
			}); // deleteBtn() End
			
			$('#replyFormBtn').click(function(e) { // '댓글 등록 폼' 클릭 시 호출되는 메소드
				e.preventDefault();
				$('#reply_content').val(""); // 또 댓글 등록하고 싶을 때 textarea에 적었던 내용을 없애기 위한 작업 (초기화!!!)
				$("#replyForm").slideToggle("slow"); // 클릭할 때마다 댓글 적는 폼이 나타났다가 안나타났다가 하게 해주는 CSS효과임!!
			}); // replyFormBtn() End
			
			$('#replyOkBtn').click(function(e) { // '댓글 등록' 클릭 시 호출되는 메소드
				e.preventDefault();
				article.reply(data.article.articleId, data.article.writerName, $('#reply_content').val()); // 데이터베이스에 넣을 게시글 번호, 댓글 쓴 사람, 댓글 내용을 파라미터로 보낸다~
			}); // replyOkBtn() End
			
	}); // detail -> $.ajax() End
}
Article.prototype.update=function(){
	var updateForm =
		'<div class="container">'
		+	'<form>'
		+		'<div class="form-group">'
		+			'<label for="articleId">게시글 번호</label>'
		+			'<input type="text" class="form-control" id="articleId" name="articleId" placeholder="글 번호" value="' + updateParam.article.articleId + '" readonly />'
		+		'</div>'
		+		'<div class="form-group">'
		+			'<label for="title">제목</label>'
		+			'<input type="text" class="form-control" id="title" name="title" placeholder="제 목" value="' + updateParam.article.title + '" />' // value 값은 ''싱글 커터를 살리기 위해 ""더블커터 사이에 싱글커터안에 넣어준다!
		+		'</div>'
		+		'<div class="form-group">'
		+			'<label for="writerName">작성자</label>'
		+			'<input type="text" class="form-control" id="writerName" name="writerName"  placeholder="작 성 자" value="' + updateParam.article.writerName + '" readonly />'
		+		'</div>'
		+		'<div class="form-group">'
		+			'<label for="password">글암호</label>'
		+			'<input type="password" id="password" class="form-control" name="password"  placeholder="비 밀 번 호" value="' + updateParam.article.password + '" />'
		+		'</div>'
		+		'<div class="form-group">'
		+			'<label for="content">글내용</label>'
		+			'<textarea id="content" name="content" class="form-control" rows="5" placeholder="글 내 용">' + updateParam.article.content + '</textarea>'
		+		'</div>'
		+		'<div class="form-group">'
		+			'<button type="submit" id="updateOkBtn" name="updateOkBtn" class="btn col-xs-6 btn-primary btn-lg">수 정 완 료</button>'   
		+			'<button type="reset" id="cancelBtn" name="cancelBtn" class="btn col-xs-6 btn-danger btn-lg">수 정 취 소</button>'
		+		'</div>'
		+	'</form>'
		+'</div>';
	$('#wrapper').html(updateForm); // article.update() 호출 시 article_home.jsp의 wrapper(div) 사이에 있던 내용을 삭제(.empty())하고 updateForm을 붙인다(.append())
	
	$('#updateOkBtn').click(function(e) { // '수 정 완 료' 버튼 클릭 시
		e.preventDefault();
		$.ajax({
			url : article.getContext() + '/article/update', 
			data : { // 위 URL로 호출되는 컨트롤러에 보낼 데이터들이다.
				articleId : $('#articleId').val(),
				title : $('#title').val(),
				writerName : $('#writerName').val(),
				password : $('#password').val(),
				content : $('#content').val()
			},
			type : 'post', // 이곳에 type을 쓰지 않으면 디폴트로 get이 된다.
			async : true, // 당연히 true여야한다. 생략가능하다
			dataType : 'json', // 생략이 가능하다, 왜냐하면 view-context.xml에서 설정해놨다.
			success : function(data) { // 해당 URL로 호출된 컨트롤러의 메소드에서 model의 값을 가져오는 것을 성공하면 success가 실행된다 (해당 값(JSON형태)은 파라미터인 data에 들어있다!)
				//alert("업데이트 성공!!");
				article.detail(article.getContext() + "/article/detail/" + data.articleId); // 업데이트 성공 후, 해당 글 id 값 포함한 URL을 article.detail로 보내면 업데이트 된 내용이 스므스하게 화면에 바로 보이게 된다!
			},
			error : function(xhr, status, msg) { // 실패하면 이곳으로, 왼쪽 매개변수는 정해져 있다.
				alert('에러 발생 상태 : '+status+' 내용 : '+msg);
			}
		}); // updataOkBtn $.ajax() End
	}); // updateOkBtn() End
	
	$('#cancelBtn').click(function(e) { // '수 정 취 소' 클릭 시 호출되는 메소드
		e.preventDefault();
		article.detail(article.getContext() + "/article/detail/" + updateParam.article.articleId); // '수 정 취 소' 클릭 시 다시 해당 글 detailForm으로 이동
	}); // cancelBtn() End
}
Article.prototype.deleteArticle=function(){
	$.ajax({
		url : article.getContext() + '/article/delete', 
		data : { // 위 URL로 호출되는 컨트롤러에 보낼 데이터들이다.
			articleId : articleId
		},
		type : 'post', // 이곳에 type을 쓰지 않으면 디폴트로 get이 된다.
		async : true, // 당연히 true여야한다. 생략가능하다
		dataType : 'json', // 생략이 가능하다, 왜냐하면 view-context.xml에서 설정해놨다.
		success : function(data) { // 해당 URL로 호출된 컨트롤러의 메소드에서 model의 값을 가져오는 것을 성공하면 success가 실행된다 (해당 값(JSON형태)은 파라미터인 data에 들어있다!)
			//alert("삭제 성공!!");
			location.href = article.getContext() + '/article/article_home'; // 해당 URL로 컨트롤러를 호출해서 메소드 실행 후, 왼쪽에 있는 URL을 호출해서 article_home.jsp로 돌아감
		},
		error : function(xhr, status, msg) { // 실패하면 이곳으로, 왼쪽 매개변수는 정해져 있다.
			alert('에러 발생 상태 : '+status+' 내용 : '+msg);
		}
	}); // deleteArticle $.ajax() End
}
Article.prototype.reply=function(){
	$.ajax({
		url : article.getContext() + '/article/reply', 
		data : { // 위 URL로 호출되는 컨트롤러에 보낼 데이터들이다.
			articleId : articleId,
			writerName : writerName,
			reply_content : reply_content
		},
		type : 'post', // 이곳에 type을 쓰지 않으면 디폴트로 get이 된다.
		async : true, // 당연히 true여야한다. 생략가능하다
		dataType : 'json', // 생략이 가능하다, 왜냐하면 view-context.xml에서 설정해놨다.
		success : function(data) { // 해당 URL로 호출된 컨트롤러의 메소드에서 model의 값을 가져오는 것을 성공하면 success가 실행된다 (해당 값(JSON형태)은 파라미터인 data에 들어있다!)
			//alert("댓글 등록 성공!!");
			$("#replyForm").css("display","none");
			$('#replyRes').empty(); // detail 입장 시 불러왔던 댓글들을 모두 날려버리고 그 자리에 방금 추가한 댓글까지 추가해서 다시 보여준다.
			$.each(data.reply, function(index, value) {  // 제이쿼리의 for - each문
				// controller에서 보내온 "reply" 접근법, data.reply는 데이터베이스에서 가져온 List<ReplyDTO>를 뜻한다 
				// index는 그안에 있는 하나하나의 ReplyDTO 객체 자체를 뜻한다.
				// value는 그 객체(ReplyDTO)에 들어있는 하나하나의 값(reply_seq, articleId, writerName, reply_content)에 접근할 때 쓴다.
				var replyRes =
					'<form class="form-inline">'
				  	+	'<div class="form-group">'
				    +		'<label for="writerName">댓글 작성자 : '+ value.writerName +'</label>'
				    +	'</div>'
				    +	'<div class="form-group">'
				    +		'<label for="regTime" style="margin-left:20px;">댓글 작성시간 : '+ value.regTime +'</label>'
				    +	'</div>'
				    +	'<button type="submit" class="btn btn-success" style="margin-left:20px;">댓글 수정</button>'
				    +	'<button type="submit" class="btn btn-warning" style="margin-left:5px;">댓글 삭제</button>'
				    +'</form>'
				    +'<div class="form-group">'
					+	'<input type="text" class="form-control" id="replyRes" name="replyRes" value="' + value.reply_content + '"  placeholder="댓글 내용" style="margin-top:10px;" readonly>' // value 값은 ''싱글 커터를 살리기 위해 ""더블커터 사이에 싱글커터안에 넣어준다!
					+'</div>';
				$('#replyRes').append(replyRes);
			  }); // $.each() End
		}, // success() End
		error : function(xhr, status, msg) { // 실패하면 이곳으로, 왼쪽 매개변수는 정해져 있다.
			alert('에러 발생 상태 : '+status+' 내용 : '+msg);
		}
	}); // reply $.ajax() End
}