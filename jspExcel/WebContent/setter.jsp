<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<jsp:useBean id="miarticulo" class="modelo.Articulo" scope="session">
<!-- Articulo miarticulo = new Articulo();
session.setAttribute("miarticulo",miarticulo);
 -->
	
</jsp:useBean>
<%
	int cantidad = 5;
	double precio = 20;
%>
<jsp:setProperty property="cantidad" name="miarticulo" value="<%=cantidad %>"/>
<!-- miarticulo.setCantidad(cantidad) -->
<jsp:setProperty property="precio" name="miarticulo" value="<%=precio %>"/>
<!-- miarticulo.setCantidad(precio) -->
<br>
<%=cantidad %>
<br>
<%=precio %>
<a href="getter.jsp" >obtener los las propiedades del objeto</a>

</body>
</html>