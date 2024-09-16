package upao.Transa.domain.Entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "Habito")
public class Habito {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "Habito_id")
    private Long habitoId;

    @Column(name = "NombreHabito", nullable = false, length = 255)
    private String nombreHabito;

    @Column(name = "Descripcion", nullable = false, length = 255)
    private String descripcion;


    @ManyToOne
    @JoinColumn(name = "TipoDeHabitoID", nullable = false)
    private TipoDeHabito tipoDeHabito;


    @ManyToOne
    @JoinColumn(name = "Usuario_id", referencedColumnName = "id", nullable = true)
    private Usuario usuario;

}
