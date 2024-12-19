
package pe.com.clinicasanpablo.ClinicaSP.entity;

import java.sql.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.*;


@Entity(name = "HistorialClinicoEntity")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "historialClinico")
public class HistorialClinicoEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer codHistorial;

    @OneToOne
    @JoinColumn(name = "codPaciente", nullable = false)
    private PacienteEntity paciente;

    @Column(nullable = false)
    private String descripcion;

    @Column(nullable = false)
    private Date  fechaRegistro;

    @Column(nullable = false)
    private Boolean estHistorialClinico;    
}
