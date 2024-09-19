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
    @PutMapping("/{id}/actualizarPesoAltura")
    public ResponseEntity<String> actualizarPesoAltura(@PathVariable Long id, @RequestBody Map<String, Double> payload) {
        try {
            Double nuevoPeso = payload.get("peso");
            Double nuevaAltura = payload.get("altura");
            userService.actualizarPesoAltura(id, nuevoPeso, nuevaAltura);
            return ResponseEntity.ok("Peso y altura actualizados con éxito.");
        } catch (RuntimeException e) {
            return ResponseEntity.status(400).body(e.getMessage());
        }
    }

    @GetMapping("/{id}/imc")
    public ResponseEntity<String> obtenerIMC(@PathVariable Long id) {
        try {
            Double imc = userService.calcularIMC(id);
            if (imc != null) {
                return ResponseEntity.ok("Tu IMC es: " + imc);
            } else {
                return ResponseEntity.status(400).body("Peso o altura no están registrados correctamente.");
            }
        } catch (RuntimeException e) {
            return ResponseEntity.status(400).body(e.getMessage());
        }
    }

}
