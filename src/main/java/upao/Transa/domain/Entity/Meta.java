package upao.Transa.domain.Entity;

import jakarta.persistence.*;
import upao.Transa.domain.Enum.Estado;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name="meta")
public class Meta {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(name ="NombreMeta",nullable = false,length = 100)
    private String nombreMeta;
    @Column(name = "Descripcionmeta",nullable = false,length = 255)
    private String descripcionMeta;
    @Enumerated(EnumType.STRING)
    private Estado estado;
    @Column(name = "Fechainicio",nullable = false)
    private LocalDateTime fechainicio;
    @Column(name = "Fechafin",nullable = false)
    private LocalDateTime fechafin;
    @ManyToOne
    @JoinColumn(name = "SeguimientoId",nullable = false)
    private Seguimiento seguimiento;

}
