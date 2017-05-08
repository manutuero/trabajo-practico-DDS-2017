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
                url: 'http://localhost:8084/TpIntegradorDDS/api/valores-cuenta',
                type: 'POST',
                data: data,
                success: function (valores) {
                            var $valoresCuentas = $('#valores-cuentas');
                            $.each(valores, function (i, valor) {
                                $valoresCuentas.append('<tr><td>' + valor.nombre + '</td><td>' 
                                                                  + valor.periodo + '</td></tr>');
                            });
                         }
            });
        }
    });
}

function limpiarFormularios() {
    $('.btn-primary').click(function () {
        $('#valores-cuentas tr').remove();
    });
}

$(document).ready(function () {
    obtenerValoresCuentas();
    limpiarFormularios();
});
