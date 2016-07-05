<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@ page import="ejemploexceljsp.conversiones , java.util.Date" %>
<%@ page contentType="application/vnd.ms-excel"%>


<%
	//response.setContentType(arg0);	
	String nombreArchivo = "reporte.xls";
	response.setHeader("Content-Disposotion", "inline;filename" + nombreArchivo);
%>


<%@page errorPage="/WEB-INF/manejoerrores.jsp" %>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
<title>Insert title here</title>
</head>
<body>
	<table>
		<tr>
			<th>curso</th>
			<th>descripcion</th>
			<th>fecha inicio</th>
		</tr>
		<tr>
			<th>java se </th>
			<th>aprenderemos java</th>
			<th><%=conversiones.formatear(new Date())  %></th>
		</tr>
		<tr>
			<th>spring </th>
			<th>framewokr ioc</th>
			<th><%=conversiones.formatear("500")  %></th>
		</tr>

	</table>
</body>
</html>