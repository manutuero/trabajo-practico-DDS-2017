function initListaIndicadores() {
    var listaIndicadores = $('#list-indicadores');

    listaIndicadores.empty();
    listaIndicadores.append('<option value="" disabled selected>Seleccione un indicador</option>');

    var data = {
        usuario: getCookie("user")
    };

    $.ajax({
        url: 'http://localhost:8084/TpIntegradorDDS/api/indicadores',
        type: 'GET',
        data: data,
        success: function (indicadores) {
            $.each(indicadores, function (indice, indicador) {
                listaIndicadores.append('<option value="' + indicador.codigo + '">' + indicador.nombre + '</option>');
            });
        }
    });
}
;

function initListaCondiciones(unaLista) {

    var listaCondiciones = unaLista;

    listaCondiciones.empty();
    listaCondiciones.append('<option value="" disabled selected>Seleccione una Condicion</option>');



    var data = {
        usuario: getCookie("user")
    };
    $.ajax({
        url: 'http://localhost:8084/TpIntegradorDDS/api/condiciones',
        type: 'GET',
        data: data,
        success: function (condiciones) {
            $.each(condiciones, function (indice, condicion) {
                listaCondiciones.append('<option value="' + condicion.codigo + '">' + condicion.nombre + '</option>');
            });
        }
    });
}
;

function initListaTipoCondiciones() {
    var listaTiposCondiciones = $('#list-tipos-condiciones');

    listaTiposCondiciones.empty();
    listaTiposCondiciones.append('<option value="" disabled selected>Seleccione Tipo de Condicion</option>');
    listaTiposCondiciones.append('<option>Taxativa</option>');
    listaTiposCondiciones.append('<option>Prioritaria</option>');

}

function initListaMetodologias(lista) {

    var listaMetodologias = lista;

    listaMetodologias.empty();
    listaMetodologias.append('<option value="" disabled selected>Seleccione una metodologia</option>');

    var data = {
        usuario: getCookie("user")
    };

    $.ajax({
        url: 'http://localhost:8084/TpIntegradorDDS/api/metodologias',
        type: 'GET',
        data: data,
        success: function (metodologias) {
            $.each(metodologias, function (indice, metodologia) {
                listaMetodologias.append('<option value="' + metodologia.codigo + '">' + metodologia.descripcion + '</option>');
            });
        }
    });
}
;

function agregarCondicion() {
    var max_fields = 10; //maximum input boxes allowed
    var wrapper = $(".input_fields_wrap"); //Fields wrapper

    var x = 0; //initlal text box count
    $('.add_field_button').click(function (e) { //on add input button click
        e.preventDefault();
        if (x < max_fields) { //max input box allowed
            x++; //text box increment
            $(wrapper).append('<div class="btn-group"><button id="uno" class="btn btn-info btn-lg" value="' + $('#list-condiciones2 option:selected').val() +
                    '">' + $('#list-condiciones2 option:selected').text() + '</button><button id="remove" type="button" class="btn btn-danger btn-lg" title="Eliminar condicion">x</button><br></div>');
        }
    });

    $(wrapper).on("click", "#remove", function (e) { //user click on remove text
        e.preventDefault();
        $(this).parent('div').remove();
        x--;
    });


}
;

function insertarIndicador() {
    $('#textarea-formula-condicion').val($('#list-indicadores').val());
}
;
function traerCondicion() {
    var codigo = $('#list-condiciones').val();
    var data = {
        codigo: codigo
    };

    $.ajax({
        url: 'http://localhost:8084/TpIntegradorDDS/api/condicion',
        type: 'GET',
        data: data,
        success: function (condicion) {
            $('#input-codigo').val(condicion.codigo);
            $('#input-codigo').attr('readonly', true);
            $('#input-nombre').val(condicion.nombre);
            $('#textarea-formula-condicion').val(condicion.formula);
            $('#btn-eliminar-condicion').css('display', 'inline-block');
            $('#btn-crear-codicion').val("Guardar");
            //$('#list-tipos-condiciones').val();
        }
    });
}
;

