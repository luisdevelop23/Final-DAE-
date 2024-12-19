/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package pe.com.clinicasanpablo.ClinicaSP.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;

import pe.com.clinicasanpablo.ClinicaSP.entity.RecetaMedicaEntity;
import pe.com.clinicasanpablo.ClinicaSP.repository.generic.GenericoRepositorio;

/**
 *
 * @author ADM
 */
public interface RecetaMedicaRepository extends GenericoRepositorio<RecetaMedicaEntity, Long>{
    
    @Query("select r from RecetaMedicaEntity r where r.estRecetaMedica=true")
    List<RecetaMedicaEntity> findAllCustom();
}
