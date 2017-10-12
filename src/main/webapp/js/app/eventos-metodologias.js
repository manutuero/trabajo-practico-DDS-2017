function initListaIndicadores() {
    var listaIndicadores = $('#list-indicadores');

    listaIndicadores.empty();
    listaIndicadores.append('<option value="" disabled selected>Seleccione un indicador</option>');

    $.ajax({
        url: 'http://localhost:8084/TpIntegradorDDS/api/indicadores',
        type: 'GET',
        success: function (indicadores) {
            $.each(indicadores, function (indice, indicador) {
                listaIndicadores.append('<option value="'+indicador.codigo+'">' + indicador.nombre + '</option>');
            });
        }
    });
}
;

function initListaCondiciones(unaLista) {
    var listaCondiciones = unaLista;

    listaCondiciones.empty();
    listaCondiciones.append('<option value="" disabled selected>Seleccione una Condicion</option>');

    $.ajax({
        url: 'http://localhost:8084/TpIntegradorDDS/api/condiciones',
        type: 'GET',
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

function agregarCondicion() {

    var max_fields = 10; //maximum input boxes allowed
    var wrapper = $(".input_fields_wrap"); //Fields wrapper

    var x = 0; //initlal text box count
    $('.add_field_button').click(function (e) { //on add input button click
        e.preventDefault();
        if (x < max_fields) { //max input box allowed
            x++; //text box increment
            $(wrapper).append('<div class="btn-group"><button id="uno" class="btn btn-info btn-lg" value="'+$('#list-condiciones2 option:selected').val() +
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
        } else {
            $('#warning-message').hide();

            var data = {
                codigo: codigo,
                nombre: nombre,
                formula: formula
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
                    $('#success-metod-message').show();
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
    );
}
;

function mostrarCondiciones()
{
    $('#btn-mostrar-condiciones').click(function () {
        $('#div-condiciones').css('display','inline-block');
        initListaCondiciones($('#list-condiciones'));
        
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

function abrirModalNuevaCondicion() {
    $('#btn-abrir-nueva-condicion').click(function () {
        cleanForm();
        cleanResponses();
        initListaIndicadores($('#list-condiciones'));
        $('[data-toggle="popover-formula-condicion"]').popover();
        $('[data-toggle="popover-codigo-condicion"]').popover();
        $('[data-toggle="popover-descripcion-condicion"]').popover();
        
        initListaTipoCondiciones();
        validarIngresoNuevaCondicion();
    });
}
;

function cerrarModalEvaluarCondicion() {
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
        initListaCondiciones($('#list-condiciones2'));
        $('[data-toggle="popover-metodologia-nombre"]').popover();
        $('[data-toggle="popover-metodologia-descripcion"]').popover();
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

function abrirModalEvaluarMetodologia() {
    $('#btn-abrir-evaluar-metodologia').click(function () {

    });
}
;

function cerrarModalEvaluarMetodologia() {
    $('#btn-cerrar-evaluar-metod').click(function () {
        cleanForm();
        cleanResponses();
    });
}
;

// Metodos que van a estar listos para usar cuando se cargue el documento HTML.
$(document).ready(function () {
    cleanForm();
    cleanResponses();

    
    // eventos
    abrirModalNuevaCondicion();
    mostrarCondiciones();
    //cerrarModalNuevacondicion();
    
    abrirModalNuevaMetodologia();
    agregarCondicion();
    //validarIngresoNuevaMetodologia();
    cerrarModalNuevaMetodologia();

    abrirModalEvaluarMetodologia();
    cerrarModalEvaluarMetodologia();
    
    

    //validarIngresoNuevaMetodologia();

});

