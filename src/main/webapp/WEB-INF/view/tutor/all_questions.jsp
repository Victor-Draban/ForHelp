<%@ page contentType="text/html; UTF-8" pageEncoding="UTF-8"
	trimDirectiveWhitespaces="true"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<h2>All questions</h2>
<div class="sidebar">
	<table class="table table-hover">
		<tr class="info">
			<th></th>
			<td>#</td>
			<th>Question</th>
		</tr>
		
		<c:forEach var="question" items="${question}">
		<tr>
			<td><a class="btn btn-success" href="/tutor/question/edit?id=${question.id}&name=${question.name}"
				role="button">Edit</a></td>
			<td>${question.id}</td>
			<td>${question.name}</td>
		</tr>
		</c:forEach>
		
	</table>

	<div>
		<a class="btn btn-primary btn-lg" href="/tutor/create-question?id=${back}" role="button">Add
		new question</a>
	</div>
	<div>
		<a class="btn btn-warning" href="/tutor/edit?id=${back}" role="button">Back</a>
	</div>
</div>
