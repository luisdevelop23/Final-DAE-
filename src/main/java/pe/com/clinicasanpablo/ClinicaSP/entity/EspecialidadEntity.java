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
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity(name = "EspecialidadEntity")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "Especialidad")
public class EspecialidadEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer codEspecialidad;

    @Column(nullable = false)
    private String nomEspecialidad;

    @Column(nullable = false)
    private Boolean estEspecialidad;
    
    @OneToMany(mappedBy = "especialidad", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<DoctorEntity> doctores;
}
