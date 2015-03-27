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
	<c:set var="eView" scope="request" value="${eliminarTema}" />
	<div class="jumbotron">
		<div class="container">
			<div class="panel-heading">
				<h1>
					<span class="glyphicon glyphicon-wrench" aria-hidden="true"></span>
					Temas: <small>Lista Temas registrados en el sistema</small>
				</h1>
			</div>
			<div>${eView.update()}</div>
			<c:if test="${eView.flag=='noAuth'}">
				<form action="/Votacion/jsp/eliminarTema" method="post">
					<div class="form-group">
						<label for="codigo">Introduce el codigo de validacion:</label> <input
							type="hidden" name="flag" value="noAuth" /> <input type="text"
							name="codigo" value="" />

					</div>
					<c:if test="${not empty eView.errorMsg}">
						<div class="alert alert-danger" role="alert">
							<span class="glyphicon glyphicon-exclamation-sign"
								aria-hidden="true"></span> <span class="sr-only">Error:</span>
							${eView.errorMsg}
						</div>

					</c:if>
					<button type="submit" class="btn btn-primary">Enviar</button>
				</form>
			</c:if>
			<c:if test="${eView.flag=='Auth'}">
				<form action="/Votacion/jsp/eliminarTema" method="post">
					<p>
						Temas a eliminar: <select name="tema" class="selectpicker">
							<c:forEach var="tema" items="${eView.temas}">
								<option value="${tema.idTema}">${tema.nombre}</option>
							</c:forEach>
						</select>
					</p>
					<p>
						<input type="hidden" name="flag" value="Auth" /> <input
							type="submit" value="Eliminar" />
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