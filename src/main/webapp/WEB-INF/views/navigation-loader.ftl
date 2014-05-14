<!--<img href="${rc.getContextPath()}/" src="${rc.getContextPath()}/resources/img/logo1.png" style="left: 90px; position: absolute; top: -6px;">--!>

<div class="navbar navbar navbar-static-top">
            <div class="navbar-inner">
                <div class="container">
                		<a href="${rc.getContextPath()}/" class="brand" style="">H u H o</a>
					
					<button data-target=".nav-collapse" data-toggle="collapse" class="btn btn-navbar" type="button">
			            <span class="icon-bar"></span>
			            <span class="icon-bar"></span>
			            <span class="icon-bar"></span>
			          </button>
			         <div class="nav-collapse collapse">
			         	<!--
			            <form class="navbar-search" style="padding-left:100px;">
							<input type="text" class="search-query span6" placeholder="Search Here">
						</form>--!>
						<a href="${rc.getContextPath()}/newPost" class="btn btn-danger btn-big" style="position:absolute; top:0%;right: 60%;"><i class="icon-white"></i>Create your Bargain Battlefield</a>
						<a href="${rc.getContextPath()}/postsShow" class="btn btn-primary btn-big" style="position:absolute; top:0%;right: 20%;"><i class="icon-white"></i>View Bargain Battlefields</a>
			            
			            <#if !loggedInUser?exists>
			            
			            <ul class="nav pull-right">
			            	<li>
			            		<a href="${rc.getContextPath()}/signUp">Sign Up</a>
			            	</li>
			            	<li>
			            		<a href="${rc.getContextPath()}/signIn">Sign In</a>
			            	</li>
			            </ul>
			            
			            <#else>
			            
			            <ul class="nav pull-right">
							<li class="dropdown ds-initial-notification" id="ds-initial-notification">
								<a data-toggle="dropdown" href="#" class="dropdown-toggle">10</a>
								<div data-count="0" class="dropdown-menu gts-flat-dropdown-menu gts-nav-dropdown-ntfn" id="gts-nav-dropdown-ntfn">
								<div class="row"><div class="span4"><header><h4>Notifications</h4></header><div class="gts-ntfn-content"><div class="ntfn-body"></div></div></div></div></div>
							</li>
							<li class="dropdown">
								<a data-toggle="dropdown" href="#" class="dropdown-toggle">${loggedInUser.fullName}</a>
								<div class="dropdown-menu gts-flat-dropdown-menu gts-user-dropdown-menu">
									<img src="${rc.getContextPath()}/resources/img/user-64-64.png" class="user-photo">
									<div class="user-details">
										<ul class="unstyled">
											<li class="user-name">${loggedInUser.fullName}</li>
											<li class="user-email">${loggedInUser.email}</li>
											<li class="divider"></li>
											<li><a href="#">Update Profile</a></li>
											<li><a href="#">App Settings</a></li>
											<li class="divider"></li>
											<li><a href="#">Sign Out</a></li>	
										</ul>
									</div>
								</div>
							</li>
						</ul>
			            
			        		
			            </#if>
			         </div> 
                </div>
            </div>
        </div>