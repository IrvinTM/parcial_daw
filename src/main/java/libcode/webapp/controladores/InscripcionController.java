package libcode.webapp.controladores;

import jakarta.annotation.PostConstruct;
import jakarta.ejb.EJB;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Named;
import java.util.ArrayList;
import java.util.List;
import libcode.webapp.entidades.Inscripciones;
import libcode.webapp.negocio.DataService;

/**
 *
 * @author irvin
 */
@Named
@RequestScoped
public class InscripcionController {
    private List<Inscripciones> inscripcionesList = new ArrayList<>();
    
    private Inscripciones inscripcion = new Inscripciones();
    
    @EJB
    DataService servicio;
    
     @PostConstruct
     public void cargarInscripciones(){
         inscripcionesList = servicio.getInscripciones();
     }
     
     public void guardarInscripcion() {
        servicio.saveInscripcion(inscripcion);
        inscripcion = new Inscripciones();
    }
     
     public void eliminarAlumno(Inscripciones inscripcion){
        servicio.deleteInscripcion(inscripcion);
    }

    public List<Inscripciones> getInscripcionesList() {
        return inscripcionesList;
    }

    public void setInscripcionesList(List<Inscripciones> inscripcionesList) {
        this.inscripcionesList = inscripcionesList;
    }

    public Inscripciones getInscripcion() {
        return inscripcion;
    }

    public void setInscripcion(Inscripciones inscripcion) {
        this.inscripcion = inscripcion;
    }

    public DataService getServicio() {
        return servicio;
    }

    public void setServicio(DataService servicio) {
        this.servicio = servicio;
    }

    
     
}

