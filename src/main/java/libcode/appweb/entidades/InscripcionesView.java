
package libcode.appweb.entidades;

import jakarta.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "inscripciones_view")

public class InscripcionesView implements Serializable {

    @Id
    
    @Column(name = "id_inscripciones")
    private Integer id;
    
    @Column(name = "nombre")
    private String nombre;
    
    @Column(name = "nombre_materia")
    private String nombreMateria;
    
    @Column(name = "ciclo_materia")
    private String cicloMateria;
    
    @Column(name = "fecha_a")
    private Integer fechaA;

    @Column(name = "fecha_inscripcion")
    private String fechaInscripcion;

    
    // getters y setters

    public Integer getId() {
        return id;
    }


    public String getNombre() {
        return nombre;
    }

    public String getNombreMateria() {
        return nombreMateria;
    }


    public String getCicloMateria() {
        return cicloMateria;
    }


    public Integer getFechaA() {
        return fechaA;
    }


    public String getFechaInscripcion() {
        return fechaInscripcion;
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
        final InscripcionesView other = (InscripcionesView) obj;
        return Objects.equals(this.id, other.id);
    }

    @Override
    public String toString() {
        return "Inscripciones{" + "id_inscripciones=" + id + ", nombre=" + nombre + ", nombre_materia=" + nombreMateria + " , ciclo_materia= " + cicloMateria  + " , fecha_a= "+ fechaA + ", fecha_inscripcion = " + fechaInscripcion + '}';
    }    

    //constructores
    public InscripcionesView() {
    }

    public InscripcionesView(Integer id) {
        this.id = id;
    }    
    
    public InscripcionesView(Integer id, String nombre, String nombreMateria, String cicloMateria, Integer fechaA, String fechaInscripcion) {
        this.id = id;
        this.nombre = nombre;
        this.nombreMateria = nombreMateria;
        this.cicloMateria = cicloMateria;
        this.fechaA = fechaA;
        this.fechaInscripcion = fechaInscripcion;
    }
  

}