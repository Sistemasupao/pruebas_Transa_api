package upao.Transa.domain.Entity;

import jakarta.persistence.*;

@Entity
@Table(name = "Habito")
public class Habito {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long Habito_id;
    @Column(name = "NombreHabito",nullable = false,length = 255)
    private String NombreHabito;
    @Column(name = "Descripcion",nullable = false,length = 255)
    private String descripcion;
    @ManyToOne
    @JoinColumn(name = "TipoDeHabitoID",nullable = false)
    private TipoDeHabito tipoDeHabitoId;
    @ManyToOne
    @JoinColumn(name = "UsuarioId",nullable = false)
    private Usuario usuario;

}
