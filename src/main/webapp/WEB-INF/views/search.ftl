<#import "/spring.ftl" as spring /> <#import "macro.ftl" as macro/>
<script src="http://code.jquery.com/jquery-1.10.2.min.js"></script>
<script src="//cdn.datatables.net/1.10.0/js/jquery.dataTables.js"></script>
<link href="//cdn.datatables.net/1.10.0/css/jquery.dataTables.css"
	rel="stylesheet">

<script type="text/javascript"
	src="${rc.getContextPath()}/resources/js/pages/SearchResultList.js"></script>
</script>

<div class="starter-template row-fluid inner-col">
	<div class="span12 center-table">
		<table class="table table-hover" id="resultTable" width="90%">
			<thead>
				<tr>
					<th>Subject</th>
					<th>Snapshot</th>
				</tr>
			</thead>

			<tbody>
				<#list postList as post>
				<tr>
					<td id="tableSubject"><a href="${post.id}" target="_blank">${post.title}</a></td>
					<#if post.description?length &gt; 130 > <#assign content =
					post.description?substring(0, 130) +'........
					<a href="${post.id}" target="_blank">See more</a>' > <#else> <#assign content =
					post.description> </#if>
					<td><p id="postContent">${content}</p></td>
				</tr>
				</#list>
			</tbody>
		</table>
	</div>

</div>

