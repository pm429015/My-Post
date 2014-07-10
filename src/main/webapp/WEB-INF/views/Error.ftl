<#import "/spring.ftl" as spring />
<#import "macro_new.ftl" as macro/>
<link rel="stylesheet" type="text/css" href="${rc.getContextPath()}/resources/css/main_page.css">

<title>The Page Not Found.</title>

<@macro.showHeader />

	<section id="about" class="container content-section text-center" >
		<div class="row">
			<div class="col-lg-8 col-lg-offset-2" style="margin-top: 80px;">
				<h1 style="color:#000;" >We are sorry</h1>
				<p>The page you are looking for no longer exists or has moved to a new location.
				</p>
				
				<li><a href="home"
						class="btn btn-danger btn-lg">DealArenas</a>
					
				</li>
				
			</div>
		</div>
	</section>
	<script type="text/javascript" src="${rc.getContextPath()}/resources/js/pages/main_page.js"></script>
	</body>	
</html>

