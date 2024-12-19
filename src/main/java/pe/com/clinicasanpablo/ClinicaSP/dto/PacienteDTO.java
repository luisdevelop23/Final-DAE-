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
public class PacienteDTO {
    private Long codPaciente;
    private String nomPaciente;
    private String apepPaciente;
    private String apemPaciente;
    private String fechaNacimiento;
    private String genero;
    private String correoPaciente;
    private String telefono;
    private String direccion;
    private boolean estPaciente;
}