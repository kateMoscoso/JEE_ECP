<?xml version="1.0" encoding="UTF-8"  ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link href="/bootstrap/css/bootstrap.min.css" rel="stylesheet">
<link href="/bootstrap/css/bootstrap-responsive.min.css" rel="stylesheet">
<link rel="stylesheet" href="bootstrap/css/estilo.css" type="text/css" />
<script src="/bootstrap/css/bootstrap.min.css"></script> 
<title>Votacion</title>
</head>
<body>
	<c:set var="eView" scope="request" value="${eliminarTema}" />
	<div class="container">
		<div class="panel panel-default">
			<div class="panel-heading">
				<h1>
					<span class="glyphicon glyphicon-wrench" aria-hidden="true"></span>
					Temas: <small>temas registrados en el sistema</small>
				</h1>
			</div>
			<div>${eView.update()}</div>
			<div class="table-responsive">
				<div class="panel panel-default">
					<table class="table table-striped table-condensed">
						<tr>
							<th>Nombre</th>
							<th>Pregunta</th>
						</tr>
						<c:forEach var="tema" items="${eView.temas}">
							<tr>
								<td value="${tema.nombre}">${tema.nombre}</td>
								<td value="${tema.pregunta}">${tema.pregunta}</td>
							</tr>
						</c:forEach>
					</table>
				</div>
			</div>
		</div>
		<p>
			<a href="/Votacion/jsp/home">Volver a Home</a>
		</p>
	</div>
	</div>
</body>
</html>