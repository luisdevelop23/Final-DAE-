package pe.com.clinicasanpablo.ClinicaSP.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import pe.com.clinicasanpablo.ClinicaSP.dto.PacienteDTO;
import pe.com.clinicasanpablo.ClinicaSP.entity.PacienteEntity;
import pe.com.clinicasanpablo.ClinicaSP.service.PacienteService;

@Controller
public class PacienteController {

    @Autowired
    private PacienteService servicio;

    // Rutas --> @GetMapping
    @GetMapping("/paciente/listar")
    public String mostrarListarPaciente(Model modelo) {
        modelo.addAttribute("listapaciente", servicio.findAllCustom());
        return "paciente/listar_paciente";
    }

    @GetMapping("/paciente/registro")
    public String mostrarRegistroPaciente(Model modelo) {
        modelo.addAttribute("paciente", new PacienteEntity());
        return "paciente/registrar_paciente";
    }

    @GetMapping("/paciente/actualiza/{id}")
    public String mostrarActualizaPaciente(@PathVariable Long id, Model modelo) {
        modelo.addAttribute("paciente", servicio.findById(id));
        return "paciente/actualizar_paciente";
    }

    @GetMapping("/paciente/eliminar/{id}")
    public String eliminarPaciente(@PathVariable Long id) {
        servicio.delete(id);
        return "redirect:/paciente/listar";
    }

    // Modelo
    @ModelAttribute("paciente")
    public PacienteEntity modeloPaciente() {
        return new PacienteEntity();
    }

    // Acciones
    @PostMapping("/paciente/registrar")
    public String registrarPaciente(@ModelAttribute("paciente") PacienteDTO p) {
        servicio.add(p);
        return "redirect:/paciente/listar";
    }

    @PostMapping("/paciente/actualizar/{id}")
    public String actualizarPaciente(@PathVariable Long id, @ModelAttribute("paciente") PacienteDTO p) {
        servicio.update(p, id);
        return "redirect:/paciente/listar";
    }
}