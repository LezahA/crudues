
package libcode.appweb.entidades;

import jakarta.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "inscripciones")
public class Inscripciones implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "inscripciones_id_inscripciones_seq")
    @SequenceGenerator(name = "inscripciones_id_inscripciones_seq", sequenceName = "inscripciones_id_inscripciones_seq", allocationSize = 1)
    @Column(name = "id_inscripciones")
    private Integer id;
    
    @Column(name = "id_alumno")
    private Integer idAlumno;
    
    @Column(name = "id_materia")
    private Integer idMateria;
    
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

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getIdAlumno() {
        return idAlumno;
    }

    public void setIdAlumno(Integer idAlumno) {
        this.idAlumno = idAlumno;
    }

    public Integer getIdMateria() {
        return idMateria;
    }

    public void setIdMateria(Integer idMateria) {
        this.idMateria = idMateria;
    }

    public String getCicloMateria() {
        return cicloMateria;
    }

    public void setCicloMateria(String cicloMateria) {
        this.cicloMateria = cicloMateria;
    }

    public Integer getFechaA() {
        return fechaA;
    }

    public void setFechaA(Integer fechaA) {
        this.fechaA = fechaA;
    }

    public String getFechaInscripcion() {
        return fechaInscripcion;
    }

    public void setFechaInscripcion(String fechaInscripcion) {
        this.fechaInscripcion = fechaInscripcion;
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
        final Inscripciones other = (Inscripciones) obj;
        return Objects.equals(this.id, other.id);
    }

    @Override
    public String toString() {
        return "Inscripciones{" + "id_inscripciones=" + id + ", id_alumno=" + idAlumno + ", id_materia=" + idMateria + " , ciclo_materia= " + cicloMateria  + " , fecha_a= "+ fechaA + ", fecha_inscripcion = " + fechaInscripcion + '}';
    }    

    //constructores
    public Inscripciones() {
    }

    public Inscripciones(Integer id) {
        this.id = id;
    }    
    
    public Inscripciones(Integer id,Integer idAlumno,Integer idMateria,String cicloMateria,Integer fechaA,String fechaInscripcion) {
        this.id = id;
        this.idAlumno = idAlumno;
        this.idMateria = idMateria;
        this.cicloMateria = cicloMateria;
        this.fechaA = fechaA;
        this.fechaInscripcion = fechaInscripcion;
    }    

}