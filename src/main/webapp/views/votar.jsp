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
	<h1>Bienvenido a la aplicaciones de votaciones</h1>
	<p>P�gina de votacion</p>
	<p>Votaciones</p>
		<p>
		<c:forEach var="rol" items="${pView.roles}">
			<option value="${rol}">${rol}</option>
		</c:forEach>
	</p>
	<p>
		<c:forEach var="tema" items="${pView.temas}">
			<option value="${tema}">${tema}</option>
		</c:forEach>
	</p>


</body>
</html>