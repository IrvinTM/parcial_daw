/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package libcode.webapp.negocio;

import jakarta.ejb.Stateless; // Listo
import jakarta.persistence.EntityManager; // Listo
import jakarta.persistence.PersistenceContext; // Listo
import jakarta.persistence.Query; // Listo
import jakarta.transaction.Transactional; // Listo
import java.util.List; // Listo
import libcode.webapp.entidades.Alumno; // Listo
import libcode.webapp.entidades.Inscripciones;
import libcode.webapp.entidades.Materia;

/**
 *
 * @author Usuario
 */
@Stateless
public class DataService {

    @PersistenceContext( unitName = "pu" )
    EntityManager entityManager;

    public List<Alumno> getAlumnos() {

        Query query = entityManager.createQuery("SELECT e FROM Alumno e ORDER BY e.id ASC");

        List<Alumno> alumnos = query.getResultList();

        return alumnos;

    }
    
    public List<Inscripciones> getInscripciones(){
        Query query = entityManager.createQuery("SELECT i FROM Inscripciones i ORDER BY i.id ASC");
        List<Inscripciones> inscripciones = query.getResultList();
        return inscripciones;
    }
    
    public List<Materia> getMaterias() {

        Query query = entityManager.createQuery("SELECT m FROM Materia m ORDER BY m.id ASC");

        List<Materia> materias = query.getResultList();

        return materias;

    }

    @Transactional
    public void saveAlumno(Alumno alumno) {
        entityManager.persist(alumno);
    }

    @Transactional
    public void editAlumno(Alumno alumno) {
        entityManager.merge(alumno);
    }
    
    @Transactional
    public void deleteAlumno(Alumno alumno) {
        Alumno alumnoEliminar = entityManager.find(Alumno.class,alumno.getId());
        entityManager.remove(alumnoEliminar);
    }
    
    
    
    // Materia

    @Transactional
    public void saveMateria(Materia materia) {
        entityManager.persist(materia);
    }

    @Transactional
    public void editMateria(Materia materia) {
        entityManager.merge(materia);
    }
    
    @Transactional
    public void deleteMateria(Materia materia) {
        Materia materiaEliminar = entityManager.find(Materia.class,materia.getId());
        entityManager.remove(materiaEliminar);
    }
    @Transactional
    public void saveInscripcion(Inscripciones inscripcion){
        entityManager.persist(inscripcion);
    }
    
    @Transactional
    public void deleteInscripcion(Inscripciones inscripcion){
        Inscripciones inscripcionEliminar = entityManager.find(Inscripciones.class, inscripcion.getId());
        entityManager.remove(inscripcionEliminar);
    }

}
