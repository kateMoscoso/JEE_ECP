<?xml version="1.0" encoding="UTF-8"  ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html>
<head>
<title>Insert title here</title>
</head>
<body>
	<h1>Bienvenido a la aplicaciones de votaciones</h1>
	<p>Página de votacion</p>
	<p>Votaciones</p>
	<c:set var="vView" scope="request" value="${votar}" />
	<div>${vView.update()}</div>
	<form action="/Votacion/jsp/votarTema" method="post">
	<p>
		<input name="pregunta" type="text" value="${vView.tema.pregunta}"/>${vView.tema.pregunta}
		</p>
		<h3>
			Tu ip es: <input name="ip" type="text"
				value="<%=request.getRemoteHost()%>" /><%=request.getRemoteHost()%></h3>

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
			<input type="submit" value="Enviar" />
		</p>
	</form>
	<p>
		<a href="/Votacion/jsp/home">Volver a Home</a>
	</p>

</body>
</html>