$(function() {
	$('.error').hide();


	$("#emailLoginBtn")
			.click(
					function() {
						var user_email = $("#email").val();
						var url_path = window.location.pathname;
						url_path = url_path.split("/");
						
						
						// Email regular expressions
						var pattern = /^\b[A-Z0-9._%-]+@[A-Z0-9.-]+\.[A-Z]{2,4}\b$/i;
						if (!pattern.test(user_email)) {
							$("label#email_error").show();
							$("input#email").focus();

							return false;
						}
						
						

						
						$('.form-horizontal')
								.html(
										'<div class="modal-body"> <h4><center>A validation e-mail has been sent to your email address<center></h4><a><center>Return in 3 seconds.... <center></a><a class="nav pull-right" href="#" data-dismiss="modal" data-target="#loginpage">Close</a></div>');
						setTimeout(function() { $('#loginpage').modal('hide');}, 3000);
						
						$.ajax({
							type : "POST",
							url : "emailProcess",
							data : {email: user_email,path:url_path[(url_path.length)-1]}
							
						});

					});


});
