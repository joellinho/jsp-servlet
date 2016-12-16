<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="/resources/css/bootstrap.min.css">
<title>Insert title here</title>

<style type="text/css">
.form-container {
	margin-top: 60px;
}

.alert {
	margin-bottom: -50px;
}
</style>


</head>
<body>
	<h1 class="text-primary">Inicion de session</h1>
<%-- 	<%=session.getAttribute("usuario")%> --%>

	<div class="form-horizontal  col-md-7 col-md-offset-3 container">

		<!-- mostrar alerta bootstrap si hay error -->
		<%-- 		<% --%>
		<!-- 		String error = (String) request.getAttribute("error"); if (error != -->
		<!-- 		null) { %> -->
		<%-- 		<div class="alert alert-danger">${error}</div> --%>
		<%-- 		<% --%>
		<!-- 			} -->
		<!-- 		%> -->



		<!-- mostrar con jstl -->
		<c:if test="${error!=null}">
			<div class="alert alert-danger">
				<c:out value="${error}">

				</c:out>
			</div>
		</c:if>


		<div class="form-container">

<%-- 			<c:forEach items="${cookie}" var="var"> --%>
<%-- <%-- 				<c:if test="${coockie!=null}">  --%>
<%-- 												<c:set scope="page" value="${coockie.getValue()}" var="user"></c:set> --%>
<%-- 					<c:out value="${var}" /> --%>
<%-- <%-- 				</c:if> --%>

<%-- 			</c:forEach> --%>



			<form method="post" action="?accion=iniciarSession">
				<div class="form-group ">

										<%
											String user = "";
										
							
											Cookie[] cookies = request.getCookies();
											if(cookies!=null){
											for (Cookie cook : cookies) {
												
												if (cook.getName().equals("usuario")) {
													user = cook.getValue();
												}
											}
											}
										%>





					<label class="col-md-2 control-label">usiario:</label>
					<div class="col-md-5">
						<input type="text" class="form-control" name="usuario" value="<%=user%>">

					</div>

				</div>
				<div class="form-group">
					<label class="col-md-2 control-label"> Password</label>
					<div class="col-md-5">
						<input type="password" class="form-control" name="password">
					</div>

				</div>

				<div class="form-group">

					<div class="col-md-5 col-md-offset-2">
						<input type="checkbox" checked="checked" name="recuerdame">
						Recordar mis datos</input>
					</div>
				</div>

				<div class="form-group">
					<div class="col-md-3 col-md-offset-2">
						<input type="hidden" value="iniciarSession" name="accion">
						<input type="submit" class="btn btn-primary" value="enviar">
					</div>

				</div>
				
	  
			</form>
		</div>
	</div>
</body>
</html>