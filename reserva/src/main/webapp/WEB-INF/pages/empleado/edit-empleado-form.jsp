<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<?xml version="1.0" encoding="ISO-8859-1" ?>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
<title>Editar empleado</title>
</head>
<body>
<h1>Editar empleado</h1>
<p>Aqui puede editar un empleado existente.</p>
<p>${message}</p>
<form:form method="POST" commandName="empleado" action="${pageContext.request.contextPath}/empleado/edit/${empleado.id}.html">
<table>
<tbody>
	<tr>
		<td>Identificacion:</td>
		<td><form:input path="identificacion" /></td>
	</tr>
	<tr>
		<td>Nombre:</td>
		<td><form:input path="nombre" /></td>
	</tr>
	<tr>
		<td>Apellido:</td>
		<td><form:input path="apellido" /></td>
	</tr>
	<tr>
		<td><input type="submit" value="Edit" /></td>
		<td></td>
	</tr>
</tbody>
</table>
</form:form>

<p><a href="${pageContext.request.contextPath}/empleado/list.html">Indice</a></p>
</body>
</html>