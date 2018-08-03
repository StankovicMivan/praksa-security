<#-- @ftlvariable name="_csrf" type="org.springframework.security.web.csrf.CsrfToken" -->
<#-- @ftlvariable name="currentUser" type="com.praksa.ivan.domain.CurrentUser" -->
<!DOCTYPE html>
<html lang="en">
<head>
	
   <meta charset="utf-8">
    	<meta http-equiv="X-UA-Compatible" content="IE=edge">
    	<meta name="viewport" content="width=device-width, initial-scale=1">
		
		<link href="/assets/css/bootstrap.css" rel="stylesheet">
		<link href="/assets/css/bootstrap-theme.css" rel="stylesheet">
		
		
		<script src="/assets/js/angular.min.js" type="text/javascript"></script>
		<script src="/assets/js/angular-route.min.js"></script>
		<script src="/app/js/main.js" type="text/javascript"></script>
    <title>Home page</title>
</head>
<body>
<nav role="navigation">
<div ng-app="praksa">
			
			<nav class="navbar navbar-inverse navbar-fixed-top">
				<div class="container-fluid">
					<div class="navbar-header">
						<a class="navbar-brand" href="/#!/">Ivan</a>
					</div>
					<ul class="nav navbar-nav">
						<li><a href="/#!/igraci">Igraci</a></li>
						<#if !currentUser??>
							<li>
								<div class="pull-right">
									<a href="/login">Log in</a>
									<a href="/user/create">Registracija</a>
								</div>
							</li>
   						</#if>
   						<#if currentUser??>
       						<li>
       						<div class="pull-right">
								
            					<form action="/logout" method="post">
                					<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
              						  <button type="submit">Log out</button>
         						</form>
         					</div>
       						</li>
        					<li>
        						<a href="/user/${currentUser.id}">Moj nalog</a>
        					</li>
    					</#if>
					</ul>
				</div>
			</nav>
			
			<br>
			<br>
			<div class="container" ng-view>
			
			</div>
		</div>
    <ul>
   
    <#if currentUser??>
        <li>
            <form action="/logout" method="post">
                <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
                <button type="submit">Log out</button>
            </form>
        </li>
        <li><a href="/user/${currentUser.id}">View myself</a></li>
    </#if>
    <#if currentUser?? && currentUser.role == "ADMIN">
       
        <li><a href="/users">View all users</a></li>
    </#if>
    </ul>
     <#if currentUser?? && currentUser.role == "ADMIN">
       
    </#if>
</nav>
</body>
</html>