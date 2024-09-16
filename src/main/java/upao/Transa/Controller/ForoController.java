package upao.Transa.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import upao.Transa.Service.ForoService;
import upao.Transa.domain.Entity.Foro;
import upao.Transa.dto.request.ForoCreateDTO;


@RestController
@RequestMapping("/api/v1/foro")
public class ForoController {

    private final ForoService foroService;

    @Autowired
    public ForoController(ForoService foroService) {
        this.foroService = foroService;
    }

    @PostMapping("/create")
    public ResponseEntity<Foro> createForo(@RequestBody ForoCreateDTO foroCreateDTO) {
        Foro foro = foroService.createForo(foroCreateDTO);
        return ResponseEntity.ok(foro);
    }
}
