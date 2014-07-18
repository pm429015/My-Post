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

function joinBid(token){
	//Check if the user has token
	$("#postFight").hide();
	$("#bidwell")
		.html(
				'<center>'+
					'<div id="bidLayer">'+
						'<div class="container">'+
							'<div class="row">'+
								'<div class="span12">'+
									'<form class="form-horizontal bidform">'+
                                    	'<fieldset>'+
										'<div class="row">'+
											'<div class="form-group">'+
												'<h3 class="col-md-3 control-label bidformtext">Out of Door Price:</h3>'+
												'<div class="col-md-5">'+
													'<input class=" form-control " id="deal_header" placeholder="Out-the-door price" style="width: 400px;" ></input>'+ 
													'<label class="error" for="header" id="header_error" hidden><font color="red">The full out-the-door price, all taxes and fees included. </font></label>'+
												'</div> '+
											'</div>'+
											'<div class="form-group">'+
												'<h3 class="col-md-3 control-label bidformtext">Description:</h3>'+
												'<div class="col-md-9">'+
													'<textarea class=" form-control" id="deal_content" rows="8" style="width: 65%;" placeholder="Write your deal here (required)" required></textarea>'+
													'<label class="error" for="content" id="deal_error" hidden><font color="red">10 more words required.</font></label>'+
												'</div>'+
											'</div>'+
											'<div class="form-group">'+
												'<div class="col-md-9 text-right">'+
													'<button type="button" class="btn btn-success btn-lg" id="postSubmit" >Submit</button>'+
												'</div>'+
											'</div>'+
											'</fieldset>'+
										'</form>'+
									'</div>'+
								'</div>'+
							'</div>'+
						'</div>'+
					'</div></center>');
}

$(function() {
	//Default hide all replies
	$(".replies").hide();
	$('.error').hide();
	
	// load cookies 
	var token = getCookie("token");
	var authorID = $("#userID").text();
	// If the user has a token to identify herself
	// And if the user is not the author, show the button
	if(token != authorID){
		$("#postFight")
		.html(
				'<a class="btn btn-danger btn-lg" role="button" onclick="joinBid('+token+')">Join the flight</a>');

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
