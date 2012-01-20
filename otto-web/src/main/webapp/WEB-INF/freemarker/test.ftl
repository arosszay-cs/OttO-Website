<#import "spring.ftl" as spring />
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<meta name="keywords" content="" />
		<meta name="description" content="" />
		<meta http-equiv="content-type" content="text/html; charset=utf-8" />
		<title>otto - test - ${test.testClass}</title>
		<link href="${rc.contextPath}/css/indicator.css" rel="stylesheet" type="text/css" media="screen" />
		<link href="${rc.contextPath}/css/otto.css" rel="stylesheet" type="text/css" media="screen" />
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
				<div id="content">

					<div class="post">
						<h2 class="title">${test.testClass?replace("V6GUIAutomation.TestClasses.","")?replace(".","<br />.")}</h2>
						<div class="entry">
							JIRA
							
							
							
						</div>
					</div>


					<div style="clear: both;">&nbsp;</div>
				</div>
				<!-- end #content -->

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