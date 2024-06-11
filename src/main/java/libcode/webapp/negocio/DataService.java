
package libcode.webapp.negocio;

import libcode.appweb.entidades.Alumno;
import libcode.appweb.entidades.Materia;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import jakarta.transaction.Transactional;
import java.util.List;
import libcode.appweb.entidades.Inscripciones;
import libcode.appweb.entidades.InscripcionesView;

@Stateless

public class DataService {
    
    @PersistenceContext( unitName = "pu")
    EntityManager entityManager;  
    
        public List<Alumno> getAlumnos(){
            
            Query query = entityManager.createQuery("SELECT e FROM Alumno e ORDER BY e.id DESC");
                    
            List<Alumno> alumnos = query.getResultList();
                    
            return alumnos;
        }

        
        public List<Materia> getMaterias(){
            
            Query queryMateria = entityManager.createQuery("SELECT e FROM Materia e ORDER BY e.id DESC");
                    
            List<Materia> materias = queryMateria.getResultList();
                    
            return materias;
        }
        
        public List<Inscripciones> getInscripciones(){
            
            Query queryInscripcion = entityManager.createQuery("SELECT e FROM Inscripciones e ORDER BY e.id DESC");
            
            List<Inscripciones> inscripcion = queryInscripcion.getResultList();

            return inscripcion;
        }

        public List<InscripcionesView> getInscripcionesView() {
            Query queryInscripcionView = entityManager.createQuery("SELECT e FROM InscripcionesView e ORDER BY e.id DESC");
            
            List<InscripcionesView> inscripcionView = queryInscripcionView.getResultList();

            return inscripcionView;
        }      
        
        
        public List<Alumno> obtenerAlumnos() {
            return entityManager.createQuery("SELECT a FROM Alumno a", Alumno.class).getResultList();
        }               
        

        public List<Materia> obtenerMaterias() {
            return entityManager.createQuery("SELECT a FROM Materia a", Materia.class).getResultList();
        }               
        

        @Transactional
        public void saveAlumno(Alumno alumno){
            entityManager.persist(alumno);
        }
        
        @Transactional
        public void editAlumno(Alumno alumno){
            entityManager.merge(alumno);
        }
        
        @Transactional
         public void deleteAlumno(Alumno alumno){
            Alumno alumnoEliminar = entityManager.find(Alumno.class, alumno.getId());
            entityManager.remove(alumnoEliminar);
        }
         
        @Transactional
        public void saveMateria(Materia materia){
            entityManager.persist(materia);
        }
        
        @Transactional
        public void editMateria(Materia materia){
            entityManager.merge(materia);
        }
        
        @Transactional
         public void deleteMateria(Materia materia){
            Materia materiaEliminar = entityManager.find(Materia.class, materia.getId());
            entityManager.remove(materiaEliminar);
        }  
         
        @Transactional
        public void saveInscripcion(Inscripciones inscripcion){
            entityManager.persist(inscripcion);
        }

        @Transactional
        public void editInscripcion(Inscripciones inscripcion){
            entityManager.merge(inscripcion);
        }

        @Transactional
        public void deleteInscripcion(Inscripciones inscripcion){
            Inscripciones inscripcionEliminar = entityManager.find(Inscripciones.class, inscripcion.getId());
            entityManager.remove(inscripcionEliminar);
        }
}
