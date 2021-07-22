package controlador;

import modelo.dao.DAOFactory;
import modelo.entidad.Denuncia;
import modelo.jpa.JPAFactory;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

@WebServlet("/registroDenunciaController")
public class RegistroDenunciaController extends HttpServlet {
    private static final long serialVersionUID = 1L;
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        procesarSolicitud(request, response);
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        procesarSolicitud(request, response);
    }

    private void procesarSolicitud(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException{
        String tipoDenuncia = req.getParameter("tipoDenuncia");
        String fecha = req.getParameter("fechaRegistro");
        String descripcion = req.getParameter("descripcion");
        String facultad = req.getParameter("facultad");

        DAOFactory fabrica = new JPAFactory();
        if(tipoDenuncia != "" && fecha != "" && descripcion != "" && facultad != "" ){
            Denuncia denuncia = null;
            try {
                denuncia = new Denuncia(descripcion,tipoDenuncia,new SimpleDateFormat("dd/MM/yyyy").parse(fecha),facultad);
                fabrica.crearDenuciaDAO().crear(denuncia);
                req.setAttribute("mensajeExito", "Se ha registrado la denuncia");//mensaje
            } catch (ParseException e) {
                req.setAttribute("mensajeError", "Intentelo otra vez");//mensaje
            }
        }else{
            req.setAttribute("mensajeError", "Se debe llenar todos los campos");//mensaje
        }
        getServletContext().getRequestDispatcher("/registroDenuncia.jsp").forward(req, resp);
    }
}
