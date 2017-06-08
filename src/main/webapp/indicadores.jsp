<%-- 
    Document   : indicadores
    Created on : May 28, 2017, 11:35:04 PM
    Author     : AdminDDS
--%>

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
                            <!--harcodeado no tengo idea como se hace-->
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
                            <h1>Nuevo Indicador</h1>
                            <p><font size="3">Modulo de ingreso de Indicador </font> </p>
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
                            <p><font size="3">Modulo de consulta de Idicadores del Sistema</font> </p>
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
            
                    <!-- ***** Modulo Cargar cuentas ***** -->
        <!-- Modal -->
        <div id="modal-nuevo-indi" class="modal fade" role="dialog">
            <div class="modal-dialog">

                <!-- Modal content-->
                <div class="modal-content">
                    <div class="modal-header">
                        <button type="button" class="close" data-dismiss="modal">&times;</button>
                        <h4 class="modal-title">Nuevo Indicador</h4>
                    </div>
                    <div class="modal-footer">
                        <input type="submit" class="btn btn-primary">
                        <button type="button" class="btn btn-default" data-dismiss="modal">Cerrar</button>
                    </div>
                </div>
           </div>
        </div> 

                            <!-- ***** Modulo Cargar cuentas ***** -->
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
        <script src="js/app/eventos.js"></script>
    </body>
</html>

