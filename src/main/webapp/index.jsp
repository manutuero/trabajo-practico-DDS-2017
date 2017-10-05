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
        <!-- Barra de navegacion -->
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
                            <a href="#">Home</a>
                        </li>
                    </ul>
                </div>
            </div>
        </nav>

        <!-- Contenido de pagina -->
        <div class="container">

            <!-- Jumbotron Header -->
            <header class="jumbotron hero-spacer">
                <h1>Bienvenido Hector!</h1>
                <p>Esta aplicacion lo ayudara en la toma de decisiones para su trabajo como asesor en inversiones.</p>
            </header>

            <hr>

            <!-- Title -->
            <div class="row">
                <div class="col-lg-12">
                    <h3>¿Que desea hacer?</h3>
                </div>
            </div>

            <!-- Page Features -->
            <div class="row text-center">

                <div class="col-md-3 col-sm-6 hero-feature">
                    <div class="thumbnail">
                        <img src="<%=request.getContextPath()%>\images\bolsa-valores.jpg" alt="http://placehold.it/800x500" >
                        <div class="caption">
                            <h3>Cuentas</h3>
                            <p>Modulo de gestion de cuentas empresariales.</p>
                            <p>
                                <a href="/TpIntegradorDDS/cuentas.jsp" class="btn btn-primary">
                                    Abrir modulo
                                </a>
                            </p>
                        </div>
                    </div>
                </div>

                <div class="col-md-3 col-sm-6 hero-feature">
                    <div class="thumbnail">
                        <img src="<%=request.getContextPath()%>\images\consulta-valores.jpeg" alt="http://placehold.it/800x500">
                        <div class="caption">
                            <h3>Consultar valores</h3>
                            <p>Modulo de consulta de valores por criterios.</p>
                            <p>
                                <!-- Dipara un modal al apretar el boton -->
                                <button type="button" class="btn btn-primary" data-toggle="modal" data-target="#modal-consultar-valores">
                                    Abrir modulo
                                </button>
                            </p>
                        </div>
                    </div>
                </div>

                <div class="col-md-3 col-sm-6 hero-feature">
                    <div class="thumbnail">
                        <img src="<%=request.getContextPath()%>\images\indicadores.png" alt="http://placehold.it/800x500">
                        <div class="caption">
                            <h3>Indicadores</h3>
                            <p>Modulo de gestion de Indicadores</p>
                            <p>
                                <a href="/TpIntegradorDDS/indicadores.jsp" class="btn btn-primary">
                                    Abrir modulo
                                </a>
                            </p>
                        </div>
                    </div>
                </div>

                <div class="col-md-3 col-sm-6 hero-feature">
                    <div class="thumbnail">
                        <img src="<%=request.getContextPath()%>\images\formulas-matematicas.jpg" alt="http://placehold.it/800x500">
                        <div class="caption">
                            <h3>Metodologias</h3>
                            <p>Modulo que permite la administracion y el uso de metodologias.</p>
                            <p>
                                <a href="/TpIntegradorDDS/metodologias.jsp" method="POST" class="btn btn-primary">Abrir modulo</a>
                            </p>
                        </div>
                    </div>
                </div>

                
            </div>        
            <hr>

            <!-- Footer -->
            <footer>
                <div class="row">
                    <div class="col-lg-12">
                        <p>Copyright &copy; Developed by Javaianos, 2017</p>
                    </div>
                </div>
            </footer>
        </div>

        <!-- ***** Modulo Consultar valores ***** -->
        <!-- Modal -->
        <div id="modal-consultar-valores" class="modal fade" role="dialog">
            <div class="modal-dialog">

                <!-- Modal content-->
                <div class="modal-content">
                    <div class="modal-header">
                        <button id="btn-consultar-valores" type="button" class="close" data-dismiss="modal">&times;</button>
                        <h4 class="modal-title">Consultar valores de una cuenta</h4>
                    </div>
                    <div class="modal-body">
                        <p>Este modulo permite visualizar los valores de todas las cuentas asociadas a una empresa para un periodo determinado.</p>
                        <div class="row">
                            <div class="col-xs-2">Seleccione empresa</div>
                            <div class="col-xs-6">
                                <p><select id="list-empresas" class="form-control" name="size" ></select></p>
                            </div>
                        </div>
                        <p>Ingrese periodo: <input id="input-periodo" name="periodo" type="text" required="true"></p>
                        <div class="modal-footer">
                            <button id="btn-consultar" class="btn btn-primary">Consultar</button>
                            <button id="btn-cerrar-calcular-valores" type="button" class="btn btn-primary" data-dismiss="modal">Cerrar</button>
                        </div>
                        <!-- Grid table -->
                        <table class="table table-condensed">
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

        <!-- ***** Modulo Carga Indicadores ***** -->
        <div id="modal-indicadores" class="modal fade" role="dialog">
            <div class="modal-dialog">
                <div class="modal-content">
                    <div class="modal-header">
                        <button type="button" class="close" data-dismiss="modal">&times;</button>
                        <h4 class="modal-title">Indicadores</h4>
                    </div>
                    <div class="modal-body">
                        <p>Este modulo permite ingresar y/o consultar un nuevo indicador. A su vez es posible ingresar </p>
                        <button id="btn-consultar" class="btn btn-primary pull-right" data-toogle="modal" data-target="#modal-visualizar-indicadores">Predefinido</button>
                        <button id="btn-consultar" class="btn btn-primary pull-left" data-toogle="modal" data-target="#modal-nuevo-indicador">Nuevo</button>
                    </div>
                    <div class="modal-footer">
                    </div>
                </div> 
            </div>
        </div>


        <script src="js/vendor/jquery-3.2.1.min.js"></script>
        <script src="js/vendor/bootstrap.min.js"></script>
        <script src="js/app/eventos-cuentas.js"></script>
    </body>
</html>

