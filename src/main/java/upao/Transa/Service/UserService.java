package upao.Transa.Service;

import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import upao.Transa.Exception.BadRequestException;
import upao.Transa.Mapper.UserMapper;
import upao.Transa.Repository.UserRepository;
import upao.Transa.Security.TokenProvider;
import upao.Transa.domain.Entity.Usuario;
import upao.Transa.domain.Enum.Role;
import upao.Transa.dto.request.AuthRequesDTO;
import upao.Transa.dto.request.SignupRequesDTO;
import upao.Transa.dto.response.AuthResponseDTO;
import upao.Transa.dto.response.UserProfileResponseDTO;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final UserMapper userMapper;
    private final TokenProvider tokenProvider;
    private final AuthenticationManagerBuilder authenticationManagerBuilder;
    private UserDetailsService userDetailsService;

    /**
     * Autenticación de un usuario.
     */
    @Transactional(readOnly = true)
    public AuthResponseDTO signIn(AuthRequesDTO authRequestDTO) {
        UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(
                authRequestDTO.getCorreo(),
                authRequestDTO.getContrasena()
        );

        Authentication authentication = authenticationManagerBuilder.getObject().authenticate(authenticationToken);
        SecurityContextHolder.getContext().setAuthentication(authentication);

        String accessToken = tokenProvider.createAccessToken(authentication);

        UserProfileResponseDTO userProfileDTO = findByCorreo(authRequestDTO.getCorreo());
        return userMapper.toAuthResponseDTO(accessToken, userProfileDTO);
    }

    /**
     * Registro de un nuevo usuario.
     */
    @Transactional
    public UserProfileResponseDTO signup(SignupRequesDTO signupRequestDTO) {
        boolean emailAlreadyExists = userRepository.existsByCorreo(signupRequestDTO.getCorreo());
        if (emailAlreadyExists) {
            throw new BadRequestException("El correo electrónico ya está siendo usado por otro usuario.");
        }

        Usuario usuario = userMapper.toUser(signupRequestDTO);
        usuario.setContrasena(passwordEncoder.encode(signupRequestDTO.getContrasena()));
        usuario.setRole(Role.User);
        userRepository.save(usuario);

        return userMapper.toUserProfileResponseDTO(usuario);
    }

    /**
     * Método auxiliar para encontrar un usuario por su correo.
     */
    public UserProfileResponseDTO findByCorreo(String correo) {
        Usuario usuario = userRepository.findOneByCorreo(correo)
                .orElseThrow(() -> new BadRequestException("Usuario no encontrado."));
        return userMapper.toUserProfileResponseDTO(usuario);
    }

    @Transactional
    public void resetPassword(String email, String newPassword) {
        Usuario usuario = userRepository.findOneByCorreo(email)
                .orElseThrow(() -> new BadRequestException("Usuario no encontrado."));

        usuario.setContrasena(passwordEncoder.encode(newPassword));
        userRepository.save(usuario);
    }

    /**
     * METODO PARA ELIMINAR UN USUARIO
     */
    @Transactional
    public void eliminarPerfil() {

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        if (authentication == null || !authentication.isAuthenticated()) {
            throw new BadRequestException("No hay usuario autenticado.");
        }


        String correoUsuario = authentication.getName();


        Usuario usuario = userRepository.findOneByCorreo(correoUsuario)
                .orElseThrow(() -> new BadRequestException("Usuario no encontrado."));


        userRepository.delete(usuario);
    }
    @Transactional
    public void eliminarUsuarioPorCorreo(String correo) {
        Usuario usuario = userRepository.findOneByCorreo(correo)
                .orElseThrow(() -> new BadRequestException("Usuario no encontrado."));

        userRepository.delete(usuario);
    }
    @Transactional
    public void delete(Long id) {
        Usuario usuario = userRepository.findById(id)
                .orElseThrow(() -> new BadRequestException("Usuario no encontrado con el ID: " + id));

        userRepository.delete(usuario);
    }
}
