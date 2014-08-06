<#import "/spring.ftl" as spring />
<#import "macro_new.ftl" as macro/>

<title>Request a Car Deal: ${post.title} ${post.model}</title>
<@macro.showHeader />
<@macro.loadExternal />
<script type="text/javascript" src="${rc.getContextPath()}/resources/js/pages/postctrl.js"></script>
<div class="firstLayer" >
	<div class="container">
        <div class="row">
            <div class="span12">
                <div class="thumbnail">
                		<div class="caption-full">
                		<div class="BTField">
                			<h1>Request a Car Deal: ${post.title} ${post.model}</h1>
                			<table style="margin:0px auto; width:80%" align="center" > 
                				<tr>
                					<td><p>Car Make:</p></td>
                					<td><p>${post.title}</p></td>
                				</tr>
                				<tr>
                					<td><p>Model:</p></td>
                					<td><p>${post.model}</p></td>
                				</tr>
                				<tr>
                					<td><p>Color:</p></td>
                					<td><p>${post.color}</p></td>
                					
                				</tr>
                				<tr>
                					<td><p>Year:</p></td>
                					<td><p>${post.year}</p></td>
                				</tr>
                				
                				<tr>
                					<td><p>Buyer Zip code:</p></td>
                					<td><p>${post.zip}</p></td>
                				</tr>
                				
                				<tr>
                					<td><p>Remining Time:</p></td>
                					<td><iframe src="http://free.timeanddate.com/countdown/i49ggjda/n848/cf12/cm0/cu4/ct0/cs1/ca0/co0/cr0/ss0/cac000/cpc000/pcfff/tcfff/fs100/szw320/szh135/iso${post.expireDate?string("yyyy-MM-dd")}T${post.expireDate?string("HH:mm:ss")}" frameborder="0" width="103" height="30"></iframe>
                				</tr>
                				
                				
                				<#if post.description??> 
                				<tr>
                					<td><p>More Info:</p></td>
                					<td><p id="postContent" >${post.description}</p>
                				</tr>
                				</#if>
                				
                				<tr>
                					<td><p>Request Status:</p></td>
                					<td><p><u id="status">${post.active}</u></p></td>
                				</tr>
                			</table>
                			
                			<p id="id" hidden>${post.id}</p>
                			<p id="userID" hidden>${user.id}</p>
		
						<div id="postFight"></div>	
						
						
					</div>
                    </div><!--caption-full-->
                </div><!-- /.thumbnail -->
                <div id="bidwell"></div>
                <div id="dealerInfo"></div>	
                <div class="dealspaste" >
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
											<a class="btn btn-success " role="button" onclick="chooseDeal('${post.deals[key].id}')">Select it</a>
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
				</div><!-- deal paste -->
            </div><!-- span12 -->
        </div><!-- row -->
    </div> <!-- /.container -->
</div>

<div>
	<div class="modal fade" id="doubleCheck" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-body">
					<h3 style="color:black">Are you sure?</h3>
				</div>
			<div class="modal-footer">
				<button type="button" data-dismiss="modal" class="btn btn-primary" id="go">OK</button>
				<button type="button" data-dismiss="modal" class="btn">Cancel</button>
			</div>
		</div>
	</div>
</div>

<div>
	<div class="modal fade" id="locked" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-body">
					<h3 style="color:black">Sorry, the requet has been processed.</h3>
				</div>
			<div class="modal-footer">
				<button type="button" data-dismiss="modal" class="btn">OK</button>
			</div>
		</div>
	</div>
</div>
<link rel="stylesheet" type="text/css" href="${rc.getContextPath()}/resources/css/battlefield.css">
<@macro.footer />
	</body>	
</html>

