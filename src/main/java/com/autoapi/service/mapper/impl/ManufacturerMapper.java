package com.autoapi.service.mapper.impl;

import com.autoapi.model.Manufacturer;
import com.autoapi.model.dto.downloader.ManufacturerDto;
import com.autoapi.service.mapper.RequestDtoMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class ManufacturerMapper implements RequestDtoMapper<ManufacturerDto, Manufacturer> {
    @Override
    public Manufacturer mapToModel(ManufacturerDto dto) {
        Manufacturer manufacturer = new Manufacturer();
        manufacturer.setId((long) dto.getMake_id());
        manufacturer.setName(dto.getMake_name().toUpperCase());
        return manufacturer;
    }
}
