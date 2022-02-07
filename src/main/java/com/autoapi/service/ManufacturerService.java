package com.autoapi.service;

import com.autoapi.model.Manufacturer;
import java.util.List;

public interface ManufacturerService {

    List<Manufacturer> saveAll(List<Manufacturer> manufacturers);

    Manufacturer findById(Long id);

    List<Manufacturer> findAll();
}
