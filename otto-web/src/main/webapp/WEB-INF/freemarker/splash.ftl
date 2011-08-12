<#import "spring.ftl" as spring />
<html>
<head>
	<title>Drone Age - Browser Based Drone Combat with HTML5 Canvas</title>
	<link href="${rc.contextPath}/css/droneage.css" rel="stylesheet" type="text/css" />
	<#include "/includes/google-analytics.ftl">

</head>
<body>

<#include "/includes/header.ftl">

<#if currentUser??>
	TODO: Logged in user: Referral promo
	
<#else>
	<#include "/includes/login-panel.ftl">
</#if>
	
<#if currentUser??>
	TODO: Status update / quick links
<#else>
	<a href="${rc.contextPath}/auth/register">REGISTER</a>
</#if>

</body>
</html>