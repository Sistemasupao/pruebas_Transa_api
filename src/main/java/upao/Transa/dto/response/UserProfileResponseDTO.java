package upao.Transa.dto.response;

import lombok.Data;
import upao.Transa.domain.Enum.Role;

@Data
public class UserProfileResponseDTO {
    private Long id;
    private String nombre;
    private String apellido;
    private String correo;
    private Role role;
}
