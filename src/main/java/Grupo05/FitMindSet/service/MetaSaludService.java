package Grupo05.FitMindSet.service;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import Grupo05.FitMindSet.domain.Entity.MetaSalud;
import Grupo05.FitMindSet.repository.MetaSaludRepository;




import java.util.Optional;
import java.util.List;




@Service
public class MetaSaludService {




    @Autowired
    private MetaSaludRepository metaSaludRepository;




    public List<MetaSalud> obtenerMetas() {
        return metaSaludRepository.findAll();
    }




    public MetaSalud modificarMeta(Long id, MetaSalud metaSaludActualizada) {
        Optional<MetaSalud> metaOpt = metaSaludRepository.findById(id);
        if (metaOpt.isPresent()) {
            MetaSalud metaExistente = metaOpt.get();
            metaExistente.setDescripcion(metaSaludActualizada.getDescripcion());
            metaExistente.setMetaObjetivo(metaSaludActualizada.getMetaObjetivo());
            metaExistente.setProgresoActual(metaSaludActualizada.getProgresoActual());
            return metaSaludRepository.save(metaExistente);
        } else {
            throw new RuntimeException("Meta de salud no encontrada");
        }
    }




    public String analizarProgreso(Long id) {
        Optional<MetaSalud> metaOpt = metaSaludRepository.findById(id);
        if (metaOpt.isPresent()) {
            MetaSalud meta = metaOpt.get();
            if (meta.getProgresoActual() < meta.getMetaObjetivo() * 0.5) {
                return "Progreso bajo. Recomendamos ajustar esta meta.";
            } else if (meta.getProgresoActual() >= meta.getMetaObjetivo()) {
                return "Meta alcanzada. Considera establecer un nuevo objetivo.";
            } else {
                return "Progreso adecuado. Sigue trabajando en tu meta.";
            }
        } else {
            throw new RuntimeException("Meta no encontrada para analizar el progreso.");
        }
    }
}

