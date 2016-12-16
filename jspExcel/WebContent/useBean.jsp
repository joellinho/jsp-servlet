<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<a href="setter.jsp"> modificar valores de javaBean</a>
	<a href="getter.jsp">obtener los valores de javaBean</a>
	<br>

	<form action="getterParameterBean.jsp">

		<label>ingresa cantidad</label> <input type="text" name="cantidad">
		<br> <label>ingresa precio</label> <input type="text"
			name="precio"> <br> <input type="submit" value="enviar">
	</form>
	<br> usando el expresion langage :
	<br> nombre de la aplicacion con el :
	${pageContext.request.contextPath}
	
	<br> nombre del id de session con el : ${cookie.JSESSIONID.value}

	<br> nombre del navegador con el : ${header["User-Agent"]}

</body>
</html>