<#import "/spring.ftl" as spring />
<#import "macro_new.ftl" as macro/>

<title>DealArenas</title>
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
							                <input id="Uyear" name="Uyear" type="text" placeholder="Example: 2014" class="form-control"></input>
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
            <div id="aboutlayer">
				<div id="about" class="container content-section text-center">
					<div class="row">
						<div class="col-lg-8 col-lg-offset-2">
							<h2>About DealArenas</h2>
							<p>DealArenas is a paradise for car buyers to instantly negotiate, compare and choose the best deals they like. 
								DealArenas is also a dealers arena because only the best deals could survive. If you want to buy a car but 
								can't find a good dealer or you can offer good car deals but can't find customers, DealArenas is your best friend.
								
							</p>
							<p>dealarenas@gmail.com</p>
							<li><a href="mailto:dealarenas@gmail.com"
								class="btn btn-default btn-lg"><i
								class="fa fa-google-plus fa-fw"></i> <span class="network-name">Google+</span></a>
							</li>
						</div>
					</div>
				</div>
			</div>
        </div>

	<@macro.loadExternal />
	<link rel="stylesheet" type="text/css" href="${rc.getContextPath()}/resources/css/main_page.css">
	<script type="text/javascript" src="${rc.getContextPath()}/resources/js/pages/main_page.js"></script>
	<@macro.footer />
	</body>	
</html>

