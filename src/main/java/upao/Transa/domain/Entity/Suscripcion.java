package upao.Transa.domain.Entity;

import jakarta.persistence.*;
import upao.Transa.domain.Enum.TipoSuscripcion;

import java.time.LocalDateTime;

@Entity
@Table(name = "Suscripcion")
public class Suscripcion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column(name = "PK_SuscripcionID")
    private Long id;

    @Column(name = "Fechainicio", nullable = true)
    private LocalDateTime fechainicio;

    @Column(name = "FechaFin", nullable = true)
    private LocalDateTime fechafin;

    @Enumerated(EnumType.STRING)
    @Column(name = "TipoSuscripcion", nullable = false)
    private TipoSuscripcion tipoSuscripcion;

    @ManyToOne
    @JoinColumn(name = "FK_Usuario_Suscripcion", nullable = false)
    private Usuario usuario;


    @ManyToOne
    @JoinColumn(name = "FK_Plan_Suscripcion", nullable = false)
    private Plan plan;
}
