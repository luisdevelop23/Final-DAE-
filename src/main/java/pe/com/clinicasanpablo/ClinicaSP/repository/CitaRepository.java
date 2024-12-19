
package pe.com.clinicasanpablo.ClinicaSP.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import pe.com.clinicasanpablo.ClinicaSP.entity.CitaEntity;

public interface CitaRepository extends JpaRepository<CitaEntity, Long>{
    @Query("select c from CitaEntity c where c.estCita=true")
    List<CitaEntity> findAllCustom();
}

