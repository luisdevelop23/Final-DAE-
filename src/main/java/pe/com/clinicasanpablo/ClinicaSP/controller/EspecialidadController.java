
package pe.com.clinicasanpablo.ClinicaSP.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import pe.com.clinicasanpablo.ClinicaSP.dto.EspecialidadDTO;
import pe.com.clinicasanpablo.ClinicaSP.service.EspecialidadService;


@Controller
public class EspecialidadController {

    //inyeccion de dependencias
    @Autowired
    private EspecialidadService servicio;

    //GetMapping --> rutas
    @GetMapping("/especialidad/listar")
    //Model modelo --> permite enviar datos desde el controlador a la vista
    public String MostrarListarEspecialidad(Model modelo) {
        modelo.addAttribute("listaespecialidad", servicio.findAllCustom());
        return "especialidad/listar_especialidad";
    }

    @GetMapping("/especialidad/registro")
    public String MostrarRegistroEspecialidad() {
        return "especialidad/registrar_especialidad";
    }

    @GetMapping("/especialidad/actualiza/{id}")
    public String MostrarActualizaEspecialidad(@PathVariable Long id, Model modelo) {
        modelo.addAttribute("listaespecialidad", servicio.findById(id));
        return "especialidad/actualizar_especialidad";
    }

    @GetMapping("/especialidad/eliminar/{id}")
    public String EliminarEspecialidad(@PathVariable Long id) {
        servicio.delete(id);
        return "redirect:/especialidad/listar";
    }

    @GetMapping("/especialidad/habilita")
    public String MostrarHabilitaEspecialidad(Model modelo) {
        modelo.addAttribute("listaespecialidad", servicio.findAll());
        return "especialidad/habilitar_especialidad";
    }

    @GetMapping("/especialidad/habilitar/{id}")
    public String HabilitarEspecialidad(@PathVariable Long id) {
        servicio.enable(id);
        return "redirect:/especialidad/habilita";
    }

    @GetMapping("/especialidad/deshabilitar/{id}")
    public String DeshabilitarEspecialidad(@PathVariable Long id) {
        servicio.delete(id);
        return "redirect:/especialidad/habilita";
    }

    //Modelo --> transporta la informacion
    @ModelAttribute("especialidad")
    public EspecialidadDTO ModeloEspecialidad() {
        return new EspecialidadDTO();
    }

    //@PostMappimg --> acciones
    @PostMapping("/especialidad/registrar")
    public String RegistrarEspecialidad(@ModelAttribute("especialidad") EspecialidadDTO e) {
        servicio.add(e);
        return "redirect:/especialidad/listar";
    }

    @PostMapping("/especialidad/actualizar/{id}")
    public String ActualizarEspecialidad(@PathVariable Long id, @ModelAttribute("especialidad") EspecialidadDTO e) {
        servicio.update(e,id);
        return "redirect:/especialidad/listar";
    }
}
 