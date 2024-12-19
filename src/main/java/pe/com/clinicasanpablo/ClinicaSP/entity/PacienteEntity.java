package pe.com.clinicasanpablo.ClinicaSP.entity;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity(name = "PacienteEntity")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "Paciente")
public class PacienteEntity implements Serializable{
    
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer codPaciente;

    @Column(nullable = false)
    private String nomPaciente;

    @Column(nullable = false)
    private String apepPaciente;

    @Column(nullable = false)
    private String apemPaciente;

    @Column(nullable = false)
    private java.sql.Date fechaNacimiento;

    @Column(nullable = false, length = 1)
    private String genero;

    private String correoPaciente;

    private String telefono;

    private String direccion;

    @Column(nullable = false)
    private Boolean estPaciente;

    @OneToMany(mappedBy = "paciente", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<CitaEntity> citas;

    @OneToMany(mappedBy = "paciente", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<HistorialClinicoEntity> historialClinico;
}
