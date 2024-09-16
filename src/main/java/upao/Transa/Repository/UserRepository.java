package upao.Transa.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import upao.Transa.domain.Entity.Usuario;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<Usuario, Long> {

    /**
     * Método para encontrar un usuario por correo electrónico.
     */
    Optional<Usuario> findOneByCorreo(String correo);

    /**
     * Método para verificar si un correo ya está registrado.
     */
    boolean existsByCorreo(String correo);
}
