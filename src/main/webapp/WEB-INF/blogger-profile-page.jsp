<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Blog</title>
</head>
<body>
	<div>
		<div style="margin-left: 100px">
			<p>Blogger profile page</p>
		</div>
		<div>
			<table style="border: 1px solid black;width=100%">
				<tr>
					<td>Blogger name:</td>
					<td><a href="<%=request.getContextPath()%>/createPost">Create
							new post</a></td>
					<td><a href="">Logout</a></td>
				</tr>
			</table>
		</div>
		<div>
			<hr
				style="height: 2px; border-width: 0; color: gray; background-color: gray">
			<c:forEach items="${allPosts}" var="post">
				<div>
					<h6>
						<c:out value="${post.createdOn}" />
					</h6>
					<h1>
						<c:out value="${post.title}" />
					</h1>
					<p>
						<c:out value="${post.content}" />
					</p>
					<h5>
						<c:out value="${post.username}" />
					</h5>

				</div>
				<hr
					style="height: 2px; border-width: 0; color: gray; background-color: gray">
			</c:forEach>
		</div>
	</div>
</body>
</html>