<%@ page contentType="text/html; UTF-8" pageEncoding="UTF-8"
	trimDirectiveWhitespaces="true"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<h2>All test</h2>
<div class="sidebar">
	<table class="table table-hover">
		<tr class="info">
			<th></th>
			<td>#</td>
			<th>Test name</th>
			<th>Description</th>
			<th>duration per question</th>
		</tr>
		
		<c:forEach var="test" items="${tests}">
		<tr>
			<td><a class="btn btn-success" href="/tutor/edit?id=${test.id}"
				role="button">Edit</a></td>
			<td>${test.id}</td>
			<td>${test.name}</td>
			<td>${test.description}</a></td>
			<td>${test.durationPerQuestion}</td>
		</tr>
		</c:forEach>
	</table>
	<nav>
		<ul class="pagination">
			<li><a href="#" aria-label="Previous"> <span
					aria-hidden="true">&laquo;</span>
			</a></li>
			<li><a href="#">1</a></li>
			<li><a href="#">2</a></li>
			<li><a href="#">3</a></li>
			<li><a href="#">4</a></li>
			<li><a href="#">5</a></li>
			<li><a href="#" aria-label="Next"> <span aria-hidden="true">&raquo;</span>
			</a></li>
		</ul>
	</nav>
	<a class="btn btn-primary btn-lg" href="/tutor/create-test" role="button">Add
		new test</a>
</div>
