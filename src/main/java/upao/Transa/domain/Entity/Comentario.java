package upao.Transa.domain.Entity;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;
@Data
@Entity
@Table(name = "Comentario")
public class Comentario {
    @Id
    @Column(name = "ComentarioId")
    private Long comentarioId;

    @Column(name = "Contenido", nullable = false, length = 255)
    private String contenido;

    @Column(name = "FechadePublicacion", nullable = false)
    private LocalDateTime fechaPublicacion;

    @ManyToOne
    @JoinColumn(name = "ForoId")
    private Foro foro;
}
