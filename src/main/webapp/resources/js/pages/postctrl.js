function expand(index, dealerID) {
	// Don't hide when the user click the textarea box
	if (!$("#comment" + index + ":focus").is("textarea")) {

		if ($(".dis" + index).is(":visible")) {
			$("#expand" + index).html('<span class="glyphicon glyphicon-chevron-down"></span>');
			$(".dis" + index).hide();

		} else {
			$("#expand" + index).html('<span class="glyphicon glyphicon-chevron-up"></span>');
			$(".dis" + index).show();

		}

		// load cookies 
		var token = getCookie("token");
		var authorID = $("#userID").text();
		// Only the author and the dealer can reply the deal
		if (token == authorID || token == dealerID) {
			$("#m_reply" + index).show();
		} else {
			$("#m_reply" + index).hide();
		}

	}
}

function commentSubmit(dealID, index) {
	
		var token = getCookie("token");
		// if post has been terminal and a dealer wants to comment, no no
		if (!checkStatus() && token != $("#userID").text()) {
			$('#locked').modal('show');
			return false;
		}
		var comment = $("#comment" + index).val();
	
		if (comment) {
			$('#doubleCheck').modal({ backdrop: 'static', keyboard: false }).one('click', '#go', function (e) {
				$.ajax({
					type : "POST",
					url : "reply",
					data : {
						token : token,
						content : comment,
						deal_id : dealID
					},
					success: function(msg){
						$('.dealspaste').html(msg);
					}
		
				});
			});
		} else {
			$("label#comment_error").show();
			$("#comment" + index).focus();
		}
	
}

function dealSubmit(){
	if (!checkStatus()) {
		
		return false;
	}
	//Check deal header and content
	if(!inputCheck("dealHeader") || !inputCheck("dealContent")){
		return false;
	}
	
	var token = getCookie("token");
	// if the user don't has the token
	if (!token) {
	$("#bidwell").hide();
	$("#dealerInfo")
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
									'<h2 class="col-md-10 bidformtext">Your Contact Info</h2>'+
										'<h3 class="col-md-3 control-label bidformtext">Name:</h3>'+
										'<div class="col-md-5">'+
											'<input class=" form-control " id="dealerName" placeholder="Your name" style="width: 500px;" ></input>'+ 
											'<label class="error" for="dealerName" id="dealerName_error" hidden><font color="red">No empty name. </font></label>'+
										'</div> '+
									'</div>'+
									'<div class="form-group">'+
										'<h3 class="col-md-3 control-label bidformtext">Email:</h3>'+
										'<div class="col-md-5">'+
											'<input class=" form-control " id="dealerEmail" placeholder="your@email.com" style="width: 500px;" ></input>'+ 
											'<label class="error" for="dealerEmail" id="dealerEmail_error" hidden><font color="red">No empty email. </font></label>'+
										'</div> '+
									'</div>'+
									'<div class="form-group">'+
										'<h3 class="col-md-3 control-label bidformtext">Phone:</h3>'+
										'<div class="col-md-5">'+
											'<input class=" form-control " id="dealerPhone" placeholder="your phone" style="width: 500px;" ></input>'+ 
											'<label class="error" for="dealerPhone" id="dealerPhone_error" hidden><font color="red">No empty phone. </font></label>'+
										'</div> '+
									'</div>'+
									'<div class="form-group">'+
										'<h3 class="col-md-3 control-label bidformtext">Car Makes you sell:</h3>'+
										'<div class="col-md-5">'+
											'<input class=" form-control " id="dealerBrands" placeholder="BMW" style="width: 500px;" ></input>'+ 
										'</div> '+
									'</div>'+
									'<div class="form-group">'+
										'<h3 class="col-md-3 control-label bidformtext">Zip code:</h3>'+
										'<div class="col-md-5">'+
											'<input class=" form-control " id="dealerZip" placeholder="94110" style="width: 500px;" ></input>'+ 
											'<label class="error" for="dealerZip" id="dealerZip_error" hidden><font color="red">No empty zip code. </font></label>'+
										'</div> '+
									'</div>'+
									'<div class="form-group">'+
										'<h3 class="col-md-3 control-label bidformtext">Contact Address:</h3>'+
										'<div class="col-md-6">'+
											'<textarea class=" form-control" id="dealerAddress" rows="4" placeholder="1234 Main St. #5, SF" required></textarea>'+
											'<label class="error" for="dealerAddress" id="dealerAddress_error" hidden><font color="red">Please provide your address so that buyer can contact you.</font></label>'+
										'</div>'+
									'</div>'+
									
									
									'<div class="form-group">'+
										'<div class="col-md-9 text-right">'+
											'<button type="button" class="btn btn-success btn-lg" onclick="dealAndUserSubmit()" >Submit</button>'+
										'</div>'+
									'</div>'+
									'</fieldset>'+
								'</form>'+
							'</div>'+
						'</div>'+
					'</div>'+
				'</div>'+
			'</div></center>'
			);
	
	}else{
		dealAndUserSubmit();
	}
}

