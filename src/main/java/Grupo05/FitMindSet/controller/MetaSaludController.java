package Grupo05.FitMindSet.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import Grupo05.FitMindSet.service.MetaSaludService;
import Grupo05.FitMindSet.domain.Entity.MetaSalud;




import java.util.List;




@RestController
public class MetaSaludController {




    @Autowired
    private MetaSaludService metaSaludService;




    @GetMapping("/metas")
    public List<MetaSalud> obtenerMetas() {
        return metaSaludService.obtenerMetas();
    }




    @PutMapping("/metas/{id}")
    public ResponseEntity<MetaSalud> modificarMeta(@PathVariable Long id, @RequestBody MetaSalud metaSaludActualizada) {
        MetaSalud metaModificada = metaSaludService.modificarMeta(id, metaSaludActualizada);
        return ResponseEntity.ok(metaModificada);
    }




    @GetMapping("/metas/analizar/{id}")
    public ResponseEntity<String> analizarProgreso(@PathVariable Long id) {
        String recomendacion = metaSaludService.analizarProgreso(id);
        return ResponseEntity.ok(recomendacion);
    }
}

