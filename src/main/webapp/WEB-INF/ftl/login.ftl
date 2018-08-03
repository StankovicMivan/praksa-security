<#-- @ftlvariable name="_csrf" type="org.springframework.security.web.csrf.CsrfToken" -->
<#-- @ftlvariable name="error" type="java.util.Optional<String>" -->
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
    <title>Log in</title>
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

<div class="container"  >
<h1>Log in</h1>
<div class="row" >
<p>Test podatci: i@i /sifra: koliko21</p>

<form role="form" action="/login" method="post">
    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>

    <div class="form-group">
        <label for="email">Email address</label>
        <input type="email" name="email" id="email" required autofocus/>
    </div>
    <div class="form-group">
        <label for="password">Password</label>
        <input type="password" name="password" id="password" required/>
    </div>
    <div class="form-group">
        <label for="remember-me">Remember me</label>
        <input type="checkbox" name="remember-me" id="remember-me"/>
    </div>
    <button class="btn btn-primary" type="submit">Sign in</button>
</form>

<#if error.isPresent()>
<p>The email or password you have entered is invalid, try again.</p>
</#if>
</div>
</div>
</body>
</html>