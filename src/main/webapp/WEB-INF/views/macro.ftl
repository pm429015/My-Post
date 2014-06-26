<#import "/spring.ftl" as spring />

<#macro showHeader htmlclass="">
<!DOCTYPE HTML>
	<head>
		<meta charset="utf-8">
	
		
		<meta http-equiv="X-UA-Compatible" content="IE=edge">
		<title></title>
		<meta name="description" content="">
		<meta name="author" content="">
		<meta name="viewport" content="width=device-width,initial-scale=1">
		
		<#include "external-css-loader.ftl" />
		<#include "external-js-loader.ftl" />
	</head>
	
	<body>
		<#include "navigation-loader.ftl" />
		
		<#nested/>

		<div class="container" ng-app>
			
				
</#macro>

<#macro loginpage>
	<link rel="stylesheet" type="text/css" href="${rc.getContextPath()}/resources/css/SocalLogin.css">
	<script type="text/javascript">
		var d = new Date();
		var url_path = window.location.pathname;
		url_path = url_path.split("/");
		
    	d.setTime(d.getTime() + (2*60*1000));
    	var expires = "expires="+d.toGMTString();
    	document.cookie = "returnURL" + "=" + url_path[(url_path.length)-1] + "; " + expires;
	</script>
	

	<div class="row-fluid inner-col">
	
	<div id="loginform">
	
			<div class="modal hide fade" id="loginpage" role="dialog" >
				<div class="modal-dialog">
					<div class="modal-content">
						<form class="form-horizontal">
							<div class="modal-header">
								<a class="nav pull-right" href="#" data-dismiss="modal" data-target="#loginpage">Close</a>
								<h4 id="modalh4" ><center>Connect with your favoriate account<center></h4>
								
								
							</div>
							<div class="modal-body">
	
								<table cellpadding="10" cellspacing="10" align="center">
							      
							      <tr>
							        <td>
							          <a href="socialauth?id=facebook">
							            <div id="facebook"><img src="https://www.facebook.com/images/fb_icon_325x325.png" alt="Facebook" title="Facebook" border="0"/><div id="connect"><center>Connect with Facebook</center></div></div>
							          </a>
							        </td>
							        
							        <td>
							          <a href="socialauth?id=googleplus">
							            <div id="google"><img src="https://lh3.googleusercontent.com/-prAs4xPK6Hs/UTdr8KJiiYI/AAAAAAACZ48/FpEiUk_urJY/s500-no/g%252B_logo.png" alt="Google" title="Google" border="0"/><div id="connect"><center>Connect with Google</center></div></div>
							          </a>
							        </td>
							      </tr>
							      <tr>
							        <td colspan="10" align="center">
							        
							          <div id="mainlogin">
							          	<h1 id="loginh1" ><font size="4" color="white">Login through Your Email</font></h1>
											
											<input type="text" placeholder="Email" value="" id="email" name="email" required>
											<label class="error" for="email" id="email_error"><font color="white">This field is required a valid email format.</font></label>
											<button id="emailLoginBtn" ><i class="fa fa-arrow-right">Login</i></button>
											
										<div id="note"><a href="#">You don't need to sign in</a></div>
										
							          </div>
							          
							        </td>
							      </tr>
							    </table>
							</div>
							
						</form>
	
					</div>
				</div>
			</div>
	        
		</div>
	</div>	
	
	<script type="text/javascript"
		src="${rc.getContextPath()}/resources/js/pages/sociallogin.js"></script>
</#macro>