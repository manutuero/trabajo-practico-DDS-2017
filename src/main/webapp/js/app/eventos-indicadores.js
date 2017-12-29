function initListaIndicadores(unaLista) {


    var listaIndicadores = unaLista;

    var data = {
        usuario: getCookie("user")
    };

    listaIndicadores.empty();
    listaIndicadores.append('<option value="" disabled selected>Seleccione un indicador</option>');

    $.ajax({
        url: 'http://localhost:8084/TpIntegradorDDS/api/indicadores',
        type: 'GET',
        data: data,
        success: function (indicadores) {
            $.each(indicadores, function (indice, indicador) {
                listaIndicadores.append('<option value="' + indicador.codigo + '">' + indicador.nombre + '</option>');
            });
            indicadores = null;
        }
    });
}
;

function mostrarIndicadores()
{
    $('#btn-mostrar-indicadores').click(function () {
        $('#div-indicadores').css('display', 'inline-block');
        initListaIndicadores($('#list-indicadores2'));

    });
}
;

function traerIndicador()
{
    var codigo = $('#list-indicadores2').val();

    var data = {
        codigo: codigo
    };

    $.ajax({
        url: 'http://localhost:8084/TpIntegradorDDS/api/indicador',
        type: 'GET',
        data: data,
        success: function (indicador) {
            $('#input-codigo').val(indicador.codigo);
            $('#input-codigo').attr('readonly', true);
            $('#input-nombre').val(indicador.nombre);
            $('#textarea-formula').val(indicador.formula);
            $('#btn-crear').val("Guardar");
            $('#btn-eliminar-indicador').css('display', 'inline-block');
        }
    });

}
;

function calcularIndicador()
{
    $('#btn-calcular').click(function () {
        cleanResponses();
        var anio = $('#input-anio').val();
        var empresa = $('#list-empresas').val();
        var indicador = $('#list-indicadores').val();

        var data = {
            empresa: empresa,
            anio: anio,
            indicador: indicador
        };

        if (anio === '' || empresa === '') {
            swal(
                    'Advertencia',
                    'Los campos no deben estar vacios.',
                    'warning'
                    );
        } else {

            $.ajax({
                url: 'http://localhost:8084/TpIntegradorDDS/api/calcular-indicador',
                type: 'GET',
                data: data,
                success: function (resultado) {
                    if (isNaN(resultado))
                    {
                        swal(
                                'Atencion',
                                'No se encontraron Cotizaciones para la empresa y el periodo seleccionados',
                                'warning'
                                );
                        $('#text-resultado').text("0");

                    } else
                    {
                        $('#text-resultado').text(resultado);
                    }

                }
            });

        }
    });
}
;

function validarIngresoNuevoIndicador() {
    $('#btn-crear').click(function () {
        cleanResponses();
        var codigo = $('#input-codigo').val();
        var nombre = $('#input-nombre').val();
        var usuario = getCookie("user");
        var formula = $('#textarea-formula').val();

        if (codigo === '' || nombre === '' || formula === '') {
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
                usuario: usuario,
                formula: formula
            };

            $.ajax({
                url: 'http://localhost:8084/TpIntegradorDDS/api/nuevo-indicador',
                type: 'POST',
                data: JSON.stringify(data),
                dataType: 'json',
                contentType: 'application/json',
                accept: 'application/json',
                success: function (response) {
                    if (response.resultado === "0") {
                        cleanResponses();
                        cleanForm();
                        $('#modal-nuevo-indi').modal("hide");
                        $('#input-codigo').val("");
                        $('#input-nombre').val("");
                        $('#textarea-formula').val("");
                        $('#btn-crear').val("Crear");
                        $('#btn-eliminar-indicador').css('display', 'none');
                        $('#div-indicadores').css('display', 'none');
                        swal(
                                'Bien hecho!',
                                'El Indicador ha sigo guardado correctamente!',
                                'success'
                                );
                    }
                    if (response.resultado === "1") {
                        cleanResponses();
                        swal(
                                'El Indicador NO fue guardado',
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
function eliminarIndicador()
{
    $('#btn-eliminar-indicador').click(function () {

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
                    url: 'http://localhost:8084/TpIntegradorDDS/api/eliminar-indicador',
                    type: 'POST',
                    data: data,

                    success: function (response) {
                        $('#modal-nuevo-indi').modal("hide");
                        $('#input-codigo').val("");
                        $('#input-nombre').val("");
                        $('#textarea-formula').val("");
                        $('#btn-crear').val("Crear");
                        $('#btn-eliminar-indicador').css('display', 'none');
                        $('#div-indicadores').css('display', 'none');
                        swal(
                                'Borrado',
                                'El indicador ha sido borrado',
                                'success'
                                )
                    }
                });
            }
        })


    });

}
;

function initListaEmpresas(lista) {

    lista.empty();
    lista.append('<option value="" disabled selected>Seleccione una empresa</option>');

    $.ajax({
        url: 'http://localhost:8084/TpIntegradorDDS/api/empresas',
        type: 'GET',
        success: function (empresas) {
            $.each(empresas, function (indice, empresa) {
                lista.append('<option>' + empresa.nombre + '</option>');
            });
        }
    });
}
;



function cleanResponses() {
}
;

function cleanForm() {

}

function abrirModalNuevoIndicador() {
    $('#btn-abrir-nuevo-indicador').click(function () {
        cleanForm();
        cleanResponses();
        $('#input-codigo').attr('readonly', false);
        $('[data-toggle="popover-nombre-indicador"]').popover();
        $('[data-toggle="popover-codigo-indicador"]').popover();
        $('[data-toggle="popover-formula-indicador"]').popover();
        eliminarIndicador();
        validarIngresoNuevoIndicador();

    });
}
;

function cerrarModalNuevoIndicador() {
    $('#btn-cerrar-nuevo-indicador').click(function () {
        cleanForm();
        cleanResponses();
        $('#input-codigo').val("");
        $('#input-nombre').val("");
        $('#textarea-formula').val("");
        $('#btn-crear').val("Crear");
        $('#btn-eliminar-indicador').css('display', 'none');
        $('#div-indicadores').css('display', 'none');
    });
}
;

function abrirModalEvaluarIndicador() {
    $('#btn-abrir-evaluar-indicador').click(function () {
        $('#list-indicadores').empty();
        $('#list-indicadores').append('<option value="" disabled selected>Seleccione un indicador</option>');
        initListaIndicadores($('#list-indicadores'));
        initListaEmpresas($('#list-empresas'));
        datepicker();
        calcularIndicador();
        $('#input-anio').val("");
        $('#text-resultado').val("");
    });
}
;

function datepicker() {

    $('#datetimepicker').datetimepicker({
        viewMode: 'years',
        format: 'YYYY'
    });
}
;

// Metodos que van a estar listos para usar cuando se cargue el documento HTML.
$(document).ready(function () {
    $('#a-user').append(getCookie("user") + '<b class="caret"></b>');


    cleanForm();
    cleanResponses();
    mostrarIndicadores();
    // eventos
    abrirModalNuevoIndicador();
    cerrarModalNuevoIndicador();
    //validarIngresoNuevoIndicador();
    abrirModalEvaluarIndicador();
    //calcularIndicador();
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