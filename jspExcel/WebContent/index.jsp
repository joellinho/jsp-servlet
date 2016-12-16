
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1>Ingrese Articulo</h1>
	<a href="/jspExcel/scriptles.jsp"> link al jsp scriples</a>
	
	<form action="/jspExcel/ServletShop">
		<label>es una expresion:</label><%=session.getId() %>
		<br>
		<label>nombre</label> <select name="nombre">
			<option value="pizarra">pizarra</option>
			<option value="carro">carro</option>
			<option value="bicicleta">bicicleta</option>
		</select> <br> <label>cantidad</label> <input type="text" name="cantidad">
		<br> <input type="submit" value="enviar">
	</form>
		<a href="/jspExcel/useBean.jsp"> acceso benas - jsp</a>
</body>
</html>