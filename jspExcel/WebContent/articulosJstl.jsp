<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<jsp:useBean id="articulo1" class="modelo.Articulo">
		<c:set target="${articulo1}" property="cantidad" value="5"></c:set>
		
		<c:set target="${articulo1}" property="precio" value="10" ></c:set>
	</jsp:useBean>
	
	
	<jsp:useBean id="articulo2" class="modelo.Articulo">
		<c:set target="${articulo2}" property="cantidad" value="10" ></c:set>
		<c:set target="${articulo2}" property="precio" value="10"></c:set>
	</jsp:useBean>
	
	
	
	<jsp:useBean id="service" class="service.ArticulosService">
	<c:set property="articulo" target="${service}"  value="${articulo1}"></c:set>
	<c:set property="articulo" target="${service}"  value="${articulo2}"></c:set>
	</jsp:useBean>
	 
	 <c:forEach var="miarticulo" items="${service.articulos}" varStatus="status" >
	 	${miarticulo.cantidad}
	 	${miarticulo.precio}
	 </c:forEach>
	
</body>
</html>