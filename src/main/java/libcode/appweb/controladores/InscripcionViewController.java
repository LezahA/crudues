package libcode.appweb.controladores;

import jakarta.annotation.PostConstruct;
import jakarta.ejb.EJB;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Named;
import java.util.ArrayList;
import java.util.List;
import libcode.webapp.negocio.DataService;
import libcode.appweb.entidades.InscripcionesView;

@Named
@RequestScoped
public class InscripcionViewController {

    private List<InscripcionesView> inscripcionesViewList = new ArrayList<>();
    
    private InscripcionesView inscripcionesView = new InscripcionesView();

    @EJB
    DataService servicio;
    
    @PostConstruct
    public void cargarInscripcionesView(){
        inscripcionesViewList = servicio.getInscripcionesView();
    }

    public List<InscripcionesView> getInscripcionesViewList() {
        return inscripcionesViewList;
    }

    public InscripcionesView getInscripcionesView() {
        return inscripcionesView;
    }   
    
}
