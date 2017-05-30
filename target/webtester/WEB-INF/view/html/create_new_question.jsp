<%@ page contentType="text/html; UTF-8" pageEncoding="UTF-8"
	trimDirectiveWhitespaces="true"%><!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<h2>Create new question</h2>
<div class="sidebar">
	<c:if test="${errorQuestion != null}">
		<div class="alert alert-danger" role="alert">${errorQuestion}</div>
	</c:if>
	<c:if test="${successQuestion != null}">
		<div class="alert alert-success" role="success">${successQuestion}</div>
	</c:if>
	<form method="post" action="/tutor/create-question">
		<div>
			<input type="text" class="form-control" name="name_test"
				placeholder="name question" />
		</div>
		<input type="submit" class="btn btn-primary btn-lg" value="Create" />
	</form>
	<div>
		<a class="btn btn-warning"
			href="/tutor/allQuestion?id=${FROM}" role="button">Back</a>
	</div>
</div>
