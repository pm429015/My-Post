function searchSubmit(){
	
	var searchTerm = $('#keyword').val();
	
	if (searchTerm != "") {
		var xmlhttp;
		if (window.XMLHttpRequest) {// code for IE7+, Firefox, Chrome, Opera, Safari
			xmlhttp = new XMLHttpRequest();
		} else {// code for IE6, IE5
			xmlhttp = new ActiveXObject("Microsoft.XMLHTTP");
		}

		xmlhttp.onreadystatechange = function() {
			if (xmlhttp.readyState == 1) {
				document.getElementById('tableContent').innerHTML = "<img src='resources/graph/loading.GIF' />";
			}
			if (xmlhttp.readyState == 4 && xmlhttp.status == 200) {
				document.getElementById('tableContent').style.top = "50px";
				document.getElementById("tableContent").innerHTML = xmlhttp.responseText;
				tableToDataTables();
			}
		};
		
		xmlhttp.open("GET", "search?keyword="+searchTerm);
		xmlhttp.send();
		
		
	}
	
};

function tableToDataTables(){
	$('#resultTable').dataTable({
		"ordering": false,
		"pagingType": "full_numbers",
		"bInfo" : false,
		"bFilter" : false,
		"bDeferRender": true
		
	});
};

$(document).ready(function() {
	tableToDataTables();
});

function keypress(e)
{
    var Ucode=e.keyCode? e.keyCode : e.charCode;
    if (Ucode == 13)
    {
        //write the code for submit
    	searchSubmit();
    }
}

function checkLength(val)
{
	alert(val);
}
