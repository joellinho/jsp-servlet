<%@page import="java.beans.Beans"%>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>Insert title here</title>
</head>
<body>
	valor base del objeto request que sera añadido al bean: base :
	<%=request.getParameter("baseform")%>
	altura:
	<%=request.getParameter("alturaform")%>
	<jsp:useBean id="rectanguro" class="beans.Rectangulo" scope="session" />
<!-- los parametros que fueron enviados por el reqest desde index se almacenan hacia el bean  en el set properto y el atributo param
 -->
	<jsp:setProperty property="base" param="baseform" name="rectangulo" />

	<jsp:setProperty property="altura" param="alturaform" name="rectangulo" />
</body>
</html>