<#import "/spring.ftl" as spring />
<#import "macro_new.ftl" as macro/>

<title>Confirm your offer</title>
<@macro.showHeader />
<@macro.loadExternal />
<div class="firstLayer" >
	<div class="container">
        <div class="row">
        	<div class="col-md-8 pull-left">
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
                			
                			<h1>Dealer Offer: </h1>
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
	                					<td><p class="commentTable" >${deal.comments[i].content}</p>
	                						<p style="text-align:right" class="commentTable" >By ${deal.comments[i].user.userName}</p>
	                					</td>
	                				</tr>
	                				</#list> 
                				</#if>
                			</table>
                			<h3 style="margin-top: 20px;">Dealer Contact Info:</h3>
                			
                			<div id="infoTable">
	                			<table style="margin:0px auto; width:80%" align="center" > 
	                				<tr>
	                					<td><p>Name:</p></td>
	                					<td><p><input id="dealerName" placeholder="${deal.user.userName}"></p></input></td>
	                				</tr>
	                				<tr>
	                					<td><p>Email:</td>
	                					<td><p><input id="dealerEmail" placeholder="${deal.user.email}"></p></input></td>
	                				</tr>
	                				<tr>
	                					<td><p>Phone:</td>
	                					<td><p><input id="dealerPhone" placeholder="${deal.user.phone}"></p></input></td>
	                				</tr>
	                				
	                				<tr>
	                					<td><p>Location:</td>
	                					<td><p><input id="dealerAddress" placeholder="${deal.user.address}"></p></input></td>
	                				</tr>
	                				
	                				<tr>
	                					<td><p>Zip code:</td>
	                					<td><p><input id="dealerZip" placeholder="${deal.user.zipCode}"></p></input></td>
	                				</tr>
	                			</table>
	                			<button class="btn btn-info pull-right" type="button" onclick="infoUpdate('${deal.id}')">Update</button>
							</div>
							
							<h3 style="margin-top: 20px;" >Introduction Fee</h3>
							<p>Dealers pay a introduction fee on each car offer confirmation. The introduction fee is paid of dealers' own will and dose not guarantee
								sales transactions will be successful. The fee is an one-time non-refundable fee and it does not apply to the amount the buyer pays. 
							</p>
						<div>
					
						</div>
                   </div><!--caption-full-->
                    
                </div><!-- /.thumbnail -->
             </div>
               
        </div><!-- row -->
        
        <div class="col-md-4">
            <div class="thumbnail">
               <div class="caption-full">
                		<div class="BTField">
                			<h3 id="paymentTitle">Confirm Here</h3>
                			<p><font color=red ><strong>Once you confirm the offer, we will notify the buy to contact you.</strong></font></p>
                			<table style="width:100%; margin-top: 20px;" >
								<tr>
									<td><p><b>Summary</b></p></td>
									<td></td>
								</tr>
								<tr>
									<td><p>Introduction Fee:</p></td>
									<td class="td-right"><p>$25.00</p></td>
								</tr>
								<tr>
									<td><p>Tax Fee:</p></td>
									<td class="td-right"><p>$0.00</p></td>
								</tr>
								<tr>
									<td><hr style="width:100%;"></td>
									<td><hr style="width:100%;"></td>
								</tr>
								
								<tr>
									<td><p>Total:</p></td>
									<td><p>$25.00</p></td>
								</tr>
								
							</table>
							By clicking Pay Now, you have read and agreed with the terms and conditions.<br>
							<a href="paypal?dealID=${deal.id}" style="margin-bottom: 10px;"><img src="https://www.paypalobjects.com/en_US/i/btn/btn_paynow_LG.gif" align="right"></a>
							<h6></h6>
                		</div>
                	</div>
            </div><!-- /.thumbnail -->
        </div><!-- col-md-2 -->
        
    </div> <!-- /.container -->
</div>


<link rel="stylesheet" type="text/css" href="${rc.getContextPath()}/resources/css/payment.css">
<script type="text/javascript" src="${rc.getContextPath()}/resources/js/pages/payment.js"></script>
<@macro.footer />
	</body>	
</html>

