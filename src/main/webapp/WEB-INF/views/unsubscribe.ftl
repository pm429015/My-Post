<#import "/spring.ftl" as spring />
<#import "macro_new.ftl" as macro/>
<link rel="stylesheet" type="text/css" href="${rc.getContextPath()}/resources/css/main_page.css">

<title>Please Help Us Improve Our Service</title>

<@macro.showHeader />

	<section id="about" class="container content-section text-center" >
		<div class="row">
			<div class="col-lg-8 col-lg-offset-2" style="margin-top: 80px;">
				<h1 style="color:#000;" >You Are Now Unsubscribed.</h1>
				<p>To improve our services we'd like to know more about why you decided to unsubscrible. If you have a moment,
					please leave a message for us. We appreciate your feedback.
				</p>
				
				<li><a href="mailto:dealarenas@gmail.com"
						class="btn btn-danger btn-lg" style="margin-bottom: 30px;" >Contact Us</a>
				</li>
				
			</div>
		</div>
	</section>
	<@macro.loadExternal />
	<@macro.footer />
	</body>	
</html>

