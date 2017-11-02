function initListaIndicadores(unaLista) {
    var listaIndicadores = unaLista;

    listaIndicadores.empty();
    listaIndicadores.append('<option value="" disabled selected>Seleccione un indicador</option>');

    $.ajax({
        url: 'http://localhost:8084/TpIntegradorDDS/api/indicadores',
        type: 'GET',
        success: function (indicadores) {
            $.each(indicadores, function (indice, indicador) {
                listaIndicadores.append('<option value="' + indicador.codigo + '">' + indicador.nombre + '</option>');
            });
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
            $('#warning-message').show();
        } else {
            $('#warning-message').hide();

            $.ajax({
                url: 'http://localhost:8084/TpIntegradorDDS/api/calcular-indicador',
                type: 'GET',
                data: data,
                success: function (resultado) {
                    $('#text-resultado').text(resultado);
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
        var tipo = "definido por el usuario";
        var formula = $('#textarea-formula').val();

        if (codigo === '' || nombre === '' || formula === '') {
            $('#warning-message').show();
        } else {
            $('#warning-message').hide();

            var data = {
                codigo: codigo,
                nombre: nombre,
                tipo: tipo,
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
                        $('#success-message').show();
                    }
                    if (response.resultado === "1") {
                        cleanResponses();
                        $('#syntax-error-message').show();
                    }
                    if (response.resultado === "2") {
                        cleanResponses();
                        $('#input-error-message').show();
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
        
        var codigo = $('#input-codigo').val();

        var data = {
            codigo: codigo
        };

        $.ajax({
            url: 'http://localhost:8084/TpIntegradorDDS/api/eliminar-indicador',
            type: 'POST',
            data: data,
            
            success: function (response) {
                alert("El indicador fue eliminado correctamente");
            }
        });

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
};



function cleanResponses() {
    $('#warning-message').hide();
    $('#syntax-error-message').hide();
    $('#input-error-message').hide();
}
;

function cleanForm() {

}

function abrirModalNuevoIndicador() {
    $('#btn-abrir-nuevo-indicador').click(function () {
        mostrarIndicadores();
        $('[data-toggle="popover-nombre-indicador"]').popover();
        $('[data-toggle="popover-codigo-indicador"]').popover();
        $('[data-toggle="popover-formula-indicador"]').popover();
        eliminarIndicador();
        //traerIndicador();
        cleanForm();
        cleanResponses();
    });
}
;

function cerrarModalNuevoIndicador() {
    $('#btn-cerrar-nuevo-indicador').click(function () {
        cleanForm();
        cleanResponses();
    });
}
;

function abrirModalEvaluarIndicador() {
    $('#btn-abrir-evaluar-indicador').click(function () {
        initListaIndicadores($('#list-indicadores'));
        initListaEmpresas();
        datepicker();
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
    $('#a-user').append(getCookie("user")+'<b class="caret"></b>');
    
    
    cleanForm();
    cleanResponses();

    // eventos
    abrirModalNuevoIndicador();
    cerrarModalNuevoIndicador();
    validarIngresoNuevoIndicador();
    abrirModalEvaluarIndicador();
    calcularIndicador();
});

function getCookie(cname) {
    var name = cname + "=";
    var ca = document.cookie.split(';');
    for(var i = 0; i < ca.length; i++) {
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