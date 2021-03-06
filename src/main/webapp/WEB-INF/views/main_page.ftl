<#import "/spring.ftl" as spring />
<#import "macro_new.ftl" as macro/>

<title>DealArenas.com - Get car dealers to compete for your new purchase </title>
<@macro.showHeader />
	<!-- Product Showcase -->
        <div class="product-showcase">
            <div class="product-showcase-pattern">
                <div class="container">
                    <div class="row">
                        <div class="span12 product-background">
                            <div class="row">
                                <div class="col-md-5 product-image leftContent">
                                   <p>Make Dealers Bid </p>
                                </div>
                                <div class="col-md-7 product-title">
                                    <form class="form-horizontal requestForm">
                                    <fieldset>
                                    	<!--  Header-->
							            <div class="form-group form-header">
							              <h3 class="col-md-10 control-label">Request a best car deal for <u>FREE</u></h3>
							            </div>
                                    
                                    	<!-- Make input-->
							            <div class="form-group">
							              <h3 class="col-md-3 control-label" for="title">Car Make:</h3>
							              <div class="col-md-5">
							                <input id="title" name="title" type="text" placeholder="Example: Toyota" class="form-control"></input>
							                <label class="error" for="title" id="subject_error" hidden><font color="red">No Emtpy Field.</font></label>
							              </div>
							            </div>
							            
							            <!-- Model input-->
							            <div class="form-group email-group">
							              <h3 class="col-md-3 control-label" for="Umodel">Model:</h3>
							              <div class="col-md-5">
							                <input id="Umodel" name="Umodel" type="text" placeholder="Example: Camry SE" class="form-control"></input>
							                <label class="error" for="Umodel" id="Umodel_error" hidden><font color="red">No Emtpy Field.</font></label>
							              </div>
							            </div>
							            
							            <!-- Year input-->
							            <div class="form-group email-group">
							              <h3 class="col-md-3 control-label" for="Uyear">Year:</h3>
							              <div class="col-md-5">
							                <input id="Uyear" name="Uyear" type="text" placeholder="Example: 2014 or Used" class="form-control"></input>
							                <label class="error" for="Uyear" id="Uyear_error" hidden><font color="red">No Emtpy Field.</font></label>
							              </div>
							            </div>
							            
							            <!-- Color input-->
							            <div class="form-group email-group">
							              <h3 class="col-md-3 control-label" for="Ucolor">Color:</h3>
							              <div class="col-md-5">
							                <input id="Ucolor" name="Ucolor" type="text" placeholder="Example: red or blue" class="form-control"></input>
							                <label class="error" for="Ucolor" id="Ucolor_error" hidden><font color="red">No Emtpy Field.</font></label>
							              </div>
							            </div>
							            
							            <!-- ZipCode input-->
							            <div class="form-group zipcode-group">
							              <h3 class="col-md-3 control-label" for="Uzip">Zip:</h3>
							              <div class="col-md-3">
							                <input id="Uzip" name="Uzip" type="text" placeholder="zip code" class="form-control"></input>
							                <label class="error" for="Uzip" id="Uzip_error" hidden><font color="red">No Emtpy Field.</font></label>
							              </div>
							              <div class="col-md-1">
							              	<h3 class="control-label">in</h3>
							              </div>
							              
							              <div class="col-md-4">
							              	<select class="form-control miles">
							              		<option>5 Miles</option>
											    <option>10 Miles</option>
											    <option>20 Miles</option>
											    <option>30 Miles</option>
											    <option>40 Miles</option>
											    <option>50 Miles</option>
											</select>
							              </div>
							            </div>
							            
							            <!-- Form actions -->
							            <div class="form-group ">
							              <div class="col-md-11 text-right">
							                <button class="btn btn-danger btn-lg" id="CarSubmit" type="button" >Submit</button>
							              </div>
							            </div>
							            
                                    </fieldset>
									</form>
									
									<form class="form-horizontal userForm">
									</form>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            
            <section id="about" class="container content-section text-center" >
		<div class="row">
			<div class="col-lg-8 col-lg-offset-2" style="margin-top: 40px;">
				<h2 style="font-weight: 120; color:black">Revolutionizing the way you buy cars</h2>
			</div>
			<div class="col-md-6">
				<ul class="text-left" type="square" style="color:black">
					<li><p><b>Never waste you time: </b>  Submit a free car deal request form and we will contact all auto dealerships in your area so 
						you don't need to physically go there.
						</p>
					</li>
					<li><p><b>Save quite a bit of money: </b> Having dealerships fighting for your request. You won't believe you can save more 
								than $2,000.
						</p>
					</li>
					
					<li><p><b>Pressure-Free negotiation: </b> Sit back and relax. You now can instantly negotiate with dealers at any where any time. 
					  	It is so much easier to walk away if they can't meet your criteria.
					  	</p>
					</li>
					
					<li><p><b>Free and always free: </b> Enjoy the best DealArenas service. No additional fees and commissions.
						</p>
					</li>
				</ul>
			</div>
			<div class="col-md-6">
				<ul class="text-left">
					<li>
						<h1 style="color:#f0371e; font-size:500%">Save Time</h1>
					</li>
					<li>
						<h1 style="color:#f0371e; font-size:500%">Save Money</h1>
					</li>
					<li>
						<h1 style="color:#f0371e; font-size:500%">Relax</h1>
					</li>
					<li>
						<h1 style="color:#f0371e; font-size:500%">Free</h1>
					</li>
				</ul>
			</div>
		
			<div class="col-lg-8 col-lg-offset-2" style="margin-top: 30px;">
				<p>All you need to do is to pick a car that fit your needs and request a offer at here.</p>
				<li><a class="btn btn-danger btn-lg" style="margin-bottom: 20px;" id="moveTop">Try it now</a>
				</li>
			</div>
		</div>
	</section>
            
            
            <div id="aboutlayer">
				<div id="about" class="container content-section text-center">
					<div class="row">
						<div class="col-lg-8 col-lg-offset-2">
							<h1 style="color:#ffcc33">Join Our Auto Dealer Network</h1>
							<form class="form-horizontal">
                            		<fieldset>
                            			<!--  Header-->
							        <div class="form-group">
							              <p class="text-center" >Make Your Time Worth Every Minute You Invest in Your Customers. </p>
							        </div>
							        
							        <!-- Dealer name-->
							        <div class="form-group">
							        <p class="col-md-3 control-label dtext" for="Dname">Name:</p>
							           <div class="col-md-8">
							      	     <input id="Dname" name="Dname" type="text" placeholder="Your name" class="form-control"></input>
							             <label class="error" for="Dname" id="Dname_error" hidden><font color="red">No Emtpy Field.</font></label>
							             </div>
							        </div>
							        
							        <!-- Name of Dealership-->
							        <div class="form-group">
							        <p class="col-md-3 control-label dtext" for="Dealership">Dealership:</p>
							           <div class="col-md-8">
							      	     <input id="Dealership" name="Dealership" type="text" placeholder="Name of dealership" class="form-control"></input>
							             <label class="error" for="Dealership" id="Dealership_error" hidden><font color="red">No Emtpy Field.</font></label>
							             </div>
							        </div>
							        
							        <!-- Make -->
							        <div class="form-group">
							        <p class="col-md-3 control-label dtext" for="Dmake">Make:</p>
							           <div class="col-md-8">
							      	     <input id="Dmake" name="Dmake" type="text" placeholder="Car Make/Model you sell. (For example, Honda, Toyota and Ford )" class="form-control"></input>
							             <label class="error" for="Dmake" id="Dmake_error" hidden><font color="red">No Emtpy Field.</font></label>
							             </div>
							        </div>
							        
							        <!-- Email -->
							        <div class="form-group">
							        <p class="col-md-3 control-label dtext" for="Demail">Email:</p>
							           <div class="col-md-8">
							      	     <input id="Demail" name="Demail" type="text" placeholder="Your contact email" class="form-control"></input>
							             <label class="error" for="Demail" id="Demail_error" hidden><font color="red">Invalid Email address.</font></label>
							             </div>
							        </div>
							        
							        <!-- phone -->
							        <div class="form-group">
							        <p class="col-md-3 control-label dtext" for="Dphone">Phone:</p>
							           <div class="col-md-8">
							      	     <input id="Dphone" name="Dphone" type="text" placeholder="Your phone" class="form-control"></input>
							             <label class="error" for="Dphone" id="Dphone_error" hidden><font color="red">No Emtpy Field.</font></label>
							             </div>
							        </div>
							        
							        <!-- Address -->
							        <div class="form-group">
							        <p class="col-md-3 control-label dtext" for="Daddress">Address:</p>
							           <div class="col-md-8">
							      	     <input id="Daddress" name="Daddress" type="text" placeholder="Your contact address" class="form-control"></input>
							             <label class="error" for="Daddress" id="Daddress_error" hidden><font color="red">No Emtpy Field.</font></label>
							             </div>
							        </div>
							        
							        <!-- zip -->
							        <div class="form-group">
							        <p class="col-md-3 control-label dtext" for="Dzip">Zip:</p>
							           <div class="col-md-8">
							      	     <input id="Dzip" name="Dzip" type="text" placeholder="Your Zip code" class="form-control"></input>
							             <label class="error" for="Dzip" id="Dzip_error" hidden><font color="red">No Emtpy Field.</font></label>
							             </div>
							        </div>
                            		
                            		
                            		</fieldset>
                            	</form>
                            	
                            	<div class="col-lg-8 col-lg-offset-2" style="margin-top: 5px;">
									<li><a class="btn btn-danger btn-lg" style="margin-bottom: 20px;" onclick="dealerSubmit()">Join Us</a>
									</li>
								</div>
						</div>
					</div>
				</div>
			</div>
        </div>

	<@macro.loadExternal />
	<link rel="stylesheet" type="text/css" href="${rc.getContextPath()}/resources/css/main_page.css">
	<script type="text/javascript" src="${rc.getContextPath()}/resources/js/pages/main_page.js"></script>
	
	<@macro.footer />
	<div>
	<div class="modal fade" id="doubleCheck" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-body">
					<h3 style="color:black">Thank you.</h3>
					<p style="color:black">Your validation email have been sent.</p>
					<p style="color:black">Once you get the validation email, just click the link and you'll be all set.</p>
				</div>
			<div class="modal-footer">
				<button type="button" data-dismiss="modal" class="btn btn-primary" id="go">OK</button>
			</div>
		</div>
	</div>
</div>
	</body>	
</html>

