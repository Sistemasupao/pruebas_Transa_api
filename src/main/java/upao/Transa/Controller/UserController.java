package upao.Transa.Controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import upao.Transa.Service.UserService;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/usuarios")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteUser(@PathVariable Long id) {
        try{
            userService.delete(id);
            return ResponseEntity.ok("Usuario eliminado exitosamente");
        } catch (RuntimeException e) {
            return ResponseEntity.status(400).body(e.getMessage());
        }
    }

    @DeleteMapping("/eliminar/{correo}")
    public ResponseEntity<String> eliminarUsuarioPorCorreo(@PathVariable String correo) {
        userService.eliminarUsuarioPorCorreo(correo);
        return ResponseEntity.ok("El usuario con el correo " + correo + " ha sido eliminado exitosamente");
    }
}

