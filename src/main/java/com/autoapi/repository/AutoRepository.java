package com.autoapi.repository;

import com.autoapi.model.Auto;
import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface AutoRepository extends JpaRepository<Auto, Long>,
        JpaSpecificationExecutor<Auto> {
    Optional<Auto> findByNumber(String number);

    Auto findByVinCode(String vinCode);

    List<Auto> findByOwnerName(String ownerName);
}
