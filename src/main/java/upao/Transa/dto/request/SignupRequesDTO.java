package upao.Transa.dto.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class SignupRequesDTO {
    @NotBlank
    private String nombre;

    @NotBlank
    private String apellidos;

    @Email(message = "Correo Electronico invalido")
    @NotBlank(message = "El correo electronico es obligatorio")
    private String correo;

    @NotNull(message = "La contraseña es obligatorio")
    @Size(min=8)
    private String contrasena;

    @NotNull(message = "El campo edad no debe estar vacío")
    private Integer edad;

    @NotNull(message = "El campo genero no debe estar vacío")
    private String genero;

    @NotNull(message = "El campo foro_id no debe estar vacío")
    private Long foroId;

    @NotNull(message = "El campo suscripcionid no debe estar vacío")
    private Long suscripcionid;
}
