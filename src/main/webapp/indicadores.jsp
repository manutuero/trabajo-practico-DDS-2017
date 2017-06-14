<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>TpIntegrador</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" href="css/bootstrap.min.css" type="text/css">
        <link href="css/heroic-features.css" rel="stylesheet">
    </head>
    <body>
        <nav class="navbar navbar-inverse navbar-fixed-top" role="navigation">
            <div class="container">
                <div class="navbar-header">
                    <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1"></button>
                    <a class="navbar-brand" href="#">Tp Integrador DDS</a>
                </div>
                <!-- Collect the nav links, forms, and other content for toggling -->
                <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
                    <ul class="nav navbar-nav">
                        <li>
                            <a href="/TpIntegradorDDS/index.jsp">Home</a> 
                        </li>
                    </ul>
                </div>
            </div>
        </nav>


        <div class="container">

            <!-- Jumbotron Header -->
            <header class="jumbotron hero-spacer">
                <h1>Gestion de Indicadores</h1>
                <p>Aqui se podra tanto ingresar y/o consultar un nuevo indicador como verificar un indicador del sistema</p>
            </header>

            <div class="row">
                <div class="col-lg-12">
                    <h3>¿Que desea hacer?</h3>
                </div>
            </div>

            <!-- Page Features -->
            <div class="row text-center">

                <div class="col-md-6 col-sm-8 hero-feature">
                    <div class="thumbnail">

                        <div class="caption">
                            <h1>Cargar nuevo Indicador</h1>
                            <p><font size="3">Modulo de ingreso de nuevos indicadores definidos por el usuario</font> </p>
                            <p>
                                <!-- Dipara un modal al apretar el boton -->
                                <button type="button" class="btn btn-primary" data-toggle="modal" data-target="#modal-nuevo-indi">
                                    Abrir modulo
                                </button>
                            </p>
                        </div>
                    </div>
                </div>
                <div class="col-md-6 col-sm-8 hero-feature">
                    <div class="thumbnail">

                        <div class="caption">
                            <h1>Evaluar Indicador</h1>
                            <p><font size="3">Modulo de evaluacion de indicadores existentes</font> </p>
                            <p>
                                <!-- Dipara un modal al apretar el boton -->
                                <button type="button" class="btn btn-primary" data-toggle="modal" data-target="#modal-evaluar-indi">
                                    Abrir modulo
                                </button>
                            </p>
                        </div>
                    </div>
                </div>           
            </div>

            <!-- ***** Modulo Gestionar indicadores ***** -->
            <!-- Modal -->
            <div id="modal-nuevo-indi" class="modal fade" role="dialog">
                <div class="modal-dialog">

                    <!-- Modal content-->
                    <div class="modal-content">
                        <div class="modal-header">
                            <button type="button" class="close" data-dismiss="modal">&times;</button>
                            <h4 class="modal-title">Nuevo Indicador</h4><br>
                            <div class="row">
                                <div class="col-xs-12">
                                    <p>Nombre: <input id ="input-nombre" type="text" required="true" size="45"></p>
                                </div>
                            </div>
                            <div class="row">
                                <div class="col-xs-12">
                                    <p>Formula: <textarea id="textarea-formula" class="form-control" rows="5" style="max-width:100%;"></textarea></p>
                                </div>
                            </div>
                            <div id="success-message" class="alert alert-success" hidden="true">
                                <strong>Exito!</strong> El indicador se ha guardado exitosamente.
                            </div>
                            <div id="warning-message" class="alert alert-warning" hidden="true">
                                <strong>Advertencia!</strong> Los campos no deben estar vacios.
                            </div>
                        </div>
                        <div class="modal-footer">
                            <input id="btn-crear" type="submit" class="btn btn-primary" value="Crear">
                            <button type="button" class="btn btn-default" data-dismiss="modal">Cerrar</button>
                        </div>
                    </div>
                </div>
            </div> 

            <!-- Modal -->
            <div id="modal-evaluar-indi" class="modal fade" role="dialog">
                <div class="modal-dialog">

                    <!-- Modal content-->
                    <div class="modal-content">
                        <div class="modal-header">
                            <button type="button" class="close" data-dismiss="modal">&times;</button>
                            <h4 class="modal-title">Evaluar Indicador</h4>
                        </div>
                        <div class="modal-footer">
                            <button type="button" class="btn btn-default" data-dismiss="modal">Cerrar</button>
                        </div>
                    </div>
                </div>
            </div> 

            <script src="js/vendor/jquery-3.2.1.min.js"></script>
            <script src="js/vendor/bootstrap.min.js"></script>
            <script src="js/app/eventos-indicadores.js"></script>
    </body>
</html>

