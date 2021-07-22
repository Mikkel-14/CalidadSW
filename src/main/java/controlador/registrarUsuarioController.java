package controlador;

import modelo.dao.DAOFactory;
import modelo.entidad.Administrador;
import modelo.entidad.Usuario;
import modelo.jpa.JPAFactory;
import modelo.security.HashPassword;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class registrarUsuarioController extends HttpServlet {
    private static final long serialVersionUID = 1L;
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        procesarSolicitud(request, response);
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        procesarSolicitud(request, response);
    }
    private void procesarSolicitud(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        String codigoUnico = req.getParameter("codigoUnico");
        String nombre = req.getParameter("nombre");
        String apellido = req.getParameter("apellido");
        String email = req.getParameter("email");
        String password = req.getParameter("password");
        String rol = req.getParameter("rol");
        DAOFactory fabrica = new JPAFactory();
        if (rol == "administrador"){
            Administrador administradorConsutado = (Administrador) fabrica.crearUsuarioDAO(JPAFactory.ADMINISTRADOR).leer(codigoUnico);
            if(administradorConsutado == null){
                HashPassword hash = new HashPassword();
                String salt = HashPassword.getSalt();
                String saltedPasswd = hash.valorHash(password+salt);
                Administrador administrador = new Administrador(codigoUnico,nombre,apellido,saltedPasswd,email);
                administrador.setSal(salt);
                fabrica.crearUsuarioDAO(JPAFactory.ADMINISTRADOR).crear(administrador);
                req.setAttribute("mensajeExito", "Se ha registrado el Administrador");//mensaje
            }else{
                req.setAttribute("mensajeError", "Administrador ya registrado");//mensaje
            }

        }else if (rol == "usuario"){
            Usuario usuarioConsutado = (Usuario) fabrica.crearUsuarioDAO(JPAFactory.USUARIO).leer(codigoUnico);
            if (usuarioConsutado == null){
                HashPassword hash = new HashPassword();
                String salt = HashPassword.getSalt();
                String saltedPasswd = hash.valorHash(password+salt);
                Usuario usuario = new Usuario(codigoUnico,nombre,apellido,saltedPasswd,email);
                usuario.setSal(salt);
                fabrica.crearUsuarioDAO(JPAFactory.ADMINISTRADOR).crear(usuario);
                req.setAttribute("mensajeExito", "Se ha registrado el Usuario");//mensaje
            }else{
                req.setAttribute("mensajeError", "Usuario ya registrado");//mensaje
            }

        }
        getServletContext().getRequestDispatcher("/registrarUsuario.jsp").forward(req, resp);
    }
}
