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
	<div>${eView.update()}</div>
	<div>
		<table>
		<c:forEach var="voto" items="${vView.votaciones}">
			<tr>
				<td value="${voto.key}">${voto.key}</td>
				<td value="${voto.value}">${voto.value}</td>
			</tr>
		</c:forEach>

	</table>
	</div>
</html>