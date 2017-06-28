function validarIngresoNuevoIndicador() {
    $('#btn-crear').click(function () {
        cleanResponses();

        var nombre = $('#input-nombre').val();
        var tipo = "definido por el usuario";
        var formula = $('#textarea-formula').val();

        if (nombre === '' || formula === '') {
            $('#warning-message').show();
        } else {
            $('#warning-message').hide();

            var data = {
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
    /*$('#input-nombre').html("");
    $('#textarea-formula').html("");
    $('#modal1').on('hidden.bs.modal', function (e) {
        $(this)
                .find("input,textarea,select")
                .val('')
                .end()
                .find("input[type=checkbox], input[type=radio]")
                .prop("checked", "")
                .end();
    })*/
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

$(document).ready(function () {
    cleanForm();
    cleanResponses();
    abrirModalNuevoIndicador();
    cerrarModalNuevoIndicador();
    validarIngresoNuevoIndicador();
});
