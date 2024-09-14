package upao.Transa.domain.Entity;

import jakarta.persistence.*;
import upao.Transa.domain.Enum.TipoRecurso;

import java.math.BigDecimal;

@Entity
@Table(name="Recursos")
public class Recurso {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long recursoid;
    @Column(name = "NombreRecurso",nullable = true)
    private String nombreRecurso;
    @Column(name = "Descripcion",nullable = true)
    private String descripcionRecurso;
    @Column(name = "Precio",nullable = true)
    private BigDecimal precioRecurso;
    @Enumerated(EnumType.STRING)
    private TipoRecurso tipoRecurso;
    @ManyToOne
    @JoinColumn(name = "AutorID",nullable = false)
    private Autor autor;
    @ManyToOne
    @JoinColumn(name = "TipoDeHabitoId",nullable = false)
    private TipoDeHabito tipoDeHabito;

}
