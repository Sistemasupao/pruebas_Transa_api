package Grupo05.FitMindSet.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import Grupo05.FitMindSet.domain.Entity.ActividadDiaria;
import Grupo05.FitMindSet.service.ActividadDiariaService;




import java.util.List;




@RestController
@RequestMapping("/api/activity")
public class ActividadDiariaController {




    @Autowired
    private ActividadDiariaService service;




    // Obtener todos los registros
    @GetMapping("/logs")
    public ResponseEntity<List<ActividadDiaria>> getAllLogs() {
        List<ActividadDiaria> logs = service.getAllActivityLogs();
        return ResponseEntity.ok(logs);
    }




    // Crear un nuevo registro
    @PostMapping("/logs")
    public ResponseEntity<ActividadDiaria> createLog(@RequestBody ActividadDiaria log) {
        ActividadDiaria savedLog = service.saveActivityLog(log);
        return ResponseEntity.ok(savedLog);
    }




    // Obtener un registro por ID
    @GetMapping("/logs/{id}")
    public ResponseEntity<ActividadDiaria> getLogById(@PathVariable Long id) {
        ActividadDiaria log = service.getActivityLogById(id);
        return log != null ? ResponseEntity.ok(log) : ResponseEntity.notFound().build();
    }




    // Actualizar un registro
    @PutMapping("/logs/{id}")
    public ResponseEntity<ActividadDiaria> updateLog(@PathVariable Long id, @RequestBody ActividadDiaria log) {
        log.setId(id);
        ActividadDiaria updatedLog = service.saveActivityLog(log);
        return ResponseEntity.ok(updatedLog);
    }




    // Eliminar un registro
    @DeleteMapping("/logs/{id}")
    public ResponseEntity<Void> deleteLog(@PathVariable Long id) {
        service.deleteActivityLog(id);
        return ResponseEntity.noContent().build();
    }
}

