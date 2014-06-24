<#import "/spring.ftl" as spring />
<#import "macro.ftl" as macro/>
<@macro.showHeader />
<div class="row-fluid inner-col" ng-controller="SignInCtrl">

	<div class="span12">
		 <ul>
		<li><a th:href="@{/signout}">Sign Out</a></li>
	</ul>
	<h3>Your Facebook Friends</h3>
	<ul>
		<li th:each="friend : ${friends}"><img th:src="'http://graph.facebook.com/' + ${friend.id} + '/picture'" align="middle"/><span th:text="${friend.name}">name</span></li>
	</ul>
		
	</div>
	
	
</div>
