package com.autoapi.service;

import com.autoapi.model.Model;
import java.util.List;

public interface ModelService {
    Model findById(Long id);

    List<Model> saveAll(List<Model> models);

    List<Model> findByManufacturer(String manufacturerName);
}
