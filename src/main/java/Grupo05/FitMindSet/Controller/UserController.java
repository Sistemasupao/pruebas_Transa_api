package Grupo05.FitMindSet.Controller;

import Grupo05.FitMindSet.Service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/usuarios")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping("/{id}/registrarPesoAltura")
    public ResponseEntity<String> registrarPesoAltura(
            @PathVariable Long id,
            @RequestParam Double peso,
            @RequestParam Double altura) {

        try {
            userService.registrarPesoAltura(id, peso, altura);
            return ResponseEntity.ok("Peso y altura registrados con éxito.");
        } catch (RuntimeException e) {
            return ResponseEntity.status(400).body(e.getMessage());
        }
    }
}
