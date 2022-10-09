<%-- 
    Document   : index
    Created on : 15 set. 2022, 22:29:19
    Author     : Jean Paul
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:useBean id="verif" scope="session" class="java.lang.String"/>
<jsp:useBean id="Usuario" scope="session" class="modelo.beans.Usuario"/>
<%@page session = "true"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="css/bootstrap.min.css" rel="stylesheet">
        <link href="css/detalle.css" rel="stylesheet">
        <link href="css/style.css" rel="stylesheet">
        <link rel="shortcut icon" href="./assets/images/logo/favicon.ico" type="image/x-icon">
        <link rel="icon" type="icon/png" href="img/icono.png"/>
        <link rel="preconnect" href="https://fonts.googleapis.com">
        <link rel="preconnect" href="https://fonts.gstatic.com">
        <link href="https://fonts.googleapis.com/css2?family=Poppins:wght@300;400;500;600;700;800;900&display=swap" rel="stylesheet">

        <title>Inicio</title>
    </head>
    <body>
        <header>
            <div class="header-main">
                <div class="container">
                    <a href="index.jsp" class="header-logo">
                        <img src="img/principal.png" alt="Anon's logo" width="300" height="100">
                    </a>
                    <div class="header-search-container">
                        <input type="search" name="search" class="search-field" placeholder="Buscar..." value="" id="buscador">
                        <button class="search-btn" onclick="MostrarLista()">
                            <ion-icon name="search-outline" ></ion-icon>
                        </button>
                    </div>
                    <div class="header-user-actions">
                        <%
                            if(verif == "clnt"){
                        %>
                        <button class="action-btn" onclick="location.href = 'Carrito.jsp'">
                            <ion-icon name="cart-outline"></ion-icon>
                        </button>
                        <button class="action-btn" onclick="location.href = 'Compras.jsp'">
                            <ion-icon name="bag-handle-outline"></ion-icon>
                        </button>
                        <ul class="desktop-menu-category-list">
                            <li class="menu-category">
                                <img src="img/usuario.png"alt=""/>
                                <ul class="dropdown-list">
                                    <li class="dropdown-item">
                                        <a>Hola <%=Usuario.getNombres()%></a>
                                        <a href="Controlador?URL=cerrar_sesion">Cerrar Sesion</a>
                                    </li>
                                </ul>
                            </li>
                        </ul>
                        <%
                            }else{
                        %>
                        <button class="action-btn" onclick="location.href = 'AreaLogin.jsp'">
                            <ion-icon name="person-outline"></ion-icon>
                        </button>
                        <%
                            }
                        %>
                    </div>
                </div>
            </div>
            <nav class="desktop-navigation-menu">
                <div class="container">
                    <ul class="desktop-menu-category-list">
                        <li class="menu-category">
                            <a href="index.jsp" class="menu-title">Inicio</a>
                        </li>
                        <li class="menu-category">
                            <a href="#" class="menu-title">Categorias</a>
                        </li>
                        <li class="menu-category">
                            <a href="#" class="menu-title">Ofertas</a>
                        </li>
                        <li class="menu-category">
                            <a href="#" class="menu-title">Blog</a>
                        </li>
                        <li class="menu-category">
                            <a href="#" class="menu-title">Nosotros</a>
                            <ul class="dropdown-list">
                                <li class="dropdown-item">
                                    <a href="#">Misión</a>
                                </li>
                                <li class="dropdown-item">
                                    <a href="#">Visión</a>
                                </li>
                                <li class="dropdown-item">
                                    <a href="#">Organigrama</a>
                                </li>
                            </ul>
                        </li>
                        <li class="menu-category">
                            <a href="#" class="menu-title">Contacto</a>
                            <ul class="dropdown-list">
                                <li class="dropdown-item">
                                    <a href="#">Teléfono</a>
                                </li>
                                <li class="dropdown-item">
                                    <a href="#">Whatsapp</a>
                                </li>
                                <li class="dropdown-item">
                                    <a href="#">Correo electrónico</a>
                                </li>
                            </ul>
                        </li>
                    </ul>
                </div>
            </nav>
        </header>
        <section>
            
            <!-- Publicidad -->
            
            <div class="banner">
                <div class="container">
                    <div class="slider-container has-scrollbar">
                        <div class="slider-item">
                            <img src="img/fondo-index2.png" alt="motog20" class="banner-img">
                            <div class="banner-content">
                                <p class="banner-subtitle">Adquiere los mejores productos aqui</p>
                                <h2 class="banner-title">FOUR STORE</h2>
                                <p class="banner-text">
                                    Gana puntos y usalos como descuento para tu siguiente compra!
                                </p>
                                <a href="AreaLogin.jsp" class="banner-btn">Registro</a>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <div class="product-container">
                <div class="container">

                    <!--Barra Lateral Categorias-->

                    <div class="sidebar  has-scrollbar" data-mobile-menu>
                        <div class="sidebar-category">
                            <div class="sidebar-top">
                                <h2 class="sidebar-title">Categorias</h2>
                            </div>
                            <div id="categorias">
                                
                                <!-- Categoria por JQuery y JSON -->
                                
                            </div>
                        </div>

                        <!-- Mejores Productos -->
                        
                        <div class="product-showcase">
                            <h3 class="showcase-heading">Mejores productos&nbsp;</h3>
                            <div class="showcase-wrapper">
                                <div class="showcase-container" id="mejoresproductos">

                                    <!-- Mejores Productos por JQuery y JSON -->

                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="product-box">

                        <!-- Lo mas Nuevo -->
                        
                        <div class="product-featured">
                            <h2 class="title">Lo Mas Reciente</h2>
                            <div class="showcase-wrapper has-scrollbar" id="masnuevo">

                                <!-- Lo mas Nuevo -->

                            </div>
                        </div>

                        <!-- Productos-->

                        <div class="product-main">
                            <h2 class="title">Nuestros Productos</h2>
                            <div id ="productost" class="product-grid">
                                
                                <!-- Productos por JQuery y JSON -->
                                
                            </div>
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
        <script src="js/filtro.js"></script>
        <script type="module" src="https://unpkg.com/ionicons@5.5.2/dist/ionicons/ionicons.esm.js"></script>
        <script nomodule src="https://unpkg.com/ionicons@5.5.2/dist/ionicons/ionicons.js"></script>
    </body>
</html>