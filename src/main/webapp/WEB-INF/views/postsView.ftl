<#import "/spring.ftl" as spring /> <#import "macro.ftl" as macro/>
<@macro.showHeader />
<script type="text/javascript"
	src="${rc.getContextPath()}/resources/js/pages/postList.js"></script>
<br />
<form class="navbar-search navbar-center" style="padding-left: 200px;">
	<input type="text" class="search-query span6" placeholder="Search">
	<button class="btn btn-default">Search</button>
</form>

<br />
<br />
<div class="starter-template row-fluid inner-col">
	<h2>Battlefield List</h2>
	<br />
	<div class="span10 center-table">
		<table class="table table-hover">
			<thead>
				<tr>
					<th>Topic</th>
					<th>Description</th>
					<th></th>
				</tr>
			</thead>

			<tbody>
				<#list postList as post>
				<tr>
					<td>${post.title}</td>
					<td>${post.description}</td>
					<td><a href="view/${post.id}" > View</a></td>
				</tr>
				</#list>



			</tbody>
		</table>
	</div>

</div>
<!-- post close -->

<@macro.showFooter> </@macro.showFooter>




