package Grupo05.FitMindSet.domain;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;
@Data
@Entity
@Table(name = "TipoDeHabito")
public class TipoDeHabito {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "PK_TipoDeHabitoID")
    private Long id;

    @Column(name="descripcion_Habito",nullable = false)
    private String descripcion;

    @Column(name = "NombreTipo",nullable = false)
    private String nombre;


    @OneToMany(mappedBy = "tipoDeHabito", cascade = CascadeType.ALL)
    private List<Habito> habitos;

    @OneToMany(mappedBy = "tipoDeHabito", cascade = CascadeType.ALL)
    private List<Recurso> recursos;


}