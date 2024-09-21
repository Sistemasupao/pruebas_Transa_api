package Grupo05.FitMindSet.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import Grupo05.FitMindSet.domain.Entity.ActividadDiaria;
import Grupo05.FitMindSet.repository.ActividadDiariaRepository;




import java.util.List;


@Service
public class ActividadDiariaService {




    @Autowired
    private ActividadDiariaRepository repository;




    public List<ActividadDiaria> getAllActivityLogs() {
        return repository.findAll();
    }




    public ActividadDiaria saveActivityLog(ActividadDiaria log) {
        return repository.save(log);
    }




    public ActividadDiaria getActivityLogById(Long id) {
        return repository.findById(id).orElse(null);
    }




    public void deleteActivityLog(Long id) {
        repository.deleteById(id);
    }
}

