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
					<label class="control-label" for="title">Specific Keywords</label>
					<div class="controls">
						<input type="text" name="subject" ng-model="title"
							class="input-xxlarge" placeholder="Example: Unlocked IPhone 5">
					</div>
				</div>
				<div class="control-group">
					<label class="control-label" for="content">Description</label>
					<div class="controls">
						<textarea ng-model="description" name="description"
							class="input-xxlarge" style="height: 120px;"
							placeholder="I request a best new deal for unlocked IPhone 5."></textarea>
					</div>
				</div>

				<div class="form-horizontal center"
					style="position: relative; left: 150px;">
					<legend>Your Contact Info</legend>

					<div class="control-group">
						<label class="control-label" for="content">Nickname</label>
						<div class="controls">
							<input type="text" name="nickname" ng-model="nickname"
								class="input" placeholder="Stanley">
						</div>

					</div>

					<div class="control-group">
						<label class="control-label" for="content">Email</label>
						<div class="controls">
							<input type="text" name="email" ng-model="email" class="input"
								placeholder="Your Email@email.com">
						</div>
					</div>

					<div class="control-group">
						<label class="control-label" for="content">Zip Code</label>
						<div class="controls">
							<input type="text" name="zipcode" ng-model="zipcode"
								class="input" placeholder="94102">
						</div>
					</div>

				</div>

				<a href="${rc.getContextPath()}/postDone"><button type="button"
						class="btn btn-info" ng-click="savePost()"
						style="position: absolute; right: 25%;">Submit</button></a>
				<button type="button" class="btn" ng-click="clear()"
					style="position: absolute; right: 18%;">Reset</button>
			</form>
		</div>


	</div>
	<!-- post close -->
</div>
<@macro.showFooter>
<script type="text/javascript"
	src="${rc.getContextPath()}/resources/js/pages/addPost.js"></script>
</@macro.showFooter>




