package com.autoapi.controller;

import com.autoapi.model.Manufacturer;
import com.autoapi.service.ManufacturerService;
import java.util.List;
import java.util.stream.Collectors;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/manufacturers")
@AllArgsConstructor
public class ManufacturerController {
    private final ManufacturerService manufacturerService;

    @GetMapping("/search")
    public String get(Model model) {
        List<String> names = manufacturerService.findAll().stream()
                .map(Manufacturer::getName)
                .collect(Collectors.toList());
        model.addAttribute("names", names);
        return "manufacturersAutocomplite";
    }
}
