<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Blog</title>
</head>
<body>
	<div style="margin-left: 100px;width=100%">
		<p>Post successful page</p>
	</div>
	<div>
		<form action="/api/auth/login" method="post">
			<table style="border: 1px solid black">
				<tr>
					<td></td>
					<td>post successful.</td>
					<%
					response.sendRedirect(request.getContextPath() + "/login-blogger");
					%>
				</tr>
			</table>
		</form>
	</div>
</body>
</html>