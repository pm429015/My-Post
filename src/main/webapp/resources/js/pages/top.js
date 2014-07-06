//jQuery to collapse the navbar on scroll
$(window).scroll(function() {
	if ($(".navbar").offset().top > 50) {
		$(".navbar-fixed-top").addClass("top-nav-collapse");
	} else {
		$(".navbar-fixed-top").removeClass("top-nav-collapse");
	}
});

function getCookie(cname) {
	var name = cname + "=";
	var ca = document.cookie.split(';');
	for (var i = 0; i < ca.length; i++) {
		var c = ca[i].trim();
		if (c.indexOf(name) == 0)
			return c.substring(name.length, c.length);
	}
	return "";
};

function saveCookie(key, value, minutes) {
	var d = new Date();
	d.setTime(d.getTime() + (minutes * 60 * 1000));
	var expires = "expires=" + d.toGMTString();
	document.cookie = key + "=" + value + "; " + expires;
}

function delete_cookie(name) {
	document.cookie = name + '=; expires=Thu, 01 Jan 1970 00:00:01 GMT;';
}

function saveUrlCookie() {
	var url_path = window.location.pathname;
	url_path = url_path.split("/");
	saveCookie("returnURL", url_path[(url_path.length) - 1], 2);
}

// jQuery for page scrolling feature - requires jQuery Easing plugin
$(function() {
	$('.page-scroll a').bind('click', function(event) {
		var $anchor = $(this);
		$('html, body').stop().animate({
			scrollTop : $($anchor.attr('href')).offset().top
		}, 1500, 'easeInOutExpo');
		event.preventDefault();
	});

	// hide error msg in the beginning
	$('.error').hide();

	// Tangle user info in navbar
	var name = getCookie("Name");
	var email = getCookie("Email");
	var token = 20;
	if (name && email) {
		$("#userToken")
				.html(
						'<a data-toggle="dropdown" href="#" class="dropdown-toggle" >'
								+ token
								+ '</a><div class="dropdown-menu gts-flat-dropdown-menu gts-user-dropdown-menu tokenMenu"><center><p>Using these tokens to join deal flights</p></center></div>');
		$("#loginStatus")
				.html(
						'<a data-toggle="dropdown" href="#" class="dropdown-toggle UserName">Hi '
								+ name
								+ '</a><div class="dropdown-menu gts-flat-dropdown-menu gts-user-dropdown-menu userMenu"><div class="user-details"><center><a id="signOut" href="#">Sign Out</a></center> </div></div>');
	} else {
		$("#loginStatus")
				.html(
						'<a href="#loginPage" data-toggle="modal" id="signInUp" onclick="saveUrlCookie()">Sign up/Login</a></li>');
	}

	$('#signOut').click(function() {
		delete_cookie("Name");
		delete_cookie("Email");
		location.reload();
	});

	$('#emailLoginBtn')
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

						
						$('.modalLoginForm')
								.html(
										'<div class="modal-body afterReg"> <h4><center>A validation e-mail has been sent to your email address<center></h4><a><center>Return in 3 seconds.... <center></a><a class="nav pull-right" href="#" data-dismiss="modal" data-target="#loginpage">Close</a></div>');
						setTimeout(function() {
							$('#loginPage').modal('hide');
						}, 3000);

						$.ajax({
							type : "POST",
							url : "emailProcess",
							data : {
								email : user_email,
								path : url_path[(url_path.length) - 1]
							}

						});
					});

});
