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

}
