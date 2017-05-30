<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page contentType="text/html; UTF-8" pageEncoding="UTF-8"
	trimDirectiveWhitespaces="true"%>

<h2>Admin</h2>
<div class="sidebar">
	<c:if test="${success != null}">
		<div class="alert alert-success" role="success">${success}</div>
	</c:if>
	<table class="table table-hover">
		<tr class="info">
			<td></td>
			<td>#</td>
			<th>Login</th>
			<th>Password</th>
			<th>First name</th>
			<th>Last name</th>
			<th>Second name</th>
			<th>Email</th>
			<th>Role</th>
			<th>Active</th>
		</tr>

		<c:forEach var="account" items="${list}">
			<tr>
				<td><a class="btn btn-success"
					href="/admin/edit?id=${account.id}" role="button">Edit</a></td>
				<td>${account.id}</td>
				<td>${account.login}</td>
				<td>${account.password}</td>
				<td>${account.firstName}</td>
				<td>${account.lastName}</td>
				<td>${account.secondName}</td>
				<td>${account.email}</td>
				<td><c:forEach var="role" items="${listRole}">
						<c:if test="${role.accountId == account.id}">
						${role.name}/
					</c:if>
					</c:forEach></td>
				<td>${account.active}</td>
			</tr>
		</c:forEach>
	</table>
	<nav>
		<ul class="pagination">
			<li><a href="#" aria-label="Previous"> <span
					aria-hidden="true">&laquo;</span>
			</a></li>
			<li><a href="#">1</a></li>
			<li><a href="#">2</a></li>
			<li><a href="#">3</a></li>
			<li><a href="#">4</a></li>
			<li><a href="#">5</a></li>
			<li><a href="#" aria-label="Next"> <span aria-hidden="true">&raquo;</span>
			</a></li>
		</ul>
	</nav>

	<a class="btn btn-primary btn-lg" href="/admin/create-account"
		role="button">Add new account</a>
</div>
