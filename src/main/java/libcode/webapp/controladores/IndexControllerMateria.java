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
import libcode.webapp.entidades.Materia;
import libcode.webapp.negocio.DataService; // Listo
/**
 *
 * @author Usuario
 */
@Named
@RequestScoped
public class IndexControllerMateria {
    
    
    // Materia
    private List<Materia> materiasList = new ArrayList<>();

    private Materia materia = new Materia();
    
    @EJB
    DataService servicio;
    
    // Materia
    @PostConstruct
    public void cargarMaterias() {
        materiasList = servicio.getMaterias();
    }

    public void guardarMateria() {
        if (materia.getId() != null) {
            servicio.editMateria(materia);
        } else {
            servicio.saveMateria(materia);
        }
        materia = new Materia();
        cargarMaterias();
    }

    public void llenarFormEditarMateria(Materia materia) {
        this.materia.setId(materia.getId());
        this.materia.setNombre(materia.getNombre());
        this.materia.setDescripcion(materia.getDescripcion());
        this.materia.setCodigo_materia(materia.getCodigo_materia());
    }

    public void eliminarMateria(Materia materia) {
        servicio.deleteMateria(materia);
        cargarMaterias();
    }

// Getter y Setter
    public List<Materia> getMateriasList() {
        return materiasList;
    }

    public void setMateriasList(List<Materia> materiasList) {
        this.materiasList = materiasList;
    }

// Getter y Setter
    public Materia getMateria() {
        return materia;
    }

    public void setMateria(Materia materia) {
        this.materia = materia;
    }

}
