package upao.Transa.domain.Entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;

@Entity
@Table(name = "Autor")

public class Autor {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(name = "Nombre",nullable = false, length = 50)
    private String nombre;
    @Column(name = "Correo",nullable = false)
    @Email(message = "Email no valido")
    @NotEmpty(message = "Email cannot be empty")
    private String correo;
    @Column(name = "Especialidad",nullable = false, length = 50)
    private String especialidad;
    @Column(name ="Telefono",nullable = false)
    private Long telefono;

}

