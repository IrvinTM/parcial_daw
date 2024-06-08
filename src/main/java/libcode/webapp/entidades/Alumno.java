/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package libcode.webapp.entidades;

import jakarta.persistence.Column; // Listo
import jakarta.persistence.Entity; // Listo
import jakarta.persistence.GeneratedValue; // Listo
import jakarta.persistence.GenerationType; // Listo
import jakarta.persistence.Id; // Listo
import jakarta.persistence.SequenceGenerator; // Listo
import jakarta.persistence.Table; // Listo
import java.io.Serializable; // Listo
import java.util.Objects; // Listo

/**
 *
 * @author Usuario
 */
@Entity
@Table(name = "alumno")
public class Alumno implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "alumno_id_seq")
    @SequenceGenerator(name = "alumno_id_seq", sequenceName = "alumno_id_seq", allocationSize = 1)
    @Column(name = "id")
    private Integer id;

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "carnet")
    private String carnet;

    public Integer getId() {
        return id;
    }

    public void setId(Integer Id) {
        this.id = Id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCarnet() {
        return carnet;
    }

    public void setCarnet(String carnet) {
        this.carnet = carnet;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 97 * hash + Objects.hashCode(this.id);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Alumno other = (Alumno) obj;
        return Objects.equals(this.id, other.id);
    }

    @Override
    public String toString() {
        return "Alumno{" + "id=" + id + ", nombre=" + nombre + ", carnet=" + carnet + '}';
    }

    public Alumno(Integer Id) {
        this.id = Id;
    }

    public Alumno(Integer Id, String nombre, String carnet) {
        this.id = Id;
        this.nombre = nombre;
        this.carnet = carnet;
    }

    public Alumno() {
    }

    public Alumno(Integer Id, String nombre) {
        this.id = Id;
        this.nombre = nombre;
    }

}
