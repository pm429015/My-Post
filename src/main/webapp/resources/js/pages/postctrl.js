function expand(index, dealerEmail) {
	// Don't hide when the user click the textarea box
	if (!$("#comment" + index + ":focus").is("textarea")) {

		if ($(".dis" + index).is(":visible")) {
			$("#expand" + index).text('Expand');
			$(".dis" + index).hide();

		} else {
			$("#expand" + index).text('Collapse');
			$(".dis" + index).show();

		}

		var userEmail = $("#post_mail").text();
		var currentUser = getCookie("Email");
		// Only the poster and the dealer can reply the deal
		if (currentUser == userEmail || currentUser == dealerEmail) {
			$("#m_reply" + index).show();
		} else {
			$("#m_reply" + index).hide();
		}

	}
}

function commentSubmit(dealID, index) {
	var user_email = getCookie("Email");
	var comment = $("#comment" + index).val();

	if (comment) {
		$.ajax({
			type : "POST",
			url : "reply",
			data : {
				email : user_email,
				content : comment,
				deal_id : dealID
			}

		});

		$(".comments").val("");
		setTimeout(function() {
			location.reload();
		}, 1000);
	} else {
		$("label#comment_error").show();
		$("#comment" + index).focus();
	}

}

$(function() {
	//Default hide all replies
	$(".replies").hide();
	
	// load cookies 
	var name = getCookie("Name");
	var email = getCookie("Email");
	var postEmail = $("#post_mail").text();
	//Check if the user is the person who requested this post. If yes, skip the join button
	if (email != postEmail) {
		// If not, check if the user has valid cookies
		if (name && email) {
			$("#postFight")
					.html(
							'<h3>Show us your best deal</h3><center><textarea class="form-control " id="deal_header" rows="1" style="width: 600px;"  placeholder="Headline (requried)" ></textarea> <label class="error" for="header" id="header_error"><font color="red">Write a killer deal headline. </font></label><br><textarea class="form-control" id="deal_content" rows="8" style="width: 650px;" placeholder="Write your deal here (required)" required></textarea><label class="error" for="content" id="deal_error"><font color="red">10 more words required.</font></label></center><button type="button" class="btn btn-success btn-lg" id="postSubmit" >Submit</button>');
		} else {
			$("#postFight")
					.html(
							'<a class="btn btn-danger btn-lg" href="#loginPage" data-toggle="modal" role="button" onclick="saveUrlCookie()">Join the flight</a>');
		}
		$('.error').hide();
	}
	
	
	$("#postSubmit").click(function() {
		$('.error').hide();

		var dealer_email = getCookie("Email");
		var dealer_content = $("#deal_content").val();
		var post_id = $("#id").text();
		var dealer_header = $("#deal_header").val();

		if (dealer_email && dealer_content && dealer_header) {
			$.ajax({
				type : "POST",
				url : "insertDeal",
				data : {
					email : dealer_email,
					content : dealer_content,
					id : post_id,
					header : dealer_header
				}

			});
			setTimeout(function() {
				location.reload();
			}, 1000);

		} else {
			if (!dealer_header) {
				$("label#header_error").show();
				$("#deal_header").focus();
			} else if (!dealer_content) {
				$("label#deal_error").show();
				$("#content").focus();
			}

		}

	});
	
	
});
