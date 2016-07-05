<%@page isErrorPage="true"%>
<%@page import="java.io.*"%>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>Insert title here</title>
<script type="text/javascript"
	src="<%=request.getContextPath()%>/recursos/funciones.js"></script>
</head>
<body>
	errores:
	<%=exception.getMessage()%>
	<a href="<%=request.getContextPath()%>/index.jsp">volver al index</a>
	<a href="#" onclick="cambio('mensaje1')">ver detalles</a>
	<br/>
	<div id="mensaje1" style="visibility: hidden">
		<pre>
<%
	exception.printStackTrace(new PrintWriter(out));
%>

</pre>
	</div>

</body>
</html>