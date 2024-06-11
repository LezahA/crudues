package libcode.webapp.resources;

import jakarta.ejb.EJB;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import java.util.List;
import libcode.appweb.entidades.Inscripciones;
import libcode.webapp.negocio.DataService;

@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@Path("/inscripciones")

public class RecursoInscripcion {
    
    @EJB DataService servicio;
    
    @GET
    public Response getInscripciones(){
        List<Inscripciones> inscripciones = servicio.getInscripciones();
        return Response.ok(inscripciones).build();
    }
    
    @POST
    public Response saveInscripcion(Inscripciones inscripcion){
        servicio.saveInscripcion(inscripcion);
        return Response.ok("Inscripción ingresada exitosamente").build();
    }
    
    @PUT
    public Response editInscripcion(Inscripciones inscripcion){
        servicio.editInscripcion(inscripcion);
        return Response.ok("Inscripción editada exitosamente").build();
    }
    
    @DELETE
    @Path("/{id_inscripciones}")
    public Response deleteInscripcion(@PathParam("id_inscripciones") Integer idInscripcion){
        servicio.deleteInscripcion(new Inscripciones(idInscripcion));
        return Response.ok("Inscripción eliminada exitosamente").build();
    }
}
