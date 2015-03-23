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
					Votaciones: <small>Añadir un Tema</small>
				</h1>
			</div>
			<c:set var="pView" scope="request" value="${tema}" />
			<div>${pView.update()}</div>
			<form action="/Votacion/jsp/incorporarTema" method="post">
				<p>
					Nombre: <input name="nombre" type="text" value="" required/>
				</p>
				<p>
					Pregunta: <input name="pregunta" type="text" value="" required/>${pView.errorMsg}</p>
				<p>
					<input type="submit" value="Añadir" />
				</p>
			</form>
			<p>
				<a href="/Votacion/jsp/home">Volver a Home</a>
			</p>
		</div>
	</div> 
</body>
</html>