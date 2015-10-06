package com.gft.repository;

import com.gft.model.Employee;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by iozi on 06/10/2015.
 */
@Repository
public class XMLHRRepository implements HRRepository {

    @Override
    public List<Employee> findAll() {
        return null;
    }

    @Override
    public Employee findById(int id) {
        return null;
    }

    @Override
    public List<Employee> findByTelephoneNumberPrefix(String prefix) {
        return null;
    }
}
