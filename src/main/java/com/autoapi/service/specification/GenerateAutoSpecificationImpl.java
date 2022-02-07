package com.autoapi.service.specification;

import com.autoapi.model.Auto;
import com.autoapi.repository.specification.SpecificationManager;
import java.util.Map;
import lombok.AllArgsConstructor;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class GenerateAutoSpecificationImpl implements GenerateSpecification<Auto> {
    private final SpecificationManager<Auto> autoSpecificationManager;

    @Override
    public Specification<Auto> generate(Map<String, String> params) {
        Specification<Auto> specification = null;
        for (Map.Entry<String, String> entry: params.entrySet()) {
            Specification<Auto> spec = autoSpecificationManager.get(entry.getKey(),
                    entry.getValue().split(","));
            specification = specification == null ? Specification.where(spec)
                    : specification.and(spec);
        }
        return specification;
    }
}
