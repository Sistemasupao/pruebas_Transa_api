package upao.Transa.Mapper;

import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;
import upao.Transa.dto.request.SignupRequesDTO;
import upao.Transa.domain.Entity.Usuario;
import upao.Transa.dto.response.AuthResponseDTO;
import upao.Transa.dto.response.UserProfileResponseDTO;

@RequiredArgsConstructor
@Component
public class UserMapper {

    private final ModelMapper modelMapper;



    public Usuario toUser(SignupRequesDTO signupRequesDTO) {
        return modelMapper.map(signupRequesDTO, Usuario.class);
    }


    public UserProfileResponseDTO toUserProfileResponseDTO(Usuario usuario) {
        return modelMapper.map(usuario, UserProfileResponseDTO.class);
    }
    public AuthResponseDTO toAuthResponseDTO(String token, UserProfileResponseDTO userProfileResponseDTO) {
        AuthResponseDTO authResponseDTO = new AuthResponseDTO();
        authResponseDTO.setToken(token);
        authResponseDTO.setUsuario(userProfileResponseDTO);
        return authResponseDTO;
    }
}
