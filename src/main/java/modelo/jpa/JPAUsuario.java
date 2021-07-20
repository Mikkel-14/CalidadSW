package modelo.jpa;

import modelo.dao.UsuarioDAO;
import modelo.entidad.Usuario;

import javax.persistence.Query;
import java.util.List;

public class JPAUsuario extends JPAGenericDAO<Usuario, String> implements UsuarioDAO<Usuario, String> {
    public JPAUsuario() {
        super(Usuario.class);

    }
    @Override
    public Usuario autorizar(String codUnico, String contraseña ) {
        Usuario usuarioEntidad = this.leer(codUnico);
        if (usuarioEntidad != null) {
            if (usuarioEntidad.getContrasenia().equals(contraseña))
                return usuarioEntidad;
        }
        return null;

    }

    @Override
    public List<Usuario> listar() {
        return null;
    }
}
