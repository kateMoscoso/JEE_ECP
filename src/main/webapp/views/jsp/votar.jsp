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

	<c:set var="vView" scope="request" value="${votar}" />
	<div>${vView.update()}</div>
	<div class="jumbotron">
		<div class="container">
			<h1>Bienvenido a la aplicaciones de votaciones</h1>
			<c:if test="${vView.flag <0}">
				<p>Escoga un tema a votar</p>
				<form action="/Votacion/jsp/votar" method="post">
					<p>
						Temas a votar: <select name="tema">
							<c:forEach var="tema" items="${vView.temas}">
								<option value="${tema.idTema}">${tema.nombre}</option>
							</c:forEach>
						</select>
					</p>
					<p>
						<input type="hidden" name="tag" value="1" /> <input type="submit"
							value="Enviar" />
					</p>
				</form>
			</c:if>
			<c:if test="${vView.flag >0}">
				<p>Rellene el formulario de votación</p>
				<form action="/Votacion/jsp/votar" method="post">
					<p>
						Tema: ${vView.tema.nombre} <input type="hidden" name="id"
							value="${vView.tema.idTema}" /> <br /> ${vView.tema.pregunta}
					</p>
					<p>
						Tu ip es:
						<%=request.getRemoteHost()%>
						<input type="hidden" name="ip"
							value="<%=request.getRemoteHost()%>" />
					</p>
					<p>
						Selecciona tu nivel de estudios: <select name="nivel">
							<c:forEach var="nivel" items="${vView. nivelEstudios}">
								<option value="${nivel}">${nivel}</option>
							</c:forEach>
						</select>
					</p>
					<p>
						Selecciona la puntuacion: <select name="valor">
							<c:forEach var="valor" items="${vView. puntuacionValores}">
								<option value="${valor}">${valor}</option>
							</c:forEach>
						</select>
					</p>
					<p>
						<input type="hidden" name="tag" value="2" /> <input type="submit"
							value="Enviar" />
					</p>
				</form>
			</c:if>
			<p>
				<a href="/Votacion/jsp/home">Volver a Home</a>
			</p>
		</div>
	</div>
</body>
</html>