function validarIngresoNuevaCondicion() {
    $('#btn-crear-condicion').click(function () {
        cleanResponses();

        var codigo = $('#input-codigo').val();
        var nombre = $('#input-nombre').val();
        var formula = $('#textarea-formula-condicion').val();
        var tipo = $('#list-tipos-condiciones').val();
        var url;

        if (tipo === 'Taxativa')
        {
            url = "http://localhost:8084/TpIntegradorDDS/api/nueva-condicion-taxativa";
        } else
        {
            url = "http://localhost:8084/TpIntegradorDDS/api/nueva-condicion-prioritaria";
        }

        if (nombre === '' || formula === '') {
            swal(
                    'Advertencia',
                    'Los campos no deben estar vacios.',
                    'warning'
                    );
        } else {

            var data = {
                codigo: codigo,
                nombre: nombre,
                formula: formula,
                usuario: getCookie("user")
            };

            $.ajax({
                url: url,
                type: 'POST',
                data: JSON.stringify(data),
                dataType: 'json',
                contentType: 'application/json',
                accept: 'application/json',
                success: function (response) {
                    if (response.resultado === "0") {
                        cleanResponses();
                        cleanForm();
                        $('#modal-nueva-condicion').modal("hide");
                        $('#textarea-formula-condicion').val("");
                        $('#div-condiciones').css('display', 'none');
                        swal(
                                'Bien hecho!',
                                'La Condicion ha sido guardada correctamente!',
                                'success'
                                );
                    }
                    if (response.resultado === "1") {
                        cleanResponses();
                        swal(
                                'La Condicion NO fue guardada',
                                'La formula ingresada posee errores de sintaxis',
                                'error'
                                );
                    }
                    if (response.resultado === "2") {
                        cleanResponses();
                        swal(
                                'El Indicador NO fue guardado',
                                'La formula ingresada posee cuentas o indicadores no existentes',
                                'error'
                                );
                    }
                }
            });
        }
    });
}
;

function validarIngresoNuevaMetodologia() {
    $('#btn-crear-metodologia').click(function () {
        cleanResponses();

        var codigo = $('#input-codigo-met').val();
        var descripcion = $('#input-descripcion-met').val();
        var usuario = getCookie("user");
        var condiciones = [];

        $('.btn-info').each(function ()
        {
            condiciones.push($(this).val());
        });

        if (codigo === '' || descripcion === '') {
            swal(
                    'Advertencia',
                    'Los campos no deben estar vacios.',
                    'warning'
                    );
        } else {

            var data = {
                codigo: codigo,
                descripcion: descripcion,
                condiciones: condiciones.join(";"),
                usuario: usuario
            };

            $.ajax({
                url: 'http://localhost:8084/TpIntegradorDDS/api/nueva-metodologia',
                type: 'POST',
                data: JSON.stringify(data),
                dataType: 'json',
                contentType: 'application/json',
                accept: 'application/json',
                success: function (response) {
                    if (response.resultado === "0") {
                        cleanResponses();
                        cleanForm();
                        $('#modal-nueva-metod').modal("hide");
                        $('#modal-nueva-metod').modal("hide");
                        $('#input-codigo-met').val("");
                        $('#input-descripcion-met').val("");
                        $('#btn-crear-metodologia').val("Crear");
                        $('#list-metodologias2').empty();
                        $('#btn-eliminar-metodologia').css('display', 'none');
                        $('#div-metodologias').css('display', 'none');
                        $(".input_fields_wrap").empty();
                        swal(
                                'Bien hecho!',
                                'La metodologia ha sido guardada',
                                'success'
                                );
                    }
                    if (response.resultado === "1") {
                        cleanResponses();
                        swal(
                                'ERROR!!',
                                'La metodologia NO fue guardada',
                                'error'
                                );
                    }

                }
            });
        }

    }
    );
}
;

