package upao.Transa.domain.Entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;

@Entity
@Table(name = "Usuario")
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(name = "Nombre",nullable = false)
    private String nombre;
    @Column(name = "Apellidos",nullable = false)
    private String apellidos;
    @Column(name = "Correo",nullable = false,unique = true)
    @Email(message = "Email no es valido")
    @NotEmpty(message = "Email cannot be enpty")
    private String correo;
    @Column(name = "Contrasena",nullable = false)
    private String contrasena;
    @Column(name = "Edad",nullable = false)
    private Integer edad;
    @Column(name = "Genero",nullable = false)
    private String genero;
    @ManyToOne
    @JoinColumn(name = "ForoId",nullable = false)
    private Foro foro;
    @ManyToOne
    @JoinColumn(name = "SuscripcionID",nullable = false)
    private Suscripcion suscripcion;
}
