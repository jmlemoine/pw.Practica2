<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>Practica #2 - 2014-0795</title>
    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.7.1/css/all.css" integrity="sha384-fnmOCqbTlWIlj8LyTjo7mOUStjsKC4pOpQbqyi7RrhN7udi9RwhKkMHpvLbHG9Sr" crossorigin="anonymous">

    <!-- Bootstrap core CSS -->
    <link href="/vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">

    <!-- Custom styles for this template -->
    <link href="/css/heroic-features.css" rel="stylesheet">

</head>


<body>

    <!-- Navigation -->
    <nav class="navbar navbar-expand-lg navbar-dark bg-success fixed-top">
        <div class="container">
            <a class="navbar-brand" href="#">Practica #2 - 2014-0795</a>
            <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarResponsive" aria-controls="navbarResponsive" aria-expanded="false" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
            </button>
            <div class="collapse navbar-collapse" id="navbarResponsive">
                <ul class="navbar-nav ml-auto">

                </ul>
            </div>
        </div>
    </nav>

    <br>

    <!-- Page Content -->
    <div class="container-mt-4">
        <a class="btn btn-success mb-1" href="/Agregar"><i class="fas fa-plus-square"></i>Agregar Estudiantes</a>

        <!-- Page Features -->
        <div class="bg-success text-center text-white">
            <#if tamanoLista>
                <table class="table">
                    <thead>
                        <tr>
                            <th>Matricula</th>
                            <th>Nombre</th>
                            <th>Apellido</th>
                            <th>Telefono</th>
                            <th>Opcion #1</th>
                            <th>Opcion #2</th>
                            <th>Opcion #3</th>
                        </tr>
                    </thead>

                    <tbody>
                        <#assign contEstudiantes = 0>

                        <#list listEstudiantes as Estudiante>
                            <tr class="animated fadeInUp">
                                <td>${Estudiante.matricula?string["0"]}</td>
                                <td>${Estudiante.nombre}</td>
                                <td>${Estudiante.apellido}</td>
                                <td>${Estudiante.telefono}</td>
                                <td><a href="/VisualizarEstudiante/${contEstudiantes}" class="btn btn-light" role="button"><i class="fas fa-eye"></i>Ver</a></td>
                                <td><a href="/Modificar/${contEstudiantes}" class="btn btn-light" role="button"><i class="fas fa-pencil-alt"></i>Editar</a></td>
                                <td><a href="/EliminarenListEstudiantes/${contEstudiantes}" class="btn btn-light" role="button"><i class="far fa-trash-alt"></i>Borrar</a></td>

                            </tr>

                                <#assign contEstudiantes++>

                        </#list>


                    </tbody>

                </table>
            </#if>

        </div>

    </div>

    <!-- Bootstrap core JavaScript -->
    <script src="vendor/jquery/jquery.min.js"></script>
    <script src="vendor/bootstrap/js/bootstrap.bundle.min.js"></script>

</body>
</html>