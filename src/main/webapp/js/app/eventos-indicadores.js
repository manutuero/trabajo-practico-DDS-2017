function initListaIndicadores() {
    var listaIndicadores = $('#list-indicadores');
 
    listaIndicadores.empty();
    listaIndicadores.append('<option value="" disabled selected>Seleccione un indicador</option>');
            
    $.ajax({
        url: 'http://localhost:8084/TpIntegradorDDS/api/indicadores',
        type: 'GET',
        success: function (indicadores) {
            $.each(indicadores, function (indice, indicador) {
                //listaIndicadores.append('<option>'+ "("+ indicador.codigo + ") "+ indicador.nombre + '</option>');
                listaIndicadores.append('<option>'+ indicador.codigo + '</option>');
            });
        }
    });
}

function calcularIndicador()
{
    $('#btn-calcular').click(function() {
        
        var anio = $('#input-anio').val();
        var empresa = $('#input-empresa').val();
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
};

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
        initListaIndicadores();
    });
}
;

// Metodos que van a estar listos para usar cuando se cargue el documento HTML.
$(document).ready(function () {
    cleanForm();
    cleanResponses();
    
    // eventos
    abrirModalNuevoIndicador();
    cerrarModalNuevoIndicador();
    validarIngresoNuevoIndicador();
    abrirModalEvaluarIndicador();
    calcularIndicador();
});
