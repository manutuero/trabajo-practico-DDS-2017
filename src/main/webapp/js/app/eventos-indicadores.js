function validarIngreso() {
    $('#btn-crear').click(function () {
        var nombre = $('#input-nombre').val();
        var tipo = "definido por el usuario";
        var formula = $('#textarea-formula').val();
        
        if(nombre === '' || formula === '') {
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
                contentType:'application/json',
                accept: 'application/json',
                success: function(){
                    // cerrar modal cuando este finalizado el backend
                }
            });
        }
    });
};

$(document).ready(function () {
    validarIngreso();
});
