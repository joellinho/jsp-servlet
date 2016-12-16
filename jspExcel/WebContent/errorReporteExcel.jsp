<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page isErrorPage="true"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	ocurrio un error
	<%=exception.getMessage()%>
	<br>
	<%@include file="page/pagina1.jsp" %>
	<!-- el atributo include no requiere la ruta completa solo relativa a la carpeta -->
	<!-- los links y los form requiereo la ruta desde /applicacion/recurso -->

	<jsp:include page="page/paginadinamica.jsp">
	<jsp:param value="yellow" name="fondo"/>
	
	</jsp:include>	

</body>
</html>