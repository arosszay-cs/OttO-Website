<#import "spring.ftl" as spring />
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta name="keywords" content="" />
<meta name="description" content="" />
<meta http-equiv="content-type" content="text/html; charset=utf-8" />
<title>otto - home</title>
<link href="css/indicator.css" rel="stylesheet" type="text/css" media="screen" />
</head>

<body>
<div id="wrapper">
	<div id="header-wrapper">
	<div id="header">
		<div id="logo">
			<h1><a href="${rc.contextPath}">otto</a></h1>
			<p>automation domination</p>
		</div>
	</div>
	</div>
	<!-- end #header -->
	<div id="page">
	<div id="page-bgtop">
	<div id="page-bgbtm">
		<div id="content">

			<#if pastWeekUnstableTests?? && pastWeekUnstableTests?size &gt; 0>

				<div class="post">
					<h2 class="title"><a href="#">Latest Status Changes</a></h2>
					<p class="meta"><span class="date">Updated February 19, 2010</span>
						<span class="posted">${pastWeekUnstableTests?size} changes</span></p>
					<div style="clear: both;">&nbsp;</div>
					<div class="entry">
<#list pastWeekUnstableTests as test>
	<h1>${test.testClass?replace(".","<wbr>.")}</h1>
	<#list test.getLatestResults(7) as testResult>
		<h2>${testResult.dateExecuted}</h2>
		<h3>${testResult.outcome} (${testResult.duration} sec)</h3>
		<#if testResult.message??>
			<h4>message</h4>
			<p>${testResult.message}</p>
		</#if>
		<#if testResult.stackTrace??>
			<h4>stacktrace</h4>
			<p>${testResult.stackTrace}</p>
		</#if>


	</#list>
</#list>
					</div>
				</div>
			</#if>


			<div class="post">
				<h2 class="title"><a href="#">Lorem ipsum sed aliquam</a></h2>
				<p class="meta"><span class="date">January 20, 2010</span><span class="posted">Posted by <a href="#">Someone</a></span></p>
				<div style="clear: both;">&nbsp;</div>
				<div class="entry">
					<p>Sed lacus. Donec lectus. Nullam pretium nibh ut turpis. Nam bibendum. In nulla tortor, elementum vel, tempor at, varius non, purus. Mauris vitae nisl nec metus placerat consectetuer. Donec ipsum. Proin imperdiet est. Phasellus <a href="#">dapibus semper urna</a>. Pellentesque ornare, orci in consectetuer hendrerit, urna elit eleifend nunc, ut consectetuer nisl felis ac diam. Etiam non felis. Donec ut ante. In id eros. Suspendisse lacus turpis, cursus egestas at sem.  Mauris quam enim, molestie in, rhoncus ut, lobortis a, est.</p>
					<p class="links"><a href="#">Read More</a>&nbsp;&nbsp;&nbsp;&nbsp;|&nbsp;&nbsp;&nbsp;&nbsp;<a href="#">Comments</a></p>
				</div>
			</div>
		<div style="clear: both;">&nbsp;</div>
		</div>
		<!-- end #content -->
		<div id="sidebar">
			<ul>
				<li>
					<div id="search" >
<#-- search bar
					<form method="get" action="#">
						<div>
							<input type="text" name="s" id="search-text" value="" />
							<input type="submit" id="search-submit" value="GO" />
						</div>
					</form>
-->
					</div>
					<div style="clear: both;">&nbsp;</div>
				</li>
				<li>
					<h2>Categories</h2>
					<ul>
						<li><a href="#">Aliquam libero</a></li>
						<li><a href="#">Consectetuer adipiscing elit</a></li>
						<li><a href="#">Metus aliquam pellentesque</a></li>
						<li><a href="#">Suspendisse iaculis mauris</a></li>
						<li><a href="#">Urnanet non molestie semper</a></li>
						<li><a href="#">Proin gravida orci porttitor</a></li>
					</ul>
				</li>
			</ul>
		</div>
		<!-- end #sidebar -->
		<div style="clear: both;">&nbsp;</div>
	</div>
	</div>
	</div>
	<!-- end #page -->
</div>
	<div id="footer">
		<p>Design by <a href="http://www.freecsstemplates.org/">Free CSS Templates</a>.</p>
	</div>
	<!-- end #footer -->
</body>
</html>







<#--
<form method="POST" action="add">
	<label for="testClass">Test Class:</label>
	<input type="text" name="testClass" />

	<label for="component">Component:</label>
	<input type="text" name="component" />

	<label for="outcome">Outcome:</label>
	<select name="outcome">
		<option>SUCCESS</option>
		<option>FAILURE</option>
		<option>INCONCLUSIVE</option>
	</select>

	<label for="reason">Reason:</label>
	<select name="reason">
		<option>BUG</option>
		<option>TIMING</option>
		<option>SCRIPTING</option>
	</select>

	<label for="duration">Duration:</label>
	<input type="text" name="duration" />

	<button>SUBMIT</button>
</form>
--#>

</body>

</html>