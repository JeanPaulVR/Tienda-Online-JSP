<%-- 
    Document   : DetalleP
    Created on : 10 set. 2022, 18:01:20
    Author     : Jean Paul
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:useBean class="modelo.logic.ProductoLogic" scope="page" id="pLogic"/>
<jsp:useBean class="modelo.beans.Producto" scope="page" id="pBeans"/>
<jsp:useBean id="msj" scope="request" class="java.lang.String"/>
<jsp:useBean id="verif" scope="session" class="java.lang.String"/>
<jsp:useBean id="Usuario" scope="session" class="modelo.beans.Usuario"/>
<%@page session = "true"%>
<!DOCTYPE html>
<%
    pBeans = pLogic.Datos(Integer.parseInt(msj));
    if(verif == "clnt"){
%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="css/bootstrap.min.css" rel="stylesheet">
        <link href="css/detalle.css" rel="stylesheet">
        <link href="css/HeaderyFooter.css" rel="stylesheet">
        <link rel="icon" type="icon/png" href="img/icono.png"/>
        <link rel="preconnect" href="https://fonts.googleapis.com">
        <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
        <link href="https://fonts.googleapis.com/css2?family=Poppins:wght@300;400;500;600;700;800;900&display=swap" rel="stylesheet">

        <title>Detalle-Producto</title>
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
        <section>
            <div class="container">
                <div class="row">
                    <div class="col-sm-9 padding-right">
                        <div class="product-details">
                            <div class="col-sm-5">
                                <div class="view-product">
                                    <img src="Controlador?URL=mostrar_imagen&id=<%=pBeans.getCodigo()%>&tip=a" />
                                    <h3>ZOOM</h3>
                                </div>
                                <div id="similar-product" class="carousel slide" data-ride="carousel">
                                    <a class="left item-control" href="#similar-product" data-slide="prev">
                                        <i class="fa fa-angle-left"></i>
                                    </a>
                                    <a class="right item-control" href="#similar-product" data-slide="next">
                                        <i class="fa fa-angle-right"></i>
                                    </a>
                                </div>
                            </div>
                            <div class="col-sm-7">
                                <div class="product-information">
                                    <img src="img/new.jpg" class="newarrival" alt="" />
                                    <h2><%=pBeans.getNombre()%></h2>
                                    <p>Web ID: <%=pBeans.getCodigo() %></p>
                                    <img src="img/rating.png" alt="" />
                                    <form action="Controlador" method="post">
                                        <span>
                                            <span>PEN $<%=pBeans.getPrecio() %></span>
                                            <label>Cantidad:</label>
                                            <input type="text" name="txtcantidad" value="1" id="txt-cantidad"/>
                                            <input type="hidden" name="txtcod" value="<%=pBeans.getCodigo() %>">
                                            <input type="hidden" name="URL" value="agregar_carrito">
                                            <button type="submit" class="btn btn-fefault cart">
                                                <i class="fa fa-shopping-cart"></i>
                                                Añadir al carrito
                                            </button>
                                        </span>
                                    </form>
                                    <p><b>Disponibilidad:</b> Activa</p>
                                    <p><b>Estado:</b> Nuevo</p>
                                    <a href=""><img src="images/product-details/share.png" class="share img-responsive"  alt="" /></a>
                                </div>
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
    </body>

    <script type="module" src="https://unpkg.com/ionicons@5.5.2/dist/ionicons/ionicons.esm.js"></script>
    <script nomodule src="https://unpkg.com/ionicons@5.5.2/dist/ionicons/ionicons.js"></script>

</html>
<%
    }else{
        response.sendRedirect("AreaLogin.jsp");
    }
%>