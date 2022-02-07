package com.autoapi.service.impl;

import com.autoapi.model.Manufacturer;
import com.autoapi.repository.ManufacturerRepository;
import com.autoapi.service.ManufacturerService;
import java.util.List;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ManufacturerServiceImpl implements ManufacturerService {
    private ManufacturerRepository manufacturerRepository;

    @Override
    public List<Manufacturer> saveAll(List<Manufacturer> manufacturers) {
        return manufacturerRepository.saveAll(manufacturers);
    }

    @Override
    public Manufacturer findById(Long id) {
        return manufacturerRepository.findById(id).orElseThrow(() ->
                new RuntimeException("Not found manufacturer with id " + id));
    }

    @Override
    public List<Manufacturer> findAll() {
        return manufacturerRepository.findAll();
    }
}
