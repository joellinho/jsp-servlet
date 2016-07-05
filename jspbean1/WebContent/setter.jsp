<%@page import="java.beans.Beans"%>
<html>
<head>
<title>Insert title here</title>
</head>
<body>
	<%
		int base = 5;
		int altura = 10;
	%>
	<jsp:useBean id="rectangulo" scope="session" class="beans.Rectangulo" />

	<jsp:setProperty property="base" value="<%=base%>" name="rectangulo" />

	<jsp:setProperty property="altura" value="<%=altura%>"
		name="rectangulo" />


</body>
</html>