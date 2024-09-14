package upao.Transa.domain.Entity;

import jakarta.persistence.*;
import upao.Transa.domain.Enum.TipoSuscripcion;

import java.time.LocalDateTime;

@Entity
@Table(name = "Suscripcion")
public class Suscripcion {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(name = "Fechainicio",nullable = true)
    private LocalDateTime fechainicio;
    @Column(name = "FechaFin",nullable = true)
    private LocalDateTime fechafin;
    @Enumerated(EnumType.STRING)
    private TipoSuscripcion tipoSuscripcion;
}
