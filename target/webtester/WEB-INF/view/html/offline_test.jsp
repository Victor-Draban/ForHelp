<%@ page contentType="text/html; UTF-8" pageEncoding="UTF-8"
	trimDirectiveWhitespaces="true"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<h2>Offline test</h2>
<div class="sidebar">
	<table class="table table-hover">
		<tr class="info">
			<th>Question</th>
			<th colspan="5">Variant of answer</th>
		</tr>

		<c:forEach var="question" items="${map}">
			<tr>
				<td>${question.key.name}</td>
				<c:forEach var="answer" items="${question.value}">
					<td>${answer.name}</td>
				</c:forEach>
			</tr>
		</c:forEach>

	</table>
	<div>
		<a class="btn btn-primary" href="#">Print</a> <a
			class="btn btn-success" href="/student/info-for-student">Back</a>
	</div>
</div>
