<%@ page contentType="text/html; UTF-8" pageEncoding="UTF-8"
	trimDirectiveWhitespaces="true"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<h2>Passed tests</h2>
<div class="sidebar">
	<table class="table table-hover">
		<tr class="info">
			<th>Test's name</th>
			<th>Result of testing</th>
			<th>Date of pass</th>
		</tr>
		
		<c:forEach var="testPassed" items="${passedTests}">
		<tr>
			<td>${testPassed.testName}</td>
			<td>${testPassed.percent}</td>
			<td>${testPassed.created}</td>
		</tr>
		</c:forEach>
		
	</table>
	<a class="btn btn-success" href="/student/all-test-for-students">All test</a>
</div>
