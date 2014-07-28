<#import "/spring.ftl" as spring />
<#import "macro_new.ftl" as macro/>
<link rel="stylesheet" type="text/css" href="${rc.getContextPath()}/resources/css/main_page.css">

<title>How it works - DealArenas</title>

<@macro.showHeader />

	<section id="about" class="container content-section text-center" >
		<div class="row">
			<div class="col-lg-8 col-lg-offset-2" style="margin-top: 40px;">
				<h2 style="font-weight: 120">Revolutionizing the way you buy cars</h2>
				<ul class="text-left" type="square" style="color:black">
					<li><p><b>Naver waste time: </b>  Submit a free car request form, and we will contact all auto dealerships in your area so 
						you don't need to physically go there.
						</p>
					</li>
					<li><p><b>Pressure-Free negotiation: </b> Sit back and relax. You now can instantly negotiate with dealers at any where any time. 
					  	It is so much easier to walk away if they can't meet your criteria. Of course, your information will be protected.
					  	</p>
					</li>
					<li><p><b>Save quite a bit of money: </b> Having dealerships fighting for your request. You won't beleive you can save more 
								than $500.
						</p>
					</li>
					<li><p><b>Free Free Free: </b> Enjoy the free DealArenas service.
						</p>
					</li>
				</ul>
			</div>
		
			<div class="col-lg-8 col-lg-offset-2" style="margin-top: 80px;">
				
				<p>Pick a car that fits your needs and you are ready to go.</p>
				
				<li><a href="home" class="btn btn-danger btn-lg" style="margin-bottom: 20px;" >Try it for free!</a>
				</li>
				
			</div>
		</div>
	</section>
	<@macro.loadExternal />
	<@macro.footer />
	</body>	
</html>

