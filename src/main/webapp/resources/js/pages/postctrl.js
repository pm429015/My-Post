$(function() {
	$("#postSubmit").click(function() {
		$('.error').hide();

		var dealer_email = getCookie("Email");
		var dealer_content = $("#content").val();
		var post_id = $("#id").text();

		if (dealer_email && dealer_content) {
			$.ajax({
				type : "POST",
				url : "insertDeal",
				data : {
					email : dealer_email,
					content : dealer_content,
					id : post_id
				}

			});
			location.reload();
		}else{
			$("label#deal_error").show();
			$("#content").focus();
		}

		

	});
});
