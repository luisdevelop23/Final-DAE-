/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pe.com.clinicasanpablo.ClinicaSP.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import pe.com.clinicasanpablo.ClinicaSP.service.CitaService;

/**
 *
 * @author ADM
 */

@Controller
public class InicioController {

        @Autowired
    private CitaService servicioCita;

    @GetMapping
    public String MostrarIndex() {
        return "index";
    }


}
