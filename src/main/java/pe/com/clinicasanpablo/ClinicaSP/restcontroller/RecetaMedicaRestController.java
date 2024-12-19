package pe.com.clinicasanpablo.ClinicaSP.restcontroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import pe.com.clinicasanpablo.ClinicaSP.dto.RecetaMedicaDTO;
import pe.com.clinicasanpablo.ClinicaSP.service.RecetaMedicaService;

import java.util.List;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */


@RestController
@RequestMapping("/recetaMedica")
public class RecetaMedicaRestController {

    @Autowired
    private RecetaMedicaService servicio;

    @GetMapping
    public List<RecetaMedicaDTO> findAll() {
        return servicio.findAll();
    }

    @GetMapping("/custom")
    public List<RecetaMedicaDTO> findAllCustom() {
        return servicio.findAllCustom();
    }

    @GetMapping("/{id}")
    public RecetaMedicaDTO findById(@PathVariable long id) {
        return servicio.findById(id);
    }

    @PostMapping
    public RecetaMedicaDTO add(@RequestBody RecetaMedicaDTO r) {
        return servicio.add(r);
    }

    @PutMapping("/{id}")
    public RecetaMedicaDTO update(@PathVariable long id, @RequestBody RecetaMedicaDTO r) {
        return servicio.update(r, id);
    }

    @DeleteMapping("/{id}")
    public RecetaMedicaDTO delete(@PathVariable long id) {
        return servicio.delete(id);
    }

    @PutMapping("/enable/{id}")
    public RecetaMedicaDTO enable(@PathVariable long id) {
        return servicio.enable(id);
    }
}
