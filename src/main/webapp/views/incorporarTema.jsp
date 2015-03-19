<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="ISO-8859-1">
<link href="src/main/webapp/bootstrap/css/bootstrap.min.css" rel="stylesheet">
<link href="src/main/webapp/bootstrap/css/bootstrap-responsive.min.css" rel="stylesheet">
<link rel="stylesheet" href="bootstrap/css/estilo.css" type="text/css" />
<script src="src/main/webapp/bootstrap/css/bootstrap.min.css"></script>
<title>Votacion</title>
</head>
<body>
	<div class="jumbotron">
		<div class="container">
			<h2>
				Formulario para añadir un tema
			</h2>
			<c:set var="pView" scope="request" value="${tema}" />
			<div>${pView.update()}</div>
			<form action="/Votacion/jsp/incorporarTema" method="post">
				<p>
					Nombre: <input name="nombre" type="text" value="" />
				</p>
				<p>
					Pregunta: <input name="pregunta" type="text" value="" />${pView.errorMsg}</p>
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