package com.autoapi.service.mapper.impl;

import com.autoapi.model.Auto;
import com.autoapi.model.dto.downloader.VinCodeDto;
import com.autoapi.service.ModelService;
import com.autoapi.service.mapper.RequestDtoMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class VinDecoderMapper implements RequestDtoMapper<VinCodeDto, Auto> {
    private final ModelService modelService;

    @Override
    public Auto mapToModel(VinCodeDto dto) {
        Auto auto = new Auto();
        auto.setYear(Integer.parseInt(dto.getModelyear()));
        auto.setModel(modelService.findById(Long.parseLong(dto.getModelid())));
        auto.setManufacturer(auto.getModel().getManufacturer().getName());
        return auto;
    }
}
