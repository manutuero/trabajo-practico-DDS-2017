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
                if (!!resultado.usuario)
                {
                    $('#info2').html("Bienvenido " + resultado.usuario);

                    $('#btn-acceso').html('<form action="LoginServlet.jsp" method="post"><input id="user" type="hidden" name="user"><input id="pass" type="hidden" name="pass"><input type="submit" id="btn-ingresar" value="Entrar" /></form>');
                    $('#user').val($('#input-usuario').val());
                    $('#input-usuario').attr("placeholder", "Password");
                    $('#input-usuario').attr("type", "Password");
                    $('#input-usuario').val("");
                    password();
                } else
                {
                    swal(
                            'ERROR',
                            'El usuario ingresado no es valido',
                            'error'
                            );
                    focus();
                }
            }
        });

    });

}
;

function password()
{
    $("#input-usuario").keyup(function () {
        $("#pass").val(this.value);
    });
}


$(document).ready(function () {
    findUsuario();
    focus();
    mensajeLogin();

});

function mensajeLogin()
{
    if ($('#info-login').text() == "nook")
    {
        swal(
                'ERROR',
                'La contraseña ingresada no es valida',
                'error'
                );
    }
    if ($('#info-login').text() == "logout")
    {
        swal(
                'Vuelva pronto!',
                'Ha cerrado sesion correctamente',
                'success'
                );
    }

}

function focus() {
    $("#input-usuario").keyup(function (event) {
        if (event.keyCode === 13) {
            $("#btn-continuar").click();
        }
    });
    $("#input-usuario").keyup(function (event) {
        if (event.keyCode === 13) {
            $("#btn-ingresar").click();
        }
    });
}
