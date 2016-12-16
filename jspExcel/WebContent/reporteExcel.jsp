

<%@page import="java.util.Date"%>
<%@page import="util.FechaUtil"%>

<%@ page language="java" contentType="application/vnd-excel"%>
<%@ page errorPage="errorReporteExcel.jsp"%>



<%
	//scriptless para el cabecero response (formato y nombre de archivp)
	response.setHeader("content-disposition", "inline; filename=nombre.xls");
%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<table>
		<tr>
			<th>id</th>
			<th>nombre</th>
			<th>apellido</th>
		</tr>
		<tr>
			<td>1</td>
			<td>joel</td>
			<td>enciso</td>
		</tr>
		<tr>
			<td>fecha</td>
			<td><%=FechaUtil.formater(new Date())%></td>
			<td>fecha</td>
			<td><%=FechaUtil.formater("enciso")%></td>
		</tr>
	</table>

</body>
</html>