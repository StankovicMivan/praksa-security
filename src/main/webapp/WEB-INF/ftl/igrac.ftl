<#-- @ftlvariable name="_csrf" type="org.springframework.security.web.csrf.CsrfToken" -->
<#-- @ftlvariable name="noviIgrac" type="com.praksa.ivan.web.IgracDTO" -->
<#import "/spring.ftl" as spring>
<!DOCTYPE html>
<html lang="en">
<head>
      <meta charset="utf-8" type="text/html">
    	<meta http-equiv="X-UA-Compatible" content="IE=edge">
    	<meta name="viewport" content="width=device-width, initial-scale=1">
		
		<link href="/assets/css/bootstrap.css" rel="stylesheet">
		<link href="/assets/css/bootstrap-theme.css" rel="stylesheet">
		
		
		<script src="/assets/js/angular.min.js" type="text/javascript"></script>
		<script src="/assets/js/angular-route.min.js"></script>
		<script src="/app/js/main.js" type="text/javascript"></script>
    <title>Create a new user</title>
</head>
<body>
	<nav class="navbar navbar-inverse navbar-fixed-top">
				<div class="container-fluid">
					<div class="navbar-header">
						<a class="navbar-brand" href="/#!/">Ivan</a>
					</div>
					<ul class="nav navbar-nav">
						
					</ul>
				</div>
			</nav>
<br>
	<br>
	<br>
<h1>Create a new Igrac</h1>


	<form role="noviIgrac" name="noviIgrac" method="post">
	<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
	
		<div class="form-group">
			<label for="ime">Ime</label> 
			<input type="text" name="ime" id="ime" value="${noviIgrac.ime}" required autofocus/>
		</div>
		<div class="form-group">
			<label for="prezime">Prezime</label> 
			<input type="prezime" value="${noviIgrac.prezime}" name="prezime" id="prezime" required/>
		</div>
		<div class="form-group">
			<label for="pozicija">Pozicija</label> 
			<input type="text" name="pozicija" id="pozicija" value="${noviIgrac.pozicija}" required autofocus/>
		</div>

		<div class="form-group">
			<label for="klubId">Klub</label>
       		<select name="klubId" id="klubId" required>
            <option <#if noviIgrac.klubId == 1>selected</#if>>1</option>
            <option <#if noviIgrac.klubId == 2>selected</#if>>2</option>
        </select>
		</div>
		<<button type="submit">Save</button>

	</form>

<@spring.bind "noviIgrac" />
<#if spring.status.error>
<ul>
    <#list spring.status.errorMessages as error>
        <li>${error}</li>
    </#list>
</ul>
</#if>

</body>
</html>