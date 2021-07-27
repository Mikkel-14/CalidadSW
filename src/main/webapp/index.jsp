<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- Bootstrap CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
    <title>Poli-Collab LogIn</title>
    <link rel="stylesheet" href="css/estiloRegistro.css"/>
</head>
<body class="container d-flex flex-column justify-content-center">
<form method="post" class="container col-lg-6 col-xl-5 col-md-11" action="loginController">
    <h1 class="mt-2 mb-4">Inicio de Sesión</h1>
    <div class="col-12 mb-2 text-danger">${err}</div>
    <div class="form-floating mb-3">
        <input type="number" class="form-control" id="number" placeholder="201720866" name="codigoUnico"/>
        <label class="form-label" for="number">Código Único</label>
    </div>
    <div class="form-floating mb-3">
        <input type="password" class="form-control" id="password" placeholder="SecurePassword" name="password"/>
        <label class="form-label" for="password">Contraseña</label>
    </div>
    <div class="form-check form-switch mb-3">
        <input class="form-check-input" type="checkbox" id="recordar" name="recordarme">
        <label class="form-check-label" for="recordar">Recuérdame</label>
    </div>
    <div class="col-12 mb-4">
        <button type="submit" class="btn btn-primary">Iniciar Sesión</button>
    </div>
    <div>
        Eres nuevo en Poli-Colaboration? <a href="registroUsuario.jsp">Regístrate</a>
    </div>
</form>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>
</body>
</html>
