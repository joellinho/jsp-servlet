<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%
	String fondo = request.getParameter("fondo");
%>

<%!
	// los atributos seran una unica copia a todos los clientes ya que estan declarados a nivel del servlet generado
	private int contador =1;
	private String nombre="enciso";
	public String getNombre(){
		return nombre;
		
	}
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body bgcolor="<%=fondo%>">
	<p>obteniendo un atributo de una declaracion a nivel de clase por atributo:<%=this.nombre %> </p>
		<p>obteniendo un atributo de una declaracion a nivel de clase por metodo:<%=this.getNombre() %> </p>
		  <br>
	<a href="/jspExcel/reporteExcel.jsp">ir a reporte excel</a>	  
</body>
</html>