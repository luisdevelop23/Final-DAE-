
package pe.com.clinicasanpablo.ClinicaSP.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import pe.com.clinicasanpablo.ClinicaSP.entity.PacienteEntity;

@Repository
public interface PacienteRepository extends JpaRepository<PacienteEntity, Long>{
    @Query("select p from PacienteEntity p")
    List<PacienteEntity> findAllCustom();
}