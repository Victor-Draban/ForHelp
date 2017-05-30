<%@ page contentType="text/html; UTF-8" pageEncoding="UTF-8"
	trimDirectiveWhitespaces="true"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<h2>Create new answer</h2>
<div class="sidebar">
	<c:if test="${errorAnswer != null}">
		<div class="alert alert-danger" role="alert">${errorAnswer}</div>
	</c:if>
	<c:if test="${successAnswer != null}">
		<div class="alert alert-success" role="success">${successAnswer}</div>
	</c:if>
	<form method="post" action="/tutor/question/create-answer">
		<div>
			<input type="text" class="form-control" name="answer_field"
				placeholder="Write answer" />
		</div>
		<div>
			Correct ?<input type="checkbox" name="correct_field" />
		</div>

		<input type="submit" class="btn btn-primary btn-lg" value="create" />
	</form>

	<div>
		<a class="btn btn-warning"
			href="/tutor/question/edit?id=${backToHome}&name=${nameQuestion}">Back</a>
	</div>
</div>
