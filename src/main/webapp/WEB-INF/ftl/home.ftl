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

<div ng-app="praksa">
			
			<nav class="navbar navbar-inverse navbar-fixed-top">
				<div class="container-fluid">
					<div class="navbar-header">
						<a class="navbar-brand" href="/#!/">Ivan</a>
					</div>
					<ul class="nav navbar-nav">
						<#if !currentUser??>
								
							<li class="pull-right">
									<a class="navbar-brand" href="/login">Log in</a>
									<a class="navbar-brand" href="/user/create">Registracija</a>
							</li>
							
   						</#if>
   						<#if currentUser??>
						 <li><a href="/#!/igraci">Igraci</a></li>
       						<li>
   							<#if currentUser.role == "ADMIN">
       								 <li>
       								 	<a href="/users">List svih korisnika</a>
       								 </li>
        					
    						</#if>
    						<#if currentUser.role == "USER">
       							<li>
        							<a href="/user/${currentUser.id}">Moj nalog</a>
        						</li>
    						</#if>
       						<div class="pull-right">
								
            					<form action="/logout" method="post">
                					<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
              						  <button type="submit">Log out</button>
         						</form>
         					</div>
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
   <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
		<script src="/assets/js/bootstrap.js"></script>
  

</body>
</html>