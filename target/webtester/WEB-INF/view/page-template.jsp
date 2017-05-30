<%@ page contentType="text/html; UTF-8" pageEncoding="UTF-8"
	trimDirectiveWhitespaces="true"%>

<!DOCTYPE html>
<html lang="en">
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="/static/css/bootstrap.css">
<link rel="stylesheet" href="/static/css/style.css">
</head>
<body>
	<header style="background-color: aqua; height: 100px">
		<div class="cssload-loader" align="right">
			<div class="cssload-inner cssload-one"></div>
			<div class="cssload-inner cssload-two"></div>
			<div class="cssload-inner cssload-three"></div>
		</div>
		<div class="text-uppercase">${role}<a class="navbar navbar-brand" href="/logout">Log out</a></div>
	</header>
	<div class="container" style="min-height: 500px">
		<jsp:include page="${currentPage}"></jsp:include>
	</div>
	<footer style="background-color: green; height: 75px"> </footer>
</body>
</html>