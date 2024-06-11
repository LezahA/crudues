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
import libcode.appweb.entidades.Materia;
import libcode.webapp.negocio.DataService;

@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@Path("/materias")

public class RecursoMaterias {
    
    @EJB DataService servicio;
    
    @GET
    public Response getMaterias(){
        List<Materia> materias = servicio.getMaterias();
        return Response.ok(materias).build();
    }
    
    @POST
    public Response saveMateria(Materia materia){
        servicio.saveMateria(materia);
        return Response.ok("Materia ingresada exitosamente").build();
    }
    
    @PUT
    public Response editMateria(Materia materia){
        servicio.editMateria(materia);
        return Response.ok("Materia editada exitosamente").build();
    }
    
    @DELETE
    @Path("/{id_materia}")
    public Response deleteMateria(@PathParam("id_materia") Integer id_materia){
        servicio.deleteMateria(new Materia(id_materia));
        return Response.ok("Materia eliminada exitosamente").build();
    }
}