function infoUpdate(id) {
	$.ajax({
		type : "POST",
		url : "dealerInfoUpdate",
		data : {
			name : $("#dealerName").val().trim(),
			email : $("#dealerEmail").val().trim(),
			phone : $("#dealerPhone").val().trim(),
			address :$("#dealerAddress").val().trim(),
			zip:$("#dealerZip").val().trim(),
			id : id
		},
		success: function(msg){
			$('#infoTable').html(msg);
		}

	});
	
};

