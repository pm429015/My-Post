function expand(index, dealerEmail) {
	if ($(".dis" + index).is(":visible")) {
		$("#expand"+index).text('Expand');
		$(".dis" + index).hide();

	} else {
		$("#expand"+index).text('Collapse');
		$(".dis" + index).show();

	}

	var userEmail = $("#post_mail").text();
	var currentUser = getCookie("Email");
	// Only the poster and the dealer can reply the deal 
	if ( currentUser == userEmail || currentUser == dealerEmail) {
		$("#m_reply"+index).show();
	}else{
		$("#m_reply"+index).hide();
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
		setTimeout(function() {location.reload();	}, 1000);
	}else{
		$("label#comment_error").show();
		$("#comment" + index).focus();
	}

}

$(function() {
	$(".replies").hide();

	$("#postSubmit").click(function() {
		$('.error').hide();

		var dealer_email = getCookie("Email");
		var dealer_content = $("#content").val();
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
			setTimeout(function() {location.reload();	}, 1000);
			
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
