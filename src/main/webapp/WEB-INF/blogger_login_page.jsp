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
		<p>Blogger login</p>
	</div>
	<div>
		<form action="/api/auth/login" method="post">
			<table style="border: 1px solid black">
				<tr>
					<td>Name:(First name)</td>
					<td><input type="text" name="firstName"></td>
				</tr>
				<tr>
					<td>Password:</td>
					<td><input type="password" name="password"></td>
				</tr>
				<tr>
					<td></td>
					<td><input type="submit" value="Login"></td>
				</tr>
			</table>
		</form>
		<div>
			Don't have an account .Please register here <a
				href="${pageContext.request.contextPath}/signup-blogger">Register
				blogger</a>
		</div>
	</div>
</body>
</html>