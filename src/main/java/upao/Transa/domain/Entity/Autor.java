package upao.Transa.domain.Entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import lombok.Data;
import upao.Transa.domain.Enum.Role;

import java.util.List;
@Data
@Entity
@Table(name = "Autor")
public class Autor {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "Nombre", nullable = false, length = 50)
    private String nombre;

    @Column(name = "Correo", nullable = false)
    @Email(message = "Email no válido")
    @NotEmpty(message = "Email no puede estar vacío")
    private String correo;

    @Column(name = "Especialidad", nullable = false, length = 50)
    private String especialidad;

    @Column(name = "Telefono", nullable = false)
    private String telefono;


    @Column(name = "Contraseña", nullable = false)
    private String contraseña;

    @Column(name = "Rol", nullable = false)
    private Role role;


    @OneToMany(mappedBy = "autor")
    private List<Recurso> recursos;


}

