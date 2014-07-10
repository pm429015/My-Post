<#import "/spring.ftl" as spring /> 

<#macro showHeader htmlclass="">
<!DOCTYPE HTML>
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta name="description" content="">
<meta name="author" content="">

</head>

<body id="page-top" data-spy="scroll" >
	
</#macro> 


<#macro footer>
	<footer>
         <div class="container">
                
                <div class="row">
                    <div class="col-md-8 copyright">
                        <p>Copyright &copy; 2014 DealArenas.com All Rights Reserved
                    </div>
                    <div class="col-md-2 copyright">
                        <a href="mailto:dealarenas@gmail.com"><p>Contact us<p></a>
                    </div>
                    <div class="col-md-2 copyright">
                        <a href="termsOfUse"><p>Terms of Use<p></a>
                    </div>
                </div> <!-- end row -->
            </div> <!-- end container -->
        </footer>
	<link rel="stylesheet" type="text/css" href="${rc.getContextPath()}/resources/css/footer.css">
</#macro>

<#macro loadExternal>
	<#include "macro_css.ftl" /> 
	<#include "macro_js.ftl" />
	<#include "navbar.ftl" /> 
</#macro>