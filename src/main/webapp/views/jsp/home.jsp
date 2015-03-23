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
					Votaciones<small>Bienvenido a la aplicacion de votaciones</small>
				</h1>
			</div>

			<p>
				<a class="btn btn-primary btn-lg" href="/Votacion/jsp/votar"
					role="button">Votar un Tema &raquo;</a>
			</p>
			<p>
				<a class="btn btn-primary btn-lg" href="/Votacion/jsp/verVotaciones"
					role="button">Ver votaciones &raquo;</a>
			</p>
			<p>
				<a class="btn btn-primary btn-lg"
					href="/Votacion/jsp/incorporarTema" role="button">Incorporar un
					Tema &raquo;</a>
			</p>
			<p>
				<a class="btn btn-primary btn-lg" href="/Votacion/jsp/eliminarTema"
					role="button">Eliminar un Tema &raquo;</a>
			</p>
		</div>
	</div>
</body>
</html>
