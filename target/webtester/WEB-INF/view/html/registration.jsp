<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<h2>Regestration</h2>
<div class="sidebar">
	<c:if test="${error != null}">
		<div class="alert alert-danger" role="alert">${error}</div>
	</c:if>
	<c:if test="${success != null}">
		<div class="alert alert-success" role="success">${success}</div>
	</c:if>
	<form method="post" action="/registration">
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
		<input type="submit" class="btn btn-primary btn-lg"
			value="registration " />
	</form>
	<div>
		<a class="btn btn-warning" href="../index.html" role="button">Back</a>
	</div>
</div>
</div>