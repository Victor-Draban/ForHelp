<%@ page contentType="text/html; UTF-8" pageEncoding="UTF-8"
	trimDirectiveWhitespaces="true"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<h2>All test for students</h2>
<div class="sidebar">
	<form method="post" action="/student/info-for-student">
		<table class="table table-hover">
			<tr class="info">
				<td>#</td>
				<th>Test name</th>
				<th>Description</th>
				<th>duration per question</th>
				<th></th>
			</tr>
			<c:forEach var="test" items="${tests}">
				<tr>
					<td>${test.id}</td>
					<td>${test.name}</td>
					<td>${test.description}</a></td>
					<td>${test.durationPerQuestion}</td>
					<th><input type="radio" name="test" value="${test.id}"></th>
				</tr>
			</c:forEach>
		</table>
		<input class="btn btn-primary" type="submit" role="button" value="Start test "/ >
	</form>
	<div>
		<a class="btn btn-success"
			href="/student/passed-test?id=${IdCurrentAccount}" role="button">view result</a>
	</div>
</div>
