<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h2>
		Vista de <b>Incorporar Tema</b>
	</h2>
	<c:set var="pView" scope="request" value="${tema}" />
	<div>${pView.update()}</div>
	<form action="/Votacion/jsp/incorporarTema" method="post">
		<p>
			Nombre: <input name="nombre" type="text" value="nombre" />
		</p>
		<p>
			Pregunta: <input name="pregunta" type="text" value="pregunta"/>${pView.errorMsg}</p>
		<p>
			<input type="submit" value="A�adir" />
		</p>
	</form>
	<p>
		<a href="/Votacion/jsp/home">Volver a Home</a>
	</p>
</body>
</html>