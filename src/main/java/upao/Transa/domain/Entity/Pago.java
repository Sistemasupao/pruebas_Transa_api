package upao.Transa.domain.Entity;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "Pago")
public class Pago {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long pagoId;
    @Column(name = "FechaPago",nullable = false)
    private LocalDateTime fechaPago;
    @Column(name = "metodoPago",nullable = false)
    private String metodoPago;
    @Column(name="Monto",nullable = false)
    private BigDecimal monto;
    @ManyToOne
    @JoinColumn(name="PlanID",nullable = false)
    private Plan plan;

}
