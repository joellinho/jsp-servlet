<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1>esta es la pagina de scriptles</h1>
	<%
		out.print("impresnion desde un escriptless");
	%>
	<br>
	<%
		String path = request.getContextPath();
	%>
	<br>
	<p>obteniedo la variable path en un expresion por medio del rquest:</p><%=path%>
	<br> obteniedo el nombre del proyecto: por medio de un metodo
	propio de la clase servlet
	<%=getServletContext().getContextPath()%>
	<br> obteniendo la uri solocitada
	<%=request.getRequestURI()%>

	<br>
	<br>
	<form action="<%=request.getContextPath()%>/paginaFondo.jsp">
		<label>engrese el fondo para la pagina</label> <input type="text"
			name="fondo"> <input type="submit" value="enviar">
	</form>
</body>
</html>