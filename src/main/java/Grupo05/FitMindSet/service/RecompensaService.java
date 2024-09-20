package Grupo05.FitMindSet.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import Grupo05.FitMindSet.domain.Entity.Recompensa;
import Grupo05.FitMindSet.repository.RecompensaRepository;
import Grupo05.FitMindSet.domain.Entity.MetaSalud;
import java.util.List;




@Service
public class RecompensaService {




    @Autowired
    private RecompensaRepository recompensaRepository;




    public List<Recompensa> obtenerRecompensas() {
        return recompensaRepository.findAll();
    }




    public void asignarRecompensa(MetaSalud meta) {
        if (meta.getProgresoActual() >= meta.getMetaObjetivo()) {
            Recompensa recompensa = new Recompensa();
            recompensa.setNombre("¡Felicidades!");
            recompensa.setDescripcion("Has alcanzado tu meta.");
            recompensaRepository.save(recompensa);
        }
    }
}
