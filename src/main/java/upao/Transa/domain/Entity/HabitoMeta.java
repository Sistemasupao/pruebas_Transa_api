package upao.Transa.domain.Entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "HabitoMeta")
public class HabitoMeta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "PK_HabitoMetaID")
    private Long id;


    @ManyToOne
    @JoinColumn(name = "FK_MetaID", nullable = false)
    private Meta meta;


    @ManyToOne
    @JoinColumn(name = "FK_HabitoID", nullable = false)
    private Habito habito;

}