package com.autoapi.service.mapper.impl;

import com.autoapi.model.Auto;
import com.autoapi.model.dto.AutoRequestDto;
import com.autoapi.model.dto.AutoResponseDto;
import com.autoapi.service.mapper.RequestDtoMapper;
import com.autoapi.service.mapper.ResponseDtoMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class AutoMapper implements RequestDtoMapper<AutoRequestDto, Auto>,
        ResponseDtoMapper<AutoResponseDto, Auto> {

    @Override
    public Auto mapToModel(AutoRequestDto dto) {
        Auto auto = new Auto();
        auto.setNumber(dto.getNumber());
        auto.setColor(Auto.Color.valueOf(dto.getColor().toUpperCase()));
        auto.setVinCode(dto.getVinCode());
        auto.setOwnerName(dto.getNameOwner());
        return auto;
    }

    @Override
    public AutoResponseDto mapToDto(Auto auto) {
        AutoResponseDto dto = new AutoResponseDto();
        dto.setId(auto.getId());
        dto.setYear(auto.getYear());
        dto.setColor(auto.getColor());
        dto.setNumber(auto.getNumber());
        dto.setVinCode(auto.getVinCode());
        dto.setOwnerName(auto.getOwnerName());
        dto.setModelName(auto.getModel().getName());
        dto.setManufacturerName(auto.getManufacturer());
        return dto;
    }
}
