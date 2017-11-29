<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>TpIntegrador</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" href="css/bootstrap.min.css" type="text/css">
        <link href="css/heroic-features.css" rel="stylesheet">
        <link rel="stylesheet" href="css/bootstrap-datetimepicker.min.css" type="text/css">
        <link rel="stylesheet" href="css/sweetalert2.min.css">
    </head>
    <body>
        <!-- Navigation bar -->
        <nav class="navbar navbar-inverse navbar-fixed-top" role="navigation">
            <div class="container">
                <div class="navbar-header">
                    <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1"></button>
                    <a class="navbar-brand" href="#">Tp Integrador DDS</a>
                </div>
                <!-- Collect the nav links, forms, and other content for toggling -->

                <ul class="nav navbar-nav">
                    <form action="IndexServlet.jsp" class="nav navbar-nav" method="post">
                        <button type="submit" class="btn btn-link navbar-btn">Home </button>
                    </form>
                </ul>


                <ul class="nav navbar-nav navbar-right">
                    <li class="dropdown">
                        <a id="a-user" href="#" class="dropdown-toggle" data-toggle="dropdown">
                            <span class="glyphicon glyphicon-user"></span> 
                        </a>
                        <ul class="dropdown-menu">
                            <li><a href=""><span class="glyphicon glyphicon-cog"></span>  Cambiar contraseña</a></li>
                            <li class="divider"></li>
                            <li><a href="/TpIntegradorDDS/login.jsp"><span class="glyphicon glyphicon-off"></span>  Cerrar Sesión</a></li>
                        </ul>
                    </li>
                </ul>
            </div>
        </nav>

        <!-- Container -->
        <div class="container">
            <!-- Jumbotron Header -->
            <header class="jumbotron hero-spacer">
                <h1>Gestion de Indicadores</h1>
                <p>Aqui se podra tanto ingresar y/o consultar un nuevo indicador como verificar un indicador del sistema</p>
            </header>

            <!-- A success message -->

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
                            <h1>Administrar Indicadores</h1>
                            <p><font size="3">Modulo de ingreso de nuevos indicadores definidos por el usuario</font> </p>
                            <p>
                                <!-- Dipara un modal al apretar el boton -->
                                <button id="btn-abrir-nuevo-indicador" type="button" class="btn btn-primary" data-toggle="modal" data-target="#modal-nuevo-indi">
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
                                <button id="btn-abrir-evaluar-indicador" type="button" class="btn btn-primary" data-toggle="modal" data-target="#modal-evaluar-indi">
                                    Abrir modulo
                                </button>
                            </p>
                        </div>
                    </div>
                </div>           
            </div>

            <!-- Page Footer -->
            <footer>
                <div class="row">
                    <div class="col-lg-12">
                        <hr>
                        <p>Copyright &copy; Developed by Javaianos, 2017</p>
                    </div>
                </div>
            </footer>
        </div>

        <!-- ***** Modulo admin Indicador ***** -->
        <!-- Modal -->
        <div id="modal-nuevo-indi" class="modal fade" role="dialog">
            <div class="modal-dialog">
                <!-- Modal content-->
                <div class="modal-content">
                    <div class="modal-header">
                        <button type="button" class="close" data-dismiss="modal">&times;</button>
                        <h4 class="modal-title">Gestion de Indicadores <!--<button id="btn-mostrar-indicadores" type="button"><span class="glyphicon glyphicon-folder-open"></span> </button>--> 
                            <div id="div-indicadores" style="display:inline-block;">
                                <p><select onChange="traerIndicador()" id="list-indicadores2" class="form-control" name="size"></select></p>
                            </div> </h4>
                    </div>
                    <div class="modal-body">
                        <div class="row">
                            <div class="col-xs-12">
                                <p>Codigo: <input id ="input-codigo" type="text" required="true" size="20">
                                    <button type="button" class="btn btn-xs btn-primary" data-toggle="popover-codigo-indicador" title="Ayuda" data-content="Breve referencia (Ej: 'IN')" >?</button></p>

                                </p>
                                <p>Nombre: <input id ="input-nombre" type="text" required="true" size="45">
                                    <button type="button" class="btn btn-xs btn-primary" data-toggle="popover-nombre-indicador" title="Ejemplo:" data-content="'Ingreso Neto'" >?</button></p>
                                </p>
                            </div>
                        </div>
                        <div class="row">
                            <div class="col-xs-12">
                                <p>Formula: 
                                    <button type="button" class="btn btn-xs btn-primary" data-toggle="popover-formula-indicador" title="Ayuda" data-content="Cálculo deseado formado por cuentas y/o indicadores (Ej: 'IN*5')" >?</button></p>
                                </p>
                                <textarea id="textarea-formula" class="form-control" rows="5" style="max-width:100%;"></textarea>
                            </div>
                        </div>

                    </div>
                    <div class="modal-footer">
                        <button id="btn-eliminar-indicador" style="display:none" type="submit" class="btn btn-danger pull-left" value="Borrar" style="">Eliminar</button>
                        <input id="btn-crear" type="submit" class="btn btn-primary" value="Crear">
                        <button id="btn-cerrar-nuevo-indicador" type="button" class="btn btn-default" data-dismiss="modal">Cerrar</button>
                    </div>
                </div>
            </div>
        </div>
    </div>

    <!-- ***** Modulo Evaluar Indicador ***** -->
    <!-- Modal -->
    <div id="modal-evaluar-indi" class="modal fade" role="dialog">
        <div class="modal-dialog">
            <!-- Modal content-->
            <div class="modal-content">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal">&times;</button>
                    <p><h4 class="modal-title">Evaluar Indicador</h4><p>
                </div>
                <div class="modal-body">
                    <div class="row">
                        <div class="col-xs-2">Indicador</div>
                        <div class="col-xs-6">
                            <p><select id="list-indicadores" class="form-control" name="size" ></select></p>
                        </div>
                    </div>
                    <div class="row">
                        <div class="col-xs-2">Periodo:</div>
                        <div class="col-xs-6">
                            <div class='input-group date' id='datetimepicker'>
                                <input type='text' class="form-control" id="input-anio">
                                <span class="input-group-addon open-datetimepicker">
                                    <span class="glyphicon glyphicon-calendar">
                                    </span>
                                </span>
                            </div>
                        </div>

                    </div>

                    <br>
                    <div class="row">
                        <div class="col-xs-2">Empresa</div>
                        <div class="col-xs-6">
                            <p><select id="list-empresas" class="form-control" name="size" ></select></p>
                        </div>
                    </div>
                    <div class="row">
                        <div class="col-xs-12">
                            <p>Resultado: <text id="text-resultado" class="form-control" rows="5" style="max-width:100%;"></text></p>
                        </div>
                    </div>

                </div>
                <div class="modal-footer">
                    <input id="btn-calcular" type="submit" class="btn btn-primary" value="Calcular">
                    <button id="btn-cerrar-evaluar-indi" type="button" class="btn btn-default" data-dismiss="modal">Cerrar</button>
                </div>
            </div>
        </div>
    </div>
    <p id="info-indicadores" hidden>${messageIndicadores}</p>

    <!-- Script files -->
    <script src="js/vendor/jquery.min.js"></script>
    <script src="js/vendor/moment.min.js"></script>
    <script src="js/vendor/bootstrap.min.js"></script>
    <script src="js/vendor/bootstrap-datetimepicker.min.js"></script>
    <script src="js/app/eventos-indicadores.js"></script>
    <script src="js/vendor/sweetalert2.min.js"></script>
</body>
</html>

