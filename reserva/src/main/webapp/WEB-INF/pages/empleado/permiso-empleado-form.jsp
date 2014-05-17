<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<?xml version="1.0" encoding="ISO-8859-1" ?>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
<title>Permiso empleado</title>
</head>
<body>
	<div class="container">

		<jsp:include page="../menu.jsp" />
		<script>			
						 
			 $(document).ready(function() {
				 $('input[type=checkbox]').click(function() {					 					    						
					 var permiso_id = $(this).attr('permiso_id')
					 var empleado_id = $(this).attr('empleado_id')					 
					 var activo = this.checked 					
					 $.get( "${pageContext.request.contextPath}/empleado/guardaPermiso.html", {empleado_id : empleado_id, permiso_id: permiso_id, activo: activo  } );
				});
			 });
		</script>
		
		<p>${message}</p>
		<form:form method="POST" commandName="empleado"
			action="${pageContext.request.contextPath}/empleado/permiso/.html">

			<div class="det-cuadro-gris-a">Permiso Empleado</div>

			<div id="dis-contenido" style="width: 100%">
				<div class="det-contenido-1a">

					<table>
						<tbody>
							<tr>
								<td>Identificacion:</td>
								<td>${empleado.identificacion}</td>								
							</tr>
							<tr>
								<td>Nombre:</td>
								<td>${empleado.nombre}</td>	
							</tr>
							<tr>
								<td>Apellido:</td>
								<td>${empleado.apellido}</td>	
							</tr>
							
							<tr>
								<td colspan="2">

									 <table>
									    <tr>
									        <th></th>
									        <th>Permiso</th>
									    </tr>
									    <c:forEach items="${empleado.permiso}" var="permiso" varStatus="status">
									        <tr>
									            <input type="hidden" name="permiso[${status.index}].id" value="${permiso.id}"/>
									        
									            <c:if test="${permiso.activo == true}">
									            	<td><input type="checkbox" empleado_id="${empleado.id}" permiso_id="${permiso.id}" id="permiso[${status.index}].activo"  name="permiso[${status.index}].activo" checked ></td>
				 					            </c:if>
									            <c:if test="${permiso.activo == false}">
									            	<td><input type="checkbox" empleado_id="${empleado.id}" permiso_id="${permiso.id}" id="permiso[${status.index}].activo" name="permiso[${status.index}].activo" ></td>
				 					            </c:if>
				 					           
									            <td>${permiso.nombre}</td>
									        </tr>
									    </c:forEach>
									</table>  
																
								</td>
							</tr>
														
						</tbody>
					</table>
						<a href="${pageContext.request.contextPath}/empleado/list.html">Lista de empleados</a>							
				</div>
			</div>
		</form:form>

	</div>
</body>
</html>