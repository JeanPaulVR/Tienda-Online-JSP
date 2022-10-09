/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo.logic;

import java.util.ArrayList;
import java.util.List;
import modelo.beans.Usuario;
import modelo.dao.UsuarioDao;

/**
 *
 * @author Jean Paul
 */
public class UsuarioLogic {

    String msj;
    UsuarioDao daoU = new UsuarioDao();
    Usuario beansU = new Usuario();

    public String Ingresar(String usuario, String contraseña) {

        //Verificacion del usuario y contraseña
        beansU = daoU.Datos(usuario);

        if (usuario.compareTo("") != 0) {
            if (contraseña.compareTo("") != 0) {
                if (beansU.getUsuario() != null) {
                    if (beansU.getContraseña().compareTo(contraseña) == 0) {
                        if (beansU.getCodverif() != null) {
                            msj = "INGRESO_ADMINISTRADOR";
                        } else {
                            msj = "INGRESO_USUARIO";
                        }
                    } else {
                        msj = "CONTRASEÑA INCORRECTA";
                    }

                } else {
                    msj = "EL NOMBRE DE USUARIO NO EXISTE";
                }
            } else {
                msj = "INGRESE LA CONTRASEÑA";
            }
        } else {
            msj = "NECESITA INGRESAR SU NOMBRE DE USUARIO";
        }

        return msj;

    }

    public Usuario DatosU(String usuario) {
        beansU = daoU.Datos(usuario);
        return beansU;
    }
    
    public Usuario DatosUxC(int cod) {
        beansU = daoU.DatosxC(cod);
        return beansU;
    }

    public String Registro(Usuario usuario) {

        //validacion de los parametros ingresados 
        List<Usuario> usuarios = new ArrayList<>();

        usuarios = daoU.listarUsuarios();

        if (usuario.getDni().compareTo("") != 0
                && usuario.getApell().compareTo("") != 0
                && usuario.getNombres().compareTo("") != 0
                && usuario.getUsuario().compareTo("") != 0
                && usuario.getContraseña().compareTo("") != 0
                && usuario.getCorreo().compareTo("") != 0
                && usuario.getTipo().compareTo("") != 0) {

            if (usuario.getUsuario().length() > 5) {

                String ComprobadorCorreo = usuario.getCorreo().substring(usuario.getCorreo().length() - 10);

                if (ComprobadorCorreo.compareTo("@gmail.com") == 0) {

                    List<String> contenedorEmail = new ArrayList<>();
                    List<String> contenedorUsuario = new ArrayList<>();

                    int n = usuarios.size();
                    int contadorC = 0, contadorU = 0;

                    while (contadorC < n) {
                        contenedorEmail.add(usuarios.get(contadorC).getCorreo());
                        contadorC = contadorC + 1;
                    }

                    while (contadorU < n) {
                        contenedorUsuario.add(usuarios.get(contadorU).getUsuario());
                        contadorU = contadorU + 1;
                    }

                    int posC = contenedorEmail.indexOf(usuario.getCorreo());
                    int posU = contenedorUsuario.indexOf(usuario.getUsuario());

                    if (posC >= 0) {

                        msj = "EL CORREO ELECTRONICO YA EXISTE";

                    } else if (posU >= 0) {
                        msj = "EL USUARIO YA EXISTE";
                    } else {

                        if (usuario.getDni().length() == 8) {

                            msj = (daoU.Agregar(usuario));
                        } else {
                            msj = "!El DNI DEBE CONTENER 8 NUMEROS¡";
                        }
                    }
                } else {
                    msj = "EL CORREO ELECTRONICO DEBE TERMINAR CON [@gmail.com]";
                }
            } else {
                msj = "NOMBRE DE USUARIO INVALIDO";
            }
        } else {
            msj = "FALTAN DATOS";
        }

        return msj;

    }
    
    public String Puntos(int cod, int cantidad, String tipo) {
        
        String puntos;
        
        if(tipo.equals("REDUCIR")){
            puntos = "-" + cantidad + " ";
            msj = daoU.Puntos(cod, puntos);
        } else if(tipo.equals("AUMENTAR")){
            puntos = "+" + cantidad + " ";
            msj = daoU.Puntos(cod, puntos);
        }
        return msj;
    }
    
    public int Contar() {
        
        int n = daoU.Contar();
        return n;
    }
}
