package modelo.jpa;

import modelo.dao.UsuarioDAO;
import modelo.entidad.Administrador;
import modelo.entidad.Usuario;

import java.util.List;

public class JPAAdministrador extends JPAGenericDAO<Administrador,String> implements UsuarioDAO<Administrador,String> {
    public JPAAdministrador() {
        super(Administrador.class);

    }

    @Override
    public Administrador autorizar(String codUnico, String contrasenia) {
        Administrador administradorEntidad = this.leer(codUnico);
        if (administradorEntidad != null) {
            if (administradorEntidad.getContrasenia().equals(contrasenia))
                return administradorEntidad;
        }
        return null;
    }

    @Override
    public List<Administrador> listar() {
        return null;
    }
}
