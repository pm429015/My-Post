<#import "/spring.ftl" as spring />
<#import "macro_new.ftl" as macro/>

<title>${post.title}</title>
<@macro.showHeader />
<@macro.loadExternal />
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
                			<p>${post.zip}</p>
                			<p id="id" hidden>${post.id}</p>
                			<p id="userID" >${user.id}</p>
		
						<div id="postFight"></div>	
						
						
					</div>
                    </div><!--caption-full-->
                </div><!-- /.thumbnail -->
                <div id="bidwell"></div>
                <div id="dealerInfo"></div>	
                <div class="well">
                		<h1>Available Deals and Offers</h1>
                		
                		<#if !post.deals?has_content> 
						<h3 id="noDeal" ><center><font color=red>Become the first one. </font> </center></h3>
					</#if>

                    

                    <#assign index = 1> 
					<#list post.deals?keys as key>
					<div id="container">
						<ul id="comments" onclick="expand('${index}','${post.deals[key].user.id}');">
							<li class="cmmnt">
								<div class="cmmnt-content">
									<header>
										<a class="btn btn-danger" role="button" onclick="chooseDeal('${post.deals[key].id}')">Select it</a>
										<a href="javascript:void(0);" class="userlink">${post.deals[key].header}</a>
										<span class="pubdate pull-right">${post.deals[key].createDate?date}</span>
									</header>
									<p>${post.deals[key].content}</p>
									<p align="right">by ${post.deals[key].user.userName}</p>
									<a href="javascript:void(0);" class="pull-right" id="expand${index}"
										onclick="expand('${index}','${post.deals[key].user.id}');">Expand</a> <br>
								</div> 
								<#if post.deals[key].comments??> 
									<#list post.deals[key].comments?keys as i>
									<ul class="replies dis${index}">
										<li class="cmmnt">
											<div class="cmmnt-content">
												<p>${post.deals[key].comments[i].content}</p>
												<p style="text-align:right;font-size:15px">by ${post.deals[key].comments[i].user.userName}</p>
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
					</div>
					<#assign index = index + 1> 
					</#list>

                    

                </div>
            </div>

        </div>

    </div> <!-- /.container -->
</div>

<link rel="stylesheet" type="text/css" href="${rc.getContextPath()}/resources/css/battlefield.css">
<@macro.footer />
	</body>	
</html>

