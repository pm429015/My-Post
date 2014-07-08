<nav class="navbar navbar-custom navbar-fixed-top" role="navigation">
		<div class="container">
			<div class="navbar-header page-scroll">
				<button type="button" class="navbar-toggle" data-toggle="collapse"
					data-target=".navbar-main-collapse">
					<i class="fa fa-bars"></i>
				</button>
				<a class="navbar-brand" href="${rc.getContextPath()}/" id="brand"> <i
					class="fa fa-play-circle"></i> <span class="light">DealArenas</span>
				</a>
			</div>

			<!-- Collect the nav links, forms, and other content for toggling -->
			<div
				class="collapse navbar-collapse navbar-right navbar-main-collapse">
				<ul class="nav navbar-nav">
					<!-- Hidden li included to remove active class from about link when scrolled up past about section -->
					<li class="page-scroll"><a href="home">I Want</a></li>
					<li class="page-scroll"><a href="arena">I Sell</a></li>
					<li id="userToken" ></li>
					<li id="loginStatus" ></li>
				</ul>
			</div>
			<!-- /.navbar-collapse -->
		</div>
		<!-- /.container -->
	</nav>
	
	<!-- Login Modal -->
<div id="loginform">	
  <div class="modal fade" id="loginPage" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
    <div class="modal-dialog">
      <div class="modal-content">
        		<form class="form-horizontal modalLoginForm">
	        		<div class="modal-header">
						<a class="nav pull-right" href="#" data-dismiss="modal"
									data-target="#loginpage">X</a>
						<div id="loginh">
							<h3><center> Connect with your favorite account<center></h3>
						</div>
				</div>
        			<div class="modal-body">
          			<table cellpadding="10" cellspacing="10" align="center">
          				<tr>
          					<td><a href="socialauth?id=facebook">
								<div id="facebook">
									<img src="${rc.getContextPath()}/resources/img/fb.png" alt="Facebook" title="Facebook" border="0" />
										<div id="connect"><center>Connect with Facebook</center></div> </div>
								</a>
							</td>
							
							<td><a href="socialauth?id=googleplus">
									<div id="google">
										<img src="${rc.getContextPath()}/resources/img/google.png" alt="Google" title="Google" border="0" />
											<div id="connect"> <center>Connect with Google</center> </div> 
									</div>
								</a>
							</td>
          				</tr>
          				
          				<tr>
							<td colspan="10" align="center">
								<div id="mainlogin">
									<h3> <font color="white">Login through Your Email</font></h3>
										<input type="text" placeholder="Email" value="" id="email" name="email" required> 
											<label class="error" for="email" id="email_error">This field is required a valid email format.</label>
											<button id="emailLoginBtn"><a>Login</a></button>

												<div id="note">
													<a href="#">You don't need to sign up</a>
												</div>
								</div>
							</td>
						</tr>
          			</table>
       			</div>
        </form>
      </div><!-- /.modal-content -->
    </div><!-- /.modal-dialog -->
  </div><!-- /.modal -->
</div><!-- /.loginform -->

