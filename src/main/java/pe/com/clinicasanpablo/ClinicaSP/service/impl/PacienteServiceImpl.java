package pe.com.clinicasanpablo.ClinicaSP.service.impl;

import java.util.List;
import java.util.stream.Collectors;
import org.modelmapper.ModelMapper;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.com.clinicasanpablo.ClinicaSP.dto.PacienteDTO;
import pe.com.clinicasanpablo.ClinicaSP.entity.PacienteEntity;
import pe.com.clinicasanpablo.ClinicaSP.repository.PacienteRepository;
import pe.com.clinicasanpablo.ClinicaSP.service.PacienteService;


@Service
public class PacienteServiceImpl implements PacienteService {

    //inyeccion de dependencia
    @Autowired
    private PacienteRepository repositorio;

    @Autowired
    private ModelMapper mapper;

    @Override
    public List<PacienteDTO> findAll() {
        List<PacienteEntity> lista = repositorio.findAll();
        return lista.stream().map(p -> mapper.map(p, PacienteDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public List<PacienteDTO> findAllCustom() {
        List<PacienteEntity> lista = repositorio.findAllCustom();
        return lista.stream().map(p -> mapper.map(p, PacienteDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public PacienteDTO findById(Long id) {
        PacienteEntity lista = repositorio.findById(id).get();
        return mapper.map(lista, PacienteDTO.class);
    }

    @Override
    public PacienteDTO add(PacienteDTO p) {
        PacienteEntity paciente = mapper.map(p, PacienteEntity.class);
        return mapper.map(repositorio.save(paciente), PacienteDTO.class);
    }

    @Override
    public PacienteDTO update(PacienteDTO p, Long id) {
        PacienteEntity paciente = repositorio.findById(id).get();
        mapper.map(p, paciente);
        return mapper.map(repositorio.save(paciente), PacienteDTO.class);
    }

    @Override
    public PacienteDTO delete(Long id) {
        PacienteEntity cliente = repositorio.findById(id).get();
        return mapper.map(repositorio.save(cliente), PacienteDTO.class);
    }

    @Override
    public PacienteDTO enable(Long id) {
        PacienteEntity cliente = repositorio.findById(id).get();
        return mapper.map(repositorio.save(cliente), PacienteDTO.class);
    }

}