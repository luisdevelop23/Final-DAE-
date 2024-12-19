
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
import pe.com.clinicasanpablo.ClinicaSP.dto.CitaDTO;
import pe.com.clinicasanpablo.ClinicaSP.service.CitaService;


@RestController
//es la ruta con la cual se busca el servicio
@RequestMapping("/cita")
public class CitaRestController {
    @Autowired
    private CitaService servicio;

    @GetMapping
    public List<CitaDTO> findAll() {
        return servicio.findAll();
    }

    @GetMapping("/custom")
    public List<CitaDTO> findAllCustom() {
        return servicio.findAllCustom();
    }

    @GetMapping("/{id}")
    public CitaDTO findById(@PathVariable long id) {
        return servicio.findById(id);
    }

    @PostMapping
    public CitaDTO add(@RequestBody CitaDTO c) {
        return servicio.add(c);
    }

    @PutMapping("/{id}")
    public CitaDTO update(@PathVariable long id, @RequestBody CitaDTO c) {
        return servicio.update(c, id);
    }

    @DeleteMapping("/{id}")
    public CitaDTO delete(@PathVariable long id) {
        return servicio.delete(id);
    }

    @PutMapping("/enable/{id}")
    public CitaDTO enable(@PathVariable long id) {
        return servicio.enable(id);
    }
}


