function findUsuario()
{
    $('#btn-continuar').click(function () {

        var usuario = $('#input-usuario').val();
        
        var data = {
            usuario: usuario
        };

        $.ajax({
            url: 'http://localhost:8084/TpIntegradorDDS/api/findUsuario',
            type: 'GET',
            data: data,
            success: function (resultado) {
                alert(resultado.usuario);
            }
        });

    });

}
;

$(document).ready(function () {
   findUsuario();
});