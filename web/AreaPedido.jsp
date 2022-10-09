<%-- 
    Document   : AreaPedido
    Created on : 9 set. 2022, 11:08:28
    Author     : Jean Paul
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:useBean id="Usuario" scope="session" class="modelo.beans.Usuario"/>
<jsp:useBean id="verif" scope="session" class="java.lang.String"/>
<%@page import="modelo.beans.Pedido"%>
<jsp:useBean id="msj" scope="request" class="java.lang.String"/>
<jsp:useBean class="modelo.logic.PedidoLogic" scope="page" id="pLogic"/>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page session = "true"%>
<!DOCTYPE html>
<%
    if(verif == "4dm1n"){
%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Pedidos</title>
        <link rel="icon" type="icon/png" href="img/icono.png"/>
        <!-- Iconscout CSS -->
        <link rel="stylesheet" href="https://unicons.iconscout.com/release/v4.0.0/css/line.css">
        <!-- CSS -->
        <link rel="stylesheet" href="css/estiloadmin.css"/>
        <link rel="stylesheet" href="css/alerta.css"/>
        <link rel="preconnect" href="https://fonts.googleapis.com" />
        <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin />
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
                        <span class="text">MENSAJES DEL SISTEMA</span>
                    </div>
                    <div class="activity">
                        <span class="text">
                            <%
                        if(msj!=null)
                            out.print(msj);
                            %>
                        </span>
                    </div>
                    <div class="title">
                        <i class="uil uil-tachometer-fast-alt"></i>
                        <span class="text">PEDIDOS PENDIENTES</span>
                    </div>
                    <!-- barra de busqueda -->
                    <div class="buscabar">
                        <div class="contebus">
                            <input type="date" class="bus" placeholder="Buscar" id="f_desdep">
                            <input type="date" class="bus" placeholder="Buscar" id="f_hastap">
                            <div class="btnbus" onclick="MostrarPP()">
                                <i class="fa fa-search"></i>
                            </div>
                        </div>
                    </div>
                    <div class="activity">
                        <div class="contenedor2">
                            <div class="tabla2">
                                <table border="0" id="pedidos_p">
                                    <thead>
                                        <tr>
                                            <th>N°</th>
                                            <th>ID</th>
                                            <th>FECHA</th>
                                            <th>CLIENTE</th>
                                            <th>TOTAL</th>
                                            <th>OPCIONES</th>
                                        </tr>
                                    </thead>

                                </table>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="title">
                    <i class="uil uil-tachometer-fast-alt"></i>
                    <span class="text">PEDIDOS REALIZADOS</span>
                </div>
                <!-- barra de busqueda -->
                <div class="buscabar">
                    <div class="contebus">
                        <input type="date" class="bus" placeholder="Buscar" id="f_desder">
                        <input type="date" class="bus" placeholder="Buscar" id="f_hastar">
                        <div class="btnbus" onclick="MostrarPR()">
                            <i class="fa fa-search"></i>
                        </div>
                    </div>
                </div>
                <div class="activity">
                    <div class="contenedor2">
                        <div class="tabla2">
                            <table border="0" id="pedidos_r">
                                <thead>
                                    <tr>
                                        <th>N°</th>
                                        <th>ID</th>
                                        <th>FECHA C</th>
                                        <th>FECHA E</th>
                                        <th>CLIENTE</th>
                                        <th>TOTAL</th>
                                        <th>OPCIONES</th>
                                    </tr>
                                </thead>

                            </table>
                        </div>
                    </div>
                </div>
                <div class="title">
                    <i class="uil uil-tachometer-fast-alt"></i>
                    <span class="text">PEDIDOS ANULADOS</span>
                </div>
                <!-- barra de busqueda -->
                <div class="buscabar">
                    <div class="contebus">
                        <input type="date" class="bus" placeholder="Buscar" id="f_desdea">
                        <input type="date" class="bus" placeholder="Buscar" id="f_hastaa">
                        <div class="btnbus" onclick="MostrarPA()">
                            <i class="fa fa-search"></i>
                        </div>
                    </div>
                </div>
                <div class="activity">
                    <div class="contenedor2">
                        <div class="tabla2">
                            <table border="0" id="pedidos_a">
                                <thead>
                                    <tr>
                                        <th>N°</th>
                                        <th>ID</th>
                                        <th>FECHA</th>
                                        <th>CLIENTE</th>
                                        <th>TOTAL</th>
                                        <th>OPCIONES</th>
                                    </tr>
                                </thead>

                            </table>
                        </div>
                    </div>
                </div>
            </div>
        </section>

        <%-- CONFIRMAR PEDIDO --%>

        <div class="overlay1<%=request.getParameter("MV_Pedido")%>">
            <div class="popup1<%=request.getParameter("MV_Pedido")%>">
                <form action="Controlador" method="post">
                    <input type="hidden" name="URL" value="cv">
                    <input type="hidden" name="nombre_ventana" value="CONFIRMAR_PEDIDO">
                    <input class="btn-cerrar-popup" type="image" src="svg-icons/times.svg" name="btnCerrar" value="">
                </form>           
                <form action="Controlador" method="post">
                    <h3> Confirmar Pedido</h3>
                    <h4>Fecha de entrega:</h4>
                    <input class="input" type="date" name="txtfecha">
                    <input type="hidden" name="ID" value="<%=request.getParameter("ID")%>">
                    <input type="hidden" name="URL" value="estado_pedido">
                    <input type="hidden" name="tipo" value="REALIZADO">
                    <input class="btn-submit" type="submit" name="btnCerrar" value="Confirmar">
                </form>
            </div>       
        </div>

        <%-- DETALLE PEDIDO --%>  

        <div id="overlay1null" class="overlay1null">
            <div id="popup1null" class="popup1null">
                <div id="detalles">
                    <%-- detalles --%>
                </div>
                <button class="btnc close" type="submit" 
                        onclick="Cerrar()" >Cerrar</button>
            </div>
        </div>

        <script src="https://code.jquery.com/jquery-3.6.1.min.js"></script>
        <script src="js/detalles.js" type="text/javascript"></script>
        <script src="js/pedidos.js" type="text/javascript"></script>
        <script src="js/script.js"></script>
        <script src="js/scriptprofile.js"></script> 
    </body>
</html>
<%
    }else{
        response.sendRedirect("AreaLogin.jsp");
    }
%>