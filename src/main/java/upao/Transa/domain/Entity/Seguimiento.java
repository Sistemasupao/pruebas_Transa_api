package upao.Transa.domain.Entity;

import jakarta.persistence.*;

import java.time.LocalDateTime;


@Entity
@Table(name = "Seguimiento")
public class Seguimiento {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(name = "Fecha",nullable = true)
    private LocalDateTime fecha;
    @Column(name="Porcentaje",nullable = true)
    private Integer porcentaje;
}
