<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>TpIntegrador</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" href="css/bootstrap.min.css" type="text/css">
        <link href="css/heroic-features.css" rel="stylesheet">
        <link rel="stylesheet" href="css/bootstrap-datetimepicker.css" type="text/css">
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
                <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
                    <ul class="nav navbar-nav">
                        <li>
                            <a href="/TpIntegradorDDS/index.jsp">Home</a> 
                        </li>
                    </ul>
                </div>
            </div>
        </nav>

        <!-- Container -->
        <div class="container">
            <!-- Jumbotron Header -->
            <header class="jumbotron hero-spacer">
                <h1>Gestion de Cuentas</h1>
                <p>Este modulo permite la carga de cuentas empresariales y cotizaciones.</p>
            </header>

            <div class="row">
                <div class="col-lg-12">
                    <h3>¿Que desea hacer?</h3>
                </div>
            </div>

            <!-- Page Features -->
            <div class="row text-center">
                <div class="col-md-4 col-sm-8 hero-feature">
                    <div class="thumbnail">
                        <div class="caption">
                            <h1>Cargar cuentas</h1>
                            <p><font size="3">Carga de cuentas empresariales</font></p>
                            <p>
                                <!-- Dipara un modal al apretar el boton -->
                                <button type="button" class="btn btn-primary" data-toggle="modal" data-target="#modal-cargar-cuentas">
                                    Abrir
                                </button>
                            </p>
                        </div>
                    </div>
                </div>

                <div class="col-md-4 col-sm-8 hero-feature">
                    <div class="thumbnail">
                        <div class="caption">
                            <h1>Cargar Cotizaciones</h1>
                            <p><font size="3">Carga de cotizaciones de cuentas segun empresa y periodo</font></p>
                            <p>
                                <!-- Dipara un modal al apretar el boton -->
                                <button type="button" class="btn btn-primary" data-toggle="modal" data-target="#modal-cargar-cotizaciones">
                                    Abrir
                                </button>
                            </p>
                        </div>
                    </div>
                </div>

                <div class="col-md-4 col-sm-8 hero-feature">
                    <div class="thumbnail">
                        <div class="caption">
                            <h1>Consultar valores</h1>
                            <p><font size="3">Modulo de consulta de valores por criterios</font></p>
                            <p>
                                <!-- Dipara un modal al apretar el boton -->
                                <button type="button" id="btn-abrir-consultar-valores" class="btn btn-primary" data-toggle="modal" data-target="#modal-consultar-valores">
                                    Abrir 
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

        <!-- ***** Modulo Cargar cuentas ***** -->
        <!-- Modal -->
        <div id="modal-cargar-cuentas" class="modal fade" role="dialog">
            <div class="modal-dialog">
                <!-- Modal content-->
                <div class="modal-content">
                    <div class="modal-header">
                        <button type="button" class="close" data-dismiss="modal">&times;</button>
                        <h4 class="modal-title">Cargar cuentas</h4>
                    </div>
                    <form action = "fileUploadCuentas" method = "post" class = "form-horizontal" enctype="multipart/form-data">
                        <div class="modal-body">
                            <p>Ingrese un archivo en formato ".csv" para realizar la carga de nuevas cuentas.</p>
                            <input name="file" type="file" accept=".csv" required="true">
                        </div>
                        <div class="modal-footer">
                            <input type="submit" class="btn btn-primary">
                            <button type="button" class="btn btn-default" data-dismiss="modal">Cerrar</button>
                        </div>
                    </form>
                </div>
            </div>
        </div> 

        <!-- ***** Modulo Cargar cotizaciones ***** -->
        <!-- Modal -->
        <div id="modal-cargar-cotizaciones" class="modal fade" role="dialog">
            <div class="modal-dialog">
                <!-- Modal content-->
                <div class="modal-content">
                    <div class="modal-header">
                        <button type="button" class="close" data-dismiss="modal">&times;</button>
                        <h4 class="modal-title">Cargar cotizaciones</h4>
                    </div>
                    <form action = "fileUploadCotizaciones" method = "post" class = "form-horizontal" enctype="multipart/form-data">
                        <div class="modal-body">
                            <p>Ingrese un archivo en formato ".csv" para realizar la carga de cotizaciones de cuentas.</p>
                            <input name="file" type="file" accept=".csv" required="true">
                        </div>
                        <div class="modal-footer">
                            <input type="submit" class="btn btn-primary">
                            <button type="button" class="btn btn-default" data-dismiss="modal">Cerrar</button>
                        </div>
                    </form>
                </div>
            </div>
        </div>

        <!-- ***** Modulo Consultar valores ***** -->
        <!-- Modal -->
        <div id="modal-consultar-valores" class="modal fade" role="dialog">
            <div class="modal-dialog">

                <!-- Modal content-->
                <div class="modal-content">
                    <div class="modal-header">
                        <button type="button" class="close" data-dismiss="modal">&times;</button>
                        <h4 class="modal-title">Consultar valores de una cuenta <button type="button" class="btn btn-xs btn-primary" data-toggle="popover-cuenta-titulo" title="" data-content="Este modulo permite visualizar los valores de todas las cuentas asociadas a una empresa para un periodo determinado." >?</button></p</h4>
                        
                    </div>
                    <div class="modal-body">
                        
                        <div class="row">
                            <div class="col-xs-2">Empresa</div>
                            <div class="col-xs-6">
                                <p><select id="list-empresas" class="form-control" name="size" ></select></p>
                            </div>
                        </div>
                        <div class="row">
                            <div class="col-xs-2">Periodo:</div>
                            <div class="col-xs-6">
                                <div class='input-group date' id='datetimepicker'>
                                    <input type='text' class="form-control" id="input-periodo" />
                                    <span class="input-group-addon open-datetimepicker">
                                        <span class="glyphicon glyphicon-calendar">
                                        </span>
                                    </span>
                                </div>
                            </div>
                            
                        </div>
                        <br>
                        <div class="modal-footer">
                            <button id="btn-consultar" class="btn btn-primary">Consultar</button>
                            <button id="btn-cerrar-consultar-valores" type="button" class="btn btn-primary" data-dismiss="modal">Cerrar</button>
                        </div>
                        <!-- Grid table -->
                        <table class="table table-condensed" id="grilla" style="display:none">
                            <thead>
                                <tr>
                                    <th>Cuenta</th>
                                    <th>Valor</th>
                                </tr>
                            </thead>
                            <tbody id="cotizaciones">
                            </tbody>
                        </table>
                    </div>
                </div>

            </div>
        </div> 

        <!-- Script files -->
        <script src="js/vendor/jquery-3.2.1.min.js"></script>
        <script src="js/app/moment-with-locales.js"></script>
        <script src="js/vendor/bootstrap.min.js"></script>
        <script src="js/app/bootstrap-datetimepicker.js"></script>
        <script src="js/app/eventos-cuentas.js"></script>

    </body>
</html>