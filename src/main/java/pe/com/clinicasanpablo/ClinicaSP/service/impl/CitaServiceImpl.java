
package pe.com.clinicasanpablo.ClinicaSP.service.impl;

import java.util.List;
import java.util.stream.Collectors;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.com.clinicasanpablo.ClinicaSP.dto.CitaDTO;
import pe.com.clinicasanpablo.ClinicaSP.entity.CitaEntity;
import pe.com.clinicasanpablo.ClinicaSP.repository.CitaRepository;
import pe.com.clinicasanpablo.ClinicaSP.service.CitaService;

@Service
public class CitaServiceImpl implements CitaService {

    //inyeccion de dependencia
    @Autowired
    private CitaRepository repositorio;

    @Autowired
    private ModelMapper mapper;

    @Override
    public List<CitaDTO> findAll() {
        List<CitaEntity> lista = repositorio.findAll();
        return lista.stream().map(c -> mapper.map(c, CitaDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public List<CitaDTO> findAllCustom() {
        List<CitaEntity> lista = repositorio.findAllCustom();
        return lista.stream().map(c -> mapper.map(c, CitaDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public CitaDTO findById(Long id) {
        CitaEntity lista = repositorio.findById(id).get();
        return mapper.map(lista, CitaDTO.class);
    }

    @Override
    public CitaDTO add(CitaDTO c) {
        CitaEntity cita = mapper.map(c, CitaEntity.class);
        return mapper.map(repositorio.save(cita), CitaDTO.class);
    }

    @Override
    public CitaDTO update(CitaDTO c, Long id) {
        CitaEntity cita = repositorio.findById(id).get();
        mapper.map(c, cita);
        return mapper.map(repositorio.save(cita), CitaDTO.class);
    }

    @Override
    public CitaDTO delete(Long id) {
        CitaEntity cita = repositorio.findById(id).get();
        cita.setEstCita(false);
        return mapper.map(repositorio.save(cita), CitaDTO.class);
    }

    @Override
    public CitaDTO enable(Long id) {
        CitaEntity cita = repositorio.findById(id).get();
        cita.setEstCita(true);
        return mapper.map(repositorio.save(cita), CitaDTO.class);
    }

}

