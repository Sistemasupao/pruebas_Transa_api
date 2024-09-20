package Grupo05.FitMindSet.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import Grupo05.FitMindSet.service.RecomendacionService;
import Grupo05.FitMindSet.service.MetaSaludService;
import Grupo05.FitMindSet.domain.Entity.MetaSalud;




import java.util.List;




@RestController
public class RecomendacionController {




    @Autowired
    private RecomendacionService recomendacionService;




    @Autowired
    private MetaSaludService metaSaludService;




    @GetMapping("/recomendaciones")
    public String obtenerRecomendaciones() {
        List<MetaSalud> metas = metaSaludService.obtenerMetas();
        return recomendacionService.generarRecomendacion(metas);
    }
}

