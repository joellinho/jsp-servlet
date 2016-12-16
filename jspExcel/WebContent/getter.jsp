<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<b>recuperando los atribuos guardados en session </b>



 
<jsp:useBean id="miarticulo" class="modelo.Articulo" scope="session"></jsp:useBean>
<!-- aquivalente a
Session session = request.getSession();
Articulo miarticulo =session.getAttribute("rectangulo");
if(articulo ==null){
articulo = new Articulo();
session.setAttribute("rectangulo");
}-->


<jsp:getProperty property="cantidad" name="miarticulo"/>
<!-- miarticulo.getCantidad(); -->
<jsp:getProperty property="precio" name="miarticulo"/>
<jsp:getProperty property="total" name="miarticulo"/>
</body>
</html>