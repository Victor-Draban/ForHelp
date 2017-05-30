<%@ page contentType="text/html; UTF-8" pageEncoding="UTF-8"
	trimDirectiveWhitespaces="true"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<h2>Date of question</h2>
<div class="sidebar">
	<form method="post" action="/tutor/question/edit?id=${backToHome}">
		Name of question<input type="text" class="form-control" value="${nameQuestion}"
			name="question_name_field" placeholder="Name of Question" /> <input
			type="submit" <c:if test="${point != null}">style="display:none"</c:if> class="btn btn-success" value="sava change " />
	</form>
	<table class="table table-hover">
		<tr class="info">
			<th></th>
			<td>#</td>
			<th>Answer</th>
			<td>correct</td>
		</tr>

		<c:forEach var="answer" items="${answer}">
			<tr>
				<td><a class="btn btn-success" 
					href="/tutor/question/answer/edit?id=${answer.id}">Change </a></td>
				<td>${answer.id}</td>
				<td>${answer.name}</td>
				<td>${answer.correct}</td>
			</tr>
		</c:forEach>

	</table>

	<div>
		<a class="btn btn-primary btn-lg" <c:if test="${point != null}">style="display:none"</c:if>
			href="/tutor/question/create-answer?id=${backToHome}">add new
			answer</a>
	</div>
	<div>
		<c:if test="${success != null}">
			<div class="alert alert-success" role="success">${success}</div>
		</c:if>
		<a class="btn btn-danger" <c:if test="${point != null}">style="display:none"</c:if> href="/tutor/question/del?id=${backToHome}"
			role="button">Delete</a>
	</div>
	<div>
		<a class="btn btn-warning" href="/tutor/allQuestion?id=${pathToBack}"
			role="button">Back</a>
	</div>
</div>
