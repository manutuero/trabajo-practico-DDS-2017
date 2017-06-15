function validarIngresoNuevoIndicador() {
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
                success: function(response) {
                    if(response.resultado === "0") {
                        alert("Exito!. El indicador se ha guardado exitosamente.");
                    }
                    if(response.resultado === "1") {
                        alert("Error de sintaxis. La formula ingresada no es correcta.");
                    }
                    if(response.resultado === "2") {
                        alert("Error lexico. Alguno de los elementos de la formula no existe.");
                    } else {
                        alert("Bueno, algo hizo");
                    }
                    // cerrar modal cuando este finalizado el backend
                }
            });
        }
    });
};

$(document).ready(function () {
    validarIngresoNuevoIndicador();
});
