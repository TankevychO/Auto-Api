package com.autoapi.repository.specification.auto;

import com.autoapi.model.Auto;
import com.autoapi.repository.specification.SpecificationProvider;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;

@Component
public class AutoPageSpecification implements SpecificationProvider<Auto> {
    private static final String FILTER_KEY = "page";

    @Override
    public Specification<Auto> getSpecification(String[] params) {
        return null;
    }

    @Override
    public String getFilterKey() {
        return FILTER_KEY;
    }
}
