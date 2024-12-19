
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

import pe.com.clinicasanpablo.ClinicaSP.dto.DoctorDTO;
import pe.com.clinicasanpablo.ClinicaSP.service.DoctorService;
import pe.com.clinicasanpablo.ClinicaSP.service.EspecialidadService;

@RestController
@RequestMapping("/doctor")
public class DoctorRestController {
    @Autowired
    private DoctorService servicio;
    
    @Autowired
    private EspecialidadService servicioespecialidad;

    @GetMapping
    public List<DoctorDTO> findAll() {
        return servicio.findAll();
    }

    @GetMapping("/custom")
    public List<DoctorDTO> findAllCustom() {
        return servicio.findAllCustom();
    }

    @GetMapping("/{id}")
    public DoctorDTO findById(@PathVariable long id) {
        return servicio.findById(id);
    }

    @PostMapping
    public DoctorDTO add(@RequestBody DoctorDTO d) {
        return servicio.add(d);
    }

    @PutMapping("/{id}")
    public DoctorDTO update(@PathVariable long id, @RequestBody DoctorDTO d) {
        return servicio.update(d, id);
    }

    @DeleteMapping("/{id}")
    public DoctorDTO delete(@PathVariable long id) {
        return servicio.delete(id);
    }

    @PutMapping("/enable/{id}")
    public DoctorDTO enable(@PathVariable long id) {
        return servicio.enable(id);
    }
}