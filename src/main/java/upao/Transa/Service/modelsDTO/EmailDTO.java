package upao.Transa.Service.modelsDTO;

import lombok.Data;

@Data
public class EmailDTO {
    private String destinatario;
    private String asunto;
    private String mensaje;
}
