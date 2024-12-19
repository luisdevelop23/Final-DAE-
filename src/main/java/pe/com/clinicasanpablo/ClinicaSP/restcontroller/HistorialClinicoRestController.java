
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

import pe.com.clinicasanpablo.ClinicaSP.dto.HistorialClinicoDTO;
import pe.com.clinicasanpablo.ClinicaSP.service.HistorialClinicoService;

@RestController
@RequestMapping("/historial-clinico")
public class HistorialClinicoRestController {

    @Autowired
    private HistorialClinicoService servicio;

    @GetMapping
    public List<HistorialClinicoDTO> findAll() {
        return servicio.findAll();
    }

    @GetMapping("/custom")
    public List<HistorialClinicoDTO> findAllCustom() {
        return servicio.findAllCustom();
    }

    @GetMapping("/{id}")
    public HistorialClinicoDTO findById(@PathVariable long id) {
        return servicio.findById(id);
    }

    @PostMapping
    public HistorialClinicoDTO add(@RequestBody HistorialClinicoDTO h) {
        return servicio.add(h);
    }

    @PutMapping("/{id}")
    public HistorialClinicoDTO update(@PathVariable long id, @RequestBody HistorialClinicoDTO h) {
        return servicio.update(h, id);
    }

    @DeleteMapping("/{id}")
    public HistorialClinicoDTO delete(@PathVariable long id) {
        return servicio.delete(id);
    }

    @PutMapping("/enable/{id}")
    public HistorialClinicoDTO enable(@PathVariable long id) {
        return servicio.enable(id);
    }
}
