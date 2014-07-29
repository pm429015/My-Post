function checkEmpty(id){
	var text = $('#'+id).val();
	if (!text) {

		$("label#"+id+"_error").show();
		$("#"+id).focus();
		
		return false;
	} else {
		$("label#"+id+"_error").hide();
		return true;
	}
}

function dealerSubmit(){
	
	// Check empty
	if (!checkEmpty('Dname') || !checkEmpty('Dealership') || !checkEmpty('Dmake') ||!checkEmpty('Demail') ||
			!checkEmpty('Dphone') || !checkEmpty('Daddress') || !checkEmpty('Dzip')) {
		return false;
	}
	
	var pattern = /^\b[A-Z0-9._%-]+@[A-Z0-9.-]+\.[A-Z]{2,4}\b$/i;
	var formEmail = "";
	if (pattern.test($("#Demail").val())) {
		formEmail = $("#Demail").val();
		$("label#Demail_error").hide();
	} else {
		$("label#Demail_error").show();
		$("#Demail").focus();
		return false;
	}
	
	$('#doubleCheck').modal();
	
	$.ajax({
		type : 'POST',
		url : 'addDealer',
		data : {
			dealerShip : $("#Dealership").val(),
			dealerName : $("#Dname").val(),
			dealerEmail :  formEmail,
			dealerPhone : $("#Dphone").val(),
			dealerZip : $("#Dzip").val(),
			dealerAddress : $("#Daddress").val(),
			dealerBrands : $("#Dmake").val()
		}

	});
	
}

function finalSubmit(){
	// Check title
	var Uname = $("#Uname").val();
	if (!Uname) {

		$("label#Uname_error").show();
		$("#Uname").focus();
		
		return false;
	} else {
		$("label#Uname_error").hide();
	}
	

	var pattern = /^\b[A-Z0-9._%-]+@[A-Z0-9.-]+\.[A-Z]{2,4}\b$/i;
	var formEmail = "";
	if (pattern.test($("#Uemail").val())) {
		formEmail = $("#Uemail").val();
		$("label#Uemail_error").hide();
	} else {
		$("label#Uemail_error").show();
		$("#Uemail").focus();
		return false;
	}
	var title = $("#title").val();
	var Umodel =  $("#Umodel").val();
	var year =  $("#Uyear").val();
	var color =  $("#Ucolor").val();
	var description =  $("#description").val();
	var zip = $("#Uzip").val();
	var name = $("#Uname").val();
	
	$('.product-background')
	.html(
			'<div class="row postThanks"><div class="col-md-8 col-md-offset-2"><h1><center>You did a great job!</center></h1><h3><center>We will contact you once we find good deals for you.</center></h3><div class="col-md-6 text-center"><a href="mainp" ><button class="btn btn-primary btn-lg" type="button" >Request another deal</button></div></a><div class="col-md-6 text-center"><a href="arena"><button class="btn btn-danger btn-lg" type="button" >Go to our deal arena</button></a></div></div></div>');

	
	$.ajax({
	type : 'POST',
	url : 'insertPost',
	data : {
		title : title,
		model : Umodel,
		year :  year,
		color : color,
		description : description,
		email : formEmail,
		miles : Uname,
		zip : zip,
		name : name
	}

	});
	

}

// jQuery for page scrolling feature - requires jQuery Easing plugin
$(document).ready(function() {
	
	$('#moveTop').click(function(){
		$('html, body').animate({ scrollTop: 0 }, 'fast');
	});
		
	$('#CarSubmit').click( function(){
		// Check title
		var title = $("#title").val();
		if (!title) {

			$("label#subject_error").show();
			$("#title").focus();

			return false;
		} else {
			$("label#subject_error").hide();
		}
		// Check model
		var model = $("#Umodel").val();
		if (!model) {

			$("label#Umodel_error").show();
			$("#Umodel").focus();

			return false;
		} else {
			$("label#Umodel_error").hide();
		}
		
		// Check year
		var year =  $("#Uyear").val();
		if (!year) {

			$("label#Uyear_error").show();
			$("#Uyear").focus();

			return false;
		} else {
			$("label#Uyear_error").hide();
		}
		
		// Check color
		var color =  $("#Ucolor").val();
		if (!color) {

			$("label#Ucolor_error").show();
			$("#Ucolor").focus();

			return false;
		} else {
			$("label#Ucolor_error").hide();
		}
		
		// Check zip code
		if (!$("#Uzip").val()) {

			$("#Uzip_error").show();
			$("#Uzip").focus();

			return false;
		} else {
			$("label#Uzip_error").hide();
		}
		
		$(".requestForm").hide();
		// Get user info
		$('.userForm')
		.html('<fieldset>'+
	            '<div class="form-group form-header">'+
	            	'<h3 class="col-md-5 control-label pull-center">Your Contact Info</h3>'+
	            '</div>'+
	            '<div class="form-group">'+
	             '<h3 class="col-md-3 control-label" for="Uname">Name:</h3>'+
	             '<div class="col-md-5">'+
	                '<input id="Uname" name="Uname" type="text" placeholder="John" class="form-control"></input>'+
	                '<label class="error" for="Uname" id="Uname_error" hidden><font color="red">No Emtpy Field.</font></label>'+
	              '</div>'+
	            '</div>'+
	            
	            '<div class="form-group">'+
	             '<h3 class="col-md-3 control-label" for="Uemail">Email:</h3>'+
	             '<div class="col-md-5">'+
	                '<input id="Uemail" name="Uemail" type="text" placeholder="your@email.com" class="form-control"></input>'+
	                '<label class="error" for="Uemail" id="Uemail_error" hidden><font color="red">Invalid Email.</font></label>'+
	              '</div>'+
	            '</div>'+
	            
	            '<div class="form-group">'+
	              '<h3 class="col-md-3 control-label" for="description">Specific Options:</h3>'+
	              '<div class="col-md-8 textinput">'+
	                '<textarea id="description" name="description" style="height: 100px;" type="text" placeholder="(Optional)  Write here if you have any specific request." class="form-control"></textarea>'+
	              '</div>'+
	            '</div>'+
	            
	            '<h5 class="col-md-12" >Your Personal Information will not be disclosed or shared with any third party.</h5>'+
	            
	            '<div class="form-group ">'+
	            	'<div class="col-md-11 text-right">'+
	            		'<button class="btn btn-danger btn-lg" onclick="finalSubmit()" type="button" >Submit</button>'+
	            	'</div>'+
	            '</div>'+
	          '</fieldset>'
		);
			
	});
	
					$('#finalSubmit')
							.click(
									function() {
										
										// Check title
										var Uname = $("#Uname").val();
										if (!Uname) {
								
											$("label#Uname_error").show();
											$("#Uname").focus();
											
								
											return false;
										} else {
											$("label#Uname_error").hide();
										}
										

										var pattern = /^\b[A-Z0-9._%-]+@[A-Z0-9.-]+\.[A-Z]{2,4}\b$/i;
										var formEmail = "";
										if (pattern.test($("#Uemail").val())) {
											formEmail = $("#Uemail").val();
											$("label#Uemail_error").hide();
										} else {
											$("label#Uemail_error").show();
											$("#Uemail").focus();
											return false;
										}
										


										alert('Sending');

										$('.product-background')
												.html(
														'<div class="row postThanks"><div class="col-md-8 col-md-offset-2"><h1><center>You did a great job!</center></h1><h3><center>We will contact you once we find good deals for you.</center></h3><div class="col-md-6 text-center"><a href="home" ><button class="btn btn-primary btn-lg" type="button" >Request another deal</button></div></a></div></div>');

									});

				});
