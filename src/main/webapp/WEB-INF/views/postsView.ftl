<#import "/spring.ftl" as spring /> <#import "macro.ftl" as macro/>
<@macro.showHeader />
<script type="text/javascript" src="${rc.getContextPath()}/resources/js/pages/postList.js"></script>
</script>

<script src="//cdn.datatables.net/1.10.0/js/jquery.dataTables.js"></script>
<link href="//cdn.datatables.net/1.10.0/css/jquery.dataTables.css" rel="stylesheet">

<br />
<div style="padding-left: 300px;" id="searchForm">
	<input type="text" class="search-query span6" placeholder="Search" id="keyword" onkeypress="keypress(event);">
	<button class="btn btn-default" onclick="searchSubmit()">Search</button>
</div>

<br />
<br />
<div class="starter-template row-fluid inner-col">
	<h2><a href="${rc.getContextPath()}/postsShow"><font color="#E98007"> Bargain Battlefields</font> </a></h2>
	<br />
	<div class="span12 center-table" id="tableContent">
		<table class="table table-hover" id="resultTable">
			<thead>
				<tr>
					<th>Subject</th>
					
				</tr>
			</thead>

			<tbody>
				<#list postList as post>
				<tr>
					<td><a href="${post.id}" >${post.title}</a></td>
					<!--<td>${post.description}</td>-->
					
				</tr>
				</#list>

			</tbody>
		</table>
	</div>

</div>
<!-- post close -->





