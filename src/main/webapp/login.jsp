
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
        <title>Login</title>
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" href="css/bootstrap.min.css" type="text/css">
        <link rel="stylesheet" href="css/style-login.css" type="text/css">
        <link href="css/heroic-features.css" rel="stylesheet">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/normalize/5.0.0/normalize.min.css">

    </head>
    <body>
        <div class="login-container animated fadeInDown">    
            <center>
                <div class="login-container animated fadeInDown">
                    <div id="info1">
                        TP Integrador
                    </div>
                    <div id="info2">
                        Ingresar
                    </div>
                    <div id="form1">
                        <div id="form-img">
                            <img src="<%=request.getContextPath()%>\images\profile-img.png" width="99" height="99" />
                        </div>
                        <div id="mailbox">
                            <input id="input-usuario" placeholder="Usuario" type="mail" name="name" style="width:270px; height:42px; border: solid 1px #c2c4c6; font-size:16px; padding-left:8px;" />
                        </div>
                        <div>
                            <input type="submit" id="btn-continuar" value="Continuar" />
                        </div>
                        <div id="info3">
                            <a href="#"/>Mas Opciones</a>
                        </div>
                    </div>
                    <!--            <div id="info4">
                                    <a href="#"/>Create account</a>
                                </div>-->


                    <footer>
                        <div class="row">
                            <div class="col-lg-12">
                                <p>Copyright &copy; Developed by Javaianos, 2017</p>
                            </div>
                        </div>
                    </footer>

                </div>
            </center>
        </div>
        <script src="js/vendor/jquery-3.2.1.min.js"></script>
        
       <script src="js/app/eventos-login.js"></script>-->
    </body>
</html>