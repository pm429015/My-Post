<#import "/spring.ftl" as spring />
<#import "macro.ftl" as macro/>
<@macro.showHeader />

<div class="content inner-col">
	<div class="row-fluid inner-col">
		<div class="starter-template text-center">
			<div class="jumbotron">
				<h1>${post.title}</h1>
				<br />
				<p>${post.description}</p>
				
				<p id="id" hidden>${post.id}</p>
				
				<script type="text/javascript">
			            $(document).ready(function(){
			            	var name = getCookie("Name");
							var email = getCookie("Email");
							
							if(name && email){
								$("#postFight").html('<h4>Show us your best deal</h4><div class="form-group"><div class="col-lg-8"><textarea class="form-control" id="content" rows="8" style="width: 515px;" placeholder="Write your deal here (required)" required></textarea><label class="error" for="content" id="deal_error"><font color="red">20 more words required.</font></label></div></div><button type="button" class="btn btn-success" id="postSubmit" >Submit</button>');
							}else{
								$("#postFight").html('<center><a class="btn btn-primary btn-lg" href="#loginpage" data-toggle="modal" >Join the Fight</a><center>');
							}
							$('.error').hide();
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