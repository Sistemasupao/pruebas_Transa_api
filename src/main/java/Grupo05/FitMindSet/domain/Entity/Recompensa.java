package Grupo05.FitMindSet.domain.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;




@Entity
public class Recompensa {




    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;
    private String descripcion;




    public String getDescripcion() {
        return descripcion;
    }




    public Long getId() {
        return id;
    }




    public String getNombre() {
        return nombre;
    }




    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }




    public void setId(Long id) {
        this.id = id;
    }




    public void setNombre(String nombre) {
        this.nombre = nombre;
    }




}
