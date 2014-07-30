<#import "/spring.ftl" as spring />
<#import "macro_new.ftl" as macro/>

<title>DealArena</title>
<@macro.showHeader />

<script src="//cdn.datatables.net/1.10.0/js/jquery.dataTables.js"></script>
<link href="//cdn.datatables.net/1.10.0/css/jquery.dataTables.css" rel="stylesheet">
<script type="text/javascript" src="${rc.getContextPath()}/resources/js/pages/postList.js"></script></script>
<div class="firstLayer" >
	<div class="container">

        <div class="row">

            <div class="span12">
                <div class="thumbnail">
                		<div class="col-md-12 arenaTitle">
                			<h1>Deal Arenas</h1>
                			<h3>ONLY BEST DEALS COULD SURVIVE</h3>
						</div>
					
                		<div class="col-md-12 " id="searchForm" >
						<input type="text" class="search-query" size="70" placeholder="Search" id="keyword" onkeypress="keypress(event);">
						<button class="btn btn-primary" onclick="searchSubmit()" >Search</button>
					</div>
					
                    <div class="caption-full" >
                        <div class="center-table" id="tableContent" >
							<table class="table table-hover" id="resultTable" width="90%" >
								<thead>
									<tr>
										<th><h3 style="margin-top: 30px;">Car Request List</h3></th>
										<th>Remaining Time</th>
									</tr>
								</thead>
					
								<tbody>
								<#list postList as post>
									<tr>
										<td id="tableSubject" ><a href="${post.id}" target="_blank"><h4>${post.year}   ${post.color} ${post.title} ${post.model}</h4></a></td>
										<!--<#if post.description?length &gt; 130 >
											<#assign content = post.description?substring(0, 130) +'........ <a href="${post.id}" target="_blank">See more</a>' >
										<#else>
											<#assign content = post.description>
										</#if>-->
										<td><iframe src="http://free.timeanddate.com/countdown/i49ggjda/n848/cf12/cm0/cu4/ct0/cs1/ca0/co0/cr0/ss0/cac000/cpc000/pcfff/tcfff/fs100/szw320/szh135/iso${post.expireDate?string("yyyy-MM-dd")}T${post.expireDate?string("HH:mm:ss")}" frameborder="0" width="103" height="30"></iframe>
									</tr>
									</#list>
								</tbody>
							</table>
						</div>
                    </div><!--caption-full-->
                </div><!-- /.thumbnail -->
            </div>

        </div>

    </div> <!-- /.container -->
</div>
<@macro.loadExternal />
<link rel="stylesheet" type="text/css" href="${rc.getContextPath()}/resources/css/arena.css">
<@macro.footer />
	</body>	
</html>

