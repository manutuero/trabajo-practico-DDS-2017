<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>TpIntegrador</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" href="css/bootstrap.min.css" type="text/css">
        <link href="css/heroic-features.css" rel="stylesheet">
        <link rel="stylesheet" href="css/sweetalert2.min.css">
        <link rel="stylesheet" href="css/bootstrap-datetimepicker.min.css" type="text/css">
    </head>

    <!-- Navigation bar -->
    <nav class="navbar navbar-inverse navbar-fixed-top" role="navigation">
        <div class="container">
            <div class="navbar-header">
                <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1"></button>
                <a class="navbar-brand">Tp Integrador DDS</a>
            </div>
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
                        <li><a><span class="glyphicon glyphicon-cog"></span>  Cambiar contraseña</a></li>
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
                                <button type="button" class="btn btn-xs btn-primary" data-toggle="popover-codigo-condicion" title="Ejemplo" data-content="INOC POSITIVO" >?</button></p>
                        </div>
                    </div>
                    <div class="row">
                        <div class="col-xs-12">
                            <p>Nombre: <input id ="input-nombre" type="text" required="true" size="45">
                                <button type="button" class="btn btn-xs btn-primary" data-toggle="popover-descripcion-condicion" title="Ejemplo" data-content="Condicion donde el INOC es positivo" >?</button></p>
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
                </div>
                <div class="modal-footer">
                    <button id="btn-eliminar-condicion" style="display:none" type="submit" class="btn btn-danger pull-left" value="Borrar" style="">Eliminar</button>
                    <input id="btn-crear-condicion" type="submit" class="btn btn-primary" value="Crear">
                    <button id="btn-cerrar-nueva-condicion" type="button" class="btn btn-default" data-dismiss="modal">Cerrar</button>
                </div>
            </div>
        </div>
    </div>

    <!-- ***** Modulo de Gestion de Metodologias ***** -->
    <!-- Modal --> 
    <div id="modal-nueva-metod" class="modal fade" role="dialog">
        <div class="modal-dialog">
            <!-- Modal content-->
            <div class="modal-content">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal">&times;</button>
                    <h4 class="modal-title">Gestion Metodologia <button id="btn-mostrar-metodologias" type="button"><span class="glyphicon glyphicon-folder-open"></span> </button> 
                        <div id="div-metodologias" style="display:none;">
                            <p><select onChange="traerMetodologia()" id="list-metodologias2" class="form-control" name="size"></select></p>
                        </div></h4>
                </div>
                <div class="modal-body">
                    <div class="row">
                        <div class="col-xs-12">
                            <p>Nombre <input id ="input-codigo-met" type="text" required="true" size="45">
                                <button type="button" class="btn btn-xs btn-primary" data-toggle="popover-metodologia-nombre" title="Ayuda" data-content="Breve referencia (Ej: 'WB')" >?</button></p>
                        </div>
                        <div class="col-xs-12">
                            <p>Descripcion: <input id ="input-descripcion-met" type="text" required="true" size="45">
                                <button type="button" class="btn btn-xs btn-primary" data-toggle="popover-metodologia-descripcion" title="Ejemplo:" data-content="'Metodología Warren Buffet'" >?</button></p>
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
                    <div class="modal-footer">
                        <button id="btn-eliminar-metodologia" style="display:none" type="submit" class="btn btn-danger pull-left" value="Borrar" style="">Eliminar</button>
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
                    <h4 class="modal-title">Evaluar Metodologia
                        <button type="button" class="btn btn-content btn-primary" data-toggle="popover-evaluar-metodologia" 
                                data-content="El resultado será un listado ordenado de empresas en las que es deseable invertir,caso contrario no apareceran">?</button>
                    </h4>
                </div>
                <div class="modal-body">
                    <div class="row">
                        <div class="col-xs-2">Metodologia</div>
                        <div class="col-xs-6">
                            <p><select id="list-metodologias" class="form-control" name="size" ></select></p>
                        </div>
                    </div>
                    <div class="row" >
                        <div class="col-xs-2">Periodo</div>
                        <div class="col-xs-6">
                            <div class='input-group date' id='datetimepicker'>
                                <input type='text' class="form-control" id="input-anio" required="true">
                                <span class="input-group-addon open-datetimepicker">
                                    <span class="glyphicon glyphicon-calendar">
                                    </span>
                                </span>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="modal-footer">
                    <input id="btn-evaluar-metodologia" type="submit" class="btn btn-primary" value="Evaluar">
                    <button id="btn-cerrar-evaluar-metod" type="button" class="btn btn-default" data-dismiss="modal">Cerrar</button>
                </div>
                <!-- Grid table -->
                <div class="modal-body">

                    <table class="table table-hover" id="grilla" style="display:none">
                        <thead>
                            <tr>
                                <th>Empresa</th>
                                <th>Porcentaje de condiciones cumplidas</th>
                            </tr>
                        </thead>
                        <tbody id="resultado">
                        </tbody>
                    </table>

                </div>
            </div>
        </div>
    </div>

    <!-- Script files -->
    <script src="js/vendor/jquery.min.js"></script>
    <script src="js/vendor/moment.min.js"></script>
    <script src="js/vendor/bootstrap.min.js"></script>
    <script src="js/vendor/bootstrap-datetimepicker.min.js"></script>
    <script src="js/app/eventos-metodologias.js"></script>
    <script src="js/vendor/sweetalert2.min.js"></script>
</html>


