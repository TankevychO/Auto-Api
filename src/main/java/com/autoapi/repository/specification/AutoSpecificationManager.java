package com.autoapi.repository.specification;

import com.autoapi.model.Auto;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;

@Component
public class AutoSpecificationManager implements SpecificationManager<Auto> {
    private final Map<String, SpecificationProvider<Auto>> providersMap;

    @Autowired
    public AutoSpecificationManager(List<SpecificationProvider<Auto>> autoSpecifications) {
        this.providersMap = autoSpecifications.stream()
                .collect(Collectors.toMap(SpecificationProvider::getFilterKey,
                        Function.identity()));
    }

    @Override
    public Specification<Auto> get(String filterKey, String[] params) {
        if (!providersMap.containsKey(filterKey)) {
            throw new RuntimeException("Key " + filterKey + " is not supported for data filtering");
        }
        return providersMap.get(filterKey).getSpecification(params);
    }
}
