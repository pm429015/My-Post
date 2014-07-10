<#import "/spring.ftl" as spring />
<#import "macro_new.ftl" as macro/>

<title>${post.title}</title>
<@macro.showHeader />
<link rel="stylesheet" type="text/css" href="${rc.getContextPath()}/resources/css/battlefield.css">
<script src="//cdn.datatables.net/1.10.0/js/jquery.dataTables.js"></script>
<link href="//cdn.datatables.net/1.10.0/css/jquery.dataTables.css" rel="stylesheet">
<script type="text/javascript" src="${rc.getContextPath()}/resources/js/pages/postctrl.js"></script>
<div class="firstLayer" >
	<div class="container">

        <div class="row">

            <div class="span12">
                <div class="thumbnail">
                		<div class="caption-full">
                		<div class="BTField">
                			<h1>${post.title}</h1>
                			<p>${post.description}</p>
                			<p id="id" hidden>${post.id}</p>
                			<p id="post_mail" hidden>${user.email}</p>
		
						<div id="postFight"></div>
						
					</div>
                    </div><!--caption-full-->
                </div><!-- /.thumbnail -->
                
                <div class="well">
                		<h1>Available Deals and Offers</h1>
                		
                		<#if !deals?has_content> 
						<h3 id="noDeal" ><center>People tend to choose the first deal they find. <font color=red>Become the first one. </font> </center></h3>
					</#if>

                    

                    <#assign index = 1> 
					<#list deals as deal>
					<div id="container">
						<ul id="comments" onclick="expand('${index}','${deal.user.email}');">
							<li class="cmmnt">
								<div class="cmmnt-content">
									<header>
										<a href="javascript:void(0);" class="userlink">${deal.header}</a>
										<span class="pubdate pull-right">${deal.createDate?date}</span>
									</header>
									<p>${deal.content}</p>
									<p align="right">by ${deal.user.firstName}</p>
									
									
									<a href="javascript:void(0);" class="pull-right" id="expand${index}"
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
											<h4>No comments yet.</h4>
										</div>
									</li>
		
								</ul>
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
													onclick="commentSubmit('${deal.id}','${index}');">Submit</button>
												</div>
											</div>
										</li>
									</ul>
								</div>
							</li>
		
						</ul>
					</div>
					<#assign index = index + 1> 
					</#list>

                    

                </div>
            </div>

        </div>

    </div> <!-- /.container -->
</div>

	</body>	
</html>
