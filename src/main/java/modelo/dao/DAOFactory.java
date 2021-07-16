package modelo.dao;

public abstract class DAOFactory {
    public abstract UsuarioDAO crearUsuarioDAO(String tipo);
}
