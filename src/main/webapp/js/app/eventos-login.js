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
                if(!!resultado.usuario)
                {
                    $('#info2').html("Bienvenido " + resultado.usuario);
                    $('#input-usuario').attr("placeholder", "Password");
                    $('#input-usuario').val("");
                    $('#btn-acceso').html('<input type="submit" id="btn-ingresar" value="Entrar" />');
                    
                    ingresar(resultado.usuario);
                }
            }
        });

    });

};

function ingresar(usuario)
{
    $('#btn-ingresar').click(function () {

        alert(usuario);
        
        var password = $('#input-usuario').val();
        
        var data = {
            usuario: usuario,
            password: password
        };

        $.ajax({
            url: 'http://localhost:8084/TpIntegradorDDS/api/ingresar',
            type: 'GET',
            data: data,
            success: function (resultado) {
                if(!!resultado.usuario)
                {
                    alert("todo bien");
                }
            }
        });

    });

};

$(document).ready(function () {
   findUsuario();
   
   
});