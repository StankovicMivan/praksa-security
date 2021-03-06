<#-- @ftlvariable name="users" type="java.util.List<com.praksa.ivan.domain.User>" -->
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
    <title>List of Users</title>
</head>
<body>
	<br>
	<br>
	<br>
	<nav class="navbar navbar-inverse navbar-fixed-top">
				<div class="container-fluid">
					<div class="navbar-header">
						<a class="navbar-brand" href="/#!/">Ivan</a>
					</div>
					<ul class="nav navbar-nav">
						
					</ul>
				</div>
			</nav>

<div class="container">
<h1 style="text-align:center">Lista svih korisnika</h1>
	<br>
	<table class="table table-bordered table-striped">
		<thead>
		 <tr>
			<th>E-mail</th>
			<th>Tip naloga:</th>
		</tr>
		</thead>
			<tbody>
			<#list users as user>
				<tr >
					<td><a href="/user/${user.id}">${user.email}</a></td>
					<td> ${user.role}</td>			
				</tr>
				 </#list>
			</tbody>
	</table>
</div>

</body>
</html>