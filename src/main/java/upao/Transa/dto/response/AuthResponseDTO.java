package upao.Transa.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class AuthResponseDTO {
    private String token;
    private UserProfileResponseDTO usuario;
    public AuthResponseDTO() {
    }
}
