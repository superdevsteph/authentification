<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<c:set var="contextPath" value="${pageContext.request.contextPath}" />

<!DOCTYPE html>
<html>
<head>
	<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css">
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>Liste des Topos</title>
<style><%@include file="/resources/css/style.css"%></style>
</head>
<header class="h-25 d-inline-block">
	<div class="overlay"></div>
  <video autoplay="autoplay" muted="muted" loop="loop">
    <source src="https://storage.googleapis.com/coverr-main/mp4/Mt_Baker.mp4" type="video/mp4">
  </video>
  <div class="container h-100">
    <div class="d-flex h-100 text-center align-items-center">
      <div class="w-100 text-white">
        <h1 class="display-3">Les amis de l'escalade</h1>
        <p class="lead mb-0">Liste des Topos</p>
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
							<a href="${pageContext.request.contextPath}/registration" class="btn btn-primary btn-lg active" role="button">Créer
								un compte</a>
						</div>
						
						<div class="col-2">
							<a href="${pageContext.request.contextPath}/registration" class="btn btn-primary btn-lg active" role="button">Créer
								un utilisateur</a>
						</div>
						
						<div class="col-2">
							<a href="${pageContext.request.contextPath}/infos" class="btn btn-primary btn-lg active" role="button">A propos de nous</a>
						</div>
						<div class="col-2">
							<a href="${pageContext.request.contextPath}/formTopo" class="btn btn-primary btn-lg active" role="button">Ajouter un Topo</a>
						</div>
						
					
						
<br/>
 
 
<section class="my-5 center_div">
 <a href="${pageContext.request.contextPath}/topoForm">Ajouter un Topo</a>
 
<br/>
<table border="1">
 <tr>
   <th>Nom</th>
   <th>Region</th>
   <th>Nombre de sites</th>
   <th>Nombre de secteurs</th>
   <th>Nombre de voies</th>
   <th>Description</th>
   <th>Date de publication</th>
  
   <th>Edit</th>
   <th>Delete</th>
 </tr>
 <c:forEach items="${topoInfos}" var="info">
 
 <tr>
   <td> ${info.toponame}  </td>
   <td> ${info.region}  </td>
   <td> ${info.nbSites} </td>
     <td> ${info.nbSecteurs} </td>
   <td> ${info.nbVoies} </td>
   <td> ${info.description} </td>
     <td> ${info.datePublication} </td>
   <td> <a href="deleteTopo?id=${info.id}">Delete</a> </td>
   <td> <a href="editTopo?id=${info.id}">Edit</a> </td>
 </tr>    
 </c:forEach>
</table>
 <br/>
 
   <div class="message">${message}</div>
</section>
 
 </div>
  </div>
    </div>
  </div>
</section>
</body>
</html>