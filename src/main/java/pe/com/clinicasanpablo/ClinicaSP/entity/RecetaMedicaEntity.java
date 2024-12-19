package pe.com.clinicasanpablo.ClinicaSP.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity(name = "RecetaMedicaEntity")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "recetaMedica")
public class RecetaMedicaEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer codReceta;

    @ManyToOne
    @JoinColumn(name = "codCita", nullable = false)
    private CitaEntity cita;

    @Column(nullable = false)
    private String medicamento;

    @Column(nullable = false)
    private String dosis;

    @Column(nullable = false)
    private Integer duracionDias;

    @Column(nullable = false)
    private String instrucciones;
    
    @Column(nullable = false)
    private Boolean estRecetaMedica;
}
