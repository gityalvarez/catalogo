<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1 " />
<meta http-equiv="X-UA-Compatible" content="IE-Edge" />
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" />
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<!-- <script src="/CatalogoDeServiciosWeb/WebContent/WEB-INF/resources/js/index.js" type="text/javascript"></script> -->
<title>Catalogo de Servicios - Home</title>
</head>
<body>
	<div class="container">
		<div class="navbar navbar-inverse">
			<div class="navbar-brand">Catalogo de Servicios</div>
		</div>
		<div class="row">
			<div class="col-sm-3">
				<!-- <div class="container"> -->
				<h3 align="center">Agregar Servicio</h3>
				<form class="form-horizontal" action="CatalogoDeServiciosServlet" method="POST">
					<div class="form-group">
						<label class="control-label col-sm-6" for="nombreOrganizacion">Organizacion:</label>
						<div class="col-sm-6">
							<input type="text" class="form-control" id="nombreOrganizacion"
								placeholder="Ingrese organizacion" name="nombreOrganizacion">
						</div>	
						<!-- <input type="hidden" id="idOrganizacion" name="idOrganizacion"/> -->
					</div>
					<div class="form-group">
						<label class="control-label col-sm-6" for="idServicio">ID Servicio:</label>
						<div class="col-sm-6">
							<input type="text" class="form-control" id="idServicio"
								placeholder="Ingrese servicio" name="idServicio">
						</div>	
						<!-- <input type="hidden" id="idOrganizacion" name="idOrganizacion"/> -->
					</div>
					<div class="form-group">
						<label class="control-label col-sm-6" for="descripcion">Descripcion:</label>
						<div class="col-sm-6">
							<textarea class="form-control" rows="5" id="descripcion"
								placeholder="Ingrese descripcion" name="descripcion"></textarea>
						</div>
					</div>
					<div class="form-group">
						<label class="control-label col-sm-6" for="wsdl">Wsdl:</label>
						<div class="col-sm-6">
							<input type="text" class="form-control" id="wsdl"
								placeholder="Ingrese wsdl" name="wsdl">
						</div>
					</div>
					<div class="form-group">
						<label class="control-label col-sm-6" for="disponibilidad">Disponibilidad:</label>
						<div class="col-sm-6">
							<input type="text" class="form-control" id="disponibilidad"
								placeholder="Ingrese disponibilidad" name="disponibilidad">
						</div>
						<!-- 
						<label class="radio-inline"> <input type="radio"
							name="optradio">Si
						</label> <label class="radio-inline"> <input type="radio"
							name="optradio">No
						</label>
						 -->
					</div>
					<div class="form-group">
						<div class="col-sm-offset-2 col-sm-10">
							<input type="submit" class="btn btn-default" id="btnAccion" name="btnAccion" value="Agregar
								Servicio"/>
						</div>
					</div>
				</form>
				<!-- </div> -->
			</div>
			<div class="col-sm-1"></div>
			<div class="col-sm-8">
				<h3 align="center">Lista de Servicios</h3>
				<br> <input class="form-control" id="myInput" type="text"
					placeholder="Buscar por nombre de Organizacion.."> <br>
				<table class="table table-bordered table-striped">
					<thead>
						<tr>
							<th>Organizacion</th>
							<th>Descripcion</th>
							<th>Wsdl</th>
							<th>Disponibilidad</th>
							<th></th>
							<th></th>
						</tr>
					</thead> 
					<tbody id="myTable">
						<c:forEach var="map" items="${lstServicios}">
						<tr>	
							<td>${map.value.organizacion.nombre }</td>
							<td>${map.value.descripcion}</td>
							<td><a href='${map.value.wsdl }'><span class="glyphicon glyphicon-download"></span></a>
							<td>${map.value.disponibilidad }</td>
							<td id="editButton"><a href="#"><span class="glyphicon glyphicon-edit"></span></a>
							</td>
							<td id="deleteButton"><a href="#"><span class="glyphicon glyphicon-trash"></span></a>
							</td>
						</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
		</div>
		<div class="page-footer font-small stylish-color-dark pt-4 mt-4">
			<!--Copyright-->
			<div class="footer-copyright py-3 text-center">
				© 2018 Copyright: <a href="#">Taller de Sistemas Empresariales </a>
			</div>
		</div>
	</div>
	<script>
		$(document).ready(function() {
			$("#myInput").on("keyup", function() {
				var value = $(this).val().toLowerCase();
				$("#myTable tr").filter(function() {
					$(this).toggle($(this).text().toLowerCase().indexOf(value) > -1)
				});
			});

		    $("#editButton").click(function(){
		    	$("#organizacion").val("1");
		    	$("#descripcion").val("2");
		    	$("#wsdl").val("3");
				$("#btnAccion").val("Actualizar Servicio");
		    });
		});
	</script>
</body>
</html>