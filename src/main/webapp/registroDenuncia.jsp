<!DOCTYPE html>

<html>

<head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- Bootstrap CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
    <title>Registrar Denuncia</title>
    <link rel="stylesheet" href="css/estiloRegistro.css"/>
</head>


<body class="container d-flex flex-column justify-content-center">
<form method="post" class="container col-lg-7 col-md-11">
    <h1 class="mt-3 mb-4">Registrar Denuncia</h1>

	<div class="form-floating mt-5 mb-3">
        <select class="form-select" id="tipoDenuncia">
            <option>Acoso</option>
            <option>Maltrato</option>
        </select>
        <label for="tipoDenuncia">Tipo de denuncia</label>
    </div>


	<div class="form-group">
		<label for="exampleFormControlTextarea1">Descripci�n de la denuncia</label>
		<textarea class="form-control" id="exampleFormControlTextarea1" rows="5"></textarea>
	</div>


    <div class="form-floating mt-4 mb-3">
        <select class="form-select" id="facultad">
            <option>Facultad de Civil</option>
            <option>Facultad de Ciencias</option>
			<option>Facultad de Ciencias Administrativas</option>
			<option>Facultad de El�ctrica</option>
			<option>Facultad de Geolog�a & Petr�leos</option>
			<option>Facultad de Mec�nica</option>
			<option>Facultad de Qu�mica & Agroindustrial</option>
			<option>Facultad de sistemas</option>
			<option>ESFOT</option>
			<option>Formaci�n b�sica</option>
        </select>
        <label for="facultad">Seleccione su facultad</label>
    </div>

    <div class="col-12 mt-4">
        <button type="submit" class="btn btn-primary">Registrar Denuncia</button>
    </div>

</form>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>
</body>
</html>
