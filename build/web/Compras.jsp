<%-- 
    Document   : Compras
    Created on : 13 set. 2022, 09:13:54
    Author     : Jean Paul
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="modelo.beans.Pedido"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<jsp:useBean class="modelo.logic.PedidoLogic" scope="page" id="pLogic"/>
<jsp:useBean id="Usuario" scope="session" class="modelo.beans.Usuario"/>
<jsp:useBean id="verif" scope="session" class="java.lang.String"/>
<%@page session = "true"%>
<!DOCTYPE html>
<%
        if(verif == "clnt"){
        List<Pedido> pedidos = pLogic.ListarxUsuario(Usuario.getCodigo());
%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="css/bootstrap.min.css" rel="stylesheet">
        <link href="css/HeaderyFooter.css" rel="stylesheet">
        <link href="css/main.css" rel="stylesheet" type="text/css"/>
        <link rel="icon" type="icon/png" href="img/icono.png"/>
        <link rel="preconnect" href="https://fonts.googleapis.com">
        <link rel="preconnect" href="https://fonts.gstatic.com">
        <link href="https://fonts.googleapis.com/css2?family=Poppins:wght@300;400;500;600;700;800;900&display=swap" rel="stylesheet">
        <script src="https://kit.fontawesome.com/eb496ab1a0.js" crossorigin="anonymous"></script>

        <title>Mis Compras</title>
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
                <div class="col-sm-6">
                    <div class="total_area">
                        <h3>Mis Compras</h3>
                        <p>Si acabas de realizar un pedido, realiza el pago a travez de whatsapp con el siguiente enlace:</p>
                        <br><br><br><br><br>
                        <p>Puedes ver el estado de tu pedido y la fecha correspondiente de llegada si ya efectuo el pago:</p>
                        <a href="https://api.whatsapp.com/send?phone=+51994162927" class="btn-wsp" target="_blank">
                            <i class="fa fa-whatsapp icono"></i>
                        </a>
                    </div>
                </div>
            </div>
            <div class="container">
                <div class="breadcrumbs">
                    <ol class="breadcrumb">
                    </ol>
                </div>
                <div class="table-responsive cart_info" id="cart-container">
                    <table class="table table-condensed" id="shop-table">
                        <thead>
                            <tr class="cart_menu">
                                <td class="quantity">N°</td>
                                <td class="quanity">Fecha Compra</td>
                                <td class="quanity">Fecha Entrega</td>
                                <td class="quantity">Ptos Ganados</td>
                                <td class="quantity">Ptos Usados</td>
                                <td class="price">Total</td>
                                <td class="total">Total Neto</td>
                                <td class="description">Estado</td>
                                <td></td>
                            </tr>
                        </thead>
                        <tbody>
                            <%
                                if(pedidos != null){
                                int i = 1;
                                for(Pedido p : pedidos){
                            %>
                            <tr>
                                <td class="cart_price" width="50">
                                    <a><%=i%></a>
                                </td>
                                <td class="cart_price">
                                    <p><%= p.getFechaC()%></p>
                                </td>
                                <%
                                        String fechE = "-";
                                        if(p.getFechaE() != null){
                                            fechE = String.valueOf(p.getFechaE());
                                        }
                                %>
                                <td class="cart_price">
                                    <p><%= fechE%></p>
                                </td>
                                <td class="cart_price">
                                    <p><%= p.getTotalptosG()%></p>
                                </td>
                                <td class="cart_price">
                                    <p><%= p.getPtosCanje()%></p>
                                </td>
                                <td class="cart_price">
                                    <p>$<%= p.getTotal()%></p>
                                </td>
                                <td class="cart_total">
                                    <p class="cart_total_price">$<%= p.getTotalNeto()%></p>
                                </td>
                                <td class="cart_quantity">
                                    <%
                                        String img = "";
                                        if(p.getEstado().equals("PENDIENTE")){
                                            img = "img/espera.png";
                                        } else if(p.getEstado().equals("REALIZADO")){
                                            img = "img/comprobado.png";
                                        } else if(p.getEstado().equals("ANULADO")){
                                            img = "img/boton-x.png";
                                        }
                                    %>
                                    <img src="<%=img%>">
                                </td>
                            </tr>
                            <%
                                i++;
                                }
                                }
                            %>                           
                        </tbody>
                    </table>
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
        <script type="module" src="https://unpkg.com/ionicons@5.5.2/dist/ionicons/ionicons.esm.js"></script>
        <script nomodule src="https://unpkg.com/ionicons@5.5.2/dist/ionicons/ionicons.js"></script>
    </body>
</html>
<%
    }else{
        response.sendRedirect("AreaLogin.jsp");
    }
%>