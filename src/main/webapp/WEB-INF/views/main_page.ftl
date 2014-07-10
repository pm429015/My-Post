<#import "/spring.ftl" as spring />
<#import "macro_new.ftl" as macro/>
<link rel="stylesheet" type="text/css" href="${rc.getContextPath()}/resources/css/main_page.css">
<title>DealArena</title>
<@macro.showHeader />
	<!-- Product Showcase -->
        <div class="product-showcase">
            <div class="product-showcase-pattern">
                <div class="container">
                    <div class="row">
                        <div class="span12 product-background">
                            <div class="row">
                                <div class="col-md-5 product-image leftContent">
                                   <p>You deserve a better way to find your dream deal. </p>
                                </div>
                                <div class="col-md-7 product-title">
                                    <form class="form-horizontal requestForm">
                                    <fieldset>
                                    		<!--  Header-->
							            <div class="form-group form-header">
							              <h3 class="col-md-10 control-label">Request a deal for <font color=red>FREE</font></h3>
							            </div>
                                    
                                    		<!-- Subject input-->
							            <div class="form-group">
							              <h3 class="col-md-3 control-label" for="title">Subject:</h3>
							              <div class="col-md-5">
							                <input id="title" name="title" type="text" placeholder="Example: An affordable iPhone 5 " class="form-control"></input>
							                <label class="error" for="title" id="subject_error"><font color="red">Please Summary your request. </font></label>
							              </div>
							            </div>
							            
							            	<!-- Email input-->
							            <div class="form-group email-group">
							              <h3 class="col-md-3 control-label" for="Uemail">Email:</h3>
							              <div class="col-md-5">
							                <input id="Uemail" name="Uemail" type="text" placeholder="your@email.com" class="form-control"></input>
							                <label class="error" for="Uemail" id="Uemail_error"><font color="red">Invalid email address</font></label>
							              </div>
							            </div>
                                    		
                                    		<!-- content input-->
							            <div class="form-group">
							              <h3 class="col-md-3 control-label" for="description">Description:</h3>
							              <div class="col-md-8">
							                <textarea id="description" name="description" style="height: 290px;" type="text" placeholder="Hey guys! I REALLY like the iPhone 5, but they are freaky expensive when bought on the Apple site and eBay. I have absolutely no problem with it being used/refurbished. I'm wondering where I can find one that isn't +$600." class="form-control"></textarea>
							                <label class="error" for="description" id="descritpion_error"><font color="red">10 more words required. </font></label>
							              </div>
							            </div>
							            
							            <!-- Form actions -->
							            <div class="form-group ">
							              <div class="col-md-11 text-right">
							                <button class="btn btn-danger btn-lg" id="RequestSubmit" type="button" >Submit</button>
							              </div>
							            </div>
							            
                                    </fieldset>
									</form>
									
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
<div id="aboutlayer">
	<section id="about" class="container content-section text-center">
		<div class="row">
			<div class="col-lg-8 col-lg-offset-2">
				<h2>About DealArenas</h2>
				<p>DealArenas is a paradise for buyers to instantly negotiate, compare and choose the best deals they like. 
				DealArenas is also a sellers arena because only the best deals could survive. If you want to buy something but 
				can't find a good deal or you have good deals but can't find customers, DealArenas is your best friend.
				</p>
				<p>dealarenas@gmail.com</p>
				<li><a href="mailto:dealarenas@gmail.com"
						class="btn btn-default btn-lg"><i
							class="fa fa-google-plus fa-fw"></i> <span class="network-name">Google+</span></a>
					</li>
			</div>
		</div>
	</section>
</div>
	<script type="text/javascript" src="${rc.getContextPath()}/resources/js/pages/main_page.js"></script>
	</body>	
</html>
