<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<?xml version="1.0" encoding="ISO-8859-1" ?>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
<title>Validacion solicitud</title>
</head>
<body>
<h1>Validacion solicitud</h1>
<p>Aqui puede Validar una solicitud.</p>
<form:form method="POST" commandName="solicitud" action="${pageContext.request.contextPath}/solicitud/edit/${solicitud.id}.html">
<table>
<tbody>
	<tr>
		<td>Ciudad Origen:</td>
		<td><form:select path="ciudadOrigen_Id.Id" items="${listaCiudades}" /></td>				
	</tr>
	<tr>
		<td>Ciudad Destino:</td>		
		<td><form:select path="ciudadDestino_Id.Id" items="${listaCiudades}" /></td>		
	</tr>
	<tr>
		<td>Fecha Salida:</td>
		<td>${solicitud.fechaSalida}</td>
	</tr>
	

	<tr>
		<td>Fecha Regreso:</td>
		<td>${solicitud.fechaRegreso}</td>
	</tr>
	
	<tr>
		<td><input type="submit" value="Edit" /></td>
		<td></td>
	</tr>
</tbody>
</table>
</form:form>

<p><a href="${pageContext.request.contextPath}/solicitud/list.html">Indice</a></p>
</body>
</html>