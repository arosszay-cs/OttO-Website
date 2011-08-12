<#macro displayTrainingMissionPanel>
	<#if trainingMission??>
		<div class="panel training" style="clear: both;">
			<h1>Instructions</h1>

			<button id="nextTrainingStep" style="float: right; margin:5px">Next</button>

			<div class="panel-body" style="padding-top: 0px">
				
				<p id="copy" class="training-copy"></p>
			</div>
			<div style="clear:both"></div>
		</div>
	</#if>
</#macro>

<#macro embedTrainingMissionCss steps>
	<style type="text/css">
		<#list steps as step>
			<#if step.cssRules?? && step.cssBodyClass??>
				<#list step.cssRules as cssRule>
					body.${step.cssBodyClass} ${cssRule}
				</#list>
			</#if>
		</#list>
	</style>
</#macro>

<#macro displayModuleIcon module>
			<div class="module">
				<@img60PxModule moduleId=module.id />
				<span class="mass">${module.mass}</span>
				<img class="padlock" src="${rc.contextPath}/img/site/padlock-white.png"  />
			</div>
</#macro>

<#macro displayHullIcon hull>
			<div class="module">
				<img src="${rc.contextPath}/img/hulls/${hull.id}.png" />
				<span class="mass">${hull.massCapacity}</span>
				<img class="padlock" src="${rc.contextPath}/img/site/padlock-white.png"  />
			</div>
</#macro>

<#macro designOverviewModules design>
		<#list design.loadout.moduleIds as moduleId>
			<div style="float:left; font-size: 10px; padding:2px;">
				<@img60PxModule moduleId=moduleId /><br />
				${moduleId}
			</div>
		</#list>
		<div style="clear:both"></div>
</#macro>

<#macro designOverviewModulesEnemyIntel design>
		<#list design.loadout.moduleIds as moduleId>
			<div style="float:left; font-size: 10px; padding:2px;">
				<#if moduleId_index == 2>
					<@img60PxModule moduleId=moduleId /><br />
					${moduleId}
				<#else>
					<div style="width:59; height:59; border: 1px solid #243; text-align: center; line-height: 50px; font-size: 24px; padding: 0; margin: 0;">?</div>
					UNKNOWN
				</#if>
			</div>
		</#list>
		<div style="clear:both"></div>
</#macro>

<#macro img60PxModule moduleId>
	<#if moduleId?length &gt; 6>
		<img src="${rc.contextPath}/img/modules/${moduleId?substring(3,6)}-60.png" />
	<#else>
		${moduleId}
	</#if>
</#macro>

<#macro img30PxModule moduleId>
	<#if moduleId?length &gt; 6>
		<img src="${rc.contextPath}/img/modules/${moduleId?substring(3,6)}-30.png" />
	<#else>
		${moduleId}
	</#if>
</#macro>

<#macro img60PxHull moduleId>
</#macro>

<#macro img30PxHull moduleId>
</#macro>


<#macro generateMessagesForJS keys>
window.messages = {
<#list keys as key>
	'${key}': '<@spring.messageText code="${key}" text="l10n.${key}" />',
</#list>
	'dummy':'dummy'
};
</#macro> 


