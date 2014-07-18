<#import "/spring.ftl" as spring />
<#import "macro_new.ftl" as macro/>


<title>Response Page</title>
<script type="text/javascript">
	function stringify() {

		var req = document.getElementById("request");
		var resp = document.getElementById("response");
		if (request != null) {
			req.innerHTML = JSON.stringify(request, null, 4);
		} else {
			req.innerHTML = "No payload for this request";
		}
		if (response != null) {
			resp.innerHTML = JSON.stringify(response, null, 4);
		} else if (error != null) {
			resp.innerHTML = error;

		}
	}
</script>
</head>
                			<h4><a href=${redirectURL}>redirect</a></h4>

	</body>	
</html>

