package modelo.jpa;

import modelo.dao.DAOFactory;
import modelo.dao.UsuarioDAO;

public class JPAFactory extends DAOFactory {
    public static final String USUARIO = "usuario";
    public static final String ADMINISTRADOR = "administrador";

    @Override
    public UsuarioDAO crearUsuarioDAO(String tipo) {
        if(tipo.equals(USUARIO)) {
            return new JPAUsuario();
        }
        else if(tipo.equals(ADMINISTRADOR)) {
            return new JPAAdministrador();
        }
        else {
            return null;
        }
    }
}
