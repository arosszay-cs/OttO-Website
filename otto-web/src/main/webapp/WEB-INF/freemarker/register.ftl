<#import "spring.ftl" as spring />
<html>
<head>
	<title>Drone Age - Browser Based Drone Combat with HTML5 Canvas</title>
	<link href="${rc.contextPath}/css/droneage.css" rel="stylesheet" type="text/css" />
	<#include "/includes/google-analytics.ftl">
</head>
<body>
<#assign locationImageUrl = "${rc.contextPath}/img/bg/planet-terrestrial-1.jpg">
<#assign locationImageRepeat = "no-repeat">
<#assign isNavHomeActive = true>
<#include "/includes/header.ftl">

<div class="panel panel-location" style="background-image: url(${locationImageUrl}); background-repeat: ${locationImageRepeat}; ">
	<h1>Planetside :: Drone Training</h1>
</div>

<div class="panel panelflex panel-location-gutter" style="background-image: url(${locationImageUrl}); background-repeat: ${locationImageRepeat}; ">
</div>

<div class="panel panelflex panel1">
	<h1>Instructions</h1>
	<div class="panel-body">
		<!-- TODO LOCALIZE -->
		<p>
			Welcome to Drone Age.
		</p>
		<p>
			To begin the enlistment process, please provide your contact information.
		</p>
		<p>
			Your privacy and security are important to us; we will never sell or rent your information to a third party.
		</p>
	</div>
</div>

<div class="panel panelflex panel2">
	<h1>Register</h1>
	<div class="panel-body">

		<form method="POST">
				<label for="invitationKey" class="required">Invite Key</label>
				<input type="text" name="invitationKey" value="" />
			
				<label for="email" class="required">Email</label>
				<input type="email" name="email" value="${email!""}" />
			
				<label for="password" class="required">Password</label>
				<input type="password" name="password" value="${password!""}" />
	
				<label for="passwordConfirm" class="required">Confirm Password</label>
				<input type="password" name="passwordConfirm" value="${passwordConfirm!""}" />

				<label for="callsign" class="required">Callsign</label>
				<input type="text" name="callsign" value="${callsign!""}" />
	
	
			<#if validationMessages??>
				<#list validationMessages as validationMessage>
						<div>${validationMessage}</div>
				</#list>
			</#if>
	
			<div style="text-align: right">
				<button>Register</button>
			</div>
	
			
			
		</form>
	</div>
</div>

<#include "/includes/footer.ftl">
<script type="text/javascript" src="${rc.contextPath}/js/lib/jquery-1.5.js"></script>		
<script type="text/javascript" src="${rc.contextPath}/js/web/match-panel-heights.js"></script>		

</body>
</html>