<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<c:set var="contextPath" value="${pageContext.request.contextPath}" />

<!DOCTYPE html>
<html>
<head>
	<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css">
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>Les articles</title>
	<style><%@include file="/resources/css/style.css"%></style>
</head>
<header class="h-25 d-inline-block">
	<div class="overlay"></div>
	<video  autoplay="autoplay" muted="muted"
		loop="loop">
		<source
			src="https://storage.googleapis.com/coverr-main/mp4/Mt_Baker.mp4"
			type="video/mp4">
	</video>
	<div class="container h-100">
		<div class="d-flex h-100 text-center align-items-center">
			<div class="w-100 text-white">
				<h1 class="display-3">Les amis de l'escalade</h1>
				<p class="lead mb-0">coucou</p>
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
						<div class="col-3">
							<a href="${pageContext.request.contextPath}/home" class="btn btn-primary btn-lg active" role="button">Accueil</a>
						</div>
						<div class="col-3">
							<a href="${pageContext.request.contextPath}/login" class="btn btn-primary btn-lg active" role="button">Login</a>
						</div>
					
						
						<div class="col-3">
							<a href="${pageContext.request.contextPath}/infos" class="btn btn-primary btn-lg active" role="button">A propos de nous</a>
						</div>
						
					

					</div>
				</div>

			</div>
			
			<div class="my-5 container text-justify">
			
			<p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Curabitur porta imperdiet ipsum, at sagittis leo hendrerit tempor. Nullam rutrum consectetur velit, sit amet auctor mi commodo eget. Etiam et augue felis. Nunc eros massa, mollis non consequat lobortis, accumsan vel nulla. Morbi id nunc ut neque mattis maximus vitae nec dui. Donec eu consectetur sapien. Aenean pulvinar ante vitae condimentum imperdiet. Duis sit amet fermentum nunc, at ornare nibh.

Nunc id dui porttitor, congue purus ac, fermentum orci. Ut dictum facilisis mauris, et iaculis nisl imperdiet id. Aliquam sit amet nulla vehicula, tempor velit nec, volutpat lorem. Proin consequat, ex ut luctus pretium, odio tortor scelerisque eros, sollicitudin aliquam urna urna id velit. Integer at orci semper, ullamcorper massa a, posuere enim. Nam vitae dolor tortor. Integer semper leo at neque blandit tempor. Morbi nec justo a neque malesuada laoreet. Aliquam feugiat quam eu enim efficitur vestibulum. Vivamus nec dui magna. Donec id dictum dolor. Mauris tincidunt vulputate nisl, quis commodo ipsum tristique a. Curabitur magna risus, fermentum id luctus vitae, porta et dolor. Donec pulvinar dolor et tortor egestas fermentum sit amet non quam.</p>
			
			</div>
			
		</div>

	</section>
</body>
</html>