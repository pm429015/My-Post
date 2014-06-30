<#import "/spring.ftl" as spring /> <#import "macro.ftl" as macro/>
<@macro.showHeader />
<div class="content inner-col">
	<div class="row-fluid inner-col" ng-controller="AddPost">
		<div class="starter-template">
			<h1>I am looking for ...</h1>
			<br> <br>
		</div>
		<div class="span6">
			<form class="form-horizontal">
				<div class="control-group">
					<label class="control-label" for="title">Request Summary</label>
					<div class="controls">
						<input type="text" name="subject" ng-model="title" id="subject"
							class="input-xxlarge" placeholder="Example: Unlocked IPhone 5">
					</div>
					<label class="error pull-right" for="subject" id="subject_error"><font color="red">Please Summary your request. </font></label>
				</div>
				<div class="control-group">
					<label class="control-label" for="content">Description</label>
					<div class="controls">
						<textarea ng-model="description" name="description" id="descritpion"
							class="input-xxlarge" style="height: 120px;"
							placeholder="I request a best new deal for unlocked IPhone 5."></textarea>
						<label class="error pull-right" for="description" id="descritpion_error"><font color="red">20 more words required. </font></label>
					</div>
				</div>
				
				<script type="text/javascript">
				$(document)
				.ready(
						function() {
							var name = getCookie("Name");
							var email = getCookie("Email");
							

							if(!name && !email){
								$("#userInfo")
								.html('<div class="form-horizontal center" style="position: relative; left: 150px;">'+'<legend>Your Contact Info or <a href="#loginpage" data-toggle="modal" style="color:blue"><b>Sign up/Login for free</b></a></legend>'+
									  '<div class="control-group"><label class="control-label" for="content">Name</label><div class="controls">'+
									  '<input type="text" name="name" id="name" ng-model="name" class="input" placeholder="Stanley"><label class="error" for="name" id="name_error"><font color="red">Please type your name. </font></label>'+
									  '</div> </div> <div class="control-group"><label class="control-label" for="content">Email</label>'+
									  '<div class="controls"><input type="text" name="email" ng-model="email" id="Uemail" class="input" placeholder="Your Email@email.com"><label class="error" for="email" id="email_error"><font color="red">Please type your email. </font></label></div></div></div>');
							}
							$('.error').hide();

						});
					
				</script>
				
				<div id="userInfo"></div>

				

				<button type="button"
						class="btn btn-info" ng-click="savePost()"
						style="position: absolute; right: 25%;">Submit</button>	
				<button type="button" class="btn" ng-click="clear()"
					style="position: absolute; right: 18%;">Reset</button>
			</form>
		</div>


	</div>
	<!-- post close -->
</div>
<script type="text/javascript"
	src="${rc.getContextPath()}/resources/js/pages/addPost.js"></script>
	





