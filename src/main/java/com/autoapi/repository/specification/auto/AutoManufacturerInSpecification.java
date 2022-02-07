package com.autoapi.repository.specification.auto;

import com.autoapi.model.Auto;
import com.autoapi.model.Model;
import com.autoapi.repository.specification.SpecificationProvider;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.JoinType;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;

@Component
public class AutoManufacturerInSpecification implements SpecificationProvider<Auto> {
    private static final String FIELD_NAME = "name";
    private static final String FILTER_KEY = "manufacturer";

    @Override
    public Specification<Auto> getSpecification(String[] manufacturers) {
        return (root, query, cb) -> {
            Join<Auto, Model> join = root.join("model", JoinType.INNER)
                    .join("manufacturer", JoinType.INNER);
            CriteriaBuilder.In<String> predicate = cb.in(join.get(FIELD_NAME));
            for (String value : manufacturers) {
                predicate.value(value);
            }
            return cb.and(predicate, predicate);
        };
    }

    @Override
    public String getFilterKey() {
        return FILTER_KEY;
    }
}
