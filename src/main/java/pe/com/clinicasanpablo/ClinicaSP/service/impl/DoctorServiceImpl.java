
package pe.com.clinicasanpablo.ClinicaSP.service.impl;

import java.util.List;
import java.util.stream.Collectors;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.com.clinicasanpablo.ClinicaSP.dto.DoctorDTO;
import pe.com.clinicasanpablo.ClinicaSP.entity.DoctorEntity;
import pe.com.clinicasanpablo.ClinicaSP.repository.DoctorRepository;
import pe.com.clinicasanpablo.ClinicaSP.service.DoctorService;

@Service
public class DoctorServiceImpl implements DoctorService {

    @Autowired
    private DoctorRepository repositorio;

    @Autowired
    private ModelMapper mapper;

    @Override
    public List<DoctorDTO> findAll() {
        List<DoctorEntity> lista = repositorio.findAll();
        return lista.stream().map(d -> mapper.map(d, DoctorDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public List<DoctorDTO> findAllCustom() {
        List<DoctorEntity> lista = repositorio.findAllCustom();
        return lista.stream().map(d -> mapper.map(d, DoctorDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public DoctorDTO findById(Long id) {
        DoctorEntity lista = repositorio.findById(id).get();
        return mapper.map(lista, DoctorDTO.class);
    }

    @Override
    public DoctorDTO add(DoctorDTO d) {
        DoctorEntity doctor = mapper.map(d, DoctorEntity.class);
        return mapper.map(repositorio.save(doctor), DoctorDTO.class);
    }

    @Override
    public DoctorDTO update(DoctorDTO d, Long id) {
        DoctorEntity doctor = repositorio.findById(id).get();
        mapper.map(d, doctor);
        return mapper.map(repositorio.save(doctor), DoctorDTO.class);
    }

    @Override
    public DoctorDTO delete(Long id) {
        DoctorEntity doctor = repositorio.findById(id).get();
        return mapper.map(repositorio.save(doctor), DoctorDTO.class);
    }

    @Override
    public DoctorDTO enable(Long id) {
        DoctorEntity doctor = repositorio.findById(id).get();
        return mapper.map(repositorio.save(doctor), DoctorDTO.class);
    }
}
