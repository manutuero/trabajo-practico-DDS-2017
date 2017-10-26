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
            <h1>Administracion de Metodologias</h1>
            <p>Aqui se podra tanto ingresar, editar y/o eliminar una metodologia como evaluar una metodologia del sistema</p>
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
                        <h3>Gestion Condiciones</h3>
                        <p><font size="3">Alta, Baja y Modificacion de Condiciones para Metodologias</font></p>
                        <p>
                            <a id="btn-abrir-nueva-condicion" type="button" class="btn btn-primary" data-toggle="modal" data-target="#modal-nueva-condicion">Abrir modulo</a>
                        </p>
                    </div>
                </div>
            </div>

            <div class="col-md-4 col-sm-8 hero-feature">
                <div class="thumbnail">
                    <div class="caption">
                        <h3>Gestion de Metodologias</h3>
                        <p><font size="3">Modulo de Edicion de Metodologia</font></p>
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
                            <a id="btn-abrir-evaluar-metodologia" type="button" class="btn btn-primary" data-toggle="modal" data-target="#modal-evaluar-metodologia">Abrir modulo</a>
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

    <!-- ***** Modulo Nueva condicion ***** -->
    <!-- Modal -->
    <div id="modal-nueva-condicion" class="modal fade" role="dialog">
        <div class="modal-dialog">
            <!-- Modal content-->
            <div class="modal-content">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal">&times;</button>
                    <h4 class="modal-title">Gestion de Condiciones <button id="btn-mostrar-condiciones" type="button"><span class="glyphicon glyphicon-folder-open"></span> </button> 
                        <div id="div-condiciones" style="display:none;">
                            <p><select onChange="traerCondicion()" id="list-condiciones" class="form-control" name="size"></select></p>
                        </div> </h4>
                </div>
                <div class="modal-body">
                    <div class="row">
                        <div class="col-xs-12">
                            <p>Codigo: <input id ="input-codigo" type="text" required="true" size="45"> 
                                <button type="button" class="btn btn-xs btn-primary" data-toggle="popover-codigo-condicion" title="Proximamente" data-content="Ejemplo" >?</button></p>

                        </div>
                    </div>
                    <div class="row">
                        <div class="col-xs-12">
                            <p>Nombre: <input id ="input-nombre" type="text" required="true" size="45">
                                <button type="button" class="btn btn-xs btn-primary" data-toggle="popover-descripcion-condicion" title="Proximamente" data-content="Ejemplo" >?</button></p>
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
                            <p>Formula:    <button type="button" class="btn btn-xs btn-primary" data-toggle="popover-formula-condicion" title="Ejemplo:" data-content="IngresoNeto > 1000000" >?</button></p>
                            <textarea id="textarea-formula-condicion" class="form-control" rows="2" style="max-width:100%;"></textarea>
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
                    <h4 class="modal-title">Gestion Metodologia <button id="btn-mostrar-metodologias" type="button"><span class="glyphicon glyphicon-folder-open"></span> </button> </h4>
                </div>
                <div class="modal-body">
                    <div class="row">
                        <div class="col-xs-12">
                            <p>Nombre <input id ="input-codigo-met" type="text" required="true" size="45">
                                <button type="button" class="btn btn-xs btn-primary" data-toggle="popover-metodologia-nombre" title="Proximamente" data-content="Ejemplo" >?</button></p>
                        </div>
                        <div class="col-xs-12">
                            <p>Descripcion: <input id ="input-descripcion-met" type="text" required="true" size="45">
                                <button type="button" class="btn btn-xs btn-primary" data-toggle="popover-metodologia-descripcion" title="Proximamente" data-content="Ejemplo" >?</button></p>
                        </div>
                    </div>
                    <p style="text-indent: 10px">  Seleccione un conjunto de Condiciones </p>
                    <div class="row">
                        <div class="col-xs-12">
                            <div class="col-xs-10">
                                <p><select id="list-condiciones2" class="form-control" name="size"></select></p>
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
    </div>

    <!-- ***** Modulo Evaluar Metodologia ***** -->
    <!-- Modal -->
    <div id="modal-evaluar-metodologia" class="modal fade" role="dialog">
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
                        <div class="col-xs-2">Empresas</div>
                        <div class="col-xs-6">
                            <p><select id="list-empresas" class="form-control" name="size" ></select></p>
                        </div>
                    </div>
                    <div class="row">
                        <div class="col-xs-2">Año</div>
                        <div class="col-xs-10"><p><input id="input-anio" type="text" required="true" size="20"></p></div>
                    </div>
                </div>
                <div class="modal-footer">
                    <input id="btn-evaluar-metodologia" type="submit" class="btn btn-primary" value="Evaluar">
                    <button id="btn-cerrar-evaluar-metod" type="button" class="btn btn-default" data-dismiss="modal">Cerrar</button>
                </div>
                <!-- Grid table -->
                <table class="table table-condensed" id="grilla" style="display:none">
                    <thead>
                        <tr>
                            <th>Empresa</th>
                            <th>Valor</th>
                        </tr>
                    </thead>
                    <tbody id="resultado">
                    </tbody>
                </table>
            </div>
        </div>
    </div>

    <!-- Script files -->
    <script src="js/vendor/jquery-3.2.1.min.js"></script>
    <script src="js/vendor/bootstrap.min.js"></script>
    <script src="js/app/eventos-metodologias.js"></script>
</html>