function dealAndUserSubmit(){
	if (!checkStatus()) {
		
		return false;
	}
	var token = getCookie("token");
	
	// if the user don't has the token
	if (!token) {
		if (!inputCheck("dealerName") || !inputCheck("dealerEmail") || !inputCheck("dealerPhone")
				|| !inputCheck("dealerZip") || !inputCheck("dealerAddress") ) {
			return false;
		}
		$('#doubleCheck').modal({ backdrop: 'static', keyboard: false }).one('click', '#go', function (e) {
			var post_id = $("#id").text();
			$.ajax({
				type : "POST",
				url : "insertDeal",
				data : {
					id : post_id,
					dealHeader : $('#dealHeader').val(),
					dealContent: $('#dealContent').val(),
					
					dealerName: $('#dealerName').val(),
					dealerEmail: $('#dealerEmail').val(),
					dealerPhone: $('#dealerPhone').val(),
					dealerZip: $('#dealerZip').val(),
					dealerAddress: $('#dealerAddress').val(),
					dealerBrands: $('#dealerBrands').val(),
				},
				success: function(msg){
					$('.dealspaste').html(msg);
				}
			});
		});
	}else{
		$('#doubleCheck').modal({ backdrop: 'static', keyboard: false }).one('click', '#go', function (e) {
			var post_id = $("#id").text();
			$.ajax({
				type : "POST",
				url : "insertDeal",
				data : {
					id : post_id,
					dealHeader : $('#dealHeader').val(),
					dealContent: $('#dealContent').val(),
					token:token
				},
				success: function(msg){
					$('.dealspaste').html(msg);
				}
			});
		});
	}
	
	$("#bidwell").hide();
	$("#dealerInfo").hide();
}

function inputCheck(id){
	var input = $('#'+id).val();
	if (!input) {
		$("#"+id+"_error").show();
		$('#'+id).focus();
		return false;
	}else{
		$("#"+id+"_error").hide();
		return input;
	}
}

function chooseDeal(index){
	if (index) {
		$('#doubleCheck').modal({ backdrop: 'static', keyboard: false }).one('click', '#go', function (e) {
			$.ajax({
				type : "POST",
				url : "selectedDeal",
				data : {
					dealID : index
				}
			});
		});
	}
} 

function checkStatus(){
	// Check the status of the post, disable deal when the buyer has chosen a deal
	var status = $("#status").text().trim();
	if (status == "Expired" || status =="Canceled") {
		$('#locked').modal('show');
		return false;
	}else{
		return true;
	}
}

function joinBid(){
	if (!checkStatus()) {
		
		return false;
	}
	
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
													'<input class=" form-control " id="dealHeader" placeholder="Out-the-door price" style="width: 500px;" ></input>'+ 
													'<label class="error" for="dealHeader" id="dealHeader_error" hidden><font color="red">The full out-the-door price, all taxes and fees included. </font></label>'+
												'</div> '+
											'</div>'+
											'<div class="form-group">'+
												'<h3 class="col-md-3 control-label bidformtext">Message:</h3>'+
												'<div class="col-md-9">'+
													'<textarea class=" form-control" id="dealContent" rows="8" style="width: 65%;" placeholder="Write your deal here (required)" required></textarea>'+
													'<label class="error" for="dealContent" id="dealContent_error" hidden><font color="red">10 more words required.</font></label>'+
												'</div>'+
											'</div>'+
											'<div class="form-group">'+
												'<div class="col-md-9 text-right">'+
													'<button type="button" class="btn btn-success btn-lg" onclick="dealSubmit()" >Submit</button>'+
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
				'<a class="btn btn-danger btn-lg" role="button" onclick="joinBid()">Your Respond</a>');
		$('.selectBT').hide();

	}
	
	
	
});
