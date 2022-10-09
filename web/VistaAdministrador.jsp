<%-- 
    Document   : vistaAdministrador
    Created on : 07/09/2022, 01:01:48 PM
    Author     : ERIKA
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:useBean id="Usuario" scope="session" class="modelo.beans.Usuario"/>
<jsp:useBean id="verif" scope="session" class="java.lang.String"/>
<%@page session = "true"%>
<!DOCTYPE html>
<%
    if(verif == "4dm1n"){
%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Admin</title>
        <link rel="icon" type="icon/png" href="img/icono.png"/>
        <!-- Iconscout CSS -->
        <link rel="stylesheet" href="https://unicons.iconscout.com/release/v4.0.0/css/line.css">
        <!-- CSS -->
        <link rel="stylesheet" href="css/estiloadmin.css"/>
    </head>
    <body>
        <nav>
            <div class="logo-name">
                <div class="logo-image">
                    <img src="img/icono.png" alt=""/>
                </div>
                <span class="logo_name">FOUR STORE </span>
            </div>
            <div class="menu-items">
                <ul class="nav-links">
                    <li>
                        <a href="#">
                            <form action="Controlador" method="post">
                                <input type="hidden" name="URL" value="area_administrador">
                                <input class="icon"type="image" src="svg-icons/estate.svg" type="submit" name="btnRegresar" value="">
                            </form>
                            <form action="Controlador" method="post">
                                <input type="hidden" name="URL" value="area_administrador">
                                <input class="link-name btn" type="submit" name="btnRegresar" value="INICIO">
                            </form>
                        </a>
                    </li>
                    <li>
                        <a href="#">
                            <form action="Controlador" method="post">
                                <input type="hidden" name="URL" value="area_pedido">
                                <input class="icon"type="image" src="svg-icons/svg-pedidos.svg" type="submit" name="btnRegresar" value="">
                            </form>
                            <form action="Controlador" method="post">
                                <input type="hidden" name="URL" value="area_pedido">
                                <input class="link-name btn" type="submit" name="btnRegresar" value="PEDIDOS">
                            </form>
                        </a>
                    </li>
                    <li>
                        <a href="#">
                            <form action="Controlador" method="post">
                                <input type="hidden" name="URL" value="area_producto">
                                <input class="icon" type="image" src="svg-icons/svg-productos.svg" type="submit" name="btnRegresar" value="">

                            </form>
                            <form action="Controlador" method="post">
                                <input type="hidden" name="URL" value="area_producto">
                                <input class="link-name btn" type="submit" name="btnRegresar" value="PRODUCTOS">
                            </form> 
                        </a>
                    </li>
                    <li>
                        <a href="#">
                            <form action="Controlador" method="post">
                                <input type="hidden" name="URL" value="area_categoria">
                                <input class="icon" type="image" src="svg-icons/svg-cate.svg" type="submit" name="btnListaPersona" value="">


                            </form>
                            <form action="Controlador" method="post">
                                <input type="hidden" name="URL" value="area_categoria">
                                <input class="link-name btn" type="submit" name="btnListaPersona" color="white" value="CATEGORIAS">
                            </form> 
                        </a>
                    </li>
                </ul>
                <ul class="logout-mode">
                    <li class="mode"> 
                        <div class="mode-toggle">
                        </div>
                    </li>
                </ul>
            </div>
        </nav>
        <section class="dashboard">
            <div class="top">
                <i class="uil uil-bars sidebar-toggle"></i>
                <div class="sesion">
                    <div class="profile">
                        <img src="img/admin.jpg"alt=""/>
                        <u1 class="profile-link">
                            <li>
                                <a>Hola <%=Usuario.getNombres()%></a>
                            </li>
                            <li>
                                <div class="a-user">
                                    <i class="uil uil-user-circle"></i>
                                    <form action="Controlador" method="post">
                                        <input type="hidden" name="URL" value="cerrar_sesion">
                                        <input class="btn-profile" type="submit" name="btnAgregar" value="Cerrar Sesion">
                                    </form>
                                </div>
                            </li>
                        </u1>
                    </div>
                </div>
            </div>
        </div>  
        <div class="dash-content">
            <div class="overwiew">
                <div class="title">
                    <i class="uil uil-tachometer-fast-alt"></i>
                    <span class="text">Bienvenido <%=Usuario.getNombres()%></span>
                </div>
            </div>
            <div class="boxes">
                <div class="box box1">
                    <i class="uil uil-users-alt"></i>
                    <span class="text">Clientes Registrados</span>
                    <span class="number" id="usuarios">0</span>
                </div>
                <div class="box box2">

                    <i class="uil uil-clipboard-notes"></i>
                    <span class="text">Categorias Registradas</span>
                    <span class="number" id="categorias">0</span>
                </div>
                <div class="box box3">
                    <i class="uil uil-cube"></i>
                    <span class="text">Productos Registrados</span>
                    <span class="number" id="productos">0</span>
                </div>
            </div>
            <br>
            <div class="boxes">
                <div class="box box1">
                    <i class="uil uil-clock-three"></i>
                    <span class="text">Pedidos Pendientes</span>
                    <span class="number" id="pendientes">0</span>
                </div>
                <div class="box box2">
                    <i class="uil uil-file-check"></i>
                    <span class="text">pedidos Realizados</span>
                    <span class="number" id="realizados">0</span>
                </div>
                <div class="box box3"> 
                    <i class="uil uil-ban"></i>
                    <span class="text">Pedidos Anulados</span>
                    <span class="number" id="anulados">0</span>
                </div>
            </div>
        </div>
    </section>
    <script src="https://code.jquery.com/jquery-3.6.1.min.js"></script>
    <script src="js/admin.js" type="text/javascript"></script>
    <script src="js/script.js"></script>
    <script src="js/scriptprofile.js" type="text/javascript"></script>
</body>
</html>
<%
    }else{
        response.sendRedirect("AreaLogin.jsp");
    }
%>