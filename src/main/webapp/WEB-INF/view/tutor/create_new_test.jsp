<%@ page contentType="text/html; UTF-8" pageEncoding="UTF-8"
	trimDirectiveWhitespaces="true"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<h2>Create new test</h2>
<div class="sidebar">
	<c:if test="${errorTest != null}">
		<div class="alert alert-danger" role="alert">${errorTest}</div>
	</c:if>
	<c:if test="${successTest != null}">
		<div class="alert alert-success" role="success">${successTest}</div>
	</c:if>
	<form method="post" action="/tutor/create-test">
		<div>
			<input type="text" class="form-control" name="name_test"
				placeholder="name test" />
		</div>
		<div>
			<input type="text" class="form-control" name="duration_per_question"
				placeholder="duration per question" />
		</div>
		<div>
			<textarea class="form-control" style="border: solid 1px #c3c3c3"
				name="review_text" cols="30" rows="6"></textarea>
		</div>
		<div>
			<input type="submit" class="btn btn-primary btn-lg" value="create" />
		</div>
	</form>
	<div>
		<div>
			<a class="btn btn-warning" href="/tutor" role="button">Back</a>
		</div>
	</div>
</div>