function evaluarMetodologia() {
    $('#btn-evaluar-metodologia').click(function () {
        var metodologia = $('#list-metodologias').val();
        var periodo = $('#input-anio').val();
        var data = {
            metodologia: metodologia,
            periodo: periodo
        };
        if (metodologia === null || periodo === "") {
            swal(
                    'Advertencia',
                    'Los campos no deben estar vacios.',
                    'warning'
                    );
        } else {
            $('#grilla').css('display', 'table');
            $.ajax({
                url: 'http://localhost:8084/TpIntegradorDDS/api/evaluar-metodologia',
                type: 'POST',
                data: data,
                success: function (valores) {
                    var $resultados = $('#resultado');
                    $.each(valores, function (i, valor) {
                        console.log(valor);
                        $resultados.append('<tr><td>' + valor.empresa.nombre + '</td><td>' + '<div class="progress"><div class="progress-bar progress-bar-striped active" role="progressbar" aria-valuenow="40" aria-valuemin="0" aria-valuemax="100" style="width:' + valor.valor + "%" + '">' +
                                +valor.valor + "%" + '</div> </div> </td></tr>');
                    });
                }
            });
        }
        ;

    }
    );
}

function datepicker() {
    $('#datetimepicker').datetimepicker({
        viewMode: 'years',
        format: 'YYYY'
    });
}
;

function mostrarCondiciones() {
    $('#btn-mostrar-condiciones').click(function () {
        $('#div-condiciones').css('display', 'inline-block');
        initListaCondiciones($('#list-condiciones'));
    });
}
;

function eliminarCondicion() {
    $('#btn-eliminar-condicion').click(function () {

        swal({
            title: 'Esta seguro?',
            text: "No podra revertir los cambios",
            type: 'warning',
            showCancelButton: true,
            confirmButtonColor: '#d33',
            cancelButtonColor: '#3085d6',
            confirmButtonText: 'Si, borralo!',
            cancelButtonText: 'Cancelar'
        }).then(function (result) {
            if (result.value) {
                var codigo = $('#input-codigo').val();
                var data = {
                    codigo: codigo
                };

                $.ajax({
                    url: 'http://localhost:8084/TpIntegradorDDS/api/eliminar-condicion',
                    type: 'POST',
                    data: data,
                    success: function (response) {
                        $('#modal-nueva-condicion').modal("hide");
                        $('#textarea-formula-condicion').val("");
                        $('#div-condiciones').css('display', 'none');
                        swal(
                                'Borrado',
                                'La condicion ha sido borrada',
                                'success'
                                );

                    }
                });
            }
        });


    });

}
;

function mostrarMetodologias()
{
    $('#btn-mostrar-metodologias').click(function () {
        $('#div-metodologias').css('display', 'inline-block');
        $('#list-metodologias2').empty();
        initListaMetodologias($('#list-metodologias2'));

    });
}
;

function traerMetodologia()
{
    var codigo = $('#list-metodologias2').val();

    var data = {
        codigo: codigo
    };

    $.ajax({
        url: 'http://localhost:8084/TpIntegradorDDS/api/metodologia',
        type: 'GET',
        data: data,
        success: function (metodologia) {
            $('#input-codigo-met').val(metodologia.codigo);
            $('#input-codigo-met').attr('readonly', true);
            $('#input-descripcion-met').val(metodologia.descripcion);
            $('#btn-crear-metodologia').val("Guardar");
            $('#btn-eliminar-metodologia').css('display', 'inline-block');
        }
    });

}
;

function eliminarMetodologia() {
    $('#btn-eliminar-metodologia').click(function () {

        swal({
            title: 'Esta seguro?',
            text: "No podra revertir los cambios",
            type: 'warning',
            showCancelButton: true,
            confirmButtonColor: '#d33',
            cancelButtonColor: '#3085d6',
            confirmButtonText: 'Si, borrar!',
            cancelButtonText: 'Cancelar'
        }).then(function (result) {
            if (result.value) {
                var codigo = $('#input-codigo-met').val();

                var data = {
                    codigo: codigo
                };

                $.ajax({
                    url: 'http://localhost:8084/TpIntegradorDDS/api/eliminar-metodologia',
                    type: 'POST',
                    data: data,

                    success: function (response) {
                        $('#modal-nueva-metod').modal("hide");
                        $('#input-codigo-met').val("");
                        $('#input-descripcion-met').val("");
                        $('#btn-crear-metodologia').val("Crear");
                        $(".input_fields_wrap").empty();
                        $('#btn-eliminar-metodologia').css('display', 'none');
                        $('#div-metodologias').css('display', 'none');
                        swal(
                                'Borrado',
                                'La metodologia ha sido borrada',
                                'success'
                                );
                    }
                });
            }
        });


    });

}
;

