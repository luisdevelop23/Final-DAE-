
package pe.com.clinicasanpablo.ClinicaSP.service.impl;

import java.util.List;
import java.util.stream.Collectors;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.com.clinicasanpablo.ClinicaSP.dto.EspecialidadDTO;
import pe.com.clinicasanpablo.ClinicaSP.entity.EspecialidadEntity;
import pe.com.clinicasanpablo.ClinicaSP.repository.EspecialidadRepository;
import pe.com.clinicasanpablo.ClinicaSP.service.EspecialidadService;

@Service
public class EspecialidadServiceImpl implements EspecialidadService {

    //inyeccion de dependencia
    @Autowired
    private EspecialidadRepository repositorio;

    @Autowired
    private ModelMapper mapper;

    @Override
    public List<EspecialidadDTO> findAll() {
        List<EspecialidadEntity> lista = repositorio.findAll();
        return lista.stream().map(e -> mapper.map(e, EspecialidadDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public List<EspecialidadDTO> findAllCustom() {
        List<EspecialidadEntity> lista = repositorio.findAllCustom();
        return lista.stream().map(e -> mapper.map(e, EspecialidadDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public EspecialidadDTO findById(Long id) {
        EspecialidadEntity lista = repositorio.findById(id).get();
        return mapper.map(lista, EspecialidadDTO.class);
    }

    @Override
    public EspecialidadDTO add(EspecialidadDTO e) {
        EspecialidadEntity especialidad = mapper.map(e, EspecialidadEntity.class);
        return mapper.map(repositorio.save(especialidad), EspecialidadDTO.class);
    }

    @Override
    public EspecialidadDTO update(EspecialidadDTO e, Long id) {
        EspecialidadEntity especialidad = repositorio.findById(id).get();
        mapper.map(e, especialidad);
        return mapper.map(repositorio.save(especialidad), EspecialidadDTO.class);
    }

    @Override
    public EspecialidadDTO delete(Long id) {
        EspecialidadEntity especialidad = repositorio.findById(id).get();
        return mapper.map(repositorio.save(especialidad), EspecialidadDTO.class);
    }

    @Override
    public EspecialidadDTO enable(Long id) {
        EspecialidadEntity especialidad = repositorio.findById(id).get();
        return mapper.map(repositorio.save(especialidad), EspecialidadDTO.class);
    }

}
