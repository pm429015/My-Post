<#import "/spring.ftl" as spring /> 

<#macro showHeader htmlclass="">
<!DOCTYPE HTML>
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta name="description" content="">
<meta name="author" content="">

<#include "macro_css.ftl" /> 
<#include "macro_js.ftl" />

</head>


<body id="page-top" data-spy="scroll" data-target=".navbar-custom">

	<#include "navbar.ftl" /> 
	
</#macro> 
