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
    public Double actualizarPesoAlturaYCalcularIMC(Long id, Double peso, Double altura) {
        Usuario usuario = userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));
        usuario.setPeso(peso);
        usuario.setAltura(altura);
        userRepository.save(usuario);
        return usuario.calcularIMC();
    }

    public Double calcularIMC(Long id) {
        Usuario usuario = userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));
        return usuario.calcularIMC();
    }

    public void actualizarPesoAltura(Long id, Double nuevoPeso, Double nuevaAltura) {
        Usuario usuario = userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));

        usuario.setPeso(nuevoPeso);
        usuario.setAltura(nuevaAltura);
        userRepository.save(usuario);
    }
}