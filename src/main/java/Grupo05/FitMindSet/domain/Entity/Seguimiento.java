package Grupo05.FitMindSet.domain;
import Grupo05.FitMindSet.domain.Estado;
import Grupo05.FitMindSet.domain.Meta;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "Seguimientos")
public class Seguimiento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "PK_SeguimientoID")
    private Long id;

    @Column(name = "Fecha", nullable = true)
    private LocalDateTime fecha;

    @Column(name = "Porcentaje", nullable = true)
    private Integer porcentaje;

    @Column(name = "TiempoCumplido", nullable = true)
    private Integer tiempoCumplido;

    @Enumerated(EnumType.STRING)
    @Column(name = "Estado", nullable = true)
    private Estado estado;

    @ManyToOne
    @JoinColumn(name = "FK_MetaID", nullable = false)
    private Meta meta;
}
