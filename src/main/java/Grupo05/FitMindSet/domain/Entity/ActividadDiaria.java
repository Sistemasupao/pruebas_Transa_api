package Grupo05.FitMindSet.domain.Entity;

import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDate;




@Entity
@Data
public class ActividadDiaria {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;




    private String activityType;
    private Integer duration;
    private String intensity;
    private String notes;
    private LocalDate activityDate;




    private String dietDetails;




}
