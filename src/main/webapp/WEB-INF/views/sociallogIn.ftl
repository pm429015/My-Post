<#import "/spring.ftl" as spring />
<#import "macro.ftl" as macro/>
<@macro.showHeader />
<style>


                                
#loginform
{
width:550px;
height:auto;
position:relative;
margin:0 auto;
}

input
{
display:block;
margin:0px auto 15px;
border-radius:5px;
background: #333333;
width:85%;
padding:12px 20px 12px 10px;
border:none;
color:#929999;                       
box-shadow:inset 0px 1px 5px #272727;
font-size:0.8em;
-webkit-transition:0.5s ease;
-moz-transition:0.5s ease;
-o-transition:0.5s ease;
-ms-transition:0.5s ease;
transition:0.5s ease; 
}

input:focus
{
-webkit-transition:0.5s ease;
-moz-transition:0.5s ease;
-o-transition:0.5s ease;
-ms-transition:0.5s ease;
transition:0.5s ease;  
box-shadow: 0px 0px 5px 1px #161718;
}

button
{
background: #ff5f32;
border-radius:50%;
border:10px solid #222526;
font-size:0.9em;
color:#fff;
font-weight:bold;
cursor:pointer;
width:85px;
height:85px;
position:absolute;
right: -42px;
top: 54px;
text-align:center;
-webkit-transition:0.5s ease;
-moz-transition:0.5s ease;
-o-transition:0.5s ease;
-ms-transition:0.5s ease;
transition:0.5s ease;
}

button:hover
{
background:#222526;
border-color:#ff5f32;
-webkit-transition:0.5s ease;
-moz-transition:0.5s ease;
-o-transition:0.5s ease;
-ms-transition:0.5s ease;
transition:0.5s ease;
}

button i
{
font-size:20px;
-webkit-transition:0.5s ease;
-moz-transition:0.5s ease;
-o-transition:0.5s ease;
-ms-transition:0.5s ease;
transition:0.5s ease;
}

button:hover i
{
color:#ff5f32;
-webkit-transition:0.5s ease;
-moz-transition:0.5s ease;
-o-transition:0.5s ease;
-ms-transition:0.5s ease;
transition:0.5s ease;
}
  
*:focus{outline:none;}
::-webkit-input-placeholder {
color:#929999;
}

:-moz-placeholder { /* Firefox 18- */
color:#929999; 
}

::-moz-placeholder {  /* Firefox 19+ */
color:#929999;  
}

:-ms-input-placeholder {  
color:#929999; 
}

h1
{
text-align:center;
color:#fff;
font-size:13px;
padding:12px 0px;
}

#note
{
color:#88887a;
font-size: 0.8em;
text-align:left;
padding-left:5px;
}

#facebook
{
text-align:center;
float:left;
background:#3B5998;
padding:0px 0px 0px 0px;
width:170px;
height:200px; 
border-radius:3px;
cursor:pointer;
box-shadow: 0px 0px 10px 2px #161718; 
margin-right:10px;
-webkit-transition:0.5s ease;
-moz-transition:0.5s ease;
-o-transition:0.5s ease;
-ms-transition:0.5s ease;
transition:0.5s ease;
}

#google
{
text-align:center;
float:left;
background:#4285f4;
padding:0px 0px 0px 0px;
width:170px;
height:200px; 
border-radius:3px;
cursor:pointer;
box-shadow: 0px 0px 10px 2px #161718; 
margin-right:10px;
-webkit-transition:0.5s ease;
-moz-transition:0.5s ease;
-o-transition:0.5s ease;
-ms-transition:0.5s ease;
transition:0.5s ease;
}

#facebook:hover
{
box-shadow: 0px 0px 0px 0px #161718;
-webkit-transition:0.5s ease;
-moz-transition:0.5s ease;
-o-transition:0.5s ease;
-ms-transition:0.5s ease;
transition:0.5s ease;
}

#google:hover
{
box-shadow: 0px 0px 0px 0px #161718;
-webkit-transition:0.5s ease;
-moz-transition:0.5s ease;
-o-transition:0.5s ease;
-ms-transition:0.5s ease;
transition:0.5s ease;
}

a
{
color:#88887a;
text-decoration:none;
-webkit-transition:0.5s ease;
-moz-transition:0.5s ease;
-o-transition:0.5s ease;
-ms-transition:0.5s ease;
transition:0.5s ease;
}

a:hover
{
color:#fff;
margin-left:5px;
-webkit-transition:0.5s ease;
-moz-transition:0.5s ease;
-o-transition:0.5s ease;
-ms-transition:0.5s ease;
transition:0.5s ease;
}

#mainlogin
{
float:left;
width:340px;
height:170px;
padding:10px 15px;
position:relative;
background:#555555;
border-radius:3px;
}

#connect
{
font-weight: bold;
color: #fff;
font-size: 13px;
text-align: left;
font-family: verdana;
padding-top:10px;
}


</style>

<div class="row-fluid inner-col">

<div id="loginform">
		  
        
	<table cellpadding="10" cellspacing="10" align="center">
      <tr><td colspan="8"><h3 align="center">Login in with your favoriate account</h3></td></tr>
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
          	<h1><font size="4" color="white">Login in through Your Email</font></h1>
			<form name="emailLoginForm" action="">
				<input type="text" placeholder="Email" value="" id="email" name="email" required>
				<label class="error" for="email" id="email_error"><font color="white">This field is required a valid email format.</font></label>
				<button type="submit" id="emailsubmitbtn" ><i class="fa fa-arrow-right">Login</i></button>
			</form>
			<div id="note"><a href="#">You don't need to sign in</a></div>
          </div>
          
        </td>
      </tr>
    </table>

	</div>
</div>	
	

<script>
      function validate(obj){
        var val = obj.id.value;
        if(trimString(val).length <= 0){
          alert("Please enter OpenID URL");
          return false;
        }else{
          return true;
        }
      }
      function trimString(tempStr)
      {
         return tempStr.replace(/^\s*|\s*$/g,"");
      }
    </script>
    
<script type="text/javascript"
	src="${rc.getContextPath()}/resources/js/pages/sociallogin.js"></script>    
    
