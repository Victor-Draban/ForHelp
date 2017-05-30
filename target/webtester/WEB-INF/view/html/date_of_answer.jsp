<%@ page contentType="text/html; UTF-8" pageEncoding="UTF-8"
	trimDirectiveWhitespaces="true"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<h2>Date of answer</h2>
<div class="sidebar">
	<c:if test="${success != null}">
		<div class="alert alert-success" role="success">${success}</div>
	</c:if>
	<form method="post" action="/tutor/question/answer/edit?id=${singleAnswer.id}">
		<div>
			<input type="text" class="form-control" value="${singleAnswer.name}"
				name="answer_field" placeholder="Write answer" />
		</div>
		<div>
			Correct ?<input type="checkbox"
				<c:if test="${singleAnswer.correct == true}">checked="checked"</c:if>
				name="correct_field" />
		</div>
		<input type="submit" <c:if test="${point != null}">style="display:none"</c:if> class="btn btn-success" value="sava change " />
		<a class="btn btn-danger" <c:if test="${point != null}">style="display:none"</c:if> href="/tutor/answer/del?id=${singleAnswer.id}" role="button">Delete</a>
	</form>

	<div>
		<a class="btn btn-warning"
			href="/tutor/question/edit?id=${backToHome}&name=${nameQuestion}">Back</a>
	</div>
</div>
