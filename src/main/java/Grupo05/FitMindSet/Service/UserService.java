package Grupo05.FitMindSet.Service;
import Grupo05.FitMindSet.Repository.UserRepository;
import Grupo05.FitMindSet.domain.Entity.Usuario;

public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public void registrarPesoAltura(Long id, Double peso, Double altura) {
        Usuario usuario = userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));
        usuario.setPeso(peso);
        usuario.setAltura(altura);
        userRepository.save(usuario);
    }
}
