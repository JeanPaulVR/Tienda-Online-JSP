<%-- 
    Document   : Modificar
    Created on : 15 set. 2022, 17:50:25
    Author     : Jean Paul
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="modelo.beans.Producto"%>
<%@page import="modelo.beans.Categoria"%>
<jsp:useBean class="modelo.logic.ProductoLogic" scope="page" id="pLogic"/>
<jsp:useBean class="modelo.logic.CategoriaLogic" scope="page" id="cLogic"/>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<jsp:useBean id="tipo" scope="request" class="java.lang.String"/>
<jsp:useBean id="cod" scope="request" class="java.lang.String"/>
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
        <title>Producto</title>
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
                        <span class="text">Modificar</span>
                    </div>
                </div>
                <%
                    if("producto".equals(tipo)) {
                %>

                <div id="formu">
                    <form action="Controlador"  method="post" enctype='multipart/form-data'>

                        <div class="form-group">
                            <label for="username">Nombre:</label>
                            <input id="username" type="text" name="txtnombre" required="required"/>
                        </div>

                        <div>
                            <label for="" class="text">Categoria:</label>
                            <select name="txtcat" class="botoncate">
                                <%
                                List<Categoria> listaC = new ArrayList<>();
                                listaC = cLogic.Listar("");

                                int m=listaC.size();
                                int j=0;
                            
                                while(j<m){
                              
                                int c1 = listaC.get(j).getCodigo();
                                String c2 = listaC.get(j).getNombre();
                                %>
                                <option  value="<%=c1%>"><%=c2%></option>
                                <%
                                j=j+1;
                                }
                                %>
                            </select>
                        </div>
                        <br>
                        <div class="form-group">
                            <label for="username">Precio:</label>
                            <input id="username" type="text" name="txtprecio" required="required"/>
                        </div> 
                        <div class="form-group">
                            <label for="username">Puntos por Compra:</label>
                            <input id="username" type="text" name="txtpuntos" required="required"/>
                        </div>
                        <br>   

                        <div>
                            <label for="" class="text-1">Imagen Principal: </label>
                            <input type="file" name="txtimgP" value="" class="botoncate2">
                        </div>
                        <br>
                        <div>
                            <label for="" class="text-1">Imagen Secundaria: </label>
                            <input type="file" name="txtimgS" value="" class="botoncate2">
                        </div>
                        <input type="hidden" name="txtcod" value="<%=Integer.parseInt(cod)%>">
                        <input type="hidden" name="URL" value="modificar_producto">
                        <button type="submit" class="btnc">Enviar</button>
                    </form> 
                </div>    
                <%
                    }else if("categoria".equals(tipo)){
                %>
                <div id="formu">
                    <form accion="Controlador" method="post">
                        <div class="form-group">
                            <label style="color: black">Nombre:</label>
                            <input id="username" type="text" name="txtnombre" required="required"/>
                        </div>
                        <input type="hidden" name="txtcod" value="<%=Integer.parseInt(cod)%>">
                        <input type="hidden" name="URL" value="modificar_categoria">
                        <button type="submit" class="btnc" align="center">Enviar</button>
                    </form>
                </div>
                <%
                    }
                %>

            </div>
        </section>
        <script src="js/script.js"></script>
        <script src="js/scriptprofile.js"></script>      
    </body>
</html>
<%
    }else{
        response.sendRedirect("AreaLogin.jsp");
    }
%>