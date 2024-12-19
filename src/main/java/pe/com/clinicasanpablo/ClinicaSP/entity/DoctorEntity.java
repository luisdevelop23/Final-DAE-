package pe.com.clinicasanpablo.ClinicaSP.entity;

import java.util.List;

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
import lombok.*;


@Entity(name = "DoctorEntity")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "doctor")
public class DoctorEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer codDoctor;

    @Column(nullable = false)
    private String nomDoctor;

    @Column(nullable = false)
    private String apepDoctor;

    @Column(nullable = false)
    private String apemDoctor;

    @ManyToOne
    @JoinColumn(name = "codEspecialidad", nullable = false)
    private EspecialidadEntity especialidad;

    @Column(nullable = false)
    private String correoDoctor;

    private String telefono;

    @Column(nullable = false)
    private Boolean estDoctor;

    @OneToMany(mappedBy = "doctor", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<CitaEntity> citas;
}