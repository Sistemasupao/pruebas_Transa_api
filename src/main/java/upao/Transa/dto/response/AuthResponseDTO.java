package upao.Transa.dto.response;

import lombok.Data;

@Data
public class AuthResponseDTO {
    private String token;
    private UserProfileResponseDTO usuario;
}