function cleanResponses() {
}
;

function cleanForm() {

}

function abrirModalNuevaCondicion() {
    $('#btn-abrir-nueva-condicion').click(function () {
        cleanForm();
        cleanResponses();

        $('#input-codigo').attr('readonly', false);
        $('#input-codigo').val("");
        $('#input-nombre').val("");
        $('#btn-crear-condicion').val("Crear");
        $('#btn-eliminar-condicion').css('display', 'none');
        initListaCondiciones($('#list-condiciones'));
        initListaIndicadores($('#list-condiciones'));
        $('[data-toggle="popover-formula-condicion"]').popover();
        $('[data-toggle="popover-codigo-condicion"]').popover();
        $('[data-toggle="popover-descripcion-condicion"]').popover();
        eliminarCondicion();

        initListaTipoCondiciones();
        validarIngresoNuevaCondicion();
    });
}
;

function cerrarModalNuevaCondicion() {
    $('#btn-cerrar-nueva-condicion').click(function () {
        cleanForm();
        cleanResponses();
        $('#textarea-formula-condicion').val("");
        $('#div-condiciones').css('display', 'none');

    });
}
;

function abrirModalNuevaMetodologia() {
    $('#btn-abrir-nueva-metodologia').click(function () {
        cleanForm();
        cleanResponses();
        agregarCondicion();
        $('#input-codigo-met').attr('readonly', false);
        $('#list-metodologias2').empty();
        $('#list-metodologias2').append('<option value="" disabled selected>Seleccione una metodologia para editarla</option>');
        initListaMetodologias($('#list-metodologias2'));
        initListaCondiciones($('#list-condiciones2'));
        $('[data-toggle="popover-metodologia-nombre"]').popover();
        $('[data-toggle="popover-metodologia-descripcion"]').popover();
        eliminarMetodologia();
        validarIngresoNuevaMetodologia();
    });
}
;

function cerrarModalNuevaMetodologia() {
    $('#btn-cerrar-nueva-metod').click(function () {
        cleanForm();
        cleanResponses();
        
    });
}
;

function limpiarGrillaValores() {
    $('.btn-primary').click(function () {
        $('#resultado tr').remove();
    });
}

function abrirModalEvaluarMetodologia() {
    $('#btn-abrir-evaluar-metodologia').click(function () {
        cleanForm();
        cleanResponses();
        $('[data-toggle="popover-evaluar-metodologia"]').popover();
        $('#list-metodologias').empty();
        $('#list-metodologias').append('<option value="" disabled selected>Seleccione una metodologia</option>');
        initListaMetodologias($('#list-metodologias'));
        datepicker();
        limpiarGrillaValores();
    });
}
;

function cerrarModalEvaluarMetodologia() {
    $('#btn-cerrar-evaluar-metod').click(function () {
        limpiarGrillaValores();
        $('#input-anio').val("");
        $('#grilla').css('display', 'none');
    });
}
;

// Metodos que van a estar listos para usar cuando se cargue el documento HTML.
$(document).ready(function () {

    $('#a-user').append(getCookie("user") + '<b class="caret"></b>');

    cleanForm();
    cleanResponses();
    mostrarCondiciones();
    mostrarMetodologias();

    // eventos
    abrirModalNuevaCondicion();
    cerrarModalNuevaCondicion();

    abrirModalNuevaMetodologia();
    cerrarModalNuevaMetodologia();

    limpiarGrillaValores();
    abrirModalEvaluarMetodologia();
    cerrarModalEvaluarMetodologia();
    evaluarMetodologia();
    //validarIngresoNuevaMetodologia();

});

function getCookie(cname) {
    var name = cname + "=";
    var ca = document.cookie.split(';');
    for (var i = 0; i < ca.length; i++) {
        var c = ca[i];
        while (c.charAt(0) == ' ') {
            c = c.substring(1);
        }
        if (c.indexOf(name) == 0) {
            return c.substring(name.length, c.length);
        }
    }
    return "";
}