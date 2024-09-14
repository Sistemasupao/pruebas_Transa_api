package upao.Transa.domain.Entity;

import jakarta.persistence.*;

import java.math.BigDecimal;

@Entity
@Table(name = "Plan")
public class Plan {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(name = "Nombre_Plan",nullable = false)
    private String nombrePlan;
    @Column(name = "Especificacion",nullable =false)
    private String especificacion;
    @Column(name = "Costo",nullable = true)
    private BigDecimal costo;
    @ManyToOne
    @JoinColumn(name = "SuscripcionId",nullable = false)
    private Suscripcion suscripcion;
}
