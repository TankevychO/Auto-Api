package com.autoapi.repository.specification.auto;

import com.autoapi.model.Auto;
import com.autoapi.repository.specification.SpecificationProvider;
import javax.persistence.criteria.CriteriaBuilder;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;

@Component
public class AutoYearInSpecification implements SpecificationProvider<Auto> {
    private static final String FIELD_NAME = "year";
    private static final String FILTER_KEY = "year";

    @Override
    public Specification<Auto> getSpecification(String[] years) {
        return (root, query, cb) -> {
            CriteriaBuilder.In<Integer> predicate = cb.in(root.get(FIELD_NAME));
            for (String value : years) {
                predicate.value(Integer.parseInt(value));
            }
            return cb.and(predicate, predicate);
        };
    }

    @Override
    public String getFilterKey() {
        return FILTER_KEY;
    }
}
