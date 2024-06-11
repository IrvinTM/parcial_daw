package libcode.webapp.negocio;

import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import jakarta.transaction.Transactional;
import java.util.List;
import libcode.webapp.entidades.Alumno;
import libcode.webapp.entidades.Inscripcion;
import libcode.webapp.entidades.Materia;
import java.time.LocalDate;

@Stateless
public class DataService {

    @PersistenceContext(unitName = "pu")
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
        Alumno alumnoEliminar = entityManager.find(Alumno.class, alumno.getId());
        entityManager.remove(alumnoEliminar);
    }

    // Materia
    public List<Materia> getMaterias() {
        Query query = entityManager.createQuery("SELECT m FROM Materia m ORDER BY m.id ASC");
        List<Materia> materias = query.getResultList();
        return materias;
    }

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
        Materia materiaEliminar = entityManager.find(Materia.class, materia.getId());
        entityManager.remove(materiaEliminar);
    }

    // Inscripción
    public List<Inscripcion> getInscripciones() {
        Query query = entityManager.createQuery("SELECT i FROM Inscripcion i ORDER BY i.id ASC");
        List<Inscripcion> inscripciones = query.getResultList();
        return inscripciones;
    }

    @Transactional
    public void saveInscripcion(Inscripcion inscripcion) {
        inscripcion.setFechaInscripcion(LocalDate.now());
        entityManager.persist(inscripcion);
    }

}
