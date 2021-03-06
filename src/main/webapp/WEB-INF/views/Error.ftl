<#import "/spring.ftl" as spring />
<#import "macro_new.ftl" as macro/>
<link rel="stylesheet" type="text/css" href="${rc.getContextPath()}/resources/css/main_page.css">

<title>The Page Not Found</title>

<@macro.showHeader />

	<section id="about" class="container content-section text-center" >
		<div class="row">
			<div class="col-lg-8 col-lg-offset-2" style="margin-top: 80px;">
				<h1 style="color:#000;" >We are sorry</h1>
				<p>The page you are looking for no longer exists or has moved to a new location.
				</p>
				
				<li style="margin-botton: 30px;"><a href="home"
						class="btn btn-danger btn-lg" style="margin-bttom: 30px;">DealArenas</a>
				</li>
				
			</div>
		</div>
	</section>
	<@macro.loadExternal />
	<@macro.footer />
	</body>	
</html>

