<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="resources/css/bootstrap.min.css">
<style type="text/css">
   img{
   width: 70px;
   height: 70px;
   border-radius: 50%;
   }
</style>
</head>
<body>
	<h1 class="text-primary">Adminstradores</h1>

	<div class="container">
		<div class="col-md-10 col-md-offset-1">
			<table class="table table-striped table-hover">
				<tr>
					<th>Nombre</th>
					<th>Correo</th>
					<th>Contraseña</th>
					<th>estado</th>
					<th>respuesta</th>
					<th>imagen</th>
				</tr>

				<c:forEach items="${adminsitradores}" var="administrador">
					<tr>
						<td><c:out value="${administrador.nombre}" /></td>
						<td><c:out value="${administrador.correo}" /></td>
						<td><c:out value="${administrador.contasena}" /></td>

						<td>
<%-- 						<c:catch var="ex"> --%>
								<c:set var="ide" value="${administrador.idPegunta}" />
								
																		 
							 <sql:query var="rs" dataSource="jdbc/joelJar">
							SELECT pregunta from pregunta where id= 2;
							 </sql:query>

								<c:forEach var="row" items="${rs.rows}">
									 		 ${row.pregunta}			 		 					
							</c:forEach>
<%-- 							</c:catch> <c:if test="${ex!=null}"> --%>
<!-- 								<div class="alert alert-warning">error conexion</div> -->
<%-- 							</c:if> --%>
							</td>

						<td><c:out value="${administrador.respuesta}" /></td>
						<td> <img  src='<c:url value="${administrador.imagen}"/>' /> </td>
					</tr>




				</c:forEach>


			</table>
		</div>


	</div>
</body>
</html>