<%@ page contentType="text/html;charset=ISO-8859-1" pageEncoding="ISO-8859-1" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="listaDenuncia" scope="request" value="${listaDenuncia}" />
<!DOCTYPE html>

<html>

<head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- Bootstrap CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
    <title>Visualizar Denuncias</title>
    <link rel="stylesheet" href="css/estiloRegistro.css"/>
</head>


<body class="container d-flex flex-column justify-content-center">
<form method="post" class="container col-lg-7 col-md-11">
    <h1 class="mt-3 mb-4">Visualizar Denuncias</h1>
	<table class="table table-striped ">
		<thead class="text-light bg-primary">
			<tr>
				<th>Tipo denuncia</th>
				<th>Fecha</th>
			</tr>
		</thead>
		<tbody>
				<c:choose>
					<c:when test="${listaDenuncia==null}">
				</tbody>
			</table>
			<div class="row mx-auto mb-4">No hay elementos para mostrar.</div>
	</c:when>
	<c:when test="${listaDenuncia!=null}">
		<c:forEach var="d" items="${listaDenuncia}">
			<tr>
				<td>${d.tipo}</td>
				<td>${d.fecha}</td>
			</tr>
		</c:forEach>
		</tbody>
		</table>

	</c:when>
	</c:choose>
</form>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>
</body>
</html>
