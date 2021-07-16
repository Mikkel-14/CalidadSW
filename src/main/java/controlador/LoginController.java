package controlador;

import modelo.dao.DAOFactory;
import modelo.entidad.Administrador;
import modelo.entidad.Usuario;

import javax.servlet.ServletException;
import javax.servlet.http.*;
import java.io.IOException;

public class LoginController extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        procesarSolicitud(request,response);
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        procesarSolicitud(request,response);
    }
    private void procesarSolicitud(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String recordar= req.getParameter("recordarme");
        String usuario = req.getParameter("usuario");
        String contrasena = req.getParameter("password");
        //
        DAOFactory fabrica = JPAFactory();
        Administrador administrador = (Administrador) fabrica.crearUsuarioDAO(JPAFactory.ADMINISTRADOR).autorizar(usuario,contrasena);
        Usuario user= (Usuario) fabrica.crearUsuarioDAO(JPAFactory.USUARIO).autorizar(usuario,contrasena);
        Cookie userCookie = new Cookie("usuario","");
        Cookie passCookie = new Cookie("password","");
        Cookie banderaCookie = new Cookie("recordar","");

        if(recordar != null && recordar.equals("on")){
            userCookie.setValue(usuario);
            passCookie.setValue(contrasena);
            banderaCookie.setValue(recordar);
        }else{
            userCookie.setMaxAge(0);
            passCookie.setMaxAge(0);
            banderaCookie.setMaxAge(0);
            resp.addCookie(passCookie);
            resp.addCookie(userCookie);
            resp.addCookie(banderaCookie);
        }

        if(administrador != null){
            //Abriendo la sesión
            HttpSession sesion = req.getSession();
            sesion.setAttribute("usuario",usuario);
            String tipo = "administrador";
            sesion.setAttribute("tipo",tipo);
            //Redireccionando a la jsp
            resp.addCookie(passCookie);
            resp.addCookie(userCookie);
            resp.addCookie(banderaCookie);
            getServletContext().getRequestDispatcher("/ModuloAdministrador.jsp").forward(req,resp);
        }else if(user != null){
            //Abriendo la sesión
            HttpSession sesion = req.getSession();
            sesion.setAttribute("usuario",usuario);
            String tipo = "usuario";
            sesion.setAttribute("tipo",tipo);
            //Redireccionando a la jsp
            resp.addCookie(passCookie);
            resp.addCookie(userCookie);
            resp.addCookie(banderaCookie);
            getServletContext().getRequestDispatcher("/ModuloUsuario.jsp").forward(req,resp);
        }else{
            userCookie.setMaxAge(0);
            passCookie.setMaxAge(0);
            banderaCookie.setMaxAge(0);
            resp.addCookie(passCookie);
            resp.addCookie(userCookie);
            resp.addCookie(banderaCookie);
            resp.sendRedirect("index.jsp");
        }


    }
}
