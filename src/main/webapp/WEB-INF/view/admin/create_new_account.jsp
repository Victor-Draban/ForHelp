<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<h2>Create account</h2>
<div class="sidebar">
	<c:if test="${error != null}">
		<div class="alert alert-danger" role="alert">${error}</div>
	</c:if>
	<c:if test="${success != null}">
		<div class="alert alert-success" role="success">${success}</div>
	</c:if>
	<form method="post" action="/admin/create-account">
		<div>
			<input type="text" class="form-control" name="login"
				placeholder="login" />
		</div>
		<div>
			<input type="text" class="form-control" name="firstName"
				placeholder="first name" />
		</div>
		<div>
			<input type="text" class="form-control" name="lastName"
				placeholder="last name" />
		</div>
		<div>
			<input type="text" class="form-control" name="secondName"
				placeholder="second name" />
		</div>
		<div>
			<input type="text" class="form-control" name="email"
				placeholder="email" />
		</div>
		<div>
			<input type="password" class="form-control" name="password"
				placeholder="password" />
		</div>
		<div>
			<input type="password" class="form-control"
				name="passwordConfirm" placeholder="confirm password" />
		</div>
		<div>
			<input type="checkbox" name="user">Student
		</div>
		<div>
			<input type="checkbox" name="tutor">Tutor
		</div>
		<div>
			<input type="checkbox" name="adv_tutor">Advance Tutor
		</div>
		<div>
			<input type="checkbox" name="admin">Admin
		</div>
		<div>
			<input type="checkbox" name="active">Active
		</div>
		<div>
			<input type="submit" class="btn btn-primary btn-lg" value="create" />
		</div>
		<div>
			<a class="btn btn-warning" href="/admin" role="button">Back</a>
		</div>
	</form>
</div>
</div>
