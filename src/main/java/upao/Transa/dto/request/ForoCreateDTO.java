package upao.Transa.dto.request;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class ForoCreateDTO {
    @NotBlank(message = "La descripción del foro es obligatoria")
    private String descripcion;

    @NotBlank(message = "El título del foro es obligatorio")
    private String titulo;
}
