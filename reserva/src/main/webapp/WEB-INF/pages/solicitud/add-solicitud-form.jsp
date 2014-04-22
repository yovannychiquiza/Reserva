<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<?xml version="1.0" encoding="ISO-8859-1" ?>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
<title>Agregar solicitud</title>
</head>
<body>
	<div class="container">
		<jsp:include page="../menu.jsp" />

		<script>
			$(function() {
				$(".datepicker").datepicker();
			});
		</script>


		<form:form method="POST" commandName="solicitud"
			action="${pageContext.request.contextPath}/solicitud/add.html">


			<div class="det-cuadro-gris-a">Agregar solicitud</div>

			<div id="dis-contenido" style="width: 100%">
				<div class="det-contenido-1a">
					<table width="100%" class="admintable">

						<tbody>
							<tr>
								<td width="30%" align="right" class="key"><label>
										*Ciudad Origen: </label></td>
								<td width="70%"><form:select path="ciudadOrigen_Id.Id"
										items="${listaCiudades}" /> 										
								</td>
							</tr>

							<tr>
								<td align="right" class="key"><label> *Ciudad
										Destino: </label></td>
								<td><form:select path="ciudadDestino_Id.Id"
										items="${listaCiudades}" /></td>
							</tr>
							<tr>
								<td align="right" class="key"><label>
										*Fecha Salida: </label></td>
								<td><form:input path="fechaSalida"
										class="datepicker det-estilo-campo" size="15" /></td>
							</tr>
							<tr>
								<td align="right" class="key"><label> *Fecha
										Regreso: </label></td>
								<td><form:input path="fechaRegreso"
										class="datepicker det-estilo-campo" /></td>
							</tr>
							<tr>
								<td align="right" class="key"></td>
								<td><input type="submit" value="Guardar" /></td>
							</tr>
						</tbody>
					</table>
				</div>

			</div>
	</div>

	</form:form>

</body>
</html>