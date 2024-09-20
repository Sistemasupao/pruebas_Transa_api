package Grupo05.FitMindSet.domain.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;




@Entity
public class MetaSalud {




    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String descripcion;
    private double progresoActual;
    private double metaObjetivo;




    private String herramientasRecomendadas;




    public Long getId() {
        return id;
    }




    public void setId(Long id) {
        this.id = id;
    }




    public String getDescripcion() {
        return descripcion;
    }




    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }




    public double getProgresoActual() {
        return progresoActual;
    }




    public void setProgresoActual(double progresoActual) {
        this.progresoActual = progresoActual;
    }




    public double getMetaObjetivo() {
        return metaObjetivo;
    }




    public void setMetaObjetivo(double metaObjetivo) {
        this.metaObjetivo = metaObjetivo;
    }




    public String getHerramientasRecomendadas() {
        return herramientasRecomendadas;
    }




    public void setHerramientasRecomendadas(String herramientasRecomendadas) {
        this.herramientasRecomendadas = herramientasRecomendadas;
    }
}

