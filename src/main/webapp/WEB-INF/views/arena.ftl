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
					
                		<div class="col-md-12 " id="searchForm">
						<input type="text" class="search-query" size="70" placeholder="Search" id="keyword" onkeypress="keypress(event);">
						<button class="btn btn-primary" onclick="searchSubmit()">Search</button>
					</div>
					
                    <div class="caption-full">
                        <div class="center-table" id="tableContent">
							<table class="table table-hover" id="resultTable" width="90%">
								<thead>
									<tr>
										<th>Subject</th>
										<th>Snapshot</th>
									</tr>
								</thead>
					
								<tbody>
								<#list postList as post>
									<tr>
										<td id="tableSubject" ><a href="${post.id}" target="_blank">${post.title}</a></td>
										<#if post.description?length &gt; 130 >
											<#assign content = post.description?substring(0, 130) +'........ <a href="${post.id}" target="_blank">See more</a>' >
										<#else>
											<#assign content = post.description>
										</#if>
										<td><p id="postContent" >${content}</p></td>
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

