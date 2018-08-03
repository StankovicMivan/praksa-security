<#-- @ftlvariable name="user" type="com.praksa.ivan.domain.User" -->
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <title>Informacije o nalogu</title>
</head>
<body>
<nav role="navigation">
    <ul>
        <li><a href="/">Home</a></li>
    </ul>
</nav>

<h1>informacije o nalogu</h1>

<p>E-mail: ${user.email}</p>

<p>Tip naloga: ${user.role}</p>
</body>
</html>