package upao.Transa.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import upao.Transa.domain.Entity.Foro;
import upao.Transa.dto.request.ForoCreateDTO;
import upao.Transa.Repository.ForoRepository;

@Service
public class ForoService {

    @Autowired
    private ForoRepository foroRepository;

    public Foro createForo(ForoCreateDTO foroCreateDTO) {
        Foro foro = new Foro();
        foro.setDescripcion(foroCreateDTO.getDescripcion());
        foro.setTitulo(foroCreateDTO.getTitulo());
        return foroRepository.save(foro);
    }
}
