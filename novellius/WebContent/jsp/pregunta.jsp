<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1>Obteniedo</h1>



	la pregunta es
	<c:out value="${param['pregunta']}" />


	<c:set var="str" value="${param['pregunta']}" />
	la longitud de la apregunta es ${fn:length(str)}

	<c:catch var="ex">
		<sql:update var="row" dataSource="jdbc/joelJar"
			sql="INSERT INTO pregunta(pregunta) VALUES(?)">
			
			<sql:param value="${param['pregunta']}"></sql:param>
		</sql:update>
		<c:choose>
			<c:when test="${row!=0}">Pregunta se registro correctamente</c:when>
			<c:otherwise>Error en la insercion de datos</c:otherwise>
		
		</c:choose>
	</c:catch>
	<c:if test="${ex!=null}">
	error en la coneccion
	</c:if>
	
</body>
</html>