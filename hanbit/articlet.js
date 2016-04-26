			if (startPage-pageSize > 0) {
				pagination += '<li><span onclick="Article.prototype.articleAll('+'\''+context+'\''+','+'\''+(startPage-1)+'\')" href="#" aria-label="Previous">&laquo;</span></li>';
			}
			
			for (var i = startPage; i <= endPage; i++) {
				if (i == pageNO) {
					pagination += '<li class="active"><span>'+i+'</span></li>';
				} else {
					pagination += '<li><span onclick="Article.prototype.articleAll('+'\''+context+'\''+','+'\''+i+'\')" href="#">'+i+'</span></li>';
				}
			}
			
			if (endPage < totalPages) {
				pagination += '<li><span onclick="Article.prototype.articleAll('+'\''+context+'\''+','+'\''+(startPage+groupSize)+'\')" href="#">&raquo;</span></li>';
			}