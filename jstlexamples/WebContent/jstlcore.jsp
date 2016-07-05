<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
<title>Insert title here</title>
</head>
<body>
	<c:set var="nombre" value="Ernesto" /><!-- VARIBALE ALCANCE DE PAGE SOLO SE ACCEDE EN ESTE JSP -->
	variable nombre:
	<c:out value="${nombre}" />
	<br></br>
	<c:set var="bandera" value="true" />
	<c:if test="${bandera}">
	la bandera es verdadera
	</c:if>
	<br></br>
	
	
	
	<c:if test="${param.opcion!=null}">
		<c:choose>
			<c:when test="${param.opcion==1}">
	opcion 1 proporcionada
	</c:when>
			<c:when test="${param.opcion==2}">
	opcion2 proprcionada</c:when>
		
		<c:otherwise>
		opcion no conocida ${param.opcion}
		<b></b>
		</c:otherwise>
		</c:choose>
	</c:if>

<!-- iteracion de una arreglo -->

<%
String[] nombres = {"joel","enciso","havier"};
request.setAttribute("nombres", nombres);
//añadimos al contexto request la matriz de elementos y su llave 
%>


<!-- creamos una variable temporal para alamcenar una lista devariables del request ya definido en este caso nombres -->
<ul>
<c:forEach var="persona" items="${nombres}">
<li> nombres:${persona}</li>
</c:forEach>
</ul>
</body>
</html>