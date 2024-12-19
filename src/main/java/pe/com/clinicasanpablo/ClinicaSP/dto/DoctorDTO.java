
package pe.com.clinicasanpablo.ClinicaSP.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;


@SuperBuilder
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class DoctorDTO{
    
    private int codDoctor;
    private String nomDoctor;
    private String apepDoctor;
    private String apemDoctor;
    private String correoDoctor;
    private String telefono;
    private boolean estDoctor;
    private EspecialidadDTO especialidad; 
}
