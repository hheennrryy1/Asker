$(document).ready(function() {
	
	var voteUrl = path + "/vote";
	var unvoteUrl = path + "/unvote";
	var updateUrl = path + "/updateVote";
	
	function vote(answerId, mode, url) {
		var args = {
			answerId : answerId,
			mode : mode
		};
		$.post(url, args);
	}
	
	$(".vote-like").click(function() {
		var like = $(this).children("a");
		var dislike = $(this).next("div").children("a");
		var likeHref = like.attr("href");
		var dislikeHref = dislike.attr("href");
		
		var answerId = $(this).children("input").val();
		
		//点赞的
		if(likeHref != null && dislikeHref != null) {
			like.removeAttr("href");
			$(this).addClass("voted");
			
			vote(answerId, true, voteUrl);
		}
		//取消赞的
		else if(likeHref == null && dislikeHref != null) {
			like.attr("href", "#");
			$(this).removeClass("voted");
			
			vote(answerId, true, unvoteUrl);
		}
		//点了反对然后点赞的
		else if(likeHref != null && dislikeHref == null) {
			like.removeAttr("href");
			$(this).addClass("voted");
			dislike.attr("href", "#");
			dislike.parent().removeClass("voted");
			
			vote(answerId, true, updateUrl);
		}
		
	});
	
	$(".vote-dislike").click(function() {
		var dislike = $(this).children("a");
		var like = $(this).prev("div").children("a");
		var dislikeHref = dislike.attr("href");
		var likeHref = like.attr("href");
		
		var answerId = $(this).prev("div").children("input").val();
		
		//反对的
		if(likeHref != null && dislikeHref != null) {
			dislike.removeAttr("href");
			$(this).addClass("voted");
			
			vote(answerId, false, voteUrl);
		}
		//取消反对的
		else if(likeHref != null && dislikeHref == null) {
			dislike.attr("href", "#");
			$(this).removeClass("voted");
			
			vote(answerId, false, unvoteUrl);
		}
		//点了赞然后点反对的
		else if(likeHref == null && dislikeHref != null) {
			dislike.removeAttr("href");
			$(this).addClass("voted");
			like.attr("href", "#");
			like.parent().removeClass("voted");
			
			vote(answerId, false, updateUrl);
		}
	});
});