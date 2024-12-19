package pe.com.clinicasanpablo.ClinicaSP.restcontroller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pe.com.clinicasanpablo.ClinicaSP.dto.EspecialidadDTO;
import pe.com.clinicasanpablo.ClinicaSP.service.EspecialidadService;


@RestController
@RequestMapping("/especialidad")
public class EspecialidadRestController {
    @Autowired
    private EspecialidadService servicio;

    @GetMapping
    public List<EspecialidadDTO> findAll() {
        return servicio.findAll();
    }

    @GetMapping("/custom")
    public List<EspecialidadDTO> findAllCustom() {
        return servicio.findAllCustom();
    }

    @GetMapping("/{id}")
    public EspecialidadDTO findById(@PathVariable long id) {
        return servicio.findById(id);
    }

    @PostMapping
    public EspecialidadDTO add(@RequestBody EspecialidadDTO e) {
        return servicio.add(e);
    }

    @PutMapping("/{id}")
    public EspecialidadDTO update(@PathVariable long id, @RequestBody EspecialidadDTO e) {
        return servicio.update(e, id);
    }

    @DeleteMapping("/{id}")
    public EspecialidadDTO delete(@PathVariable long id) {
        return servicio.delete(id);
    }

    @PutMapping("/enable/{id}")
    public EspecialidadDTO enable(@PathVariable long id) {
        return servicio.enable(id);
    }
}
