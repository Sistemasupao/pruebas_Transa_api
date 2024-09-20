package Grupo05.FitMindSet.service;

import org.springframework.stereotype.Service;
import Grupo05.FitMindSet.domain.Entity.MetaSalud;




import java.util.List;




@Service
public class RecomendacionService {


    public String generarRecomendacion(List<MetaSalud> metas) {
        double promedioProgreso = metas.stream()
                .mapToDouble(MetaSalud::getProgresoActual)
                .average()
                .orElse(0);


        if (promedioProgreso < 50) {
            return "Te recomendamos aumentar tus actividades físicas diarias.";
        } else {
            return "¡Buen trabajo! Sigue así para alcanzar tus metas.";
        }
    }
}
