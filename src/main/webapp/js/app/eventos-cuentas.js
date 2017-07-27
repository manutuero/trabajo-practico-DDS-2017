function obtenerValoresCuentas() {
    $('#btn-consultar').click(function () {
        var empresa = $('#input-empresa').val();
        var periodo = $('#input-periodo').val();
        var data = {
            empresa: empresa,
            periodo: periodo
        };

        if(empresa === null  || periodo === null){
            alert("no se aceptan campos vacios");
        }else {
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

function limpiarFormularios() {
    $('.btn-primary').click(function () {
        $('#cotizaciones tr').remove();
    });
}

$(document).ready(function () {
    obtenerValoresCuentas();
    limpiarFormularios();
        
    // Check for FileReader API (HTML5) support.
    if (!window.FileReader) {
        alert('This browser does not support the FileReader API.');
    }
});
