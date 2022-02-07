package com.autoapi.repository;

import com.autoapi.model.Model;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ModelRepository extends JpaRepository<Model, Long> {
    @Query("SELECT m FROM Model m "
            + "join fetch m.manufacturer man "
            + "WHERE man.name = ?1")
    List<Model> findByManufacturer(String manufacturerName);
}
