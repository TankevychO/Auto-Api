package com.autoapi.service.impl;

import com.autoapi.model.Model;
import com.autoapi.repository.ModelRepository;
import com.autoapi.service.ModelService;
import java.util.List;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ModelServiceImpl implements ModelService {
    private final ModelRepository modelRepository;

    @Override
    public Model findById(Long id) {
        return modelRepository.findById(id).orElseThrow(() ->
                new RuntimeException("Not found model with id " + id));
    }

    @Override
    public List<Model> saveAll(List<Model> models) {
        return modelRepository.saveAll(models);
    }

    @Override
    public List<Model> findByManufacturer(String manufacturerName) {
        return modelRepository.findByManufacturer(manufacturerName);
    }
}
