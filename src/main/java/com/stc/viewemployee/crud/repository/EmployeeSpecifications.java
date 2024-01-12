package com.stc.viewemployee.crud.repository;

import com.stc.viewemployee.crud.entity.Employee;
import jakarta.persistence.criteria.Predicate;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.jpa.domain.Specification;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Slf4j
public class EmployeeSpecifications {


    private EmployeeSpecifications() {
        throw new IllegalStateException("Utility class");
    }

    public static Specification<Employee> withDynamicQuery(final String search) {
        return (root, query, criteriaBuilder) -> {
            if (search != null) {
                List<Predicate> predicates = new ArrayList<>();
                Pattern pattern = Pattern.compile("(\\w+?)([:<>])(\\w+?),");
                Matcher matcher = pattern.matcher(search + ",");
                while (matcher.find()) {
                    String field = matcher.group(1);
                    String operation = matcher.group(2);
                    String value = matcher.group(3);
                    switch (operation) {
                        case ":":
                            predicates.add(criteriaBuilder.equal(root.get(field), value));
                            break;
                        case "<":
                            predicates.add(criteriaBuilder.lessThan(root.get(field), value));
                            break;
                        case ">":
                            predicates.add(criteriaBuilder.greaterThan(root.get(field), value));
                            break;
                        default:
                            log.error("Operation {}", operation + " is not supported.");
                            throw new IllegalArgumentException("Operation " + operation + " is not supported.");
                    }
                }
                return criteriaBuilder.and(predicates.toArray(new Predicate[0]));
            }
            return null;
        };
    }
}