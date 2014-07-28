<#import "/spring.ftl" as spring />
<#import "macro_new.ftl" as macro/>
<link rel="stylesheet" type="text/css" href="${rc.getContextPath()}/resources/css/main_page.css">

<title>How it works - DealArenas</title>

<@macro.showHeader />

	<section id="about" class="container content-section text-center" >
		<div class="row">
			<div class="col-lg-8 col-lg-offset-2" style="margin-top: 40px;">
				<h2 style="font-weight: 100">Revolutionizing the way you buy cars</h2>
			</div>
		
			<div class="col-lg-8 col-lg-offset-2" style="margin-top: 80px;">
				<h2 >About DealArenas</h2>
				<p>
				DealArenas is a paradise for car buyers to instantly negotiate, compare and choose the best deals they like. 
								DealArenas is also a dealers arena because only the best deals could survive. If you want to buy a car but 
								can't find a good dealer or you can offer good car deals but can't find customers, DealArenas is your best friend.
				
				</p>
				
				<li><a href="home" class="btn btn-danger btn-lg" style="margin-bottom: 20px;" >Try it for free!</a>
				</li>
				
			</div>
		</div>
	</section>
	<@macro.loadExternal />
	<@macro.footer />
	</body>	
</html>

