package com.autoapi.service.impl;

import com.autoapi.model.Auto;
import com.autoapi.repository.AutoRepository;
import com.autoapi.service.AutoService;
import com.autoapi.service.downloader.VinDecoderService;
import com.autoapi.service.mapper.impl.VinDecoderMapper;
import java.util.List;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class AutoServiceImpl implements AutoService {
    private final AutoRepository autoRepository;
    private final VinDecoderService vinDecoderService;
    private final VinDecoderMapper vinDecoderMapper;

    @Override
    public Auto save(Auto auto) {
        if (isPresent(auto.getNumber())) {
            auto.setId(findByNumber(auto.getNumber()).getId());
        }
        decodingVin(auto);
        return autoRepository.save(auto);
    }

    @Override
    public Page<Auto> findAll(Specification<Auto> spec, Pageable pageable) {
        return autoRepository.findAll(spec, pageable);
    }

    @Override
    public Auto update(Long id, Auto auto) {
        decodingVin(auto);
        auto.setId(id);
        return autoRepository.save(auto);
    }

    @Override
    public void deleteById(Long id) {
        autoRepository.deleteById(id);
    }

    @Override
    public Auto findByNumber(String number) {
        return autoRepository.findByNumber(number).orElseThrow(() ->
                new RuntimeException("Not found auto with number " + number));
    }

    @Override
    public Auto findByVinCode(String vinCode) {
        return autoRepository.findByVinCode(vinCode);
    }

    @Override
    public List<Auto> findByNameOwner(String ownerName) {
        return autoRepository.findByOwnerName(ownerName);
    }

    @Override
    public Boolean isPresent(String number) {
        return autoRepository.findByNumber(number).isPresent();
    }

    private Auto decodingVin(Auto auto) {
        Auto autoData = vinDecoderMapper.mapToModel(vinDecoderService.fetchInfo(auto.getVinCode()));
        auto.setModel(autoData.getModel());
        auto.setManufacturer(autoData.getManufacturer());
        auto.setYear(autoData.getYear());
        return auto;
    }
}
