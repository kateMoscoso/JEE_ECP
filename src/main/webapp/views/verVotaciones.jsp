<?xml version="1.0" encoding="UTF-8"  ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link href="../bootstrap/css/bootstrap.min.css" rel="stylesheet">
<link href="../bootstrap/css/bootstrap-responsive.min.css"
	rel="stylesheet">
<link rel="stylesheet" href="/..bootstrap/css/estilo.css"
	type="text/css" />
<script src="../bootstrap/css/bootstrap.min.css"></script>
<title>Votacion</title>
</head>
<body>
	<div class="jumbotron">
		<div class="container">
			<div class="panel-heading">
				<h1>
					<span class="glyphicon glyphicon-wrench" aria-hidden="true"></span>
					Votaciones: <small>Vista de votaciones</small>
				</h1>
			</div>
			<c:set var="vView" scope="request" value="${verVotaciones}" />
			<div>${vView.update()}</div>
			<p class="lead">Votos por Temas</p>

			<div class="panel-body">
				<div class="table-responsive">
					<table class="table table-striped table-condensed">
						<tr>
							<th>Nombre</th>
							<th>Valor</th>
						</tr>
						<c:forEach var="voto" items="${vView.votaciones}">
							<tr>
								<td>${voto.key}</td>
								<td>${voto.value}</td>
							</tr>
						</c:forEach>

					</table>
				</div>
			</div>
			<BR />
			<p class="lead">Media de Votos por Nivel de Estudios</p>
			<div class="panel-body">
				<div class="table-responsive">
					<table class="table table-striped table-condensed">
						<tr>
							<th>Nivel Estudio</th>
							<th>Valor</th>
						</tr>
						<c:forEach var="media" items="${vView.medias}">
							<tr>
								<td>${media.key}</td>
								<td>${media.value}</td>
							</tr>
						</c:forEach>

					</table>
				</div>
			</div>
			<p>
				<a href="/Votacion/jsp/home">Volver a Home</a>
			</p>
		</div>
	</div>

</html>