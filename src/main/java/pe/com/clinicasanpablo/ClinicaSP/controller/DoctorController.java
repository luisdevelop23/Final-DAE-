package pe.com.clinicasanpablo.ClinicaSP.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import pe.com.clinicasanpablo.ClinicaSP.dto.DoctorDTO;
import pe.com.clinicasanpablo.ClinicaSP.entity.DoctorEntity;
import pe.com.clinicasanpablo.ClinicaSP.service.DoctorService;

@Controller
public class DoctorController {
    @Autowired
    private DoctorService servicio;

    // Modelo
    @ModelAttribute("doctor")
    public DoctorDTO Modelodoctor() {
        return new DoctorDTO();
    }

    // Rutas --> @GetMapping
    @GetMapping("/doctor/listar")
    public String mostrarListarDoctor(Model modelo) {
        modelo.addAttribute("listadoctor", servicio.findAllCustom());
        return "doctor/listar_doctor";
    }

    @GetMapping("/doctor/registro")
    public String mostrarRegistroDoctor(Model modelo) {
        modelo.addAttribute("doctor", new DoctorEntity());
        return "doctor/registrar_doctor";
    }

    @GetMapping("/doctor/actualiza/{id}")
    public String mostrarActualizaDoctor(@PathVariable Long id, Model modelo) {
        modelo.addAttribute("doctor", servicio.findById(id));
        return "doctor/actualizar_doctor";
    }

    @GetMapping("/doctor/eliminar/{id}")
    public String eliminarDoctor(@PathVariable Long id) {
        servicio.delete(id);
        return "redirect:/doctor/listar";
    }

    // Acciones
    @PostMapping("/doctor/registrar")
    public String registrarDoctor(@ModelAttribute("doctor") DoctorDTO d) {
        servicio.add(d);
        return "redirect:/doctor/listar";
    }

    @PostMapping("/doctor/actualizar/{id}")
    public String actualizarDoctor(@PathVariable Long id, @ModelAttribute("doctor") DoctorDTO d) {
        servicio.update(d, id);
        return "redirect:/doctor/listar";
    }
}