package modelo.entidad;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class Denuncia implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "descripcion")
    private String descripcion;

    @Column(name = "estado")
    private String estado;


    public Denuncia(){

    }
    public Denuncia(String denuncia){
        this.descripcion = denuncia;
        this.estado = "Registrada";
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer idDenuncia) {
        this.id = idDenuncia;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + (((descripcion) == null) ? 0 : descripcion.hashCode());
        result = prime * result + (((estado) == null) ? 0 : estado.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if(obj instanceof Denuncia){
            Denuncia denuncia = (Denuncia) obj;
            return denuncia.getId().equals(this.id);
        }
        return false;
    }

    @Override
    public String toString() {
        return "Denuncia [id= " + this.id + ", denuncia=" + this.descripcion +", estado=" + this.estado +  "]";
    }
}
