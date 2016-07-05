<%@page import="java.beans.Beans"%>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>Insert title here</title>
</head>
<body>

<jsp:useBean id="rectangulo" class="beans.Rectangulo" scope="session" />
base<jsp:getProperty property="base" name="rectangulo"/>
altura<jsp:getProperty property="base" name="rectangulo"/>
area <jsp:getProperty property="area" name="rectangulo"/>

<a href="index.jsp">regresar al inicio</a>
</body>
</html>