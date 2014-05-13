<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">


  <title>Menu</title>
  <link  href="<c:url value='/resources/style/jquery-ui-1.10.4.custom.css' />" rel="stylesheet">  
<%--   <link  href="<c:url value='/resources/style/jquery.ui.all.css' />" rel="stylesheet"> --%>
  <link  href="<c:url value='/resources/style/jmenu.css' />" rel="stylesheet">
  <script src="<c:url value="/resources/script/jquery-1.10.2.js" />"></script>
  <script src="<c:url value="/resources/script/jquery.ui.core.js" />"></script>
  <script src="<c:url value="/resources/script/jquery.ui.widget.js" />"></script>    
  <script src="<c:url value="/resources/script/jquery.ui.position.js" />"></script>
  <script src="<c:url value="/resources/script/jquery.ui.button.js" />"></script>    
  <script src="<c:url value="/resources/script/jquery.ui.menu.js" />"></script>  
  <script src="<c:url value="/resources/script/jMenu.jquery.js" />"></script>  
  <link href="<c:url value='/resources/style/demos.css' />" rel="stylesheet">
  <link href="<c:url value='/resources/style/reserva_style.css' />" rel="stylesheet">	
  <script src="<c:url value="/resources/script/jquery.ui.datepicker.js" />"></script>    
  
  <script src="<c:url value="/resources/script/jquery.tablesorter.js" />"></script>
  <link  href="<c:url value='/resources/style/table_style.css' />" rel="stylesheet">  
  
  <script>
  $(function() {
   $("#tabla").tablesorter( {sortList: [[0,0], [1,0]]} ); 
   $( "input[type=submit], button" ).button();		
   
   $("#menu").jMenu({
       openClick : false,
       ulWidth :'auto',
        TimeBeforeOpening : 100,
       TimeBeforeClosing : 11,
       animatedText : false,
       paddingLeft: 1,
       effects : {
           effectSpeedOpen : 150,
           effectSpeedClose : 150,
           effectTypeOpen : 'slide',
           effectTypeClose : 'slide',
           effectOpen : 'swing',
           effectClose : 'swing'
       }

   });

  });
  </script>
  
  <style>
   .ui-menu { width: 150px; } 
   #menu { margin: 0 0 4em; }
  </style>



 <h1>Reserva Net</h1>
 <h4><security:authentication property="principal.username" /></h4>
 
<ul id="menu" >
  
  <li>
    <a href="#">Empleado</a>
    <ul>
      <security:authorize access="hasRole('ADMIN')">         
      <li><a href="${pageContext.request.contextPath}/empleado/add.html">Crear</a></li>
      </security:authorize>
      <li><a href="${pageContext.request.contextPath}/empleado/list.html">Lista</a></li>
    </ul>
  </li>
  
  <li>
    <a href="#">Solicitud</a>
    <ul>      
      <li><a href="${pageContext.request.contextPath}/solicitud/add.html">Crear</a></li>      
      <li><a href="${pageContext.request.contextPath}/solicitud/list.html">Lista</a></li>
    </ul>
  </li>

  <li>
    <a href="#">Ciudades</a>
    <ul>   
      <security:authorize access="hasRole('ADMIN')">     
      	<li><a href="${pageContext.request.contextPath}/ciudad/add.html">Crear</a></li>  
      </security:authorize>    
      <li><a href="${pageContext.request.contextPath}/ciudad/list.html">Lista</a></li>
    </ul>
  </li>
   
  <li ><a href="${pageContext.request.contextPath}/">Inicio</a></li>
  
  <li ><a href="<c:url value="${pageContext.request.contextPath}/j_spring_security_logout" />"> Salir</a></li>
</ul>
 
 









