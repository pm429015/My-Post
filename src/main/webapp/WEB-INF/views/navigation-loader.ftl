<script type="text/javascript">
	function getCookie(cname) {
    var name = cname + "=";
    var ca = document.cookie.split(';');
    for(var i=0; i<ca.length; i++) {
        var c = ca[i].trim();
        if (c.indexOf(name) == 0) return c.substring(name.length, c.length);
    }
    return "";
}

</script>

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
						
						<a class="btn btn-danger btn-big" role="button" href="${rc.getContextPath()}/newPost" style="position:absolute; top:0%;right: 60%;"><i class="icon-white"></i>Create your Bargain Battlefield</a>
						<a class="btn btn-primary btn-big" role="button" href="${rc.getContextPath()}/postsShow"  style="position:absolute; top:0%;right: 20%;"><i class="icon-white"></i>View Bargain Battlefields</a>
			            

			            <script type="text/javascript">
			            $(document).ready(function(){
			            	var name = getCookie("Name");
							var email = getCookie("Email");
							
							if(name && email){
								$("#loginSign").html('<ul class="nav pull-right"><li class="dropdown ds-initial-notification" id="ds-initial-notification"><a data-toggle="dropdown" href="#" class="dropdown-toggle">10</a><div data-count="0" class="dropdown-menu gts-flat-dropdown-menu gts-nav-dropdown-ntfn" id="gts-nav-dropdown-ntfn"><div class="row"><div class="span4"><header><h4>Notifications</h4></header><div class="gts-ntfn-content"><div class="ntfn-body"></div></div></div></div></div></li><li class="dropdown"><a data-toggle="dropdown" href="#" class="dropdown-toggle">'+name+'</a><div class="dropdown-menu gts-flat-dropdown-menu gts-user-dropdown-menu"><img src="${rc.getContextPath()}/resources/img/user-64-64.png" class="user-photo"><div class="user-details"><ul class="unstyled"><li class="user-name">'+name+'</li><li class="user-email">'+email+'</li><li class="divider"></li><li><a href="#">Update Profile</a></li><li><a href="#">App Settings</a></li><li class="divider"></li><li><a href="#">Sign Out</a></li>	</ul></div></div></li></ul>');
							}else{
								$("#loginSign").html('<ul class="nav pull-right"><li><a href="#loginpage" data-toggle="modal" >LOG IN / SIGN UP</a></li> </ul>');
							}
						});
							
			            </script>
			            
			            <div id="loginSign"></div>
			            
			            
			            
			         </div> 
                </div>
            </div>
        </div>
        
<@macro.loginpage />

