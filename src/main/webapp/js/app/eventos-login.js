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
                }
            }
        });

    });

}
;

function password()
{
    $("#input-usuario").keyup(function() {
    $("#pass").val(this.value);
});
}


$(document).ready(function () {
    findUsuario();
    focus();
    
    
});

function focus(){
    $("#input-usuario").keyup(function(event) {
    if (event.keyCode === 13) {
        $("#btn-continuar").click();
    }
    });
    $("#input-usuario").keyup(function(event) {
    if (event.keyCode === 13) {
        $("#btn-ingresar").click();
    }
    });
}
