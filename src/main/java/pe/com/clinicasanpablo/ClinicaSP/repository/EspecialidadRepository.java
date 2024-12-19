
package pe.com.clinicasanpablo.ClinicaSP.repository;

import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import pe.com.clinicasanpablo.ClinicaSP.entity.EspecialidadEntity;
import pe.com.clinicasanpablo.ClinicaSP.repository.generic.GenericoRepositorio;

@Repository
public interface EspecialidadRepository extends GenericoRepositorio<EspecialidadEntity, Long> {

    @Query("select e from EspecialidadEntity e where e.estEspecialidad=true")
    List<EspecialidadEntity> findAllCustom();
}
