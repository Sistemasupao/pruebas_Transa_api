package upao.Transa.domain.Entity;


import jakarta.persistence.*;

@Entity
@Table(name = "Foro")
public class Foro {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long foroId;
    @Column(name = "Titulo",nullable = false,length = 50)
    private String titulo;
    @Column(name = "Descripcion",nullable = false,length = 255)
    private String descripcion;
}
