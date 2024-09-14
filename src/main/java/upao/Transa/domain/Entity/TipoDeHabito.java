package upao.Transa.domain.Entity;

import jakarta.persistence.*;

@Entity
@Table(name = "TipoDeHabito")
public class TipoDeHabito {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(name="descripcion_Habito",nullable = true)
    private String descripcion;
    @Column(name = "NombreTipo",nullable = true)
    private String nombre;
}
