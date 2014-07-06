// jQuery for page scrolling feature - requires jQuery Easing plugin
$(document).ready(function () {
	var user_email = getCookie("Email");
	var user_name = getCookie("Name");
	
	// if the user has an email cookie, hide the email input
	if (user_email) {
		$('.email-group').hide();
	}
	
	$('#tb').click(
			function() {
				$('.product-background')
				.html('<div class="row postThanks"><div class="col-md-8 col-md-offset-2"><h1><center>You did a great job!</center></h1><h3><center>We will contact you once we find good deals for you.</center></h3><div class="col-md-6 text-center"><a href="mainp" ><button class="btn btn-primary btn-lg" type="button" >Request another deal</button></div></a><div class="col-md-6 text-center"><a href="${rc.getContextPath()}/"><button class="btn btn-danger btn-lg" type="button" >Go to our deal arena</button></a></div></div></div>');
	
	});
	
	$('#RequestSubmit').click(
			function() {
				if (!$("#title").val() ) {
					
					$("label#subject_error").show();
					$("#title").focus();
					
					return false;
				}else{
					$("label#subject_error").hide();
				}
				
				var pattern = /^\b[A-Z0-9._%-]+@[A-Z0-9.-]+\.[A-Z]{2,4}\b$/i;
				var formEmail="";
				if(user_email){
					formEmail = user_email;
					$("label#Uemail_error").hide();
					
				}else if(pattern.test($("#Uemail").val() )){
					formEmail = $("#Uemail").val();
					$("label#Uemail_error").hide();
				}else{
					$("label#Uemail_error").show();
					$("#Uemail").focus();
					return false;
				}
					
				if(!$("#description").val()){
					
					$("#descritpion_error").show();
					$("#description").focus();
					return false;
				}else{
					$("#descritpion_error").hide();
				}
				
				
				$.ajax({
					type : 'POST',
					url : 'insertPost',
					data : {
						title : $("#title").val(),
						description : $("#description").val(),
						email : formEmail
					}
					
				});
				
				$('.product-background')
				.html('<div class="row postThanks"><div class="col-md-8 col-md-offset-2"><h1><center>You did a great job!</center></h1><h3><center>We will contact you once we find good deals for you.</center></h3><div class="col-md-6 text-center"><a href="mainp" ><button class="btn btn-primary btn-lg" type="button" >Request another deal</button></div></a><div class="col-md-6 text-center"><a href="${rc.getContextPath()}/"><button class="btn btn-danger btn-lg" type="button" >Go to our deal arena</button></a></div></div></div>');
						
	});
	
});


