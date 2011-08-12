<#macro displayModuleIcon module>
			<div class="module">
				<#if module.id?length &gt; 6>
					<img src="${rc.contextPath}/img/modules/${module.id?substring(3,6)}-60.png" />
				<#else>
					${module.id}
				</#if>
				<span class="mass">${module.mass}</span>
			</div>
</#macro>

<#macro displayHullIcon hull>
			<div class="module">
				<img src="${rc.contextPath}/img/hulls/${hull.id}.png" />
				<span class="mass">${hull.massCapacity}</span>
			</div>
</#macro>
