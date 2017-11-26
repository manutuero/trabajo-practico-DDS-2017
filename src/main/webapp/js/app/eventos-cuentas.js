/* global message */

function obtenerValoresCuentas() {
    $('#btn-consultar').click(function () {

        var empresa = $('#list-empresas').val();
        var periodo = $('#input-periodo').val();
        var data = {
            empresa: empresa,
            periodo: periodo
        };

        if (empresa === null || periodo === "") {
            alert("No se aceptan campos vacios");
        } else {
            $('#grilla').css('display', 'inline-block');
            $.ajax({
                url: 'http://localhost:8084/TpIntegradorDDS/api/cotizaciones',
                type: 'POST',
                data: data,
                success: function (valores) {
                    var $cotizaciones = $('#cotizaciones');
                    $.each(valores, function (i, valor) {
                        console.log(valor);
                        $cotizaciones.append('<tr><td>' + valor.cuenta.nombre + '</td><td>'
                                + valor.valor + '</td></tr>');
                    });
                }
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

function initListaEmpresas() {
    var listaEmpresas = $('#list-empresas');

    listaEmpresas.empty();
    listaEmpresas.append('<option value="" disabled selected>Seleccione una empresa</option>');

    $.ajax({
        url: 'http://localhost:8084/TpIntegradorDDS/api/empresas',
        type: 'GET',
        success: function (empresas) {
            $.each(empresas, function (indice, empresa) {
                listaEmpresas.append('<option>' + empresa.nombre + '</option>');
            });
        }
    });
}

function abrirModalConsultarValores() {
    $('#btn-abrir-consultar-valores').click(function () {
        initListaEmpresas();
        $('[data-toggle="popover-cuenta-titulo"]').popover();
        datepicker();
        limpiarGrillaValores();

    });
}
;

function cerrarModalCalcularValores() {
    $('#btn-cerrar-consultar-valores').click(function () {
        limpiarGrillaValores();
        $('#input-periodo').val("");
    });
}
;

function limpiarGrillaValores() {
    $('.btn-primary').click(function () {
        $('#cotizaciones tr').remove();
    });
}
;

$(document).ready(function () {
    $('#a-user').append(getCookie("user") + '<b class="caret"></b>');
  
    limpiarGrillaValores();
    abrirModalConsultarValores();
    cerrarModalCalcularValores();
    obtenerValoresCuentas();


    // Check for FileReader API (HTML5) support.
    if (!window.FileReader) {
        alert('This browser does not support the FileReader API.');
    }
    mensajeCuentas();
    mensajeCoti();



});

function mensajeCuentas()
{
    if ($('#info-cuentas').text() == "ok")
    {
        swal(
                'Bien hecho!',
                'Las cuentas se han cargado correctamente!',
                'success'
                );
    }
    if ($('#info-cuentas').text() == "nook")
    {
        swal(
                'ERROR',
                'Las cuentas NO pudieron ser cargadas',
                'error'
                );
    }

}

function mensajeCoti()
{
    if ($('#info-coti').text() == "ok")
    {
        swal(
                'Bien hecho!',
                'Las Cotizaciones se han cargado correctamente!',
                'success'
                );
    }
    if ($('#info-coti').text() == "nook")
    {
        swal(
                'ERROR',
                'Las Cotizaciones NO pudieron ser cargadas',
                'error'
                );
    }

}

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