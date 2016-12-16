<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<c:set var="nombre" value="Ernesto"></c:set>
	
	<c:out value="${nombre}"></c:out>

	<c:set var="bandera" value="true"></c:set>
	<c:if test="${bandera}">
 	la bander es beredadera
 </c:if>

	<br> el param
	<c:choose>
		<c:when test="${param.opcion==1}">
		el parametro es 1
		</c:when>
		<c:when test="${param.opcion==2}">
		el parametro es 2
		</c:when>
		<c:otherwise>
	parametro no conocido ${param["opcion"]}
	</c:otherwise>
	</c:choose>

	<a href="articulosJstl.jsp"> link l articulos jstl</a>

</body>
</html>