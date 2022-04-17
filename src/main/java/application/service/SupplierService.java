package application.service;

import application.dto.SupplierResponseDto;
import application.mapper.SupplierMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import application.repository.SupplierRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class SupplierService {
    private final SupplierRepository repository;
    private final SupplierMapper mapper;

    public SupplierService(SupplierRepository repository, SupplierMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    public List<SupplierResponseDto> getAll() {
        return repository.findAll().stream()
                .map(mapper::entityToSupplierResponseDto)
                .collect(Collectors.toList());
    }



}
