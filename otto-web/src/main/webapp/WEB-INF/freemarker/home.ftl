<#import "spring.ftl" as spring />
<html>
<head>
	<title>Home</title>
</head>
<body>

<h1>LIST OF ALL TEST RESULTS!</h1>


<#list tests as test>
	<h1>${test.testClass}</h1>
	<#if test.description??>
		<p>${test.description}</p>
	</#if>
	<#list test.categories as category>
		<span>${category}</span>
	</#list>
	<#list test.results as testResult>
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