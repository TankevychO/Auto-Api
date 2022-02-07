package com.autoapi.controller;

import com.autoapi.model.Auto;
import com.autoapi.model.dto.AutoRequestDto;
import com.autoapi.model.dto.AutoResponseDto;
import com.autoapi.service.AutoService;
import com.autoapi.service.export.ExelFileService;
import com.autoapi.service.mapper.impl.AutoMapper;
import com.autoapi.service.specification.GenerateSpecification;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import javax.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@RequestMapping("/autos")
public class AutoController {
    private List<AutoResponseDto> autos;
    private final AutoMapper autoMapper;
    private final AutoService autoService;
    private final ExelFileService<AutoResponseDto> exelFileService;
    private final GenerateSpecification<Auto> generateSpecification;

    @PostMapping
    public AutoResponseDto save(@RequestBody @Valid AutoRequestDto autoRequestDto) {
        Auto auto = autoService.save(autoMapper.mapToModel(autoRequestDto));
        return autoMapper.mapToDto(auto);
    }

    @GetMapping
    public List<AutoResponseDto> getAll(@RequestParam (defaultValue = "10") Integer count,
                                        @RequestParam (defaultValue = "0") Integer page,
                                        @RequestParam (defaultValue = "id") String sortBy,
                                        @RequestParam Map<String, String> params) {
        Sort sort = Sort.by(sortBy);
        Pageable pageRequest = PageRequest.of(page, count, sort);
        Specification<Auto> specification = generateSpecification.generate(params);
        autos = autoService.findAll(specification, pageRequest).stream()
                .map(autoMapper::mapToDto)
                .collect(Collectors.toList());
        return autos;
    }

    @PutMapping("/{id}")
    public AutoResponseDto update(@PathVariable Long id,
                                  @RequestBody @Valid AutoRequestDto autoRequestDto) {
        Auto auto = autoService.update(id, autoMapper.mapToModel(autoRequestDto));
        return autoMapper.mapToDto(auto);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        autoService.deleteById(id);
    }

    @GetMapping("/by-vin")
    public AutoResponseDto findByVin(@RequestParam String vin) {
        return autoMapper.mapToDto(autoService.findByVinCode(vin));
    }

    @GetMapping("/by-name")
    public List<AutoResponseDto> findByNameOwner(@RequestParam String name) {
        return autoService.findByNameOwner(name).stream()
                .map(autoMapper::mapToDto)
                .collect(Collectors.toList());
    }

    @GetMapping("/by-number")
    public AutoResponseDto findByNumber(@RequestParam String number) {
        return autoMapper.mapToDto(autoService.findByNumber(number));
    }

    @GetMapping("/export")
    public String myExcel(Model model) {
        try {
            exelFileService.writeExcel(autos);
        } catch (IOException e) {
            new RuntimeException("Сan't write file", e);
        }
        return "Recording was successful!";
    }
}
