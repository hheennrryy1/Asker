$(document).ready(function() {
	
	var voteUrl = path + "/vote";
	var unvoteUrl = path + "/unvote";
	
	function vote(answerId, mode) {
		var args = {
			answerId : answerId,
			mode : mode
		};
		$.post(voteUrl, args, function(json) {
			
		});
	}
	
	function unvote(answerId) {
		var args = {
			answerId : answerId,
		};
		alert(unvoteUrl);
		$.post(unvoteUrl, args, function(json) {
			
		});
	}
	
	$(".vote-like").click(function() {
		var like = $(this);
		var dislike = like.parent().next("div").children("a");
		var likeHref = like.attr("href");
		var dislikeHref = dislike.attr("href");
		
		var answerId = like.parent().children("input").val();
		
		//点赞的
		if(likeHref != null && dislikeHref != null){
			like.removeAttr("href");
			like.parent().addClass("voted");
			
			vote(answerId, true);
		}
		//取消赞的
		else if(likeHref == null && dislikeHref != null) {
			like.attr("href", "#");
			like.parent().removeClass("voted");
			
			unvote(answerId);
		}
		//点了反对然后点赞的
		else if(likeHref != null && dislikeHref == null) {
			like.removeAttr("href");
			like.parent().addClass("voted");
			dislike.attr("href", "#");
			dislike.parent().removeClass("voted");
		}
		
	});
	
	$(".vote-dislike").click(function() {
		var dislike = $(this);
		var like = dislike.parent().prev("div").children("a");
		var dislikeHref = dislike.attr("href");
		var likeHref = like.attr("href");
		
		var answerId = like.parent().children("input").val();
		
		//反对的
		if(likeHref != null && dislikeHref != null){
			dislike.removeAttr("href");
			dislike.parent().addClass("voted");
		}
		//取消反对的
		else if(likeHref != null && dislikeHref == null) {
			dislike.attr("href", "#");
			dislike.parent().removeClass("voted");
		}
		//点了赞然后点反对的
		else if(likeHref == null && dislikeHref != null) {
			dislike.removeAttr("href");
			dislike.parent().addClass("voted");
			like.attr("href", "#");
			like.parent().removeClass("voted");			
		}
	});
});