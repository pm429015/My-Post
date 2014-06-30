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
				<p id="post_mail" >${user.email}</p>

				<script type="text/javascript">
					$(document)
							.ready(
									function() {
										var name = getCookie("Name");
										var email = getCookie("Email");
										var postEmail = $("#post_mail").text();

										if (email != postEmail) {

											if (name && email) {
												$("#postFight")
														.html(
																'<h4>Show us your best deal</h4><div class="form-group"><div class="col-lg-8"><textarea class="form-control " id="deal_header" rows="1" style="width: 600px;"  placeholder="Headline (requried)" ></textarea> <label class="error" for="header" id="header_error"><font color="red">Write a killer Ad headline. </font></label><br><textarea class="form-control" id="content" rows="8" style="width: 650px;" placeholder="Write your deal here (required)" required></textarea><label class="error" for="content" id="deal_error"><font color="red">20 more words required.</font></label></div></div><button type="button" class="btn btn-success" id="postSubmit" >Submit</button>');
											} else {
												$("#postFight")
														.html(
																'<center><a class="btn btn-primary btn-lg" href="#loginpage" data-toggle="modal" >Join the Fight</a><center>');
											}
											$('.error').hide();
										}
									});
				</script>

				<div id="postFight"></div>
			</div>


		</div>


		<div id="w">
			<h3>Deal List</h3>
			<#assign index = 1> <#list deals as deal>
			<div id="container">
				<ul id="comments">
					<li class="cmmnt">
						<div class="cmmnt-content">
							<header>
								<a href="javascript:void(0);" class="userlink">${deal.header}</a>
								<span class="pubdate pull-right">${deal.createDate?date}</span>
							</header>
							<p>${deal.content}</p>
							<p align="right">by ${deal.user.firstName}</p>
							
							
							<a href="javascript:void(0);" class="pull-right"
								onclick="expand('${index}','${deal.user.email}');">Expand</a> <br>
						</div> 
						<#if deal.comments??> 
						<#list deal.comments?keys as i>
						<ul class="replies dis${index}">
							<li class="cmmnt">
								<div class="cmmnt-content">
									<p>${deal.comments[i].content}</p>
									<p style="text-align:right;font-size:15px">by ${deal.comments[i].user.firstName}</p>
								</div>
							</li>

						</ul> 
						</#list> 
						<#else>
							<ul class="replies dis${index}">
							<li class="cmmnt">
								<div class="cmmnt-content">
									<h4>No Comment.</h4>
								</div>
							</li>

						</ul>
						</#if>

						<div class="msg_reply" id="m_reply${index}">
							<ul class="replies dis${index} ">
								<li class="cmmnt">
									<div class="cmmnt-content">
										<h4>Leave a message</h4>
										<textarea class="form-control" id="comment${index}" rows="6"
											style="width: 700px;" placeholder="Leave a message here"></textarea>
										<div align="right"> 
											<button class="btn btn-success"
											onclick="commentSubmit('${deal.id}','${index}');">Submit</button>
										</div>
									</div>

								</li>
							</ul>

						</div>



					</li>

				</ul>
			</div>
			<#assign index = index + 1> </#list>
		</div>


	</div>
</div>

<script type="text/javascript"
	src="${rc.getContextPath()}/resources/js/pages/postctrl.js"></script>