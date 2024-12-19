
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
public class CitaDTO{
    
    private int codCita;
    private PacienteDTO paciente; 
    private DoctorDTO doctor; 
    private String fechaCita;
    private String motivoCita;
    private boolean estCita;
}
