<#import "/spring.ftl" as spring />
<#import "macro.ftl" as macro/>
<@macro.showHeader />
<div class="row-fluid inner-col" ng-controller="HomeCtrl">
<!--
	<div class="span12">				
			<h3>Bookmarks</h3>
			<ul>
				<li>Store and organize your favorites online </li>
				<li>Easily share favorites with others</li>
				<li>Access Anytime - Anywhere</li>
				<li>Add your notes and descriptions</li>
			</ul>
		</div>

		<div class="features-storage-text">
		<h3>Powerful Bookmark Management</h3>
		<h3>Save your Research</h3>
		
							
	</div>
	
</div>
--!>
<div id="this-carousel-id" class="carousel slide"><!-- class of slide for animation -->
  <div class="carousel-inner">
    <div class="item active"><!-- class of active since it's the first item -->
      <img src="http://placehold.it/1200x480" alt="" />
      <div class="carousel-caption">
        <p>1</p>
      </div>
    </div>
    <div class="item">
      <img src="http://placehold.it/1200x480" alt="" />
      <div class="carousel-caption">
        <p>2</p>
      </div>
    </div>
    <div class="item">
      <img src="http://placehold.it/1200x480" alt="" />
      <div class="carousel-caption">
        <p>3</p>
      </div>
    </div>
    <div class="item">
      <img src="http://placehold.it/1200x480" alt="" />
      <div class="carousel-caption">
        <p>4</p>
      </div>
    </div>
  </div><!-- /.carousel-inner -->
  <!--  Next and Previous controls below
        href values must reference the id for this carousel -->
    <a class="carousel-control left" href="#this-carousel-id" data-slide="prev">&lsaquo;</a>
    <a class="carousel-control right" href="#this-carousel-id" data-slide="next">&rsaquo;</a>
</div><!-- /.carousel -->
<@macro.showFooter>
	<script type="text/javascript" src="${rc.getContextPath()}/resources/js/pages/home.js"></script>
</@macro.showFooter>