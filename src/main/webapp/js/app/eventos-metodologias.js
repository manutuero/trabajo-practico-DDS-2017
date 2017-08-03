function initListaIndicadores() {
    var listaIndicadores = $('#list-indicadores');
 
    listaIndicadores.empty();
    listaIndicadores.append('<option value="" disabled selected>Seleccione un indicador</option>');
            
    $.ajax({
        url: 'http://localhost:8084/TpIntegradorDDS/api/indicadores',
        type: 'GET',
        success: function (indicadores) {
            $.each(indicadores, function (indice, indicador) {
                listaIndicadores.append('<option>'+ indicador.codigo + '</option>');
            });
        }
    });
};

function insertarIndicador(){
    $('#textarea-formula-condicion').append($('#list-indicadores').val());
};

function validarIngresoNuevaCondicion() {
    
    $('#btn-crear-condicion').click(function() {
        cleanResponses();
        
        var codigo = $('#input-codigo').val();
        var nombre = $('#input-nombre').val();
        var formula = $('#textarea-formula-condicion').val();

        if (nombre === '' || formula === '') {
            $('#warning-message').show();
        } else {
            $('#warning-message').hide();

            var data = {
                codigo: codigo,
                nombre: nombre,
                formula: formula
            };

            $.ajax({
                url: 'http://localhost:8084/TpIntegradorDDS/api/nueva-condicion',
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
                        $('#success-condicion-message').show();
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

function abrirModalNuevaCondicion(){
    $('#btn-abrir-nueva-condicion').click(function () {
        cleanForm();
        cleanResponses();
        initListaIndicadores();
    });
};

function cerrarModalEvaluarCondicion() {
    $('#btn-cerrar-nueva-condicion').click(function () {
        cleanForm();
        cleanResponses();
    });
};


function abrirModalNuevaMetodologia() {
    $('#btn-abrir-nueva-metodologia').click(function () {
        cleanForm();
        cleanResponses();
        initListaIndicadores();
    });
}
;

function cerrarModalNuevaMetodologia() {
    $('#btn-cerrar-nueva-metod').click(function () {
        cleanForm();
        cleanResponses();
    });
};

function abrirModalEvaluarMetodologia() {
    $('#btn-abrir-evaluar-metodologia').click(function () {
        initListaMetodologias();
    });
};

function cerrarModalEvaluarMetodologia() {
    $('#btn-cerrar-evaluar-metod').click(function () {
        cleanForm();
        cleanResponses();
    });
};

// Metodos que van a estar listos para usar cuando se cargue el documento HTML.
$(document).ready(function () {
    cleanForm();
    cleanResponses();
    
    // eventos
    validarIngresoNuevaCondicion();
    abrirModalNuevaMetodologia();
    cerrarModalNuevaMetodologia();
    abrirModalEvaluarMetodologia();
    cerrarModalEvaluarMetodologia();
    abrirModalNuevaCondicion();
    cerrarModalNuevacondicion();
    
    //validarIngresoNuevaMetodologia();
    
});