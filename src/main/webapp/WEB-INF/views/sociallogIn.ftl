<#import "/spring.ftl" as spring />
<#import "macro.ftl" as macro/>
<@macro.showHeader />

<div class="row-fluid inner-col" ng-controller="SignInCtrl">

	<div class="span12">
		  <div class="alerts">
            <div bs-alert="alert" ng-repeat="alert in alerts" class="alert fade ng-scope in alert-{{alert.type}}"><button data-dismiss="alert" class="close" type="button">x</button><strong class="ng-scope">{{alert.title}}</strong><span class="ng-scope">{{alert.content}}</div>
          </div>
        
        
		<form class="form-horizontal" name="form">
			   <div class="control-group">
			   	  <label class="control-label" for="inputEmail">User Name</label>
			      <div class="controls">
			         <div class="input-prepend"> <span class="add-on"><i class="icon-user"></i></span> <input type="text" placeholder="User Name" name="userName" class="input-large" autofocus="" ng-model="user.userName" required/> </div>
			      </div>
			   </div>
			   
			   <div class="control-group">
			      <label class="control-label" for="inputEmail">Password</label>
			      <div class="controls">
			         <div class="input-prepend"> <span class="add-on"><i class="icon-key"></i></span> <input type="password" placeholder="Password" name="password" class="input-large" ng-model="user.password" required/> </div>
			      </div>
			   </div>
			   <div class="form-actions">
				<input type="button" id="submit" value="Login" class="btn btn-success" ng-click="submit()"/>
				<button type="button" class="btn">Cancel</button>
    		   </div>
		</form>
		
	<table cellpadding="10" cellspacing="10" align="center">
      <tr><td colspan="8"><h3 align="center">Welcome to Social Auth Demo</h3></td></tr>
      <tr><td colspan="8"><p align="center">Please click on any icon.</p></td></tr>
      <tr>
        <td>
          <a href="socialauth?id=facebook">
            <img src="http://labs.3pillarglobal.com/socialauthdemo/images/facebook_icon.png" alt="Facebook" title="Facebook" border="0"/>
          </a>
        </td>
        
        <td>
          <a href="socialauth?id=googleplus">
            <img src="https://lh5.googleusercontent.com/-2r7nkB71SpM/AAAAAAAAAAI/AAAAAAAArjc/Eb1JU7m_Xis/photo.jpg?sz=48" alt="Google plus" title="Google plus" border="0"/>
          </a>
        </td>
      </tr>
      <tr>
        <td colspan="8" align="center">
          <form action="socialauth" onsubmit="return validate(this);">
            or enter OpenID url: <input type="text" value="" name="id"/>
            <input type="submit" value="Submit"/> 
          </form>
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
