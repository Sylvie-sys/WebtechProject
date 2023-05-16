package com.social.repository;

import com.social.model.Inpatient;
import org.springframework.data.repository.CrudRepository;

public interface ImpatientRepository extends CrudRepository<Inpatient, Integer> {

    public Long countById(Integer id);
}
