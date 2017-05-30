<%@ page contentType="text/html; UTF-8" pageEncoding="UTF-8"
	trimDirectiveWhitespaces="true"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<h2>Online test</h2>
<div class="sidebar">
	<form id="xxx" method="post"
		action="/student/online?page=${page}&countQuestion=${sizeQuestion}&countAnswer=${sizeAnswer}">
		<div>
			Time for answer <p id="timer">${time}</p>
		</div>
		<div>${nameQuestion}</div>
		<c:forEach var="answer" items="${answers}" varStatus="st" >
			<div>
				<input type="checkbox" name="kok${st.index}">${answer.name}
			</div>
		</c:forEach>
		<div>
			<c:if test="${stop == null}">
				<input type="submit" class="btn btn-primary btn-lg" value="next" />
			</c:if>
			<c:if test="${stop != null}">
				<input type="submit" class="btn btn-danger" value="finish" />
			</c:if>	
		</div>
	</form>
	<script type="text/javascript">
	</script>
</div>
