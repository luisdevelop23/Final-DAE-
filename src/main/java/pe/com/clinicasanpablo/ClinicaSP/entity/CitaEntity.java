package pe.com.clinicasanpablo.ClinicaSP.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import java.util.Date;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity(name = "CitaEntity")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "Cita")
public class CitaEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer codCita;

    @ManyToOne
    @JoinColumn(name = "codPaciente", nullable = false)
    private PacienteEntity paciente;

    @ManyToOne
    @JoinColumn(name = "codDoctor", nullable = false)
    private DoctorEntity doctor;

    @Column(nullable = false)
    private Date fechaCita;

    @Column(nullable = false)
    private String motivoCita;

    @Column(nullable = false)
    private Boolean estCita;

    @OneToMany(mappedBy = "cita", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<RecetaMedicaEntity> recetas;
}
