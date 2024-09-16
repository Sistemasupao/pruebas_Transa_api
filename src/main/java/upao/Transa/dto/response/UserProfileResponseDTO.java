package upao.Transa.dto.response;

import lombok.Data;
import upao.Transa.domain.Enum.Role;

@Data
public class UserProfileResponseDTO {
    private Long id;
    private String nombre;
    private String apellidos;
    private String correo;
    private Integer edad;
    private String genero;
    private Role role;
}
