
package pe.com.clinicasanpablo.ClinicaSP.service.impl;

import java.util.List;
import java.util.stream.Collectors;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.com.clinicasanpablo.ClinicaSP.dto.EspecialidadDTO;
import pe.com.clinicasanpablo.ClinicaSP.dto.HistorialClinicoDTO;
import pe.com.clinicasanpablo.ClinicaSP.entity.EspecialidadEntity;
import pe.com.clinicasanpablo.ClinicaSP.entity.HistorialClinicoEntity;
import pe.com.clinicasanpablo.ClinicaSP.repository.EspecialidadRepository;
import pe.com.clinicasanpablo.ClinicaSP.repository.HistorialClinicoRepository;
import pe.com.clinicasanpablo.ClinicaSP.service.EspecialidadService;
import pe.com.clinicasanpablo.ClinicaSP.service.HistorialClinicoService;


@Service
public class HistorialClinicoServiceImpl implements HistorialClinicoService {

    @Autowired
    private HistorialClinicoRepository repositorio;

    @Autowired
    private ModelMapper mapper;

    @Override
    public List<HistorialClinicoDTO> findAll() {
        List<HistorialClinicoEntity> lista = repositorio.findAll();
        return lista.stream().map(e -> mapper.map(e, HistorialClinicoDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public List<HistorialClinicoDTO> findAllCustom() {
        List<HistorialClinicoEntity> lista = repositorio.findAll();
        return lista.stream().map(e -> mapper.map(e, HistorialClinicoDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public HistorialClinicoDTO findById(Long id) {
        HistorialClinicoEntity lista = repositorio.findById(id).get();
        return mapper.map(lista, HistorialClinicoDTO.class);
    }

    @Override
    public HistorialClinicoDTO add(HistorialClinicoDTO e) {
        HistorialClinicoEntity historialClinico = mapper.map(e, HistorialClinicoEntity.class);
        return mapper.map(repositorio.save(historialClinico), HistorialClinicoDTO.class);
    }

    @Override
    public HistorialClinicoDTO update(HistorialClinicoDTO e, Long id) {
        HistorialClinicoEntity historialClinico = repositorio.findById(id).get();
        mapper.map(e, historialClinico);
        return mapper.map(repositorio.save(historialClinico), HistorialClinicoDTO.class);
    }

    @Override
    public HistorialClinicoDTO delete(Long id) {
        HistorialClinicoEntity historialClinico = repositorio.findById(id).get();
        return mapper.map(repositorio.save(historialClinico), HistorialClinicoDTO.class);
    }

    @Override
    public HistorialClinicoDTO enable(Long id) {
        HistorialClinicoEntity historialClinico = repositorio.findById(id).get();
        return mapper.map(repositorio.save(historialClinico), HistorialClinicoDTO.class);
    }
}
