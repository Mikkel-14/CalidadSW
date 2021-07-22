package controlador;

import modelo.dao.DAOFactory;
import modelo.entidad.Administrador;
import modelo.entidad.Usuario;
import modelo.jpa.JPAFactory;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
@WebServlet("/actualizarEstudianteController")
public class LoginController extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        procesarSolicitud(request,response);
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        procesarSolicitud(request,response);
    }
    private void procesarSolicitud(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String recordar= req.getParameter("recordarme");
        String email = req.getParameter("email");
        String contrasena = req.getParameter("password");
        //
        DAOFactory fabrica = new JPAFactory();
        Administrador administrador = (Administrador) fabrica.crearUsuarioDAO(JPAFactory.ADMINISTRADOR).autorizar(email,contrasena);
        Usuario user= (Usuario) fabrica.crearUsuarioDAO(JPAFactory.USUARIO).autorizar(email,contrasena);
        Cookie emailCookie = new Cookie("email","");
        Cookie passCookie = new Cookie("password","");
        Cookie banderaCookie = new Cookie("recordar","");

        if(recordar != null && recordar.equals("on")){
            emailCookie.setValue(email);
            passCookie.setValue(contrasena);
            banderaCookie.setValue(recordar);
        }else{
            emailCookie.setMaxAge(0);
            passCookie.setMaxAge(0);
            banderaCookie.setMaxAge(0);
            resp.addCookie(passCookie);
            resp.addCookie(emailCookie);
            resp.addCookie(banderaCookie);
        }

        if(administrador != null){
            //Abriendo la sesión
            HttpSession sesion = req.getSession();
            sesion.setAttribute("usuario",email);
            String tipo = "administrador";
            sesion.setAttribute("tipo",tipo);
            //Redireccionando a la jsp
            resp.addCookie(passCookie);
            resp.addCookie(emailCookie);
            resp.addCookie(banderaCookie);
            getServletContext().getRequestDispatcher("/ModuloAdministrador.jsp").forward(req,resp);
        }else if(user != null){
            //Abriendo la sesión
            HttpSession sesion = req.getSession();
            sesion.setAttribute("usuario",email);
            String tipo = "usuario";
            sesion.setAttribute("tipo",tipo);
            //Redireccionando a la jsp
            resp.addCookie(passCookie);
            resp.addCookie(emailCookie);
            resp.addCookie(banderaCookie);
            getServletContext().getRequestDispatcher("/ModuloUsuario.jsp").forward(req,resp);
        }else{
            emailCookie.setMaxAge(0);
            passCookie.setMaxAge(0);
            banderaCookie.setMaxAge(0);
            resp.addCookie(passCookie);
            resp.addCookie(emailCookie);
            resp.addCookie(banderaCookie);
            resp.sendRedirect("index.jsp");
        }


    }
}
