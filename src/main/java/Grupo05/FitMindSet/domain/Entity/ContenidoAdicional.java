package Grupo05.FitMindSet.domain.Entity;

import jakarta.persistence.*;
import lombok.Data;
import java.util.Set;

@Data
@Entity
@Table(name = "ContenidosAdicional")
public class ContenidoAdicional {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "Nombre", nullable = false)
    private String nombre;

    @Column(name = "Descripcion", nullable = false)
    private String descripcion;

    @Column(name = "Costo", nullable = false)
    private Double costo;

    @ManyToMany(mappedBy = "contenidosAdicionales")
    private Set<Suscripcion> suscripciones;
}
