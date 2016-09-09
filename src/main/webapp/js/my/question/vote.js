$(document).ready(function() {
	$(".vote-like").click(function() {
		var like = $(this);
		var dislike = $(this).parent().next("div").children("a");
		var likeHref = like.attr("href");
		var dislikeHref = dislike.attr("href");
		
		if(likeHref != null && dislikeHref != null){
			alert("点赞的");
			like.removeAttr("href");
			like.parent().addClass("voted");
		}
		else if(likeHref == null && dislikeHref != null) {
			alert("取消赞的");
			like.attr("href", "#");
			like.parent().removeClass("voted");
		}
		else if(likeHref != null && dislikeHref == null) {
			alert("点了反对然后点赞的");
			like.removeAttr("href");
			like.parent().addClass("voted");
			dislike.attr("href", "#");
			dislike.parent().removeClass("voted");
		}
		
		/*
		var url = path + "/vote/";
		var args = {
		};
		$.post(url, args, function(json) {
			alert(json);
		});
		*/
	});
	
	$(".vote-dislike").click(function() {
		var dislike = $(this);
		var like = $(this).parent().prev("div").children("a");
		var dislikeHref = dislike.attr("href");
		var likeHref = like.attr("href");
		
		if(likeHref != null && dislikeHref != null){
			alert("反对的");
			dislike.removeAttr("href");
			dislike.parent().addClass("voted");
		}
		else if(likeHref != null && dislikeHref == null) {
			alert("取消反对的");
			dislike.attr("href", "#");
			dislike.parent().removeClass("voted");
		}
		else if(likeHref == null && dislikeHref != null) {
			alert("点了赞然后点反对的");
			dislike.removeAttr("href");
			dislike.parent().addClass("voted");
			like.attr("href", "#");
			like.parent().removeClass("voted");			
		}
	});
});