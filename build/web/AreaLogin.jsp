<%-- 
    Document   : AreaLogin
    Created on : 29 ago. 2022, 18:46:01
    Author     : Jean Paul
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:useBean id="msj" scope="request" class="java.lang.String"/>
<%@page session="true"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8" />
        <meta name="viewport" content="width=device-width, initial-scale=1.0" />
        <script src="https://kit.fontawesome.com/64d58efce2.js" crossorigin="anonymous"></script>
        <link rel="stylesheet" href="css/StyleLogin.css" />
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
        <link rel="stylesheet" href="css/alerta.css"/>
        <link rel="stylesheet" href="https://unicons.iconscout.com/release/v4.0.0/css/line.css">
        <script src="https://code.iconify.design/iconify-icon/1.0.0-beta.3/iconify-icon.min.js"></script>
        <link rel="icon" type="icon/png" href="img/icono.png"/>
        <title>Login</title>
    </head>
    <body>
        <div class="container">
            <div class="forms-container">
                <div class="signin-signup">
                    <form action="Controlador" class="sign-in-form" method="post">
                        <h2 class="title">Iniciar Sesión</h2>
                        <div class="input-field">
                            <i class="fas fa-user"></i>
                            <input type="text" name="txtUsuario" placeholder="Nombre de Usuario" />
                        </div>
                        <div class="input-field">
                            <i class="fas fa-lock"></i>
                            <input type="password" name="txtContraseña" placeholder="Clave" />
                        </div>
                        <%
                            if(msj!=null)
                                out.print(msj);
                        %>
                        <input type="hidden" name="URL" value="ingresar">
                        <input type="submit" value="Login" id="btn-abrir-coda" class="btn solid" />
                        <p class="social-text">No olvides seguirnos a travez de:&nbsp;&nbsp;</p>
                        <div class="social-media">
                            <a href="#" class="social-icon">
                                <i class="fab fa-facebook-f"></i>
                            </a>
                            <a href="#" class="social-icon">
                                <i class="fab fa-twitter"></i>
                            </a>
                        </div>
                    </form>
                    <form action="Controlador" class="sign-up-form" method="post">
                        <h2 class="title">Regístrate</h2>
                        <div class="input-field">
                            <i class="fas fa-user"></i>
                            <input type="text" name="txtdni" placeholder="DNI" />
                        </div>
                        <div class="input-field">
                            <i class="fas fa-user"></i>
                            <input type="text" name="txtnombres" placeholder="Nombres" />
                        </div>
                        <div class="input-field">
                            <i class="fas fa-user"></i>
                            <input type="text" name="txtapell" placeholder="Apellidos" />
                        </div> 
                        <div class="input-field">
                            <i class="fas fa-user"></i>
                            <input type="text" name="txtusuario" placeholder="Nombre de Usuario" />
                        </div>
                        <div class="input-field">
                            <i class="fas fa-envelope"></i>
                            <input type="email" name="txtcorreo" placeholder="Correo Electrónico" />
                        </div>
                        <div class="input-field">
                            <i class="fas fa-lock"></i>
                            <input type="password" name="txtcontra" placeholder="Contraseña" />
                        </div>
                        <%
                            if(msj!=null)
                                out.print(msj);
                        %>
                        <div class="checkbox-text">
                            <div class="checkbox-content">
                                <input type="checkbox" name="checkbox" id="logCheck">
                                <label for="logCheck" class="text">Acepto los<a href="Untitled-6.html">Terminos y Condiciones</a></label>
                            </div>
                        </div>
                        <input type="hidden" name="URL" value="registrar">
                        <input type="submit" class="btn" value="Registrar" />
                    </form>
                </div>
            </div>

            <div class="panels-container">
                <div class="panel left-panel">
                    <div class="content">
                        <h3>¿Eres nuevo acá?</h3>
                        <p>
                            Registrate y haz parte de tí los servicios que tenemos
                            a tú disposición total
                        </p>
                        <button class="btn transparent" id="sign-up-btn">
                            Registrarse
                        </button>
                    </div>
                    <img src="img/log.svg" class="image" alt="" />
                </div>
                <div class="panel right-panel">
                    <div class="content">
                        <h3>¿Ya tienes una cuenta?</h3>
                        <p>
                            Si ya tienes una cuenta, ingresa con tu nombre de usuario y clave
                        </p>
                        <button class="btn transparent" id="sign-in-btn">
                            Ingresar
                        </button>
                    </div>
                    <img src="img/register.svg" class="image" alt="" />
                </div>
            </div>
        </div>

        <!-- Verificacion de codigo de Administrador -->

        <div class="overlay<%=request.getParameter("MV_Cod")%>">
            <div class="popup<%=request.getParameter("MV_Cod")%>">
                <form action="Controlador" method="post">
                    <input type="hidden" name="URL" value="cv">
                    <input type="hidden" name="nombre_ventana" value="AUTENTIFICACION">
                    <input class="btn-cerrar-popup" type="image" src="svg-icons/times.svg" name="btnCerrar" value="">
                </form>
                <i class= "coda">
                    <iconify-icon icon="eva:alert-triangle-outline"></iconify-icon>
                </i>
                <h4>CÓDIGO DE VERIFICACION</h4>
                <form action="Controlador" method="post">
                    <input class="inputs" type="password" name="txtCod_V" placeholder="">
                    <div>
                        <%=request.getParameter("MSJcod")%>
                    </div>
                    <div>
                        <input type="hidden" name="URL" value="administrador">
                        <input type="hidden" name="usuario" value="<%=request.getParameter("usuario")%>">    
                        <input class="btn-submit" type="submit" name="btnRegistrar" value="COMPROBAR">  
                    </div>
                    <div>
                    </div>
                </form>
            </div>       
        </div>

        <script src="js/login.js"></script>
    </body>
</html>