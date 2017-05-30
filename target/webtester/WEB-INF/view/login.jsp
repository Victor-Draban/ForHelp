<%@ page contentType="text/html; UTF-8" pageEncoding="UTF-8" trimDirectiveWhitespaces="true" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<h2>Indefication of user</h2>
<div class="sidebar">

<c:if test="${error != null}">
	<div class="alert alert-danger" role="alert">${error}</div>
</c:if>
	<form method="post" action="/login">
		<div>
			<input type="text" class="form-control" name="login"
				placeholder="login" title="write your login" maxlength="30" />
		</div>
		<div>
			<input type="password" class="form-control" name="password"
				placeholder="password" title="write your password" maxlength="30" />
		</div>
		<div>
			<select name="role_field" class="form-control">
				<option name="studend_check">student</option>
				<option name="tutor_check">tutor</option>
				<option name="adv_tutor_check">advance tutor</option>
				<option name="admin_check">admin</option>
			</select>
		</div>
		<button type="submit" class="btn btn-primary btn-lg" value="enter"
			title="send date">Вход</button>
		<div>
			<a class="btn btn-success" href="/restore password" role="button">Reconstruction
				password</a> 
			<a class="btn btn-success" href="/registration" role="button">Regestration</a>

		</div>
	</form>
</div>