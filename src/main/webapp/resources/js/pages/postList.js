function searchSubmit(){
	
	var searchTerm = $('#keyword').val();
	alert(searchTerm);
	/*if (searchTerm != "") {
		var xmlhttp;
		if (window.XMLHttpRequest) {// code for IE7+, Firefox, Chrome, Opera, Safari
			xmlhttp = new XMLHttpRequest();
		} else {// code for IE6, IE5
			xmlhttp = new ActiveXObject("Microsoft.XMLHTTP");
		}

		xmlhttp.onreadystatechange = function() {
			if (xmlhttp.readyState == 1) {
				document.getElementById('returnTable').innerHTML = "<img src='resources/graph/loading.GIF' />";
			}
			if (xmlhttp.readyState == 4 && xmlhttp.status == 200) {
				document.getElementById('returnTable').style.top = "50px";
				document.getElementById("returnTable").innerHTML = xmlhttp.responseText;

			}
		};
		
		xmlhttp.open("GET", "search?keyword="+searchTerm);
		xmlhttp.send();
	}*/
}
