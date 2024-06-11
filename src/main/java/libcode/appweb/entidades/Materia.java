
package libcode.appweb.entidades;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "materia")

public class Materia implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "materia_id_materia_seq")
    @SequenceGenerator(name = "materia_id_materia_seq", sequenceName = "materia_id_materia_seq", allocationSize = 1)
    @Column(name = "id_materia")
    private Integer id;
    
    @Column(name = "nombre_materia")
    private String nombre;
    
    @Column(name = "descripcion_materia")
    private String descripcion;
    
    @Column(name = "codigo_materia")
    private String codigo;

    public Integer getId() {
        return id;
    }


    public String getNombre() {
        return nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public String getCodigo() {
        return codigo;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }    

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }


    @Override
    public int hashCode() {
        int hash = 5;
        hash = 23 * hash + Objects.hashCode(this.id);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Materia other = (Materia) obj;
        return Objects.equals(this.id, other.id);
    }

    @Override
    public String toString() {
        return "Materia{" + "id_materia=" + id + ", nombre_materia=" + nombre + ", descripcion_materia=" + descripcion + " , codigo_materia= " + codigo + '}';
    }

    public Materia(Integer id) {
        this.id = id;
    }

    public Materia(Integer id, String nombre, String descripcion, String codigo) {
        this.id = id;
        this.nombre = nombre;
        this.descripcion = nombre;
        this.codigo = nombre;

    }
    
    public Materia() {
        
    }      
}