/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package libcode.webapp.controladores;

import jakarta.annotation.PostConstruct; // Listo
import jakarta.ejb.EJB; // Listo
import jakarta.enterprise.context.RequestScoped; // Listo
import jakarta.inject.Named; // Listo
import java.util.ArrayList; // Listo
import java.util.List; // Listo
import libcode.webapp.entidades.Alumno; // Listo
import libcode.webapp.negocio.DataService; // Listo

/**
 *
 * @author Usuario
 */
@Named
@RequestScoped
public class IndexController {

    private List<Alumno> alumnosList = new ArrayList<>();

    private Alumno alumno = new Alumno();

    @EJB
    DataService servicio;

    @PostConstruct
    public void cargarAlumnos() {
        alumnosList = servicio.getAlumnos();
    }

    public void guardarAlumno() {
        if (alumno.getId() != null) {
            servicio.editAlumno(alumno);
        } else {
            servicio.saveAlumno(alumno);
        }
        alumno = new Alumno();
        cargarAlumnos();
    }

    public void llenarFormEditar(Alumno alumno) {
        this.alumno.setId(alumno.getId());
        this.alumno.setNombre(alumno.getNombre());
        this.alumno.setCarnet(alumno.getCarnet());
    }
    
    public void eliminarAlumno(Alumno alumno){
        servicio.deleteAlumno(alumno);
        cargarAlumnos();
    }

    // Getter y Setter
    public List<Alumno> getAlumnosList() {
        return alumnosList;
    }

    public void setAlumnosList(List<Alumno> alumnosList) {
        this.alumnosList = alumnosList;
    }

    // Getter y Setter
    public Alumno getAlumno() {
        return alumno;
    }

    public void setAlumno(Alumno alumno) {
        this.alumno = alumno;
    }

}
