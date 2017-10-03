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
                <h1>Gestion de Metodologias</h1>
                <p>Aqui se podra tanto ingresar una nueva metodologia como evaluar una metodologia del sistema</p>
            </header>

            <div class="row">
                <div class="col-lg-7"></div>

                <div id="success-condicion-message" class="alert alert-success" hidden="true">
                    <strong>Exito!</strong> La Condicion se ha guardado exitosamente.
                </div>
                <div id="success-metod-message" class="alert alert-success" hidden="true">
                    <strong>Exito!</strong> La Metodologia se ha guardado exitosamente.
                </div>

            </div>

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
                            <h3>Cargar Condiciones</h3>
                            <p><font size="3">Ingreso de condiciones para Metodologias</font></p>
                            <p>
                                <a id="btn-abrir-nueva-condicion" type="button" class="btn btn-primary" data-toggle="modal" data-target="#modal-nueva-condicion">Abrir modulo</a>
                            </p>
                        </div>
                    </div>
                </div>

                <div class="col-md-4 col-sm-8 hero-feature">
                    <div class="thumbnail">
                        <div class="caption">
                            <h3>Nueva Metodologia</h3>
                            <p><font size="3">Modulo de Carga de Metodologia</font></p>
                            <p>
                                <a id="btn-abrir-nueva-metodologia" type="button" class="btn btn-primary" data-toggle="modal" data-target="#modal-nueva-metod">Abrir modulo</a>
                            </p>
                        </div>
                    </div>
                </div>

                <div class="col-md-4 col-sm-8 hero-feature">
                    <div class="thumbnail">
                        <div class="caption">
                            <h3>Analizar Metodologias</h3>
                            <p><font size="3">Modulo que realiza analisis de Metodologias.</font></p>
                            <p>
                                <a id="btn-abrir-evaluar-metodologia" type="button" class="btn btn-primary" data-toggle="modal" data-target="#modal-evaluar-metod">Abrir modulo</a>
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

        <!-- ***** Modulo Nueva metodologia ***** -->
        <!-- Modal -->
        <div id="modal-nueva-condicion" class="modal fade" role="dialog">
            <div class="modal-dialog">
                <!-- Modal content-->
                <div class="modal-content">
                    <div class="modal-header">
                        <button type="button" class="close" data-dismiss="modal">&times;</button>
                        <h4 class="modal-title">Nueva Condicion</h4><br>
                        <div class="row">
                            <div class="col-xs-12">
                                <p>Codigo: <input id ="input-codigo" type="text" required="true" size="45"></p>
                            </div>
                        </div>
                        <div class="row">
                            <div class="col-xs-12">
                                <p>Nombre: <input id ="input-nombre" type="text" required="true" size="45"></p>
                            </div>
                        </div>
                        <div class="row">
                            <div class="col-xs-6">
                                <select id="list-tipos-condiciones" class="form-control" name="size"></select>
                            </div>
                            <div class="col-xs-6">
                                <p><select onChange="insertarIndicador()" id="list-indicadores" class="form-control" name="size"   ></select></p>
                            </div>
                        </div>
                        <div class="row">
                            <div class="col-xs-12">
                                <p>Formula: <textarea id="textarea-formula-condicion" class="form-control" rows="2" style="max-width:100%;"></textarea></p>
                            </div>
                        </div>
                    </div>
                    <div class="row">
                        <div class="col-xs-12">
                            <div id="warning-message" class="alert alert-warning" hidden="true">
                                <strong>Advertencia!</strong> Los campos no deben estar vacios.
                            </div>
                            <div id="syntax-error-message" class="alert alert-danger" hidden="true">
                                <strong>Error sintactico!</strong> La formula ingresada posee una expresion no valida.
                            </div>
                        </div>
                    </div>
                    <div class="modal-footer">
                        <input id="btn-crear-condicion" type="submit" class="btn btn-primary" value="Crear">
                        <button id="btn-cerrar-nueva-condicion" type="button" class="btn btn-default" data-dismiss="modal">Cerrar</button>
                    </div>
                </div>
            </div>
        </div>

        <div id="modal-nueva-metod" class="modal fade" role="dialog">
            <div class="modal-dialog">
                <!-- Modal content-->
                <div class="modal-content">
                    <div class="modal-header">
                        <button type="button" class="close" data-dismiss="modal">&times;</button>
                        <h4 class="modal-title">Nueva Metodologia</h4><br>
                        <div class="row">
                            <div class="col-xs-12">
                                <p>Codigo: <input id ="input-codigo-met" type="text" required="true" size="45"></p>
                            </div>
                            <div class="col-xs-12">
                                <p>Descripcion: <input id ="input-descripcion-met" type="text" required="true" size="45"></p>
                            </div>
                        </div>
                    </div>
                    <p style="text-indent: 10px">  Seleccione un conjunto de Condiciones </p>
                        <div class="row">
                            <div class="col-xs-12">
                                <div class="col-xs-10">
                                    <p><select id="list-condiciones" class="form-control" name="size"></select></p>
                                </div> 
                                <div class="col-xs-2">
                                    <button id="btn-agregar-condicion" class="add_field_button">Agregar</button>
                                </div> 
                            </div>
                            <div class="col-xs-12">
                                <div class="input_fields_wrap"></div> 
                             </div>
                        </div>
                    <div class="row">
                            <div class="col-xs-12">
                                <p>Formula: <textarea id="textarea" class="form-control" rows="2" style="max-width:100%;"></textarea></p>
                            </div>
                        </div>
                    
                        
                    <div class="row">
                        <div class="col-xs-12">
                            <div id="warning-message" class="alert alert-warning" hidden="true">
                                <strong>Advertencia!</strong> Los campos no deben estar vacios.
                            </div>
                        </div>
                    </div>
                    <div class="modal-footer">
                        <input id="btn-crear-metodologia" type="submit" class="btn btn-primary" value="Crear">
                        <button id="btn-cerrar-nueva-metod" type="button" class="btn btn-default" data-dismiss="modal">Cerrar</button>
                    </div>
                </div>
            </div>
        </div>

        <!-- ***** Modulo Evaluar Metodologia ***** -->
        <!-- Modal -->
        <div id="modal-evaluar-metod" class="modal fade" role="dialog">
            <div class="modal-dialog">
                <!-- Modal content-->
                <div class="modal-content">
                    <div class="modal-header">
                        <button type="button" class="close" data-dismiss="modal">&times;</button>
                        <p><h4 class="modal-title">Evaluar Metodologia</h4><p>
                        <div class="row">
                            <div class="col-xs-2">Metodologia</div>
                            <div class="col-xs-6">
                                <p><select id="list-metodologias" class="form-control" name="size" ></select></p>
                            </div>
                        </div>
                        <div class="row">
                            <div class="col-xs-12">
                                <p>Resultado: <text id="textarea-formula" class="form-control" rows="5" style="max-width:100%;"></textarea></p>
                            </div>
                        </div>
                    </div>
                    <div class="modal-footer">
                        <input id="btn-crear" type="submit" class="btn btn-primary" value="Calcular">
                        <button id="btn-cerrar-evaluar-metod" type="button" class="btn btn-default" data-dismiss="modal">Cerrar</button>
                    </div>
                </div>
            </div>
        </div>

        <!-- Script files -->
        <script src="js/vendor/jquery-3.2.1.min.js"></script>
        <script src="js/vendor/bootstrap.min.js"></script>
        <script src="js/app/eventos-metodologias.js"></script>
    </body>
</html>


