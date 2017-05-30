<%@ page contentType="text/html; UTF-8" pageEncoding="UTF-8"
	trimDirectiveWhitespaces="true"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<h2>Change date</h2>
<div class="sidebar">
	<c:if test="${error != null}">
		<div class="alert alert-danger" role="alert">${error}</div>
	</c:if>
	<c:if test="${success != null}">
		<div class="alert alert-success" role="success">${success}</div>
	</c:if>
	<form method="post" action="/admin/edit">
		<div>
			<input type="text" class="form-control" name="login"
				value="${account.login}" placeholder="login" />
		</div>
		<div>
			<input type="text" class="form-control" name="firstName"
				value="${account.firstName}" placeholder="first name" />
		</div>
		<div>
			<input type="text" class="form-control" name="lastName"
				value="${account.lastName}" placeholder="last name" />
		</div>
		<div>
			<input type="text" class="form-control" name="secondName"
				value="${account.secondName}" placeholder="second name" />
		</div>
		<div>
			<input type="text" class="form-control" name="email"
				value="${account.email}" placeholder="email" />
		</div>
		<div>
			<input type="password" class="form-control" name="password"
				value="${account.password}" placeholder="password" />
		</div>
		<div>
			<input type="password" class="form-control"
				name="passwordConfirm" value="confirm password"
				placeholder="confirm password" />
		</div>
		<c:forEach var="role" items="${listRole}">
			<c:choose>
				<c:when test="${role.name == 'student'}">
					<c:set var="role1" value="1"></c:set>
				</c:when>
				<c:when test="${role.name == 'tutor'}">
					<c:set var="role2" value="1"></c:set>
				</c:when>
				<c:when test="${role.name == 'advance tutor'}">
					<c:set var="role3" value="1"></c:set>
				</c:when>
				<c:when test="${role.name == 'admin'}">
					<c:set var="role4" value="1"></c:set>
				</c:when>
			</c:choose>
		</c:forEach>
		<div>
			<input type="checkbox"
				<c:if test="${role1 == 1}">checked="checked"</c:if> name="role_user">Student
		</div>
		<div>
			<input type="checkbox"
				<c:if test="${role2 == 1}">checked="checked"</c:if> name="role_tutor">Tutor
		</div>
		<div>
			<input type="checkbox"
				<c:if test="${role3 == 1}">checked="checked"</c:if> name="role_adv_tutor">Advance
			Tutor
		</div>
		<div>
			<input type="checkbox"
				<c:if test="${role4 == 1}">checked="checked"</c:if> name="role_admin">Admin
		</div>
		<div>
			<input type="checkbox"
				<c:if test="${account.active == true}">checked="checked"</c:if>
				name="active_field">Active
		</div>
		<div>
		<input type="submit" <c:if test="${point != null}">style="display:none"</c:if> class="btn btn-success" value="Save" />
		 <a	class="btn btn-danger"<c:if test="${point != null}">style="display:none"</c:if> href="/admin/del?id=${account.id}" role="button">Delete</a>
		</div>
		<div>
			<a class="btn btn-warning" href="/admin" role="button">Back</a>
		</div>
	</form>
</div>
