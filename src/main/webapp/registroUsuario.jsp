<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- Bootstrap CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
    <title>Registro de Usuarios</title>
    <link rel="stylesheet" href="css/estiloRegistro.css"/>
</head>
<body class="container d-flex flex-column justify-content-center">
<form method="post" class="container col-lg-7 col-md-11">
    <h1 class="mt-2 mb-4">Registro de usuario</h1>
    <div class="form-floating mb-3">
        <input type="number" class="form-control" id="codigoUnico" placeholder="202114788" name = "codigoUnico"/>
        <label class="form-label" for="codigoUnico">Código Único</label>
    </div>
    <div class="form-floating mb-3">
        <input type="text" class="form-control" id="nombre" placeholder="Anita" name="nombre"/>
        <label class="form-label" for="nombre">Nombre</label>
    </div>
    <div class="form-floating mb-3">
        <input type="text" class="form-control" id="apellido" placeholder="Ocassio" name="apellido"/>
        <label class="form-label" for="apellido">Apellido</label>
    </div>
    <div class="form-floating mb-3">
        <input type="email" class="form-control" id="email" placeholder="nombre.apellido@epn.edu.ec" name="email"/>
        <label class="form-label" for="email">E-Mail</label>
    </div>
    <div class="form-floating mb-3">
        <input type="password" class="form-control" id="password" placeholder="SecurePassword" name="password"/>
        <label class="form-label" for="password">Contraseña</label>
    </div>
    <div class="form-floating mb-3">
        <select class="form-select" id="rol" name="rol">
            <option value="administrador">Administrador</option>
            <option value="usuario">Usuario</option>
        </select>
        <label for="rol">Seleccione un rol</label>
    </div>
    <div class="col-12">
        <button type="submit" class="btn btn-primary">Registrarse</button>
    </div>
</form>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>
</body>
</html>
