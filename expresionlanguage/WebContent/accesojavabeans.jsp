<%@page import="java.beans.Beans"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
<title>Insert title here</title>
</head>
<body>
<jsp:useBean id="rectangulo" class="beans.Rectangulo" scope="session"/>
<jsp:setProperty property="*" name="rectangulo"/><!-- con property =* se llenan todos datos que estan en el request a las propiedades de la clase pero que se llamen iguales -->
valores mostrados con el  el:
<br/>
base:${rectangulo.base}
<br/>
altura:${rectangulo.altura}
<br/>
area:${rectangulo.area}
<br/>
<a href="index.jsp">regreso al inicio</a>
</body>
</html>
<!-- con el expresion language se puede acceder solo acceder a expresiones
ya sean de objetos implicitos o clases realizadas pero previamente llamadas al jsp con usebean

 -->