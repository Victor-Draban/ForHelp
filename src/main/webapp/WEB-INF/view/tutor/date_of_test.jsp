<%@ page contentType="text/html; UTF-8" pageEncoding="UTF-8"
	trimDirectiveWhitespaces="true"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<h2>Date of test</h2>
<div class="sidebar">
	<c:if test="${error != null}">
		<div class="alert alert-danger" role="alert">${error}</div>
	</c:if>
	<c:if test="${success != null}">
		<div class="alert alert-success" role="success">${success}</div>
	</c:if>
	<form method="post" action="/tutor/edit?id=${test.id}">
		<div>
			<input type="text" class="form-control" name="name_test"
				value="${test.name}" placeholder="write your test name"/>
		</div>
		<div>
			<input type="text" class="form-control" name="duration_per_question"
				value="${test.durationPerQuestion}" placeholder="field for duration per question"/>
		</div>
		<div>
			<textarea style="border: solid 1px #c3c3c3" class="form-control"
				name="review_text" cols="30" rows="6">${test.description}</textarea>
		</div>
		<div>
			<a class="btn btn-primary btn-lg" <c:if test="${point != null}">style="display:none"</c:if>
				href="/tutor/allQuestion?id=${test.id}">view question</a>
		</div>
		<div>
			<input type="submit" <c:if test="${point != null}">style="display:none"</c:if> class="btn btn-success" value="Save" />
			<a class="btn btn-danger" <c:if test="${point != null}">style="display:none"</c:if> href="/tutor/test/del?id=${test.id}" role="button">Delete</a>
		</div>
		<div>
			<a class="btn btn-warning" href="/tutor" role="button">Back</a>
		</div>
	</form>
</div>
