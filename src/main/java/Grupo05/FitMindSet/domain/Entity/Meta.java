package Grupo05.FitMindSet.domain;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;
@Data
@Entity
@Table(name = "Meta")
public class Meta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "PK_MetaID")
    private Long id;

    @Column(name = "Descripcion", nullable = false)
    private String descripcion;

    @Column(name = "Estado", nullable = false)
    private String estado;

    @Column(name = "FechaInicio", nullable = false)
    private LocalDateTime fechaInicio;

    @Column(name = "FechaFin", nullable = false)
    private LocalDateTime fechaFin;


    @OneToMany(mappedBy = "meta", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Seguimiento> seguimientos;
}
