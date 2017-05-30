<%@ page contentType="text/html; UTF-8" pageEncoding="UTF-8"
	trimDirectiveWhitespaces="true"%>

<h2>Passed tests</h2>
<div class="sidebar">
	<table class="table table-hover">
		<tr class="info">
			<th>Test's name</th>
			<th>Result of testing</th>
			<th>Date of pass</th>
			<th>Time of pass</th>
		</tr>
		<%
			for (int i = 1; i < 4; i++) {
		%>
		<tr>
			<td>test<%=i%></td>
			<td>0%</a></td>
			<td>2016-08-20</td>
			<td>02:37:54</td>
		</tr>
		<%
			}
		%>
	</table>
	<a class="btn btn-success" href="/student/all-test-for-students">All test</a>
</div>
