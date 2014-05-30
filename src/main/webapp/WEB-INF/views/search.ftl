<#import "/spring.ftl" as spring /> <#import "macro.ftl" as macro/>

<div class="starter-template row-fluid inner-col">
	<div class="span12 center-table">
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

