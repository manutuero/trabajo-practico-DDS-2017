function initListaMetodologias() {
    var listaMetodologias = $('#list-metodologias');
 
    listaMetodologias.empty();
    listaMetodologias.append('<option value="" disabled selected>Seleccione una metodologia</option>');
            
    $.ajax({
        url: 'http://localhost:8084/TpIntegradorDDS/api/metodologias',
        type: 'GET',
        success: function (metodologias) {
            $.each(metodologias, function (indice, metodologia) {
                listaMetodologias.append('<option>' + metodologia.nombre + '</option>');
            });
        }
    });
};

function validarIngresoNuevaMetodologia() {
    $('#btn-crear').click(function () {
        cleanResponses();

        var nombre = $('#input-nombre').val();
        var formula = $('#textarea-formula').val();

        if (nombre === '' || formula === '') {
            $('#warning-message').show();
        } else {
            $('#warning-message').hide();

            var data = {
                nombre: nombre,
                formula: formula
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

function abrirModalNuevaMetodologia() {
    $('#btn-abrir-nueva-metodologia').click(function () {
        cleanForm();
        cleanResponses();
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

function abrirModalEvaluarMetodologia() {
    $('#btn-abrir-evaluar-metodologia').click(function () {
        initListaMetodologias();
    });
}
;

// Metodos que van a estar listos para usar cuando se cargue el documento HTML.
$(document).ready(function () {
    cleanForm();
    cleanResponses();
    
    // eventos
    abrirModalNuevaMetodologia();
    cerrarModalNuevaMetodologia();
    validarIngresoNuevaMetodologia();
    abrirModalEvaluarMetodologia();
});