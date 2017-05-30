<%@ page contentType="text/html; UTF-8" pageEncoding="UTF-8"
	trimDirectiveWhitespaces="true"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<h2>Online test</h2>
<div class="sidebar">
	<form method="post" action="#" name="form1">
		<div>
			Time for answer <input type="text" name="time_field">
		</div>
		<div>${nameQuestion}</div>
		<c:forEach var="answer" items="${listAnswer}">
			<div>
				<input type="checkbox" name="kok">${answer.name}
			</div>
		</c:forEach>
		<div>
			<a class="btn btn-primary" <c:if test="${stop != null}">style="display:none"</c:if> href="/student/online?page=${page}">Next</a> <a
				class="btn btn-danger" <c:if test="${stop == null}">style="display:none"</c:if> href="/student/test-result">Finish</a>
		</div>
	</form>
</div>
