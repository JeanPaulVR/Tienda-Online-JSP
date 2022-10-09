/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controlador;

import com.google.gson.Gson;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import jakarta.servlet.http.Part;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import modelo.beans.Categoria;
import modelo.beans.DetallePedido;
import modelo.beans.Pedido;
import modelo.beans.Producto;
import modelo.beans.Usuario;
import modelo.logic.CategoriaLogic;
import modelo.logic.DetallePedidoLogic;
import modelo.logic.PedidoLogic;
import modelo.logic.ProductoLogic;
import modelo.logic.UsuarioLogic;

/**
 *
 * @author Jean Paul
 */
@MultipartConfig
@WebServlet(name = "Controlador", urlPatterns = {"/Controlador"})
public class Controlador extends HttpServlet {

    private String acceso = "";
    private String msj = "";
    private String rutaUrl = "";
    private String actividad = "";

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doPost(request, response);
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doPost(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        rutaUrl = request.getParameter("URL");

        if (rutaUrl.compareTo("registrar") == 0) {
            Registrar(request, response);
        } else if (rutaUrl.compareTo("ingresar") == 0) {
            Ingresar(request, response);
        } else if (rutaUrl.compareTo("administrador") == 0) {
            Administrador(request, response);
        } else if (rutaUrl.compareTo("agregar_categoria") == 0) {
            AgregarCategoria(request, response);
        } else if (rutaUrl.compareTo("modificar_categoria") == 0) {
            ModificarCategoria(request, response);
        } else if (rutaUrl.compareTo("eliminar_categoria") == 0) {
            EliminarCategoria(request, response);
        } else if (rutaUrl.compareTo("agregar_producto") == 0) {
            AgregarProducto(request, response);
        } else if (rutaUrl.compareTo("modificar_producto") == 0) {
            ModificarProducto(request, response);
        } else if (rutaUrl.compareTo("eliminar_producto") == 0) {
            EliminarProducto(request, response);
        } else if (rutaUrl.compareTo("stock_producto") == 0) {
            StockProducto(request, response);
        } else if (rutaUrl.compareTo("estado_pedido") == 0) {
            EstadoPedido(request, response);
        } else if (rutaUrl.compareTo("eliminar_pedido") == 0) {
            EliminarPedido(request, response);
        } else if (rutaUrl.compareTo("mv") == 0) {
            Mostrar_Ventana(request, response);
        } else if (rutaUrl.compareTo("cv") == 0) {
            Cerrar_Ventana(request, response);
        } else if (rutaUrl.compareTo("cerrar_sesion") == 0) {
            Cerrar_Sesion(request, response);
        } else if (rutaUrl.compareTo("area_administrador") == 0) {
            AreaAdministrador(request, response);
        } else if (rutaUrl.compareTo("area_categoria") == 0) {
            AreaCategoria(request, response);
        } else if (rutaUrl.compareTo("area_producto") == 0) {
            AreaProducto(request, response);
        } else if (rutaUrl.compareTo("area_pedido") == 0) {
            AreaPedido(request, response);
        } else if (rutaUrl.compareTo("area_modificar") == 0) {
            AreaModificar(request, response);
        } else if (rutaUrl.compareTo("mostrar_imagen") == 0) {
            MostrarImagen(request, response);
        } else if (rutaUrl.compareTo("mostrar_pp") == 0) {
            MostrarPedidosP(request, response);
        } else if (rutaUrl.compareTo("mostrar_pr") == 0) {
            MostrarPedidosR(request, response);
        } else if (rutaUrl.compareTo("mostrar_pa") == 0) {
            MostrarPedidosA(request, response);
        } else if (rutaUrl.compareTo("mostrar_productosA") == 0) {
            MostrarProductosA(request, response);
        } else if (rutaUrl.compareTo("mostrar_categoriaA") == 0) {
            MostrarCategoriaA(request, response);
        } else if (rutaUrl.compareTo("mostrar_productos") == 0) {
            MostrarProductosT(request, response);
        } else if (rutaUrl.compareTo("mostrar_categorias") == 0) {
            MostrarCategoriasT(request, response);
        } else if (rutaUrl.compareTo("mejores_productos") == 0) {
            MejoresProductos(request, response);
        } else if (rutaUrl.compareTo("mas_nuevo") == 0) {
            LoMasNuevo(request, response);
        } else if (rutaUrl.compareTo("detalle_producto") == 0) {
            DetalleProducto(request, response);
        } else if (rutaUrl.compareTo("detalle_pedido") == 0) {
            DetallesPedido(request, response);
        } else if (rutaUrl.compareTo("agregar_carrito") == 0) {
            AgregarCarrito(request, response);
        } else if (rutaUrl.compareTo("eliminar_carrito") == 0) {
            EliminarCarrito(request, response);
        } else if (rutaUrl.compareTo("contar_usuarios") == 0) {
            CountClientes(request, response);
        } else if (rutaUrl.compareTo("contar_productos") == 0) {
            CountProductos(request, response);
        } else if (rutaUrl.compareTo("contar_categorias") == 0) {
            CountCategorias(request, response);
        } else if (rutaUrl.compareTo("contar_pedidos") == 0) {
            CountPedidos(request, response);
        } else if (rutaUrl.compareTo("finalizar_venta") == 0) {
            FinalizarVenta(request, response);
        }

    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

    //Areas de la pagina
    public void AreaAdministrador(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        acceso = "/VistaAdministrador.jsp";
        RequestDispatcher vista = request.getRequestDispatcher(acceso);
        vista.forward(request, response);
    }

    public void AreaCategoria(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        acceso = "/AreaCategoria.jsp";
        RequestDispatcher vista = request.getRequestDispatcher(acceso);
        vista.forward(request, response);
    }

    public void AreaProducto(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        acceso = "/AreaProducto.jsp";
        RequestDispatcher vista = request.getRequestDispatcher(acceso);
        vista.forward(request, response);
    }

    public void AreaPedido(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        acceso = "/AreaPedido.jsp";
        RequestDispatcher vista = request.getRequestDispatcher(acceso);
        vista.forward(request, response);
    }

    public void AreaModificar(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String cod = request.getParameter("txtcod");
        String tipo = request.getParameter("tipo");

        acceso = "/AreaModificar.jsp";
        request.setAttribute("tipo", tipo);
        request.setAttribute("cod", cod);
        RequestDispatcher vista = request.getRequestDispatcher(acceso);
        vista.forward(request, response);
    }

    //Acciones del controlador
    public void Registrar(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        UsuarioLogic uL = new UsuarioLogic();
        Usuario uB = new Usuario();

        uB.setDni(request.getParameter("txtdni"));
        uB.setApell(request.getParameter("txtapell"));
        uB.setNombres(request.getParameter("txtnombres"));
        uB.setUsuario(request.getParameter("txtusuario"));
        uB.setCorreo(request.getParameter("txtcorreo"));
        uB.setContraseña(request.getParameter("txtcontra"));
        uB.setTipo("CL");
        uB.setPtosac(0);

        msj = uL.Registro(uB);
        acceso = "/AreaLogin.jsp";
        request.setAttribute("msj", msj);
        RequestDispatcher vista = request.getRequestDispatcher(acceso);
        vista.forward(request, response);
    }

    public void Ingresar(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        String usuario = request.getParameter("txtUsuario");
        String contraseña = request.getParameter("txtContraseña");

        UsuarioLogic uL = new UsuarioLogic();
        Usuario uB = uL.DatosU(usuario);

        msj = uL.Ingresar(usuario, contraseña);

        if (msj.compareTo("INGRESO_USUARIO") == 0) {

            //creamos la sesion
            HttpSession osesion = request.getSession();
            osesion.setAttribute("Usuario", uB);
            osesion.setAttribute("verif", "clnt");
            response.sendRedirect("index.jsp");

        } else if (msj.compareTo("INGRESO_ADMINISTRADOR") == 0) {

            acceso = "/AreaLogin.jsp?MSJini= &MV_Cod=Open&MSJcod= &usuario=" + uB.getUsuario();
            RequestDispatcher vista = request.getRequestDispatcher(acceso);
            vista.forward(request, response);

        } else {

            acceso = "/AreaLogin.jsp";
            request.setAttribute("msj", msj);
            RequestDispatcher vista = request.getRequestDispatcher(acceso);
            vista.forward(request, response);

        }
    }

    public void Administrador(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        String Cod_V = request.getParameter("txtCod_V");
        String usu = request.getParameter("usuario");
        UsuarioLogic uL = new UsuarioLogic();
        Usuario uB = uL.DatosU(usu);

        if (uB.getCodverif().compareTo(Cod_V) == 0) {

            //creamos la sesion
            HttpSession osesion = request.getSession();
            osesion.setAttribute("Usuario", uB);
            osesion.setAttribute("verif", "4dm1n");
            response.sendRedirect("VistaAdministrador.jsp");

        } else {

            acceso = "/AreaLogin.jsp?MV_Cod=Open&MSJcod=CODIGO INVALIDO&usuario=" + usu;
            RequestDispatcher vista = request.getRequestDispatcher(acceso);
            vista.forward(request, response);

        }
    }

    public void AgregarCategoria(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        CategoriaLogic cL = new CategoriaLogic();
        Categoria cB = new Categoria();

        cB.setNombre(request.getParameter("txtnombre"));

        msj = cL.Agregar(cB);
        acceso = "/AreaCategoria.jsp";
        request.setAttribute("msj", msj);
        RequestDispatcher vista = request.getRequestDispatcher(acceso);
        vista.forward(request, response);
    }

    public void ModificarCategoria(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        CategoriaLogic cL = new CategoriaLogic();
        Categoria cB = new Categoria();

        cB.setCodigo(Integer.parseInt(request.getParameter("txtcod")));
        cB.setNombre(request.getParameter("txtnombre"));

        msj = cL.Modificar(cB);
        acceso = "/AreaCategoria.jsp";
        request.setAttribute("msj", msj);
        RequestDispatcher vista = request.getRequestDispatcher(acceso);
        vista.forward(request, response);
    }

    public void EliminarCategoria(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        CategoriaLogic cL = new CategoriaLogic();

        int cod = Integer.parseInt(request.getParameter("txtcod"));

        msj = cL.Eliminar(cod);
        acceso = "/AreaCategoria.jsp";
        request.setAttribute("msj", msj);
        RequestDispatcher vista = request.getRequestDispatcher(acceso);
        vista.forward(request, response);
    }

    public void AgregarProducto(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        ProductoLogic pL = new ProductoLogic();
        Producto pB = new Producto();

        Part partP = request.getPart("txtimgP");
        Part partS = request.getPart("txtimgS");
        InputStream impP = partP.getInputStream();
        InputStream impS = partS.getInputStream();

        pB.setNombre(request.getParameter("txtnombre"));
        pB.setImgP(impP);
        pB.setImg(impS);
        pB.setPrecio(Double.parseDouble(request.getParameter("txtprecio")));
        pB.setStock(Integer.parseInt(request.getParameter("txtstock")));
        pB.setCodCat(Integer.parseInt(request.getParameter("txtcat")));
        pB.setPtosG(Integer.parseInt(request.getParameter("txtpuntos")));

        msj = pL.Agregar(pB);
        acceso = "/AreaProducto.jsp";
        request.setAttribute("msj", msj);
        RequestDispatcher vista = request.getRequestDispatcher(acceso);
        vista.forward(request, response);
    }

    public void ModificarProducto(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        ProductoLogic pL = new ProductoLogic();
        Producto pB = new Producto();

        Part partP = request.getPart("txtimgP");
        Part partS = request.getPart("txtimgS");
        InputStream impP = partP.getInputStream();
        InputStream impS = partS.getInputStream();

        pB.setCodigo(Integer.parseInt(request.getParameter("txtcod")));
        pB.setNombre(request.getParameter("txtnombre"));
        pB.setImgP(impP);
        pB.setImg(impS);
        pB.setPrecio(Double.parseDouble(request.getParameter("txtprecio")));
        pB.setCodCat(Integer.parseInt(request.getParameter("txtcat")));
        pB.setPtosG(Integer.parseInt(request.getParameter("txtpuntos")));

        msj = pL.Modificar(pB);
        acceso = "/AreaProducto.jsp";
        request.setAttribute("msj", msj);
        RequestDispatcher vista = request.getRequestDispatcher(acceso);
        vista.forward(request, response);
    }

    public void EliminarProducto(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        ProductoLogic pL = new ProductoLogic();

        int cod = Integer.parseInt(request.getParameter("cod"));

        msj = pL.Eliminar(cod);
        acceso = "/AreaProducto.jsp";
        request.setAttribute("msj", msj);
        RequestDispatcher vista = request.getRequestDispatcher(acceso);
        vista.forward(request, response);
    }

    public void StockProducto(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        ProductoLogic pL = new ProductoLogic();

        int cod = Integer.parseInt(request.getParameter("ID"));
        int cantidad = Integer.parseInt(request.getParameter("txtcant"));

        msj = pL.Stock(cod, cantidad, "AUMENTAR");
        acceso = "/AreaProducto.jsp";
        request.setAttribute("msj", msj);
        RequestDispatcher vista = request.getRequestDispatcher(acceso);
        vista.forward(request, response);
    }

    public void MostrarImagen(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        ProductoLogic pL = new ProductoLogic();
        response.setContentType("image/png");
        int id = Integer.parseInt(request.getParameter("id"));
        String tip = request.getParameter("tip");
        byte[] b = null;

        try {
            b = pL.Imagen(tip, id);
            try ( InputStream bos = new ByteArrayInputStream(b)) {
                int tamanoInput = bos.available();
                byte[] datosIMAGEN = new byte[tamanoInput];
                bos.read(datosIMAGEN, 0, tamanoInput);

                response.getOutputStream().write(datosIMAGEN);
            }

        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public void MostrarProductosA(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        ProductoLogic pL = new ProductoLogic();

        String busq;
        if (request.getParameter("busq") != null) {
            busq = request.getParameter("busq");
        } else {
            busq = "";
        }
        List<Producto> lista;
        lista = pL.Listar(busq);
        String productos = "";
        int i = 1;

        for (Producto pro : lista) {
            productos += "<tbody>\n"
                    + "                                    <tr>\n"
                    + "                                        <td>" + i + "</td>\n"
                    + "                                        <td>" + pro.getNombre() + "</td>\n"
                    + "                                        <td>" + pro.getPrecio() + "</td>\n"
                    + "                                        <td>" + pro.getStock() + "</td>\n"
                    + "                                        <td>" + pro.getNomCat() + "</td>\n"
                    + "                                        <td>" + pro.getPtosG() + "</td>\n"
                    + "                                        <td id=\"btnopc\">\n"
                    + "                                            <form action=\"Controlador\" method=\"post\">\n"
                    + "                                                <input type=\"hidden\" name=\"txtcod\" value=\"" + pro.getCodigo() + "\">\n"
                    + "                                                <input type=\"hidden\" name=\"tipo\" value=\"producto\">\n"
                    + "                                                <input type=\"hidden\" name=\"URL\" value=\"area_modificar\">\n"
                    + "                                                <button type=\"submit\" class=\"boton\">\n"
                    + "                                                    <img src=\"img/lapiz.png\" alt=\"\"/>\n"
                    + "                                                </button>\n"
                    + "                                            </form>\n"
                    + "                                            <form action=\"Controlador\" method=\"post\">\n"
                    + "                                                <input type=\"hidden\" name=\"ID\" value=\"" + pro.getCodigo() + "\">\n"
                    + "                                                <input type=\"hidden\" name=\"nombre_ventana\" value=\"STOCK\">\n"
                    + "                                                <input type=\"hidden\" name=\"URL\" value=\"mv\">\n"
                    + "                                                <button type=\"submit\" class=\"boton\">\n"
                    + "                                                    <img src=\"img/en-stock.png\" alt=\"\"/>\n"
                    + "                                                </button>\n"
                    + "                                            </form>\n"
                    + "                                            <form action=\"Controlador\" method=\"post\">\n"
                    + "                                                <input type=\"hidden\" name=\"cod\" value=\"" + pro.getCodigo() + "\">\n"
                    + "                                                <input type=\"hidden\" name=\"URL\" value=\"eliminar_producto\">\n"
                    + "                                                <button type=\"submit\" class=\"boton\">\n"
                    + "                                                    <img src=\"img/boton-eliminar.png\" alt=\"\"/>\n"
                    + "                                                </button>\n"
                    + "                                            </form>\n"
                    + "                                        </td>\n"
                    + "                                    </tr>\n"
                    + "                                </tbody>";
            i++;
        }

        try {
            Gson gson = new Gson();
            String json = gson.toJson(productos);
            response.setContentType("application/json;charset=UTF-8");
            PrintWriter out = response.getWriter();
            out.println(json);

        } catch (IOException e) {
        }
    }

    public void MostrarCategoriaA(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        CategoriaLogic cL = new CategoriaLogic();

        String b_cate = request.getParameter("busq");

        List<Categoria> lista;
        lista = cL.Listar(b_cate);
        int i = 0;
        String categorias = "";

        for (Categoria cate : lista) {
            categorias += "<tbody>\n"
                    + "                                    <tr>\n"
                    + "                                        <th scope=\"row\">" + i + "</th>\n"
                    + "                                        <td>" + cate.getNombre() + "</td>\n"
                    + "                                        <td>" + cate.getCodigo() + "</td>\n"
                    + "                                        <td id=\"btnopc\">\n"
                    + "                                            <form action=\"Controlador\" method=\"post\">\n"
                    + "                                                <input type=\"hidden\" name=\"txtcod\" value=\"" + cate.getCodigo() + "\">\n"
                    + "                                                <input type=\"hidden\" name=\"tipo\" value=\"categoria\">\n"
                    + "                                                <input type=\"hidden\" name=\"URL\" value=\"area_modificar\">\n"
                    + "                                                <button type=\"submit\" class=\"boton\">\n"
                    + "                                                    <img src=\"img/lapiz.png\" alt=\"\"/>\n"
                    + "                                                </button>\n"
                    + "                                            </form>\n"
                    + "                                            <form action=\"Controlador\" method=\"post\">\n"
                    + "                                                <input type=\"hidden\" name=\"txtcod\" value=\"" + cate.getCodigo() + "\">\n"
                    + "                                                <input type=\"hidden\" name=\"URL\" value=\"eliminar_categoria\">\n"
                    + "                                                <button type=\"submit\" class=\"boton\">\n"
                    + "                                                    <img src=\"img/boton-eliminar.png\" alt=\"\"/>\n"
                    + "                                                </button>\n"
                    + "                                            </form>\n"
                    + "                                        </td>\n"
                    + "                                    </tr>\n"
                    + "                                </tbody>";
            i++;
        }

        try {
            Gson gson = new Gson();
            String json = gson.toJson(categorias);
            response.setContentType("application/json;charset=UTF-8");
            PrintWriter out = response.getWriter();
            out.println(json);

        } catch (IOException e) {
        }
    }

    public void MostrarPedidosP(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        PedidoLogic pL = new PedidoLogic();

        String desde = request.getParameter("f_desde");
        String hasta = request.getParameter("f_hasta");

        List<Pedido> lista;
        lista = pL.Listar("PENDIENTE", desde, hasta);
        String pedidos = "";
        int i = 1;

        for (Pedido ped : lista) {
            pedidos += "<tbody>\n"
                    + "                                        <tr>\n"
                    + "                                            <td>" + i + "</td>\n"
                    + "                                            <td>" + ped.getCodigo() + "</td>\n"
                    + "                                            <td>" + ped.getFechaC() + "</td>\n"
                    + "                                            <td>" + ped.getNomUsu() + "</td>\n"
                    + "                                            <td>" + ped.getTotalNeto() + "</td>\n"
                    + "                                            <td id=\"btnopc\">\n"
                    + "                                                <form action=\"Controlador\" method=\"post\">\n"
                    + "                                                    <input type=\"hidden\" name=\"ID\" value=\"" + ped.getCodigo() + "\">\n"
                    + "                                                    <input type=\"hidden\" name=\"nombre_ventana\" value=\"CONFIRMAR_PEDIDO\">\n"
                    + "                                                    <input type=\"hidden\" name=\"URL\" value=\"mv\">\n"
                    + "                                                    <button type=\"submit\" class=\"boton\">\n"
                    + "                                                        <img src=\"img/comprobado.png\" alt=\"\"/>\n"
                    + "                                                    </button>\n"
                    + "                                                </form>\n"
                    + "                                                <form action=\"Controlador\" method=\"post\">\n"
                    + "                                                    <input type=\"hidden\" name=\"ID\" value=\"" + ped.getCodigo() + "\">\n"
                    + "                                                    <input type=\"hidden\" name=\"tipo\" value=\"ANULADO\">\n"
                    + "                                                    <input type=\"hidden\" name=\"URL\" value=\"estado_pedido\">\n"
                    + "                                                    <button type=\"submit\" class=\"boton\">\n"
                    + "                                                        <img src=\"img/boton-x.png\" alt=\"\"/>\n"
                    + "                                                    </button>\n"
                    + "                                                </form>\n"
                    + "                                                <button class=\"open boton\" type=\"submit\" onclick=\"Mostrar('" + ped.getCodigo() + "')\">\n"
                    + "                                                    <img src=\"img/OIP.png\" alt=\"\"/>\n"
                    + "                                                </button>   \n"
                    + "                                            </td>\n"
                    + "                                        </tr>\n"
                    + "                                    </tbody>";

            i++;
        }

        try {
            Gson gson = new Gson();
            String json = gson.toJson(pedidos);
            response.setContentType("application/json;charset=UTF-8");
            PrintWriter out = response.getWriter();
            out.println(json);

        } catch (IOException e) {
        }
    }

    public void MostrarPedidosR(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        PedidoLogic pL = new PedidoLogic();

        String desde = request.getParameter("f_desde");
        String hasta = request.getParameter("f_hasta");

        List<Pedido> lista;
        lista = pL.Listar("REALIZADO", desde, hasta);
        String pedidos = "";
        int i = 1;

        for (Pedido ped : lista) {
            pedidos += "<tbody>\n"
                    + "                                    <tr>\n"
                    + "                                        <td>" + i + "</td>\n"
                    + "                                        <td>" + ped.getCodigo() + "</td>\n"
                    + "                                            <td>" + ped.getFechaC() + "</td>\n"
                    + "                                            <td>" + ped.getFechaE() + "</td>\n"
                    + "                                        <td>" + ped.getNomUsu() + "</td>\n"
                    + "                                        <td>" + ped.getTotalNeto() + "</td>\n"
                    + "                                        <td id=\"btnopc\">\n"
                    + "                                            <button class=\"open boton\" type=\"submit\" onclick=\"Mostrar('" + ped.getCodigo() + "')\" >\n"
                    + "                                                <img src=\"img/OIP.png\" alt=\"\"/>\n"
                    + "                                            </button>   \n"
                    + "                                        </td>\n"
                    + "                                    </tr>\n"
                    + "                                </tbody>";
            i++;
        }

        try {
            Gson gson = new Gson();
            String json = gson.toJson(pedidos);
            response.setContentType("application/json;charset=UTF-8");
            PrintWriter out = response.getWriter();
            out.println(json);

        } catch (IOException e) {
        }
    }

    public void MostrarPedidosA(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        PedidoLogic pL = new PedidoLogic();

        String desde = request.getParameter("f_desde");
        String hasta = request.getParameter("f_hasta");

        List<Pedido> lista;
        lista = pL.Listar("ANULADO", desde, hasta);
        String pedidos = "";
        int i = 1;

        for (Pedido ped : lista) {
            pedidos += "<tbody>\n"
                    + "                                    <tr>\n"
                    + "                                        <td>" + i + "</td>\n"
                    + "                                        <td>" + ped.getCodigo() + "</td>\n"
                    + "                                            <td>" + ped.getFechaC() + "</td>\n"
                    + "                                        <td>" + ped.getNomUsu() + "</td>\n"
                    + "                                        <td>" + ped.getTotalNeto() + "</td>\n"
                    + "                                        <td id=\"btnopc\">\n"
                    + "                                            <form action=\"Controlador\" method=\"post\">\n"
                    + "                                                <input type=\"hidden\" name=\"cod\" value=\""+ ped.getCodigo() +"\">\n"
                    + "                                                <input type=\"hidden\" name=\"URL\" value=\"eliminar_pedido\">\n"
                    + "                                                <button type=\"submit\" class=\"boton\">\n"
                    + "                                                    <img src=\"img/boton-eliminar.png\" alt=\"\"/></button>\n"
                    + "                                            </form>\n"
                    + "                                            <button class=\"open boton\" type=\"submit\" onclick=\"Mostrar('" + ped.getCodigo() + "')\" id=\"busca\" >\n"
                    + "                                                <img src=\"img/OIP.png\" alt=\"\"/>\n"
                    + "                                            </button>\n"
                    + "                                        </td>\n"
                    + "                                    </tr>\n"
                    + "                                </tbody>";
            i++;
        }

        try {
            Gson gson = new Gson();
            String json = gson.toJson(pedidos);
            response.setContentType("application/json;charset=UTF-8");
            PrintWriter out = response.getWriter();
            out.println(json);

        } catch (IOException e) {
        }
    }

    public void MostrarProductosT(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        ProductoLogic pL = new ProductoLogic();

        String busq = request.getParameter("busq");

        List<Producto> lista;
        lista = pL.Listar(busq);
        String productosT = "";

        for (Producto pro : lista) {
            productosT += "<div class=\"showcase\">\n"
                    + "                                    <div class=\"showcase-banner\">\n"
                    + "                                        <img src=\"Controlador?URL=mostrar_imagen&id=" + pro.getCodigo() + "&tip=a\" alt=\"" + pro.getNombre() + "\" width=\"300\" class=\"product-img default\">\n"
                    + "                                        <img src=\"Controlador?URL=mostrar_imagen&id=" + pro.getCodigo() + "&tip=b\" alt=\"" + pro.getNombre() + "\" width=\"300\" class=\"product-img hover\">\n"
                    + "                                    </div>\n"
                    + "                                    <div class=\"showcase-content\">\n"
                    + "                                        <a href=\"Controlador?URL=detalle_producto&id=" + pro.getCodigo() + "\" class=\"showcase-category\">" + pro.getNombre() + "</a>\n"
                    + "                                        <a href=\"Controlador?URL=detalle_producto&id=" + pro.getCodigo() + "\" class=\"showcase-category\">\n"
                    + "                                            <h3 class=\"showcase-title\">Gana: " + pro.getPtosG() + "</h3>\n"
                    + "                                        </a>\n"
                    + "                                        <div class=\"showcase-rating\">\n"
                    + "                                            <ion-icon name=\"star\"></ion-icon>\n"
                    + "                                            <ion-icon name=\"star\"></ion-icon>\n"
                    + "                                            <ion-icon name=\"star\"></ion-icon>\n"
                    + "                                            <ion-icon name=\"star\"></ion-icon>\n"
                    + "                                            <ion-icon name=\"star-outline\"></ion-icon>\n"
                    + "                                        </div>\n"
                    + "                                        <div class=\"price-box\">\n"
                    + "                                            <p class=\"price\">$" + pro.getPrecio() + "</p>\n"
                    + "                                        </div>\n"
                    + "                                    </div>\n"
                    + "                                </div>";
        }

        try {
            Gson gson = new Gson();
            String json = gson.toJson(productosT);
            response.setContentType("application/json;charset=UTF-8");
            PrintWriter out = response.getWriter();
            out.println(json);

        } catch (IOException e) {
        }

    }

    public void MostrarCategoriasT(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        CategoriaLogic cL = new CategoriaLogic();

        List<Categoria> lista;
        lista = cL.Listar("");
        String categorias = "";

        for (Categoria cate : lista) {
            categorias += "<ul class=\"sidebar-menu-category-list\">\n"
                    + "                                <li class=\"sidebar-menu-category\">\n"
                    + "                                    <button onclick=\"Categoria('" + cate.getNombre() + "')\" class=\"sidebar-accordion-menu data-accordion-btn\" >\n"
                    + "                                        <div class=\"menu-title-flex\">\n"
                    + "                                            <img src=\"img/cat.png\" alt=\"clothes\" width=\"20\" height=\"20\"\n"
                    + "                                                 class=\"menu-title-img\">\n"
                    + "                                            <p class=\"menu-title\">" + cate.getNombre() + "</p>\n"
                    + "                                        </div>\n"
                    + "                                    </button>\n"
                    + "                                </li>\n"
                    + "                            </ul>";
        }

        try {
            Gson gson = new Gson();
            String json = gson.toJson(categorias);
            response.setContentType("application/json;charset=UTF-8");
            PrintWriter out = response.getWriter();
            out.println(json);

        } catch (IOException e) {
        }
    }

    public void MejoresProductos(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        ProductoLogic pL = new ProductoLogic();

        List<Producto> lista;
        lista = pL.MejoresProductos();
        String mejoresproductos = "";

        for (Producto pro : lista) {
            mejoresproductos += "<div class=\"showcase\">\n"
                    + "                                        <a href=\"Controlador?URL=detalle_producto&id=" + pro.getCodigo() + "\" class=\"showcase-img-box\">\n"
                    + "                                            <img src=\"Controlador?URL=mostrar_imagen&id=" + pro.getCodigo() + "&tip=a\" alt=\"" + pro.getNombre() + "\" width=\"75\" height=\"75\"\n"
                    + "                                                 class=\"showcase-img\">\n"
                    + "                                        </a>\n"
                    + "                                        <div class=\"showcase-content\">\n"
                    + "                                            <a href=\"Controlador?URL=detalle_producto&id=" + pro.getCodigo() + "\">\n"
                    + "                                                <h4 class=\"showcase-title\">" + pro.getNombre() + "</h4>\n"
                    + "                                            </a>\n"
                    + "                                            <div class=\"showcase-rating\">\n"
                    + "                                                <ion-icon name=\"star\"></ion-icon>\n"
                    + "                                                <ion-icon name=\"star\"></ion-icon>\n"
                    + "                                                <ion-icon name=\"star\"></ion-icon>\n"
                    + "                                                <ion-icon name=\"star\"></ion-icon>\n"
                    + "                                                <ion-icon name=\"star\"></ion-icon>\n"
                    + "                                            </div>\n"
                    + "                                            <div class=\"price-box\">\n"
                    + "                                                <p class=\"price\">$" + pro.getPrecio() + "</p>\n"
                    + "                                            </div>\n"
                    + "                                        </div>\n"
                    + "                                    </div>";
        }

        try {
            Gson gson = new Gson();
            String json = gson.toJson(mejoresproductos);
            response.setContentType("application/json;charset=UTF-8");
            PrintWriter out = response.getWriter();
            out.println(json);

        } catch (IOException e) {
        }
    }

    public void LoMasNuevo(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        ProductoLogic pL = new ProductoLogic();

        Producto pro = pL.LoMasNuevo();
        String masnuevo = "<div class=\"showcase-container\">\n"
                + "                                    <div class=\"showcase\">\n"
                + "                                        <div class=\"showcase-banner\">\n"
                + "                                            <img src=\"Controlador?URL=mostrar_imagen&id=" + pro.getCodigo() + "&tip=a\" class=\"showcase-img\">\n"
                + "                                        </div>\n"
                + "                                        <div class=\"showcase-content\">\n"
                + "                                            <div class=\"showcase-rating\">\n"
                + "                                                <ion-icon name=\"star\"></ion-icon>\n"
                + "                                                <ion-icon name=\"star\"></ion-icon>\n"
                + "                                                <ion-icon name=\"star\"></ion-icon>\n"
                + "                                                <ion-icon name=\"star\"></ion-icon>\n"
                + "                                                <ion-icon name=\"star\"></ion-icon>\n"
                + "                                            </div>\n"
                + "                                            <a href=\"#\">\n"
                + "                                                <h3 class=\"showcase-title\">" + pro.getNombre() + "</h3>\n"
                + "                                            </a>\n"
                + "                                            <p class=\"showcase-desc\">\n"
                + "                                                Adquierelo en la puerta de tu casa y gana puntos por tu compra\n"
                + "                                            </p>\n"
                + "                                            <div class=\"price-box\">\n"
                + "                                                <p class=\"price\">" + pro.getPrecio() + "</p>\n"
                + "                                            </div>\n"
                + "                                            <button onclick=\"location.href ='Controlador?URL=detalle_producto&id=" + pro.getCodigo() + "'\" class=\"add-cart-btn\">Comprar</button>"
                + "                                        </div>\n"
                + "                                    </div>\n"
                + "                                </div>";

        try {
            Gson gson = new Gson();
            String json = gson.toJson(masnuevo);
            response.setContentType("application/json;charset=UTF-8");
            PrintWriter out = response.getWriter();
            out.println(json);

        } catch (IOException e) {
        }
    }

    public void DetalleProducto(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        msj = request.getParameter("id");

        acceso = "/DetalleProducto.jsp";
        request.setAttribute("msj", msj);
        RequestDispatcher vista = request.getRequestDispatcher(acceso);
        vista.forward(request, response);
    }

    public void AgregarCarrito(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        HttpSession osesion = request.getSession(true);
        ProductoLogic pLogic = new ProductoLogic();

        int cantidad = Integer.parseInt(request.getParameter("txtcantidad"));
        int codigoP = Integer.parseInt(request.getParameter("txtcod"));

        Producto pBeans = pLogic.Datos(codigoP);

        double total = cantidad * pBeans.getPrecio();
        int totalptosG = cantidad * pBeans.getPtosG();
        boolean flag = false;

        ArrayList<DetallePedido> productos;

        if (osesion.getAttribute("carrito") == null) {
            productos = new ArrayList<>();
        } else {
            productos = (ArrayList) osesion.getAttribute("carrito");
        }

        if (!productos.isEmpty()) {
            for (DetallePedido p : productos) {
                if (codigoP == p.getCodProducto()) {
                    p.setCantidad(p.getCantidad() + cantidad);
                    p.setPrecio(p.getPrecio() + total);
                    flag = true;
                    break;
                }
            }
        }

        if (!flag) {
            DetallePedido det = new DetallePedido();
            det.setCantidad(cantidad);
            det.setPrecio(total);
            det.setCodProducto(codigoP);
            det.setPtosG(totalptosG);
            productos.add(det);
        }

        acceso = "/Carrito.jsp";
        osesion.setAttribute("carrito", productos);
        RequestDispatcher vista = request.getRequestDispatcher(acceso);
        vista.forward(request, response);

    }

    public void EliminarCarrito(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        int idproducto = Integer.parseInt(request.getParameter("idproducto"));

        HttpSession osesion = request.getSession(true);
        ArrayList<DetallePedido> productos = osesion.getAttribute("carrito") == null ? null : (ArrayList) osesion.getAttribute("carrito");

        if (productos != null) {
            for (DetallePedido dp : productos) {
                if (dp.getCodProducto() == idproducto) {
                    productos.remove(dp);
                    break;
                }
            }
        }

        double total = 0;

        for (DetallePedido dp : productos) {
            total += dp.getPrecio();
        }

        response.getWriter().print(total);
    }

    public void EliminarPuntos(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        HttpSession osesion = request.getSession(true);
        ArrayList<DetallePedido> productos = osesion.getAttribute("carrito") == null ? null : (ArrayList) osesion.getAttribute("carrito");

        int ptosG = 0;

        for (DetallePedido dp : productos) {
            ptosG += dp.getPtosG();
        }

        response.getWriter().print(ptosG);
    }

    public void FinalizarVenta(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        HttpSession osesion = request.getSession();

        DetallePedidoLogic dL = new DetallePedidoLogic();
        PedidoLogic pL = new PedidoLogic();
        Pedido pB = new Pedido();
        UsuarioLogic uL = new UsuarioLogic();
        Usuario usuario = (Usuario) osesion.getAttribute("Usuario");

        ArrayList<DetallePedido> productos = (ArrayList<DetallePedido>) osesion.getAttribute("carrito");

        pB.setTotal(Double.parseDouble(request.getParameter("txttotal")));
        pB.setEstado("PENDIENTE");
        pB.setPtosCanje(Integer.parseInt(request.getParameter("txtptos")));
        pB.setTotalNeto(Double.parseDouble(request.getParameter("txtneto")));
        pB.setTotalptosG(Integer.parseInt(request.getParameter("txtptosg")));
        pB.setCodigoU(((Usuario) osesion.getAttribute("Usuario")).getCodigo());

        int id = pL.Agregar(pB);
        if (id > 0) {
            for (DetallePedido detp : productos) {
                detp.setCodPedido(id);
                msj = dL.Agregar(detp);
            }
            uL.Puntos(usuario.getCodigo(), Integer.parseInt(request.getParameter("txtptos")), "REDUCIR");
            productos.clear();
        }

        acceso = "/Compras.jsp";
        RequestDispatcher vista = request.getRequestDispatcher(acceso);
        vista.forward(request, response);
        request.setAttribute("msj", msj);
        osesion.setAttribute("carrito", productos);
    }

    public void EstadoPedido(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        DetallePedidoLogic dL = new DetallePedidoLogic();
        PedidoLogic pL = new PedidoLogic();
        ProductoLogic proL = new ProductoLogic();
        UsuarioLogic uL = new UsuarioLogic();
        List<DetallePedido> detalles;

        String tipo = request.getParameter("tipo");
        int cod = Integer.parseInt(request.getParameter("ID"));

        Pedido pB = pL.Datos(cod);

        if (tipo.compareTo("REALIZADO") == 0) {

            detalles = dL.DetallesPedido(cod);

            for (DetallePedido detp1 : detalles) {
                Producto pro = proL.Datos(detp1.getCodProducto());
                if (pro.getStock() >= detp1.getCantidad()) {
                    msj = "OK";
                } else {
                    msj = "Hay un producto con stock insuficiente";
                    break;
                }
            }

            if (msj.compareTo("OK") == 0) {

                Date fecha = Date.valueOf(request.getParameter("txtfecha"));

                pB.setEstado(tipo);
                pB.setFechaE(fecha);
                String result = pL.Cambiarestado(pB);

                if (result.equals("COMPLETADO")) {
                    for (DetallePedido detp : detalles) {
                        proL.Stock(detp.getCodProducto(), detp.getCantidad(), "REDUCIR");
                        
                    }
                    msj = "ESTADO MODIFICADO";
                    uL.Puntos(pB.getCodigoU(), pB.getTotalptosG(), "AUMENTAR");
                } else {
                    msj = "NO SE PUDO MODIFICAR";
                }
            }

        } else if (tipo.compareTo("ANULADO") == 0) {

            pB.setCodigo(cod);
            pB.setEstado(tipo);
            pB.setFechaE(null);

            msj = pL.Cambiarestado(pB);
            uL.Puntos(pB.getCodigoU(), pB.getPtosCanje(), "AUMENTAR");

        } else {
            msj = "ERROR INESPERADO";
        }

        request.setAttribute("msj", msj);
        acceso = "/AreaPedido.jsp";
        RequestDispatcher vista = request.getRequestDispatcher(acceso);
        vista.forward(request, response);
    }

    public void EliminarPedido(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        DetallePedidoLogic dL = new DetallePedidoLogic();
        PedidoLogic pL = new PedidoLogic();
        List<DetallePedido> detalles;

        int cod = Integer.parseInt(request.getParameter("cod"));
        detalles = dL.DetallesPedido(cod);
        for (DetallePedido detp : detalles) {
            if (dL.Eliminar(cod).equals("REALIZADO")) {
                msj = pL.Eliminar(cod);
            }
        }

        acceso = "/AreaPedido.jsp";
        request.setAttribute("msj", msj);
        RequestDispatcher vista = request.getRequestDispatcher(acceso);
        vista.forward(request, response);
    }

    public void DetallesPedido(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        PedidoLogic pL = new PedidoLogic();
        DetallePedidoLogic dL = new DetallePedidoLogic();
        UsuarioLogic uL = new UsuarioLogic();
        ProductoLogic prL = new ProductoLogic();
        List<DetallePedido> lista;

        int cod = Integer.parseInt(request.getParameter("ID"));

        Pedido pbeans = pL.Datos(cod);
        Usuario ubeans = uL.DatosUxC(pbeans.getCodigoU());
        lista = dL.DetallesPedido(pbeans.getCodigo());

        String detalle = "<div class=\"title\">\n"
                + "                    <span class=\"text\">Detalles de Compra</span>\n"
                + "                </div>\n"
                + "                <p class=\"text\" align=\"left\">Nombre: " + ubeans.getNombres() +" "+ ubeans.getApell() + "</p>\n"
                + "                <p class=\"text\" align=\"left\">DNI: " + ubeans.getDni() + "</p>\n"
                + "                        <table border=\"0\" style=\"width: 465px\">\n"
                + "                            <thead>\n"
                + "                                <tr>\n"
                + "                                    <th>Producto</th>\n"
                + "                                    <th>Cant.</th>\n"
                + "                                    <th>S.Total</th>\n"
                + "                                </tr>\n"
                + "                            </thead>";

        for (DetallePedido ped : lista) {
            Producto proB = prL.Datos(ped.getCodProducto());
            detalle += "<tbody>\n"
                    + "                            <td>" + proB.getNombre() + "</td>\n"
                    + "                            <td>" + ped.getCantidad() + "</td>\n"
                    + "                            <td>" + ped.getPrecio() + "</td>\n"
                    + "                            </tbody>";
        }
        detalle += "</table>\n"
                + "                    <p align=\"left\"\">Total: " + pbeans.getTotal() + "</p>\n"
                + "                    <p align=\"left\">Puntos Usados: " + pbeans.getPtosCanje() + "</p>\n"
                + "                    <p align=\"left\">Descuento: " + (pbeans.getTotal() - pbeans.getTotalNeto()) + "</p>\n"
                + "                    <p align=\"left\">Total Neto: " + pbeans.getTotalNeto() + "</p>";

        try {
            Gson gson = new Gson();
            String json = gson.toJson(detalle);
            response.setContentType("application/json;charset=UTF-8");
            PrintWriter out = response.getWriter();
            out.println(json);

        } catch (Exception e) {
        }
    }

    public void CountClientes(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        UsuarioLogic uL = new UsuarioLogic();
        int n = uL.Contar();

        try {
            Gson gson = new Gson();
            String json = gson.toJson(n);
            response.setContentType("application/json;charset=UTF-8");
            PrintWriter out = response.getWriter();
            out.println(json);

        } catch (Exception e) {
        }
    }

    public void CountCategorias(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        CategoriaLogic cL = new CategoriaLogic();
        int n = cL.Contar();

        try {
            Gson gson = new Gson();
            String json = gson.toJson(n);
            response.setContentType("application/json;charset=UTF-8");
            PrintWriter out = response.getWriter();
            out.println(json);

        } catch (Exception e) {
        }
    }

    public void CountProductos(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        ProductoLogic pL = new ProductoLogic();
        int n = pL.Contar();

        try {
            Gson gson = new Gson();
            String json = gson.toJson(n);
            response.setContentType("application/json;charset=UTF-8");
            PrintWriter out = response.getWriter();
            out.println(json);

        } catch (Exception e) {
        }
    }

    public void CountPedidos(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        PedidoLogic pL = new PedidoLogic();
        String tip = request.getParameter("tip");
        int n = pL.Contar(tip);

        try {
            Gson gson = new Gson();
            String json = gson.toJson(n);
            response.setContentType("application/json;charset=UTF-8");
            PrintWriter out = response.getWriter();
            out.println(json);

        } catch (Exception e) {
        }
    }

    public void Cerrar_Sesion(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        HttpSession osesion = request.getSession();
        osesion.invalidate();
        response.sendRedirect("index.jsp");
    }

    //Mensajes del sistema
    public void Mostrar_Ventana(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        actividad = request.getParameter("nombre_ventana");
        if (actividad.compareTo("CONFIRMAR_PEDIDO") == 0) {
            acceso = "/AreaPedido.jsp?MV_Pedido=Open" + "&ID=" + request.getParameter("ID");
        } else if (actividad.compareTo("STOCK") == 0) {
            acceso = "/AreaProducto.jsp?MV_Stock=Open" + "&ID=" + request.getParameter("ID");
        }

        RequestDispatcher vista = request.getRequestDispatcher(acceso);
        vista.forward(request, response);
    }

    public void Cerrar_Ventana(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        actividad = request.getParameter("nombre_ventana");

        if (actividad.compareTo("AUTENTIFICACION") == 0) {
            acceso = "/AreaLogin.jsp";
        } else if (actividad.compareTo("CONFIRMAR_PEDIDO") == 0) {
            acceso = "/AreaPedido.jsp";
        } else if (actividad.compareTo("STOCK") == 0) {
            acceso = "/AreaProducto.jsp";
        }
        RequestDispatcher vista = request.getRequestDispatcher(acceso);
        vista.forward(request, response);
    }
}
