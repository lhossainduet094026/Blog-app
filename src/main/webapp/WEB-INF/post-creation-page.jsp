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
		<p>Write your post here</p>
	</div>
	<div>
		<form action="/api/posts/addPost" method="post">
			<table style="border: 1px solid black">
				<tr>
					<td>Title: <input type="text" name="title"></td>
				</tr>
				<tr>
					<td>Content: <textarea name="content"></textarea>
					</td>

				</tr>
				<tr>
					<td></td>
					<td><input type="submit" value="Post"></td>
				</tr>
			</table>
		</form>
		
	</div>
</body>
</html>