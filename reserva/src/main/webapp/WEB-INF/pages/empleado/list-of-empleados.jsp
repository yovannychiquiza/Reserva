<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<?xml version="1.0" encoding="ISO-8859-1" ?>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
<title>Lista de empleados</title>
</head>
<body>
	<div class="container">

		<jsp:include page="../menu.jsp" />

		<div class="det-cuadro-gris-a">Lista de empleados</div>

		<div id="dis-contenido" style="width: 100%">
			<div class="det-contenido-1a">


				<table id="tabla" class="tablesorter">
					<thead>
						<tr>
							<th width="10%">id</th>
							<th width="15%">Identificacion</th>
							<th width="15%">Nombre</th>
							<th width="10%">Apellido</th>
							<th width="10%">acciones</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach var="empleado" items="${empleados}">
							<tr>
								<td>${empleado.id}</td>
								<td>${empleado.identificacion}</td>
								<td>${empleado.nombre}</td>
								<td>${empleado.apellido}</td>
								<td>
								<security:authorize access="hasRole('ADMIN')">
									<a href="${pageContext.request.contextPath}/empleado/edit/${empleado.id}.html">Editar</a><br />
								</security:authorize>
								<security:authorize access="hasRole('ADMIN')">
									<a href="${pageContext.request.contextPath}/empleado/permiso/${empleado.id}.html">permiso</a><br />
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