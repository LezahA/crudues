package libcode.appweb.controladores;

import jakarta.annotation.PostConstruct;
import jakarta.ejb.EJB;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Named;
import java.util.ArrayList;
import java.util.List;
import libcode.appweb.entidades.Materia;
import libcode.appweb.entidades.Alumno;
import libcode.appweb.entidades.Inscripciones;
import libcode.webapp.negocio.DataService;
import java.text.SimpleDateFormat;
import java.util.Date;

@Named
@RequestScoped
public class InscripcionController {
    
    private List<Inscripciones> inscripcionesList = new ArrayList<>();
    private List<Alumno> listaAlumnos;  
    private List<Materia> listaMaterias;  
    
    private Inscripciones inscripcion = new Inscripciones();
    private String fechaInscripcionString;
    private Integer idAlumnoSeleccionado;
    private Integer idMateriaSeleccionada;

    @EJB
    DataService servicio;
    
    @PostConstruct
    public void cargarInscripciones(){
        inscripcionesList = servicio.getInscripciones();
    }

    public List<Alumno> obtenerAlumnos() {
        if (listaAlumnos == null) {
            listaAlumnos = servicio.obtenerAlumnos();
        }
        return listaAlumnos;
    }    
    
    public List<Materia> obtenerMaterias() {
        if (listaMaterias == null) {
            listaMaterias = servicio.obtenerMaterias();
        }
        return listaMaterias;
    } 

    public void guardarInscripcion() {
        if (inscripcion.getId() != null) {
            fechaInscripcionString = obtenerFechaInscripcion();
            inscripcion.setFechaInscripcion(fechaInscripcionString);
            inscripcion.setIdAlumno(idAlumnoSeleccionado); 
            inscripcion.setIdMateria(idMateriaSeleccionada); 
            
            servicio.editInscripcion(inscripcion);
        } else {
            fechaInscripcionString = obtenerFechaInscripcion();
            inscripcion.setFechaInscripcion(fechaInscripcionString);
            inscripcion.setIdAlumno(idAlumnoSeleccionado); 
            inscripcion.setIdMateria(idMateriaSeleccionada); 
            
            servicio.saveInscripcion(inscripcion);
        }
        inscripcion = new Inscripciones();
        cargarInscripciones();
    }

    public void llenarFormEditarInscripcion(Inscripciones inscripcion){
        this.inscripcion.setId(inscripcion.getId());
        this.inscripcion.setIdAlumno(inscripcion.getIdAlumno());
        this.inscripcion.setIdMateria(inscripcion.getIdMateria());
        this.inscripcion.setCicloMateria(inscripcion.getCicloMateria());
        this.inscripcion.setFechaA(inscripcion.getFechaA());
        this.inscripcion.setFechaInscripcion(inscripcion.getFechaInscripcion());
    }

    public String obtenerFechaInscripcion() {
        Date fechaActual = new Date();
        SimpleDateFormat formatoFecha = new SimpleDateFormat("yyyy-MM-dd");
        return formatoFecha.format(fechaActual);
    }

    public void eliminarInscripcion(Inscripciones inscripcion){
        servicio.deleteInscripcion(inscripcion);
        cargarInscripciones();
    }
    
    // Getters y setters
    
    public List<Inscripciones> getInscripcionesList(){
        return inscripcionesList;
    }
    

    public void setInscripcionesList(List<Inscripciones> inscripcionesList){
        this.inscripcionesList = inscripcionesList;
    }

    public Inscripciones getInscripcion() {
        return inscripcion;
    }

    public void setInscripcion(Inscripciones inscripcion) {
        this.inscripcion = inscripcion;
    }
    
    public Integer getIdAlumnoSeleccionado() {
        return idAlumnoSeleccionado;
    }
    public Integer getIdMateriaSeleccionada() {
        return idMateriaSeleccionada;
    }

    public void setIdAlumnoSeleccionado(Integer idAlumnoSeleccionado) {
        this.idAlumnoSeleccionado = idAlumnoSeleccionado;
    }    
    
    public void setIdMateriaSeleccionada(Integer idMateriaSeleccionada) {
        this.idMateriaSeleccionada = idMateriaSeleccionada;
    }      
    
    public String getFechaInscripcionString() {
        return fechaInscripcionString;
    }

    public void setFechaInscripcionString(String fechaInscripcionString) {
        this.fechaInscripcionString = fechaInscripcionString;
    }        

}
