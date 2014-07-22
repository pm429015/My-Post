<#import "/spring.ftl" as spring />
<#import "macro_new.ftl" as macro/>
<@macro.loadExternal />
<script type="text/javascript" src="${rc.getContextPath()}/resources/js/pages/postctrl.js"></script>
                <div class="well">
                	<h1>Current Deals</h1>
                		
                	<#if !post.deals?has_content> 
						<h3 id="noDeal" ><center><font color=red>Become the first one. </font> </center></h3>
					</#if>

                    <#assign index = 1> 
					<#list post.deals?keys as key>
					<div id="container">
						<ul id="comments">
							<li class="cmmnt">
								<div class="cmmnt-content">
									<header>
										<div class="col-md-1 selectBT">
											<a class="btn btn-success" role="button" onclick="chooseDeal('${post.deals[key].id}')">Select it</a>
										</div>
										<div class="col-md-11 ">
											<h3 id="cmt-header" >${post.deals[key].header}</h3>
										</div>
									</header>
									<div class="col-md-12">
										<p>${post.deals[key].content}</p>
									</div>
									<p class= "timeAndDealer" style="text-align:right">${post.deals[key].createDate?date} By ${post.deals[key].user.userName}</p>
									
									<div class="text-center">
										<button type="button" id="expand${index}" class="btn btn-sm pull-center" onclick="expand('${index}','${post.deals[key].user.id}');">
											<span class="glyphicon glyphicon-chevron-down"></span>
										</button>
									</div> 
								</div> 
								<#if post.deals[key].comments??> 
									<#list post.deals[key].comments?keys as i>
									<ul class="replies dis${index}">
										<li class="cmmnt">
											<div class="cmmnt-content">
												<p>${post.deals[key].comments[i].content}</p>
												<p class= "timeAndDealer" style="text-align:right" >by ${post.deals[key].comments[i].user.userName}</p>
											</div>
										</li>
			
									</ul> 
									</#list> 
								
								</#if>
		
								<div class="msg_reply" id="m_reply${index}">
									<ul class="replies dis${index} ">
										<li class="cmmnt">
											<div class="cmmnt-content">
												<h3>Leave a message</h3>
												<textarea class="form-control comments" id="comment${index}" rows="6"
													style="width: 700px;" placeholder="Leave a message here"></textarea>
												<label class="error" for="comment${index}" id="comment_error"><font color="red">Please write something. </font></label>
												<div align="right"> 
													<button class="btn btn-success btn-lg"
													onclick="commentSubmit('${post.deals[key].id}','${index}');">Submit</button>
												</div>
											</div>
										</li>
									</ul>
								</div>
							</li>
		
						</ul>
					</div> <!-- /.container -->
					<#assign index = index + 1> 
					</#list>
				</div><!-- well -->
	</body>	
</html>

