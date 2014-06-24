<#import "/spring.ftl" as spring /> <#import "macro.ftl" as macro/>
<@macro.showHeader />

<div class="content inner-col">
	<div class="row-fluid inner-col" ng-controller="PostCtrl"
		ng-init="id='${post.id}';">
		<div class="starter-template text-center">
			<div class="jumbotron">
				<h1>${post.title}</h1>
				<br />
				<p>${post.description}</p>
				<p>
					<a class="btn btn-primary btn-lg" role="button" href="#dealForm"
						data-toggle="modal">Join Fight</a>
				</p>
			</div>

		</div>
		<table class="table table-hover">
			<thead>
				<tr>
					<th>Deal List</th>
				</tr>
			</thead>

			<tbody>
				<#list post.deals?keys as key>
				<tr>
					<td>${post.deals[key].content}</td>
				</tr>
				</#list>
			</tbody>
		</table>


		<div class="modal fade" id="dealForm" role="dialog">
			<div class="modal-dialog">
				<div class="modal-content">
					<form class="form-horizontal">
						<div class="modal-header">
							<h4>Enter Your Deal</h4>
						</div>
						<div class="modal-body">

							<div class="form-group">
								<div class="col-lg-10">
									<textarea class="form-control" ng-model="content" rows="8"
										style="width: 515px;"
										placeholder="I can offer you my best deal."></textarea>
								</div>
							</div>
						</div>
						<div class="modal-footer">
							<a href="${rc.getContextPath()}/view/${post.id}"><button
									type="button" class="btn btn-success" ng-click="saveDeal()">Submit</button></a>
						</div>

					</form>

				</div>
			</div>
		</div>
	</div>
</div>

<script type="text/javascript"
	src="${rc.getContextPath()}/resources/js/pages/postctrl.js"></script>





