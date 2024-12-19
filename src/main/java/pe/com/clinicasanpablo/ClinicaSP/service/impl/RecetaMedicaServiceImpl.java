package pe.com.clinicasanpablo.ClinicaSP.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.com.clinicasanpablo.ClinicaSP.dto.RecetaMedicaDTO;
import pe.com.clinicasanpablo.ClinicaSP.entity.RecetaMedicaEntity;
import pe.com.clinicasanpablo.ClinicaSP.repository.RecetaMedicaRepository;
import pe.com.clinicasanpablo.ClinicaSP.service.RecetaMedicaService;
import org.modelmapper.ModelMapper;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class RecetaMedicaServiceImpl implements RecetaMedicaService {

    @Autowired
    private RecetaMedicaRepository repositorio;

    @Autowired
    private ModelMapper mapper;

    @Override
    public List<RecetaMedicaDTO> findAll() {
        List<RecetaMedicaEntity> lista = repositorio.findAll();
        return lista.stream().map(e -> mapper.map(e, RecetaMedicaDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public List<RecetaMedicaDTO> findAllCustom() {
        List<RecetaMedicaEntity> lista = repositorio.findAllCustom();
        return lista.stream().map(e -> mapper.map(e, RecetaMedicaDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public RecetaMedicaDTO findById(Long id) {
        RecetaMedicaEntity receta = repositorio.findById(id).get();
        return mapper.map(receta, RecetaMedicaDTO.class);
    }

    @Override
    public RecetaMedicaDTO add(RecetaMedicaDTO e) {
        RecetaMedicaEntity receta = mapper.map(e, RecetaMedicaEntity.class);
        return mapper.map(repositorio.save(receta), RecetaMedicaDTO.class);
    }

    @Override
    public RecetaMedicaDTO update(RecetaMedicaDTO e, Long id) {
        RecetaMedicaEntity receta = repositorio.findById(id).get();
        mapper.map(e, receta);
        return mapper.map(repositorio.save(receta), RecetaMedicaDTO.class);
    }

    @Override
    public RecetaMedicaDTO delete(Long id) {
        RecetaMedicaEntity receta = repositorio.findById(id).get();
        return mapper.map(repositorio.save(receta), RecetaMedicaDTO.class);
    }

    @Override
    public RecetaMedicaDTO enable(Long id) {
        RecetaMedicaEntity receta = repositorio.findById(id).get();
        return mapper.map(repositorio.save(receta), RecetaMedicaDTO.class);
    }
}
