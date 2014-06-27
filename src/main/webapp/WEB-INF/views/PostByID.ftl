<#import "/spring.ftl" as spring /> <#import "macro.ftl" as macro/>
<@macro.showHeader />
<link rel="stylesheet" type="text/css"
	href="${rc.getContextPath()}/resources/css/postid.css">
<div class="content inner-col">
	<div class="row-fluid inner-col">
		<div class="starter-template text-center">
			<div class="jumbotron">
				<h1>${post.title}</h1>
				<br />
				<p>${post.description}</p>

				<p id="id" hidden>${post.id}</p>

				<script type="text/javascript">
					$(document)
							.ready(
									function() {
										var name = getCookie("Name");
										var email = getCookie("Email");

										if (name && email) {
											$("#postFight")
													.html(
															'<h4>Show us your best deal</h4><div class="form-group"><div class="col-lg-8"><textarea class="form-control" id="content" rows="8" style="width: 515px;" placeholder="Write your deal here (required)" required></textarea><label class="error" for="content" id="deal_error"><font color="red">20 more words required.</font></label></div></div><button type="button" class="btn btn-success" id="postSubmit" >Submit</button>');
										} else {
											$("#postFight")
													.html(
															'<center><a class="btn btn-primary btn-lg" href="#loginpage" data-toggle="modal" >Join the Fight</a><center>');
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


		<div id="w">
			<h3>List of Deal</h3>

			<div id="container">

				<ul id="comments">
					<li class="cmmnt">
						<div class="cmmnt-content">
							<header>
								<a href="javascript:void(0);" class="userlink">$50</a> - <span
									class="pubdate">10:30pm</span>
							</header>
							<p>I can sell you for $50</p>
						</div>

						<ul class="replies">
							<li class="cmmnt">
								<div class="cmmnt-content">
									<p>Come on Man!! $30</p>
								</div>
							</li>

						</ul>

						<ul class="replies">
							<li class="cmmnt">
								<div class="cmmnt-content">
									<p>No, $45 Thx</p>
								</div>
							</li>

						</ul>
					</li>

				</ul>
			</div>
			<div id="container">
				<ul id="comments">
					<li class="cmmnt">
						<div class="cmmnt-content">
							<header>
								<a href="javascript:void(0);" class="userlink">Life Time
									warranty</a> - <span class="pubdate">11:30pm</span>
							</header>
							<p>$70 but life time warranty.</p>
						</div>

						<ul class="replies">
							<li class="cmmnt">
								<div class="cmmnt-content">
									<p>Come on Man!! $30</p>
								</div>
							</li>

						</ul>
					</li>

				</ul>

			</div>
		</div>



	</div>
</div>

<script type="text/javascript"
	src="${rc.getContextPath()}/resources/js/pages/postctrl.js"></script>