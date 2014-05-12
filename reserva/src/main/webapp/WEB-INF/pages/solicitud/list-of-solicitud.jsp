<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags"%>

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
	<div class="container">

		<jsp:include page="../menu.jsp" />


		<div class="det-cuadro-gris-a">Lista de solicitudes</div>

		<br />
		<div id="dis-contenido" style="width: 100%">
			<div class="det-contenido-1a">

				<table id="tabla" class="tablesorter">
					<thead>
						<tr class="tabla">
							<th width="10%">id</th>
							<th width="15%">Ciudad Origen</th>
							<th width="15%">Ciudad Destino</th>
							<th width="10%">Fecha Salida</th>
							<th width="10%">Fecha regreso</th>
							<th width="10%">Empleado</th>
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
								<td>${solicitud.empleado.nombre} ${solicitud.empleado.apellido}</td>								
								<td>${solicitud.estadoSolicitud_Id.nombre}</td>
								<td>
								    <security:authorize access="hasRole('AutorizacionSeguridad')">         								
										<a href="${pageContext.request.contextPath}/solicitud/seguridad/${solicitud.id}.html">Autorizar Seguridad</a><br />
									</security:authorize>
									<security:authorize access="hasRole('AutorizacionJefe')">
										<a href="${pageContext.request.contextPath}/solicitud/jefe/${solicitud.id}.html">Autorizar Jefe</a><br />
									</security:authorize>
									<security:authorize access="hasRole('AutorizacionGerencia')">
										<a href="${pageContext.request.contextPath}/solicitud/gerencia/${solicitud.id}.html">Autorizar Gerencia</a><br />
									</security:authorize>
									
								</td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
		</div>


	</div>
</body>
</html>