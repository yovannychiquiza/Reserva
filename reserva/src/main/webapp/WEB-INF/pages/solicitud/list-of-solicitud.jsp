<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<?xml version="1.0" encoding="ISO-8859-1" ?>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
<title>Lista de solicitudes</title>
</head>
<body>
	<h1>Lista de solicitudes</h1>
	<p>Aqui puede ver la lista de empleados, editarlos, eliminarlos o
		actualizarlos.</p>

	<a href="${pageContext.request.contextPath}/solicitud/add.html">Agregar</a>
	<br />

	<table border="1px" cellpadding="0" cellspacing="0">
		<thead>
			<tr>
				<th width="10%">id</th>
				<th width="15%">Ciudad Origen</th>
				<th width="15%">Ciudad Destino</th>
				<th width="10%">Fecha Salida</th>
				<th width="10%">Fecha regreso</th>
				<th width="10%">Estado</th>
				<th width="10%">acciones</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="solicitud" items="${solicitudes}">
				<tr>
					<td>${solicitud.id}</td>
					<td>${solicitud.ciudadOrigen_Id.nombre}</td>
					<td>${solicitud.ciudadDestino_Id.nombre}</td>
					<td>${solicitud.fechaSalida}</td>
					<td>${solicitud.fechaRegreso}</td>
					<td>${solicitud.estadoSolicitud_Id.nombre}</td>
					<td><a
						href="${pageContext.request.contextPath}/solicitud/edit/${solicitud.id}.html">Editar</a><br />
						<a
						href="${pageContext.request.contextPath}/solicitud/delete/${solicitud.id}.html">borrar</a><br />
					</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>

	<p>
		<a href="${pageContext.request.contextPath}/">Regresar</a>
	</p>

</body>
</html>