package upao.Transa.domain.Entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "Foro")
public class Foro {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long foroId;

    @Column(name = "Titulo", nullable = false, length = 50)
    private String titulo;

    @Column(name = "Descripcion", nullable = true, length = 255)
    private String descripcion;
    @ManyToOne
    @JoinColumn(name = "usuario_id")
    private Usuario usuario;

}
