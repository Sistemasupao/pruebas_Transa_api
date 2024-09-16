package upao.Transa.domain.Entity;

import jakarta.persistence.*;
import lombok.Data;
import upao.Transa.domain.Enum.Estado;
import upao.Transa.domain.Enum.Role;


import java.util.List;
@Data
@Entity
@Table(name = "Usuario")
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "Nombre")
    private String nombre;

    @Column(name = "Apellido")
    private String apellido;

    @Column(name = "Correo")
    private String correo;

    @Column(name = "Contraseña")
    private String contrasena;

    @Column(name = "Edad")
    private int edad;

    @Column(name = "Género")
    private String genero;
    @Enumerated(EnumType.STRING)
    private Role role;

    @ManyToOne
    @JoinColumn(name = "SuscripcionID")
    private Suscripcion suscripcion;

    @OneToMany(mappedBy = "usuario")
    private List<Habito> hábitos;

    // Getters y setters
}
