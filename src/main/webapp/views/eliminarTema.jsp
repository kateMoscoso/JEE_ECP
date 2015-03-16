<?xml version="1.0" encoding="UTF-8"  ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>Eliminar Tema Views</title>
</head>
<body>
	<h2>
		Vista de <b>Eliminar Tema</b>
	</h2>
	<c:set var="eView" scope="request" value="${eliminarTema}" />
	<div>${eView.update()}</div>
	<div>
	<table>
		<c:forEach var="tema" items="${eView.temas}">
			<tr>
				<td value="${tema.nombre}">${tema.nombre}</td>
				<td value="${tema.pregunta}">${tema.pregunta}</td>
			</tr>
		</c:forEach>

	</table>
	</div>
	<p>
		<a href="/Votacion/jsp/home">Volver a Home</a>
	</p>
</body>
</html>