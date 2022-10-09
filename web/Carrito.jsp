<%-- 
    Document   : Carrito
    Created on : 10 set. 2022, 12:39:17
    Author     : Jean Paul
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="modelo.beans.DetallePedido"%>
<%@page import="modelo.beans.Producto"%>
<jsp:useBean class="modelo.logic.ProductoLogic" scope="page" id="pLogic"/>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<jsp:useBean id="Usuario" scope="session" class="modelo.beans.Usuario"/>
<jsp:useBean id="verif" scope="session" class="java.lang.String"/>
<%@page session = "true"%>
<!DOCTYPE html>
<%
        if(verif == "clnt"){
            HttpSession osesion = request.getSession(true);
            ArrayList<DetallePedido> productos = osesion.getAttribute("carrito") == null ? null : (ArrayList) osesion.getAttribute("carrito");
%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="css/bootstrap.min.css" rel="stylesheet">
        <link href="css/HeaderyFooter.css" rel="stylesheet">
        <link href="css/font-awesome.min.css" rel="stylesheet">
        <link href="css/main.css" rel="stylesheet">
        <link href="css/responsive.css" rel="stylesheet">
        <link rel="icon" type="icon/png" href="img/icono.png"/>
        <link rel="preconnect" href="https://fonts.googleapis.com">
        <link rel="preconnect" href="https://fonts.gstatic.com">
        <link href="https://fonts.googleapis.com/css2?family=Poppins:wght@300;400;500;600;700;800;900&display=swap" rel="stylesheet">

        <title>Carrito</title>
    </head>
    <body>
        <header>
            <div class="header-main">
                <div class="container">
                    <a href="index.jsp" class="header-logo ah">
                        <img src="img/principal.png" alt="Anon's logo" width="300" height="100">
                    </a>
                    <div class="header-search-container">
                        <input type="search" name="search" class="search-field inputh" placeholder="Buscar...">
                        <button class="search-btn buttonh">
                            <ion-icon name="search-outline"></ion-icon>
                        </button>
                    </div>
                    <div class="header-user-actions">
                        <button class="action-btn buttonh" onclick="location.href = 'Carrito.jsp'">
                            <ion-icon name="cart-outline"></ion-icon>
                        </button>
                        <button class="action-btn buttonh" onclick="location.href = 'Compras.jsp'">
                            <ion-icon name="bag-handle-outline"></ion-icon>
                        </button>
                        <ul class="desktop-menu-category-list">
                            <li class="menu-category lih">
                                <img src="img/usuario.png"alt=""/>
                                <ul class="dropdown-list">
                                    <li class="dropdown-item lih">
                                        <a class="ah">Hola <%=Usuario.getNombres()%></a>
                                        <a class="ah" href="Controlador?URL=cerrar_sesion">Cerrar Sesion</a>
                                    </li>
                                </ul>
                            </li>
                        </ul>
                    </div>
                </div>
            </div>
            <nav class="desktop-navigation-menu">
                <div class="container">
                    <ul class="desktop-menu-category-list">
                        <li class="menu-category lih">
                            <a href="index.jsp" class="menu-title ah">Inicio</a>
                        </li>
                        <li class="menu-category lih">
                            <a href="#" class="menu-title ah">Categorias</a>
                        </li>
                        <li class="menu-category lih">
                            <a href="#" class="menu-title ah">Ofertas</a>
                        </li>
                        <li class="menu-category lih">
                            <a href="#" class="menu-title ah">Blog</a>
                        </li>
                        <li class="menu-category lih">
                            <a href="#" class="menu-title ah">Nosotros</a>
                            <ul class="dropdown-list">
                                <li class="dropdown-item lih">
                                    <a class="ah" href="#">Misión</a>
                                </li>
                                <li class="dropdown-item lih">
                                    <a class="ah" href="#">Visión</a>
                                </li>
                                <li class="dropdown-item lih">
                                    <a class="ah" href="#">Organigrama</a>
                                </li>
                            </ul>
                        </li>
                        <li class="menu-category lih">
                            <a href="#" class="menu-title ah">Contacto</a>
                            <ul class="dropdown-list">
                                <li class="dropdown-item lih">
                                    <a class="ah" href="#">Teléfono</a>
                                </li>
                                <li class="dropdown-item lih">
                                    <a class="ah" href="#">Whatsapp</a>
                                </li>
                                <li class="dropdown-item lih">
                                    <a class="ah" href="#">Correo electrónico</a>
                                </li>
                            </ul>
                        </li>
                    </ul>
                </div>
            </nav>
        </header>
        <section id="cart_items">
            <div class="container">
                <div class="breadcrumbs">
                    <ol class="breadcrumb">
                    </ol>
                </div>
                <div class="table-responsive cart_info" id="cart-container">
                    <table class="table table-condensed" id="shop-table">
                        <thead>
                            <tr class="cart_menu">
                                <td class="image">Producto</td>
                                <td class="description">Descripcion</td>
                                <td class="price">Precio</td>
                                <td class="quantity">Cantidad</td>
                                <td class="total">Total</td>
                                <td></td>
                            </tr>
                        </thead>
                        <tbody>
                            <%
                                double total = 0;
                                int ptosG = 0;
                                if(productos != null){
                                for(DetallePedido d: productos){
                                    Producto producto = pLogic.Datos(d.getCodProducto());
                                    total+=d.getPrecio();
                                    ptosG+=d.getPtosG();
                                    
                            %>
                            <tr>
                                <td class="cart_product" width="120">
                                    <a href=""><img src="Controlador?URL=mostrar_imagen&id=<%=producto.getCodigo()%>&tip=a" alt="" width="120"></a>
                                </td>
                                <td class="cart_description">
                                    <h4><a href=""><%= producto.getNombre()%></a></h4>
                                    <p>Web ID: <%= producto.getCodigo()%></p>
                                </td>
                                <td class="cart_price">
                                    <p>$<%= producto.getPrecio()%></p>
                                </td>
                                <td class="cart_quantity">
                                    <div class="cart_quantity_button">
                                        <input class="cart_quantity_input" type="text" name="quantity" value="<%= d.getCantidad()%>" autocomplete="off" size="2">
                                    </div>
                                </td>
                                <td class="cart_total">
                                    <p class="cart_total_price">$<%= d.getPrecio()%></p>
                                </td>
                                <td class="cart_delete">
                                    <span id="idarticulo" style="display:none;"><%= producto.getCodigo()%></span>
                                    <a class="cart_quantity_delete" href="" id="deleteitem">
                                        <img src="img/eliminar-carrito.png" alt=""/>
                                    </a>
                                </td>
                            </tr>
                            <%
                                }
                                }
                            %>                           
                        </tbody>
                    </table>
                </div>
            </div>
        </section>
        <section id="do_action">
            <div class="container">
                <div class="heading">
                    <h3>Confirma tu pedido</h3>
                    <p>Adquiere tus productos en la puerta de tu casa y obten puntos de descuento para tu siguiente compra!</p>
                </div>
                <div class="row">
                    <div class="col-sm-6">
                        <form action="Carrito.jsp" method="post">
                            <div class="chose_area">
                                <ul class="user_option">
                                    <li>
                                        <h4>Canjea tus puntos aquí!</h4>
                                    </li><br><br>
                                    <li>
                                        <p>Puntos Disponibles: <span><%= Usuario.getPtosac()%></span></p>
                                    </li><br>
                                </ul>
                                <ul class="user_info">
                                    <li class="single_field zip-field">
                                        <p>Puntos a canjear:</p>
                                        <input type="number" value="0" name="puntosusados">
                                    </li>
                                </ul>
                                <button type="submit" class="btn btn-default update">Agregar</button>
                            </div>
                        </form>
                    </div>
                    <%
                        String dato = request.getParameter("puntosusados");
                        int puntosU = 0;
                        double desc = 0;
                        if(dato != null && Usuario.getPtosac()>=Integer.parseInt(dato)){
                            puntosU = Integer.parseInt(dato);
                            desc = puntosU/10;
                        } else if (dato != null && Usuario.getPtosac()<Integer.parseInt(dato)){
                            puntosU = Usuario.getPtosac();
                            desc = puntosU/10;
                        }
                    %>
                    <div class="col-sm-6">
                        <div class="total_area">
                            <ul>
                                <li>Sub Total: <span id="txt-subtotal">$<%= total%></span></li>
                                <li>Puntos Usados: <span><%= puntosU%></span></li>
                                <li>Puntos Ganados: <span id="txt-pts"><%= ptosG%></span></li>
                                <li>Descuento por Puntos: <span>$<%= desc%></span></li>
                                <li>Total a pagar: <span id="txt-total"><%= total-desc%></span></li>
                            </ul>
                            <form action="Controlador" method="post">
                                <input type="hidden" name="txttotal" value="<%= total%>">
                                <input type="hidden" name="txtptos" value="<%= puntosU%>">
                                <input type="hidden" name="txtneto" value="<%= total-desc%>">
                                <input type="hidden" name="txtptosg" value="<%= ptosG%>">
                                <input type="hidden" name="URL" value="finalizar_venta">
                                <input type="submit" name="rbt" class="btn btn-default update" value="Confirmar">
                            </form>
                        </div>
                    </div>      
                </div>
            </div>
        </section>
        <footer>            
            <div class="footer-nav">
                <div class="container">
                    <ul class="footer-nav-list">
                        <li class="footer-nav-item">
                            <h2 class="nav-title">Categorias Populares</h2>
                        </li>
                        <li class="footer-nav-item">
                            <a href="#" class="footer-nav-link">Smarphones</a>
                        </li>
                        <li class="footer-nav-item">
                            <a href="#" class="footer-nav-link">Mouses</a>
                        </li>
                        <li class="footer-nav-item">
                            <a href="#" class="footer-nav-link">Parlantes</a>
                        </li>
                        <li class="footer-nav-item">
                            <a href="#" class="footer-nav-link">Audifonos</a>
                        </li>
                        <li class="footer-nav-item">
                            <a href="#" class="footer-nav-link">Teclados</a>
                        </li>
                    </ul>
                    <ul class="footer-nav-list">

                        <li class="footer-nav-item">
                            <h2 class="nav-title">Marcas</h2>
                        </li>
                        <li class="footer-nav-item">
                            <a href="#" class="footer-nav-link">Samsung</a>
                        </li>

                        <li class="footer-nav-item">
                            <a href="#" class="footer-nav-link">Huawei</a>
                        </li>
                        <li class="footer-nav-item">
                            <a href="#" class="footer-nav-link">Asus</a>
                        </li>
                        <li class="footer-nav-item">
                            <a href="#" class="footer-nav-link">Xiaomi</a>
                        </li>
                        <li class="footer-nav-item">
                            <a href="#" class="footer-nav-link">Steelseries</a>
                        </li>
                    </ul>
                    <ul class="footer-nav-list">
                        <li class="footer-nav-item">
                            <h2 class="nav-title">Servicios</h2>
                        </li>
                        <li class="footer-nav-item">
                            <a href="#" class="footer-nav-link">Delivery</a>
                        </li>
                        <li class="footer-nav-item">
                            <a href="#" class="footer-nav-link">Sistema de Entrega</a>
                        </li>
                        <li class="footer-nav-item">
                            <a href="#" class="footer-nav-link">Compra Segura</a>
                        </li>
                        <li class="footer-nav-item">
                            <a href="#" class="footer-nav-link">Preguntas Frecuentes</a>
                        </li>
                        <li class="footer-nav-item">
                            <a href="#" class="footer-nav-link">Soporte</a>
                        </li>
                    </ul>
                    <ul class="footer-nav-list">
                        <li class="footer-nav-item">
                            <h2 class="nav-title">Medios de Pago</h2>
                        </li>
                        <li class="footer-nav-item">
                            <a href="#" class="footer-nav-link">Transferencia Bancaria</a>
                        </li>
                        <li class="footer-nav-item">
                            <a href="#" class="footer-nav-link">Yape</a>
                        </li>
                        <li class="footer-nav-item">
                            <a href="#" class="footer-nav-link">Plin</a>
                        </li>
                        <li class="footer-nav-item">
                            <a href="#" class="footer-nav-link">Pagoefectivo</a>
                        </li>
                    </ul>
                    <ul class="footer-nav-list">
                        <li class="footer-nav-item">
                            <h2 class="nav-title">Contactanos</h2>
                        </li>
                        <li class="footer-nav-item flex">
                            <div class="icon-box">
                                <ion-icon name="location-outline"></ion-icon>
                            </div>
                            <address class="content">
                                419 State 414 Rte
                                Beaver Dams, New York(NY), 14812, USA
                            </address>
                        </li>
                        <li class="footer-nav-item flex">
                            <div class="icon-box">
                                <ion-icon name="call-outline"></ion-icon>
                            </div>
                            <a href="tel:+607936-8058" class="footer-nav-link">925 632 345</a>
                        </li>
                        <li class="footer-nav-item flex">
                            <div class="icon-box">
                                <ion-icon name="mail-outline"></ion-icon>
                            </div>
                            <a href="mailto:example@gmail.com" class="footer-nav-link">tiendaonline@gmail.com</a>
                        </li>
                    </ul>
                    <ul class="footer-nav-list">
                        <li class="footer-nav-item">
                            <h2 class="nav-title">Follow Us</h2>
                        </li>
                        <li>
                            <ul class="social-link">
                                <li class="footer-nav-item">
                                    <a href="#" class="footer-nav-link">
                                        <ion-icon name="logo-facebook"></ion-icon>
                                    </a>
                                </li>
                                <li class="footer-nav-item">
                                    <a href="#" class="footer-nav-link">
                                        <ion-icon name="logo-twitter"></ion-icon>
                                    </a>
                                </li>
                                <li class="footer-nav-item">
                                    <a href="#" class="footer-nav-link">
                                        <ion-icon name="logo-linkedin"></ion-icon>
                                    </a>
                                </li>
                                <li class="footer-nav-item">
                                    <a href="#" class="footer-nav-link">
                                        <ion-icon name="logo-instagram"></ion-icon>
                                    </a>
                                </li>
                            </ul>
                        </li>
                    </ul>
                </div>
            </div>
            <div class="footer-bottom">
                <div class="container">
                    <img src="img/payment.png" alt="payment method" class="payment-img">
                    <p class="copyright">
                        Copyright &copy; <a href="#">Anon</a> all rights reserved.
                    </p>
                </div>
            </div>
        </footer>

        <script src="https://code.jquery.com/jquery-3.6.1.min.js"></script>
        <script src="js/carrito.js" type="text/javascript"></script>
        <script src="js/detalles.js" type="text/javascript"></script>
        <script type="module" src="https://unpkg.com/ionicons@5.5.2/dist/ionicons/ionicons.esm.js"></script>
        <script nomodule src="https://unpkg.com/ionicons@5.5.2/dist/ionicons/ionicons.js"></script>
    </body>
</html>
<%
    }else{
        response.sendRedirect("AreaLogin.jsp");
    }
%>
