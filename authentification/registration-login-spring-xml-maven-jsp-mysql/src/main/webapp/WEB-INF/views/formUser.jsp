<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<c:set var="contextPath" value="${pageContext.request.contextPath}" />

<!DOCTYPE html>
<html>
<head>
	<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css">
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>Créer un compte</title>
<style><%@include file="/resources/css/style.css"%></style>
</head>
<header class="h-25 d-inline-block">
	<div class="overlay"></div>
	<video autoplay="autoplay" muted="muted"
		loop="loop">
		<source
			src="https://storage.googleapis.com/coverr-main/mp4/Mt_Baker.mp4"
			type="video/mp4">
	</video>
	<div class="container h-100">
		<div class="d-flex h-100 text-center align-items-center">
			<div class="w-100 text-white">
				<h1 class="display-3">Les amis de l'escalade</h1>
				<p class="lead mb-0">Créez un compte</p>
			</div>
		</div>
	</div>
</header>
<body>
	<section class="my-5">
		<div class="container-fluid">
			<div class="row">

				<div class="container">
					<div class="row">
						<div class="col-2">
							<a href="${pageContext.request.contextPath}/home" class="btn btn-primary btn-lg active" role="button">Accueil</a>
						</div>
						<div class="col-2">
							<a href="${pageContext.request.contextPath}/login" class="btn btn-primary btn-lg active" role="button">Login</a>
						</div>

						<div class="col-2">
							<a href="${pageContext.request.contextPath}/userList" class="btn btn-primary btn-lg active" role="button">Liste
								des utilisateurs</a>
						</div>

						<div class="col-2">
							<a href="${pageContext.request.contextPath}/infos" class="btn btn-primary btn-lg active" role="button">A propos de nous</a>
						</div>
						
							<div class="col-2">
							<a href="${pageContext.request.contextPath}/topoList" class="btn btn-primary btn-lg active" role="button">Les Topos</a>
						</div>
						<div class="col-2">
							<a href="${pageContext.request.contextPath}/formTopo" class="btn btn-primary btn-lg active" role="button">Ajouter un Topo</a>
						</div>
						</div>
		</div>
						</div>
		</div>
	</section>
<section class="my-5 col-12 center_div">
		<div class="container">
			<div class="row">
			
			<form:form class="my-5 center_div col-6 form-signin" action="saveUser" method="POST"
							modelAttribute="userForm">
					
					
							<h2 class="form-signin-heading text-primary">Ajouter un utilisateur</h2>


							<table>
								<tr>
									<td>Name</td>
									<td><form:input path="name" required="required"/></td>
									<td><form:errors path="name" class="error-message" /></td>
								</tr>
								<tr>
									<td>Password</td>
									<td><form:input type="password" path="password" required="required" /></td>
									<td><form:errors path="password" class="error-message" /></td>
								</tr>
								<tr>
									<td>Confirm the Password</td>
									<td><form:input type="password" path="passwordConfirm" required="required"/></td>
									<td><form:errors path="passwordConfirm" class="error-message" /></td>
								</tr>
								<tr>
									<td>Email</td>
									<td><form:input path="email" required="required"/></td>
									<td><form:errors path="email" class="error-message" /></td>
								</tr>
								<tr>
									<td>Login</td>
									<td><form:input path="username" required="required"/></td>
									<td><form:errors path="username" class="error-message" /></td>

								</tr>

								<tr>
									<td>Cotation</td>
									<td><form:input path="cotation" required="required"/></td>
									<td><form:errors path="cotation" class="error-message" /></td>
								</tr>

								<tr>
									<td>&nbsp;</td>
									<td>
										<button class="btn btn-lg btn-primary btn-block" type="submit">Submit</button>
										<a href="${pageContext.request.contextPath}/userList">Cancel</a>
									</td>
									<td>&nbsp;</td>
								</tr>
							</table>

						</form:form>

					</div>
					</div>
				</section>
			
</body>
</html>