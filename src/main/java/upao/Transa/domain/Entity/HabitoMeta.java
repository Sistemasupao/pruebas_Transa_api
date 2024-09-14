package upao.Transa.domain.Entity;

import jakarta.persistence.*;

@Entity
@Table(name = "HabitoMeta")
public class HabitoMeta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "MetaID", nullable = true)
    private Meta meta;

    @ManyToOne
    @JoinColumn(name = "HabitoID", nullable = true)
    private Habito habito;

    }