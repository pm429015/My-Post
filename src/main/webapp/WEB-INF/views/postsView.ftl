<#import "/spring.ftl" as spring /> <#import "macro.ftl" as macro/>
<@macro.showHeader />
<!-- <script type="text/javascript"
	src="${rc.getContextPath()}/resources/js/pages/postList.js"></script> -->
	
<script type="text/javascript">
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
				document.getElementById('returnTable').innerHTML = "<img src='resources/graph/loading.GIF' />";
			}
			if (xmlhttp.readyState == 4 && xmlhttp.status == 200) {
				document.getElementById('returnTable').style.top = "50px";
				document.getElementById("returnTable").innerHTML = xmlhttp.responseText;

			}
		};
		
		xmlhttp.open("GET", "search?keyword="+searchTerm);
		xmlhttp.send();
	}
}
</script>
<br />
<div style="padding-left: 300px;" id="searchForm">
	<input type="text" class="search-query span6" placeholder="Search" id="keyword">
	<button class="btn btn-default" onclick="searchSubmit()">Search</button>
</div>

<br />
<br />
<div class="starter-template row-fluid inner-col">
	<h2>Battlefield List</h2>
	<br />
	<div class="span12 center-table" id="returnTable">
		<table class="table table-hover">
			<thead>
				<tr>
					<th>Topic</th>
					
				</tr>
			</thead>

			<tbody>
				<#list postList as post>
				<tr>
					<td><a href="view/${post.id}" >${post.title}</a></td>
					<!--<td>${post.description}</td>-->
					
				</tr>
				</#list>

			</tbody>
		</table>
	</div>

</div>
<!-- post close -->





