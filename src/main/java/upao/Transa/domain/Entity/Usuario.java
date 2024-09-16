package upao.Transa.domain.Entity;

import jakarta.persistence.*;
import lombok.Data;
import upao.Transa.domain.Enum.Role;
import java.util.List;

@Data
@Entity
@Table(name = "Usuario")
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "Nombre", nullable = false, length = 100)
    private String nombre;

    @Column(name = "Apellidos", nullable = false, length = 100)
    private String apellidos;

    @Column(name = "Correo", nullable = false, unique = true)
    private String correo;

    @Column(name = "Contraseña", nullable = false)
    private String contrasena;

    @Column(name = "Edad")
    private int edad;

    @Column(name = "Genero")
    private String genero;

    @Enumerated(EnumType.STRING)
    private Role role;


    @ManyToOne
    @JoinColumn(name = "SuscripcionID")
    private Suscripcion suscripcion;


    @OneToMany(mappedBy = "usuario")
    private List<Habito> habitos;

    @OneToMany(mappedBy = "usuario")
    private List<Foro> foros;

}
