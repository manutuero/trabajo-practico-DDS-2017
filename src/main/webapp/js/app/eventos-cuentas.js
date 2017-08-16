function obtenerValoresCuentas() {
    $('#btn-consultar').click(function () {
        var empresa = $('#list-empresas').val();
        var periodo = $('#input-periodo').val();
        var data = {
            empresa: empresa,
            periodo: periodo
        };

        if (empresa === null || periodo === null) {
            alert("no se aceptan campos vacios");
        } else {
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
    $('#btn-consultar-valores').click(function () {
        limpiarFormularios();
    });
}
;

function cerrarModalCalcularValores() {
    $('#btn-cerrar-calcular-valores').click(function () {
        limpiarFormularios();
    });
}
;

function limpiarFormularios() {
    $('.btn-primary').click(function () {
        $('#cotizaciones tr').remove();
    });
}

$(document).ready(function () {
    abrirModalConsultarValores();
    cerrarModalCalcularValores();
    limpiarFormularios();
    initListaEmpresas();
    obtenerValoresCuentas();


    // Check for FileReader API (HTML5) support.
    if (!window.FileReader) {
        alert('This browser does not support the FileReader API.');
    }
});
