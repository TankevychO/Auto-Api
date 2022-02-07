package com.autoapi.controller;

import com.autoapi.model.dto.ModelResponseDto;
import com.autoapi.service.ModelService;
import com.autoapi.service.mapper.impl.ModelMapper;
import java.util.List;
import java.util.stream.Collectors;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@RequestMapping("/models")
public class ModelController {
    private final ModelService modelService;
    private final ModelMapper modelMapper;

    @GetMapping("/by-manufacturer")
    public List<ModelResponseDto> findByManufacturer(@RequestParam String manufacturer) {
        return modelService.findByManufacturer(manufacturer).stream()
                .map(modelMapper::mapToDto)
                .collect(Collectors.toList());
    }
}
