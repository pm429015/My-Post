<#import "/spring.ftl" as spring />
<#import "macro_new.ftl" as macro/>

<title>Confirm your offer</title>
<@macro.showHeader />
<@macro.loadExternal />
<script type="text/javascript" src="${rc.getContextPath()}/resources/js/pages/payment.js"></script>
<div class="firstLayer" >
	<div class="container">
        <div class="row">
            <div class="span12">
                <div class="thumbnail">
                		<div class="caption-full">
                		<div class="BTField">
                			<h1>Request Summary</h1>
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
                				
                				
                				<#if !post.description??> 
                				<tr>
                					<td><p>More Info:</p></td>
                					<td><p id="postContent" >${post.description}</p>
                				</tr>
                				</#if>
                				
                			</table>
                			
                			<h1><font color="#ecac00">Dealer Offer: </font></h1>
                			<table style="margin:0px auto; width:80%" align="center" > 
                				<tr>
                					<td><p>Out-the-door Price:</p></td>
                					<td><p><u>${deal.header} <u></p></td>
                				</tr>
                				<tr>
                					<td><p>Message:</p></td>
                					<td><p><u>${deal.content} </u></p></td>
                				</tr>
                				
                			</table>
                			
                			
                			<table style="margin:0px auto; width:80%" align="center" border="1"> 
                			<h3 style="margin-top: 20px;">Comment: </h3>
                				 <#if deal.comments??>
                					<#list deal.comments?keys as i> 
	                				<tr>
	                					<td></td>
	                					<td><p>${deal.comments[i].content}</p>
	                						<p style="text-align:right" >By ${deal.comments[i].user.userName}</p>
	                					</td>
	                				</tr>
	                				</#list> 
                				</#if>
                			</table>
                			<h3 style="margin-top: 20px;">Dealer Contact Info: </h3>
                			<table style="margin:0px auto; width:80%" align="center" > 
                				<tr>
                					<td><p>Name:</p></td>
                					<td><p>${deal.user.userName}</p></td>
                				</tr>
                				<tr>
                					<td><p>Email:</td>
                					<td><p>${deal.user.email}</p></td>
                				</tr>
                				<tr>
                					<td><p>Phone:</td>
                					<td><p>${deal.user.phone}</p></td>
                				</tr>
                				
                				<tr>
                					<td><p>Location:</td>
                					<td><p>${deal.user.address}</p></td>
                				</tr>
                				
                				<tr>
                					<td><p>Zip code:</td>
                					<td><p>${deal.user.phone}</p></td>
                				</tr>
                			</table>

							
							<h3 style="margin-top: 20px;">Introduction Fee</h3>
							<p>Dealers pay a introduction fee on each car offer confirmation. The introduction fee is paid of dealers' own will and dose not guarantee
								sales transactions will be successful. The fee is an one-time Charge fee and it does not apply to the amount the buyer pays. 
							</p>
							<div>
							<table style="right:50px">
							<tr>
								<td><p>Summary</p></td>
								<td></td>
							</tr>
							<tr>
								<td><p>Introduction Fee:</p></td>
								<td><p>$25.00</p></td>
							</tr>
							<tr>
								<td><p>Tax Fee:</p></td>
								<td><p>$0.00</p></td>
							</tr>
							<tr>
								<td><hr style="width:190px;"></td>
								<td><hr style="width:60px;"></td>
							</tr>
							<tr>
								<td><p>Total:</p></td>
								<td><p>$25.00</p></td>
							</tr>
							
							</table>
							<br>
							<p><font color=red ><strong>Once you confirm the offer, we will notice the buy and arrange an appointment with you.</strong></font></p>
					</div>
                    </div><!--caption-full-->
                </div><!-- /.thumbnail -->

               
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
					<h3 style="color:black">Sorry, the buyer has chosen the best deal.</h3>
				</div>
			<div class="modal-footer">
				<button type="button" data-dismiss="modal" class="btn">OK</button>
			</div>
		</div>
	</div>
</div>
<link rel="stylesheet" type="text/css" href="${rc.getContextPath()}/resources/css/payment.css">
<@macro.footer />
	</body>	
</html>

