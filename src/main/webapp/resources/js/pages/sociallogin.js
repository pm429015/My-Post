$(function() {
	$('.error').hide();
	$("#emailsubmitbtn")
			.click(
					function() {
						var email = $("#email").val();
						// Email regular expressions
						var pattern = /^\b[A-Z0-9._%-]+@[A-Z0-9.-]+\.[A-Z]{2,4}\b$/i;
						if (!pattern.test(email)) {
							$("label#email_error").show();
							$("input#email").focus();
							return false;
						}
						
						$.ajax({
									type : "POST",
									url : "emailProcess",
									data : 'email='+email,
									success : function() {
										$('#loginform').html(
												"<div id='message'></div>");
										$('#message')
												.html(
														"<h3><center>A validation e-mail has been sent to your email address</center></h3>")
												.append(
														"<p><center>Please login with a link in the validation email.</center></p>");
												
									}
								});
						return false;
					});

});
