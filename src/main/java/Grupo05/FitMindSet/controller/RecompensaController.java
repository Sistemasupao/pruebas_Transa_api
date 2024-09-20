package Grupo05.FitMindSet.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import Grupo05.FitMindSet.service.RecompensaService;
import Grupo05.FitMindSet.domain.Entity.Recompensa;
import java.util.List;




@RestController
public class RecompensaController {




    @Autowired
    private RecompensaService recompensaService;




    @GetMapping("/recompensas")
    public List<Recompensa> obtenerRecompensas() {
        return recompensaService.obtenerRecompensas();
    }
}
