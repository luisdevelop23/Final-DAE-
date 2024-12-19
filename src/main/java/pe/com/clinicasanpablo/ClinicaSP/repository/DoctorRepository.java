package pe.com.clinicasanpablo.ClinicaSP.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import pe.com.clinicasanpablo.ClinicaSP.entity.DoctorEntity;

@Repository
public interface DoctorRepository extends JpaRepository<DoctorEntity, Long>{
    @Query("select d from DoctorEntity d")
    List<DoctorEntity> findAllCustom();
}
