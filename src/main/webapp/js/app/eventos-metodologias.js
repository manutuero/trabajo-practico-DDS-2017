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

function initListaMetodologias() {
    var listaMetodologias = $('#list-metodologias');

    listaMetodologias.empty();
    listaMetodologias.append('<option value="" disabled selected>Seleccione una metodologia</option>');

    $.ajax({
        url: 'http://localhost:8084/TpIntegradorDDS/api/metodologias',
        type: 'GET',
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
    $('#textarea-formula-condicion').append($('#list-indicadores').val());
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
            $('#warning-message').show();
            swal(
                    'Advertencia',
                    'Los campos no deben estar vacios.',
                    'warning'
                    );
        } else {
            $('#warning-message').hide();

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
        var condiciones = [];

        $('.btn-info').each(function ()
        {
            condiciones.push($(this).val());
        });

        var data = {
            codigo: codigo,
            descripcion: descripcion,
            condiciones: condiciones.join(";")
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
                    swal(
                            'Bien hecho!',
                            'La metodologia ha sido guardada',
                            'success'
                            )
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
            alert("No se aceptan campos vacios");
        } else {
            $('#grilla').css('display', 'inline-block');
            $.ajax({
                url: 'http://localhost:8084/TpIntegradorDDS/api/evaluar-metodologia',
                type: 'POST',
                data: data,
                success: function (valores) {
                    var $resultados = $('#resultado');
                    $.each(valores, function (i, valor) {
                            console.log(valor);
                            $resultados.append('<tr><td>' + valor.empresa.nombre + '</td><td>'
                                + valor.valor + '</td></tr>');
                    });
                }
            });
        }
        ;

    }
    );
}

function initListaEmpresas() { //es visual, para ver que empresas hay
    var listEmpresas = $('#list-empresas');
    listEmpresas.empty();
    listEmpresas.append('<option disabled>Empresas a evaluar</option>');
    $.ajax({
        url: 'http://localhost:8084/TpIntegradorDDS/api/empresas',
        type: 'GET',
        success: function (empresas) {
            $.each(empresas, function (indice, empresa) {
                listEmpresas.append('<option disabled>' + empresa.nombre + '</option>');
            });
        }
    });
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
                        swal(
                                'Borrado',
                                'La condicion ha sido borrada',
                                'success'
                                )

                    }
                });
            }
        })


    });

}
;

function eliminarMetodologia() {
    $('#btn-eliminar-metodologia').click(function () {

        var codigo = $('#input-codigo-met').val();

        var data = {
            codigo: codigo
        };

        $.ajax({
            url: 'http://localhost:8084/TpIntegradorDDS/api/eliminar-metodologia',
            type: 'POST',
            data: data,
            success: function (response) {
                alert("La Condicion fue eliminada correctamente");
            }
        });

    });

}
;

function cleanResponses() {
    $('#warning-message').hide();
    $('#syntax-error-message').hide();
    $('#input-error-message').hide();
}
;

function cleanForm() {

}

function abrirModalNuevaCondicion() {
    $('#btn-abrir-nueva-condicion').click(function () {
        cleanForm();
        cleanResponses();
        mostrarCondiciones();
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
    });
}
;

function abrirModalNuevaMetodologia() {
    $('#btn-abrir-nueva-metodologia').click(function () {
        cleanForm();
        cleanResponses();
        agregarCondicion();
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
        initListaMetodologias();
        initListaEmpresas();
        datepicker();
        limpiarGrillaValores();
    });
}
;

function cerrarModalEvaluarMetodologia() {
    $('#btn-cerrar-evaluar-metod').click(function () {
        limpiarGrillaValores();
        $('#input-anio').val("");
    });
}
;

// Metodos que van a estar listos para usar cuando se cargue el documento HTML.
$(document).ready(function () {

    $('#a-user').append(getCookie("user") + '<b class="caret"></b>');

    cleanForm();
    cleanResponses();

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

