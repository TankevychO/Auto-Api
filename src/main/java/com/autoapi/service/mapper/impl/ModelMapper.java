package com.autoapi.service.mapper.impl;

import com.autoapi.model.Model;
import com.autoapi.model.dto.ModelResponseDto;
import com.autoapi.model.dto.downloader.ModelDto;
import com.autoapi.service.ManufacturerService;
import com.autoapi.service.mapper.RequestDtoMapper;
import com.autoapi.service.mapper.ResponseDtoMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class ModelMapper implements ResponseDtoMapper<ModelResponseDto, Model>,
        RequestDtoMapper<ModelDto, Model> {
    private final ManufacturerService manufacturerService;

    @Override
    public ModelResponseDto mapToDto(Model model) {
        ModelResponseDto dto = new ModelResponseDto();
        dto.setId(model.getId());
        dto.setName(model.getName());
        return dto;
    }

    @Override
    public Model mapToModel(ModelDto dto) {
        Model model = new Model();
        model.setId((long) dto.getModel_id());
        model.setName(dto.getModel_name().toUpperCase());
        model.setManufacturer(manufacturerService.findById((long) dto.getMake_id()));
        return model;
    }
}
