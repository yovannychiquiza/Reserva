<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="security"
	uri="http://www.springframework.org/security/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>

<html>

<head>
	<link rel="shortcut icon" href="<c:url value='/resources/images/favicon.ico' />" type="image/x-icon">
	<link rel="icon" href="<c:url value='/resources/images/favicon.ico' />" type="image/x-icon">
	<link href="<c:url value='/resources/style/reserva_style.css' />" rel="stylesheet">		
</head>
<body>
<div class="container">

	<div id="loginPannel">
		<security:authorize access="!isAuthenticated()">
		<div style = "float: left;">
			<img src="<c:url value="/resources/images/logo.jpg" />" >
		</div>
			<div class="det-cuadro-gris-a">Bienvenidos a Reserva Net</div>

			<div id="dis-contenido" style="width: 100%">
				<div class="det-contenido-1a">

					<c:if test="${loginFailed}">
						<div style="color: red">Could not sign in, please check your
							login/password...</div>
					</c:if>

					<form method="post" class="signin" action="j_spring_security_check">
						<table>
							<tr>
								<th><label for="username_or_email">Usuario</label></th>
								<td><input id="username_or_email" name="j_username"
									type="text" /></td>
							</tr>
							<tr>
								<th><label for="password">Contraseña</label></th>
								<td><input id="password" name="j_password" type="password" /></td>
							</tr>
							<tr>
								<th></th>
								<td><input name="commit" type="submit" value="Enviar" /></td>
							</tr>
						</table>
					</form>

				</div>
			</div>

		</security:authorize>


		<security:authorize access="isAuthenticated()">
		 	ESTA AUTENTICADO
		 </security:authorize>

	</div>
</div>

</body>
</html>