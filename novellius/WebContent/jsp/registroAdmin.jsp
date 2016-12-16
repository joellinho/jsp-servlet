<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="/resources/css/bootstrap.min.css">
<title>Insert title here</title>
<script type="text/javascript" src='<c:url value="/js/ajax.js"/>'></script>
</head>

<body>
	<br>
	<br>

	<div class="form-horizontal  col-md-offset-2 col-md-8 container">
		<h1>Registro Administrador</h1>
		<form method="post" action="?accion=registrarAdmin">
			
			<div>  <c:out value="${mensajes}"/> </div>
			<div class="form-group">
				<label class="col-md-2 label-control ">Correo:</label>
				<div class="col-md-5">
					<div class="input-group">
						<input type="text" class="form-control" name="correo"> <span
							class="input-group-addon">@</span> <input type="text"
							class="form-control" name="dominio">
					</div>
				</div>
			</div>
			
			
			<div class="form-group">
				<label class=" col-md-2 label-control">contraseña:</label>
				<div class="col-md-5">
					<input type="text" class="form-control" name="contrasena">
				</div>
			</div>
			
			<div class="form-group">
				<label class=" col-md-2 label-control">nombre:</label>
				<div class="col-md-5">
					<input type="text" class="form-control" name="nombre">
				</div>
			</div>
			
			<!-- creando el select -->
			<div class="form-group">
				<label class="label-control col-md-2">pregunta secreta:</label>
				<div class="col-md-5">

					<c:catch var="ex">
						<sql:query var="rs" dataSource="jdbc/joelJar">
					   select * from pregunta
					</sql:query>


						<select class="form-control" name="pregunta">
							<c:forEach var="row" items="${rs.rows}">
								<option value="${row.id}" label="${row.pregunta}"></option>
							</c:forEach>
						</select>

					</c:catch>
					<c:if test="${ex!=null}">
						<div class="alert">
							<c:out value="Error de la coneccion" />
						</div>
					</c:if>
				</div>
			</div>
			<!-- select creado -->
			
			
			<div class="form-group">
				<label class="label-control col-md-2">respuesta:</label>
				<div class="col-md-5">
					<input type="text" class="form-control" name="respuesta">
				</div>
			</div>
			
			
			<div class="form-group">
				<label class="label-control col-md-2">imagen:</label>
				<div class="col-md-5 form-inline">
					<input type="file"  id="file" class="form-control" >
					 <input  class="form-control" type="button" value="cargar" onclick="cargarImagen();" >
					<br>
					<div id="respuesta" style="font-weight: bold;"></div>					
				</div>
			</div>
			
			
			<div class="form-group">
				<div class="col-md-offset-2 col-md-3">
					<input type="submit" class="btn btn-primary" value="Enviar">
				</div>
			</div>
			

		</form>

	</div>



</body>
</html>