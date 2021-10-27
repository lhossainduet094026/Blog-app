<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Blog</title>
</head>
<body>
	<div style="margin-left: 100px">
		<p>Blogger signup</p>
	</div>
	<div>
		<form action="/api/auth/addBlogger" method="post">
			<table style="with: 50%">
				<tr>
					<td>First name:</td>
					<td><input type="text" name="firstName"></td>
				</tr>
				<tr>
					<td>Last name:</td>
					<td><input type="text" name="lastName"></td>
				</tr>
				<tr>
					<td>Email:</td>
					<td><input type="text" name="email"></td>
				</tr>
				<tr>
					<td>Password:</td>
					<td><input type="password" name="password"></td>
				</tr>
				<tr>
					<td></td>
					<td><input type="submit" value="Signup"></td>
				</tr>

			</table>
		</form>

	</div>
</body>
</html>