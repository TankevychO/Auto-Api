package com.autoapi.service;

import com.autoapi.model.Auto;
import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;

public interface AutoService {
    Auto save(Auto auto);

    Page<Auto> findAll(Specification<Auto> spec, Pageable pageable);

    Auto update(Long id, Auto auto);

    void deleteById(Long id);

    Auto findByNumber(String number);

    Auto findByVinCode(String vinCode);

    List<Auto> findByNameOwner(String ownerName);

    Boolean isPresent(String number);
}
