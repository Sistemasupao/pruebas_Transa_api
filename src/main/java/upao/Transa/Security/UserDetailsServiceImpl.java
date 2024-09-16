package upao.Transa.Security;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import upao.Transa.Repository.UserRepository;
import upao.Transa.domain.Entity.Usuario;
@RequiredArgsConstructor
@Service
public class UserDetailsServiceImpl implements UserDetailsService {
private final UserRepository userRepository;
public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    Usuario usuario = userRepository
            .findOneByCorreo(username)
            .orElseThrow(()-> new UsernameNotFoundException(username));
    return org.springframework.security.core.userdetails.User
            .withUsername(usuario.getCorreo())
            .password(usuario.getContrasena())
            .roles(usuario.getRole().name())
            .build();
}
}
