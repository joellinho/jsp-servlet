<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<!-- seteando los atributos con las propiedades que viene en el request -->
	<jsp:useBean id="miarticulo" class="modelo.Articulo" scope="page"></jsp:useBean>
	<jsp:setProperty property="cantidad" name="miarticulo" param="cantidad" />
	<jsp:setProperty property="precio" name="miarticulo" param="precio" />
	
	<p>comparando los valores del request y del bean con tquiteas action</p>
	
	<br> del rquest :<%=request.getParameter("cantidad")%>
	<br>
	del bean :<jsp:getProperty property="cantidad" name="miarticulo" />

	<br> del rquest :<%=request.getParameter("precio")%>
	<br>
	del bean :<jsp:getProperty property="precio" name="miarticulo" />

	<br> obteniedo el total
	<jsp:getProperty property="total" name="miarticulo" />
	
	<br>
	<br>
	accdiendo a los parametros del rquest con Expression Langage
	<br>
	cantidad : ${param["cantidad"]}
		<br>
	precio : ${param["precio"]}
	
	<br>
	<br>
	accdiendo a las propiedades del objeto con Expression Langage
	<br>
	cantidad : ${miarticulo.cantidad}
		<br>
	precio : ${miarticulo.precio}
</body>
</html>