package Grupo05.FitMindSet.domain.Entity;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

import java.util.List;

@Data
@Entity
@Table(name = "Autores")
public class Autor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "Nombre", nullable = false, length = 50)
    private String nombre;

    @Column(name = "Correo", nullable = false, unique = true)
    @Email(message = "Email no válido")
    @NotEmpty(message = "Email no puede estar vacío")
    private String correo;

    @Column(name = "Especialidad", nullable = false, length = 50)
    private String especialidad;

    @Column(name = "Telefono", nullable = false)
    private String telefono;

    @Column(name = "Contraseña")
    private String contrasena;

    @Column(name = "Role")
    private String role;

    @OneToMany(mappedBy = "autor")
    private List<Recurso> recursos;
}

