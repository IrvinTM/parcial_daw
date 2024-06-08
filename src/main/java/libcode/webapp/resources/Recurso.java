/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package libcode.webapp.resources;

import jakarta.ejb.EJB; // Listo
import jakarta.ws.rs.Consumes; // Listo
import jakarta.ws.rs.DELETE; // Listo
import jakarta.ws.rs.GET; // Listo
import jakarta.ws.rs.POST; // Listo
import jakarta.ws.rs.PUT; // Listo
import jakarta.ws.rs.Path; // Listo
import jakarta.ws.rs.PathParam; // Listo
import jakarta.ws.rs.Produces; // Listo
import jakarta.ws.rs.core.MediaType; // Listo
import jakarta.ws.rs.core.Response; // Listo
import java.util.List; // listo
import libcode.webapp.entidades.Alumno; // Listo
import libcode.webapp.negocio.DataService; // Listo

/**
 *
 * @author Usuario
 */
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@Path("/alumnos")
public class Recurso {

    @EJB DataService servicio;

    @GET
    public Response getAlumnos() {

        List<Alumno> alumnos = servicio.getAlumnos();

        return Response.ok(alumnos).build();

    }

    @POST
    public Response saveAlumno(Alumno alumno) {

        servicio.saveAlumno(alumno);

        return Response.ok("Alumno creado exitosamente").build();

    }
    
    @PUT
    public Response editAlumno(Alumno alumno) {

        servicio.editAlumno(alumno);

        return Response.ok("Alumno editado exitosamente").build();

    }
    
     @DELETE
     @Path("/{id}")
    public Response deleteAlumno(@PathParam("id") Integer id) {

        servicio.deleteAlumno(new Alumno(id));

        return Response.ok("Alumno eliminado exitosamente").build();

    }
    
    
}
