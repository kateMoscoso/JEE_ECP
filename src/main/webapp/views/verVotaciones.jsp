<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Eliminar Tema Views</title>
</head>
<body>
	<h2>
		Vista de <b>Ver votaciones</b>
	</h2>
	<c:set var="vView" scope="request" value="${verVotaciones}" />
	<div>${vView.update()}</div>
	<div>
		<table>
			<tr>
				<td>Nombre</td>
				<td>Valor</td>
			</tr>
			<c:forEach var="voto" items="${vView.votaciones}">
				<tr>
					<td>${voto.key}</td>
					<td>${voto.value}</td>
				</tr>
			</c:forEach>

		</table>
		<table>
			<tr>
				<td>Nivel Estudio</td>
				<td>Valor</td>
			</tr>
			<c:forEach var="media" items="${vView.medias}">
				<tr>
					<td>${media.key}</td>
					<td>${media.value}</td>
				</tr>
			</c:forEach>

		</table>
		<p>
			<a href="/Votacion/jsp/home">Volver a Home</a>
		</p>
	</div>
</html>