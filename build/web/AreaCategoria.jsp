<%-- 
    Document   : vistaAdministrador
    Created on : 07/09/2022, 01:01:48 PM
    Author     : ERIKA
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="modelo.beans.Categoria"%>
<jsp:useBean class="modelo.logic.CategoriaLogic" scope="page" id="cLogic"/>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<jsp:useBean id="msj" scope="request" class="java.lang.String"/>
<jsp:useBean id="verif" scope="session" class="java.lang.String"/>
<jsp:useBean id="Usuario" scope="session" class="modelo.beans.Usuario"/>
<%@page session = "true"%>
<!DOCTYPE html>
<%
    if(verif == "4dm1n"){
%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="css/alerta.css"/>
        <!-- Iconscout CSS -->
        <link rel="stylesheet" href="https://unicons.iconscout.com/release/v4.0.0/css/line.css">
        <!-- CSS -->
        <link rel="stylesheet" href="css/estiloadmin.css"/>
        <link rel="icon" type="icon/png" href="img/icono.png"/>
        <link
            href="https://fonts.googleapis.com/css2?family=Poppins&display=swap"
            rel="stylesheet"
            />

        <link
            rel="stylesheet"
            href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.1.1/css/all.min.css"
            integrity="sha512-KfkfwYDsLkIlwQp6LFnl8zNdLGxu9YAA1QvwINks4PhcElQSvqcyVLLD9aMhXd13uQjoXtEKNosOWaZqXgel0g=="
            crossorigin="anonymous"
            referrerpolicy="no-referrer"
            />
        <title>Categoria</title>
    </head>
    <body>
        <nav>
            <div class="logo-name">
                <div class="logo-image">
                    <img src="img/icono.png" alt=""/>
                </div>
                <span class="logo_name">FOUR STORE</span>
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
            <div class="dash-content">
                <div class="overwiew">
                    <div class="title">
                        <i class="uil uil-tachometer-fast-alt"></i>
                        <span class="text">AGREGAR CATEGORIA</span>
                    </div>
                </div>
                    <form accion="Controlador" method="post">
                        <div class="form-group">
                            <label>Nombre:</label>
                            <input id="username" type="text" name="txtnombre" required="required"/>
                        </div>
                        <input type="hidden" name="URL" value="agregar_categoria">
                        <button type="submit" class="btnc" align="center">Enviar</button><br>
                        <%
                        if(msj!=null)
                            out.print(msj);
                        %>
                    </form>
                <div class="activity">
                    <div class="title">
                        <i class="uil uil-clock-three"></i>
                        <span class="text">LISTAR CATEGORIA</span>
                    </div>
                    <!-- barra de busqueda -->
                    <div class="buscabar">
                        <div class="contebus">
                            <input type="text" class="bus" placeholder="Buscar" id="b_cat">
                            <div class="btnbus" onclick="Mostrar()">
                                <i class="fa fa-search"></i>
                            </div>
                        </div>
                    </div>
                    <div class="contenedor2">
                        <div class="tabla2">
                            <table border="0" id="tabla_cate">
                                <thead>
                                    <tr>
                                        <th>N°</th>
                                        <th>Codigo</th>
                                        <th>Nombre</th>
                                        <th>Opciones</th>
                                    </tr>
                                </thead>

                            </table>
                        </div>
                    </div>
                </div>
            </div>
        </section>

        <script src="https://code.jquery.com/jquery-3.6.1.min.js"></script>   
        <script src="js/script.js"></script>
        <script src="js/scriptprofile.js"></script>      
        <script src="js/categoria.js" type="text/javascript"></script>
    </body>
</html>
<%
    }else{
        response.sendRedirect("AreaLogin.jsp");
    }
%>