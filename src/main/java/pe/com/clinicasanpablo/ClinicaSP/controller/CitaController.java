
package pe.com.clinicasanpablo.ClinicaSP.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import pe.com.clinicasanpablo.ClinicaSP.dto.CitaDTO;
import pe.com.clinicasanpablo.ClinicaSP.entity.CitaEntity;
import pe.com.clinicasanpablo.ClinicaSP.service.CitaService;
import pe.com.clinicasanpablo.ClinicaSP.service.DoctorService;
import pe.com.clinicasanpablo.ClinicaSP.service.PacienteService;

@Controller
public class CitaController {

    //inyeccion de dependencias
    @Autowired
    private CitaService servicio;
    
    @Autowired
    private PacienteService serviciopaciente;
    
    @Autowired
    private DoctorService serviciodoctor;
    //GetMapping --> rutas
    @GetMapping("/cita/listar")
    public String MostrarListarCita(Model modelo) {
        modelo.addAttribute("listacita", servicio.findAllCustom());
        return "cita/listar_cita";
    }

    @GetMapping("/cita/registro")
    public String MostrarRegistroCita(Model modelo) {
        modelo.addAttribute("cita", new CitaEntity()); 
        modelo.addAttribute("paciente", serviciopaciente.findAllCustom());
        modelo.addAttribute("doctor", serviciodoctor.findAllCustom());
        return "detalleorden/registrar_detalleorden";
    }

    @GetMapping("/cita/actualiza/{id}")
    public String MostrarActualizaCita(@PathVariable Long id, Model modelo) {
        modelo.addAttribute("listacita", servicio.findById(id));
        return "cita/actualizar_cita";
    }

    @GetMapping("/cita/eliminar/{id}")
    public String EliminarCita(@PathVariable Long id) {
        servicio.delete(id);
        return "redirect:/cita/listar";
    }

    @GetMapping("/cita/habilita")
    public String MostrarHabilitaCita(Model modelo) {
        modelo.addAttribute("listacita", servicio.findAll());
        return "especialidad/habilitar_cita";
    }

    @GetMapping("/cita/habilitar/{id}")
    public String HabilitarCita(@PathVariable Long id) {
        servicio.enable(id);
        return "redirect:/cita/habilita";
    }

    @GetMapping("/cita/deshabilitar/{id}")
    public String DeshabilitarCita(@PathVariable Long id) {
        servicio.delete(id);
        return "redirect:/cita/habilita";
    }

    //Modelo --> transporta la informacion
    @ModelAttribute("cita")
    public CitaDTO ModeloCita() {
        return new CitaDTO();
    }

    //@PostMappimg --> acciones
    @PostMapping("/cita/registrar")
    public String RegistrarCita(@ModelAttribute("cita") CitaDTO c) {
        servicio.add(c);
        return "redirect:/cita/listar";
    }

    @PostMapping("/cita/actualizar/{id}")
    public String ActualizarEspecialidad(@PathVariable Long id, @ModelAttribute("especialidad") CitaDTO c) {
        servicio.update(c,id);
        return "redirect:/especialidad/listar";
    }
}
 