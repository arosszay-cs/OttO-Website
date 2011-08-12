<#import "spring.ftl" as spring />
<html>
<head>
	<title>Home</title>
</head>
<body>

<h1>LIST OF ALL TEST RESULTS!</h1>
<ul>

<#list testResults as testResult>
    <li>${testResult.testClass} : ${testResult.component} (${testResult.duration}sec)</li>
</#list>

</ul>


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

</body>

</html>