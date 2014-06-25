<#import "/spring.ftl" as spring />
<#import "macro.ftl" as macro/>
<@macro.showHeader />

<div class="content inner-col">
	<div class="row-fluid inner-col" ng-controller="PostCtrl" ng-init="id='${post.id}' >
		<div class="starter-template text-center">
			<div class="jumbotron">
				<h1>${post.title}</h1>
				<br />
				<p>${post.description}</p>
				
				<script type="text/javascript">
			            $(document).ready(function(){
			            	var name = getCookie("Name");
							var email = getCookie("Email");
							
							if(name && email){
								$("#postFight").html('<h4>Enter Your Deal</h4><div class="form-group"><div class="col-lg-8"><textarea class="form-control" id="content" rows="8" style="width: 515px;" placeholder="I can offer you my best deal."></textarea></div></div><button type="button" class="btn btn-success" id="postSubmit" >Submit</button>');
							}else{
								$("#postFight").html('<center><a class="btn btn-primary btn-lg" href="#loginpage" data-toggle="modal" >Join the Fight</a><center>');
							}
						});
							
			     </script>
			            
			     <div id="postFight"></div>
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



	</div>
</div>

<script type="text/javascript"
	src="${rc.getContextPath()}/resources/js/pages/postctrl.js"></script>