<#import "/spring.ftl" as spring />
<#import "macro_new.ftl" as macro/>

<title>How it works - DealArenas</title>

<@macro.showHeader />

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
								than $500.
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
				<li><a class="btn btn-danger btn-lg" style="margin-bottom: 20px;" onclick="dealerSubmit()" >Try it now</a>
				</li>
			</div>
		</div>
	</section>
	<@macro.loadExternal />
	<link rel="stylesheet" type="text/css" href="${rc.getContextPath()}/resources/css/main_page.css">
	<@macro.footer />
	</body>	
</html>

