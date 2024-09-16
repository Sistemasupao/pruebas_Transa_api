package upao.Transa.domain.Entity;

import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;
@Data
@Entity
@Table(name = "Pago")
public class Pago {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "PK_PagoID")
    private Long pagoId;

    @Column(name = "Fecha_Pago", nullable = false)
    private LocalDateTime fechaPago;

    @Column(name = "Metodo_Pago", nullable = false)
    private String metodoPago;

    @Column(name="Monto", nullable = false)
    private BigDecimal monto;


    @ManyToOne
    @JoinColumn(name="FK_PlanID", nullable = false)
    private Plan plan;


}
