
package pe.com.clinicasanpablo.ClinicaSP.repository.generic;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;


@NoRepositoryBean
public interface GenericoRepositorio<T,ID> extends JpaRepository<T, ID>{
    
}
