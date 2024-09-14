package upao.Transa.domain.Entity;
import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "Comentario")
public class Comentario {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long comentarioId;
    @Column(name = "Contenido",nullable = false,length = 255)
    private String contenido;
    @Column(name = "FechadePublicacion",nullable = false)
    private LocalDateTime fechaPublicacion;
    @ManyToOne
    @JoinColumn(name = "ForoId",nullable = false)
    private Foro foro;

}
